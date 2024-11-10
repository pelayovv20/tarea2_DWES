package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.Controlador;
import modelo.Credencial;
import util.ConexionBD;

public class CredencialDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CredencialDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Método para iniciar sesión en la base de datos, ya sea como administrador o
	 * como personal
	 * 
	 * @param usuario  de tipo String
	 * @param password de tipo String
	 * @return true si va todo bien, false si hay algún error
	 */
	public boolean autenticarUsuario(String usuario, String password) {

		String consulta = "SELECT COUNT(*) FROM credenciales WHERE usuario =? AND password=?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setString(1, usuario);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next() && rs.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Método para saber que usuario es el actual, es decir el usuario que se
	 * registró
	 * 
	 * @param usuario de tipo String
	 * @return true si el usuario existe y false si no existe
	 */
	public boolean usuarioActual(String usuario) {
		String u = "SELECT usuario FROM credenciales";
		ArrayList<String> usuarios = new ArrayList<>();
		try {
			ps = con.prepareStatement(u);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuarios.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (u.contains(usuario)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método para insertar las credenciales de una persona previamente insertada
	 * 
	 * @param usuario
	 * @param contraseña
	 * @param idpersona
	 * @return
	 */
	public int insertar(String usuario, String contraseña, Long idpersona) {
		int filas = 0;
		String insertarCredenciales = "INSERT INTO credenciales (usuario, password, idpersona) VALUES (?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(insertarCredenciales, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, usuario);
			ps.setString(2, contraseña);
			ps.setLong(3, idpersona);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las credenciales.");
		}
		return filas;

	}

	/**
	 * Método para validar las credenciales
	 * 
	 * @param entidad de tipo Credencial
	 * @return true si las credenciales son correctas
	 */
	public boolean validarCredencial(Credencial c) {
		if (c == null) {
			return false;
		}
		if (c.getUsuario() == null || c.getUsuario().isEmpty()) {
			return false;
		} else if (!Controlador.getServicios().getServiciosCredencial().usuarioEsUnico(c.getUsuario())) {
			return false;
		} else if (c.getPassword() == null || c.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Método para comprobar que el usuario introducido sea único en la base de
	 * datos
	 * 
	 * @param usuario de tipo String
	 * @return true si el usuario es único
	 */
	public boolean UsuarioEsUnico(String usuario) {

		String consulta = "SELECT COUNT(*) FROM credenciales WHERE usuario = ?";

		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, usuario);

			ResultSet rs = ps.executeQuery();

			if (rs.next() && rs.getInt(1) > 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}

	/**
	 * Método para validar la contraseña introducida.
	 * 
	 * @param contraseña de tipo String
	 * @return true si la contraseña es válida
	 */
	public boolean validarContraseña(String contraseña) {
		if (!contraseña.matches("^(?=\\S+$).{8,}$")) {
			return false;
		}

		return true;
	}

}
