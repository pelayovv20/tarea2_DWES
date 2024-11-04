package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import com.mysql.cj.xdevapi.Statement;

import modelo.Planta;
import util.ConexionBD;

public class PlantaDAO implements OperacionesCRUD<Planta> {
	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	public PlantaDAO(Connection con) {
			this.con = con;
	}

	@Override
	public long insertar(Planta elemento) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Planta buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Planta> verTodos() {
		HashSet<Planta> plantas = new HashSet<Planta>();
		String consulta = "SELECT * FROM plantas";
		
		
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}

			 ps = con.prepareStatement(consulta);
			 rs = ps.executeQuery();

		while (rs.next()) {
				Planta nueva = new Planta(
						rs.getString("codigo"),
						rs.getString("nombrecomun"),
						rs.getString("nombrecientifico")
						);
				
				plantas.add(nueva);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return plantas;
		
		
	}

	@Override
	public boolean modificar(Planta p) {
		String consulta = "UPDATE plantas SET nombrecomun =?, nombrecientifico =? WHERE codigo =?";
		try {
			
			ps = con.prepareStatement(consulta);
			ps.setString(1, p.getNombrecomun());
			ps.setString(2, p.getNombrecientifico());
			ps.setString(3, p.getCodigo());
			
			
			int resultadomodificacion = ps.executeUpdate();
			if (resultadomodificacion == 1)
				return true;
			else
				return false;	

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean eliminar(Planta elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
