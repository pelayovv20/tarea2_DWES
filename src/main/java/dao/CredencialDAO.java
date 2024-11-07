package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Credencial;
import modelo.Planta;

public class CredencialDAO {

	Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CredencialDAO(Connection con) {

		this.con = con;
	}

	public boolean autenticarUsuario(String usuario, String password) {

		String consulta = "SELECT COUNT(*) FROM credenciales WHERE usuario =? AND password=?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setString(1, "usuario");
			ps.setString(2, "password");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean usuario(String usuario) {
		String u = "SELECT usuario FROM credenciales";
		ArrayList<String> usuarios = new ArrayList<String>();
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
	
	public int insertar(String usuario, String contraseña, Long idPersona) {
		int filas = 0;
		String insertarCredenciales = "INSERT INTO credenciales (usuario, password, idPersona) VALUES (?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(insertarCredenciales,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, usuario);
			ps.setString(2, contraseña);
			ps.setLong(3, idPersona);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar las credenciales.");
		}
		return filas;

	}
	
	public boolean validarCredencial(Credencial c) {
		 if (c == null) {
		        return false;
		    }
		    if (c.getUsuario()==null||c.getUsuario().isEmpty()) {
		    	return false;
		    }else if(c.getPassword()==null||c.getPassword().isEmpty()) {
		    	return false;
		    }
		    return true;
	}

}
