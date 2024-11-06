package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import modelo.Persona;
import modelo.Planta;
import util.ConexionBD;

public class PersonaDAO implements OperacionesCRUD<Persona> {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public PersonaDAO(Connection con) {
		
			this.con = con;
	}

	@Override
	public long insertar(Persona p) {
		try {
			ps = con.prepareStatement("INSERT INTO personas (id,nombre,email) VALUES(?,?,?)");
			ps.setLong(1, p.getId());
			ps.setString(2,p.getNombre());
			ps.setString(3, p.getEmail());
			return ps.executeUpdate();
		}catch(SQLException e){
			System.out.println("Error al registrar una persona " + e.getMessage());
			e.getStackTrace();
		}
		return 0;
	}

	@Override
	public Persona buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
				Persona nueva = new Persona(
						rs.getLong("id"),
						rs.getString("nombre"),
						rs.getString("email")
						);
				
				personas.add(nueva);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return personas;
		
	}

	@Override
	public boolean modificar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
