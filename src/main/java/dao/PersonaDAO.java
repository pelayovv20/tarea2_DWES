package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import modelo.Persona;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
