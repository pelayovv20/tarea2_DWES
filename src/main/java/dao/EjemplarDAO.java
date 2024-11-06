package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import modelo.Ejemplar;
import modelo.Planta;
import util.ConexionBD;

public class EjemplarDAO implements OperacionesCRUD<Ejemplar> {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public EjemplarDAO(Connection con) {
		
			this.con = con;
	}

	@Override
	public long insertar(Ejemplar e) {
		try {
			ps = con.prepareStatement("INSERT INTO ejemplares(id,nombre,id_planta) VALUES(?,?,?)");
			ps.setLong(1, e.getId());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getId_planta());
			return ps.executeUpdate();
			
			
		}catch(SQLException ex) {
			System.out.println("Ha ocurrido un error al insertar un ejemplar " + ex.getMessage());
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public Ejemplar buscarPorID(long id) {
		String consulta = "SELECT * FROM ejemplares WHERE id = ?";
	    Ejemplar e = null;
	    try {
	        ps = con.prepareStatement(consulta);
	        ps.setLong(1, id); 
	        rs = ps.executeQuery();
	        
	        
	        while(rs.next()) {
	            long idEjemplar = rs.getLong("id");
	            String nombre = rs.getString("nombre");
	            String codigoPlanta = rs.getString("id_planta");
	            e = new Ejemplar(idEjemplar, nombre, codigoPlanta);
	        }
	    } catch (SQLException ex) {
	        System.out.println("Se ha producido una SQLException: " + ex.getMessage());
	        ex.printStackTrace();
	    } catch (Exception exc) {
	        System.out.println("Se ha producido una Exception: " + exc.getMessage());
	        exc.printStackTrace();
	    }
	    
		return e;
	}

	@Override
	public Collection<Ejemplar> verTodos() {
		ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		String consulta = "SELECT * FROM ejemplares";
		
		
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}

			 ps = con.prepareStatement(consulta);
			 rs = ps.executeQuery();

		while (rs.next()) {
				Ejemplar nuevo = new Ejemplar(
						rs.getLong("id"),
						rs.getString("nombre"),
						rs.getString("id_planta")
						);
				
				ejemplares.add(nuevo);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ejemplares;
	}

	@Override
	public boolean modificar(Ejemplar elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
