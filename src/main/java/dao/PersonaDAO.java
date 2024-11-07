package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Persona;
import modelo.Planta;
import util.ConexionBD;

public class PersonaDAO {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public PersonaDAO(Connection con) {

		this.con = con;
	}

	public long insertar(Persona p) {
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			ps = con.prepareStatement("INSERT INTO personas (nombre,email) VALUES(?,?)");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al registrar una persona " + e.getMessage());
			e.getStackTrace();
		}
		return 0;
	}

	public Collection<Persona> verTodos() {

		ArrayList<Persona> personas = new ArrayList<Persona>();
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
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return personas;

	}

	public boolean validarPersona(Persona p) {
		if (p == null) {
			return false;
		}

		if (p.getNombre() == null || p.getNombre().isEmpty()) {
			return false;
		}
		if (p.getEmail() == null || p.getEmail().isEmpty()) {
			return false;
		}
		return true;
	}

}
