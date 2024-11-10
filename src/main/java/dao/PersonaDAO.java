package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import control.Controlador;
import modelo.Persona;
import util.ConexionBD;

public class PersonaDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PersonaDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Método para insertar una persona en la base de datos
	 * 
	 * @param entidad de tipo Persona
	 * @return id de la persona de tipo long
	 */
	public long insertar(Persona p) {
		long idPersona = 0;
		String consulta = "INSERT INTO personas (nombre, email) values (?, ?)";
		try (PreparedStatement ps = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getEmail());
			int filas = ps.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						idPersona = rs.getLong(1);
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar la persona: " + e.getMessage());
		}

		return idPersona;
	}

	/**
	 * Método para ver todas la personas que hay registradas en la base de datos
	 * 
	 * @return ArrayList de tipo Persona llamado personas
	 */
	public Collection<Persona> verTodos() {

		ArrayList<Persona> personas = new ArrayList<>();
		String consulta = "SELECT * FROM personas";

		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}

			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();

			while (rs.next()) {
				Persona nueva = new Persona(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"));

				personas.add(nueva);
			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return personas;

	}

	/**
	 * Método para validar la persona
	 * 
	 * @param entidad de tipo Persona
	 * @return true si la persona es válida
	 */
	public boolean validarPersona(Persona p) {
		if ((p == null) || p.getNombre() == null || p.getNombre().isEmpty()) {
			return false;
		}
		if (p.getNombre().length() < 3 || p.getNombre().length() > 20) {
			return false;
		}
		if (p.getEmail() == null || p.getEmail().isEmpty()) {
			return false;
		}
		if (p.getEmail().length() < 5 || !p.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
				|| p.getEmail().length() > 40) {
			return false;
		}
		if (!Controlador.getServicios().getServiciosPersona().emailEsUnico(p.getEmail())) {
			return false;
		}
		return true;
	}

	/**
	 * Método para para saber que persona está autenticada en la base de datos
	 * 
	 * @param usuario registrado de tipo String
	 * @return id de la persona registrada de tipo long
	 */
	public long personaAutenticada(String usuario) {
		long idPersona = -1;
		String consulta = "SELECT personas.id FROM personas INNER JOIN credenciales ON personas.id = idpersona WHERE usuario = ?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setString(1, usuario);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					idPersona = rs.getLong("id");
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener el id de: " + usuario + ": " + e.getMessage());
		}
		return idPersona;
	}

	/**
	 * Método para comprobar que el email introducido es único
	 * 
	 * @param email de tipo String
	 * @return true si el email es único
	 */
	public boolean emailEsUnico(String email) {

		String consulta = "SELECT COUNT(*) FROM personas WHERE email = ?";

		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			if (rs.next() && rs.getInt(1) > 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}

}
