package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.Ejemplar;
import modelo.Persona;
import util.ConexionBD;

public class EjemplarDAO  {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public EjemplarDAO(Connection con) {

		this.con = con;
	}


	public long insertar(Ejemplar e) {
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			
			ps = con.prepareStatement("INSERT INTO ejemplares(id,nombre,id_planta) VALUES(?,?,?)");
			ps.setLong(1, e.getId());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getId_planta());
			return ps.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("Ha ocurrido un error al insertar un ejemplar " + ex.getMessage());
			ex.printStackTrace();
		}
		return 0;
	}




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
				Ejemplar nuevo = new Ejemplar(rs.getLong("id"), rs.getString("nombre"), rs.getString("id_planta"));

				ejemplares.add(nuevo);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return ejemplares;
	}
	
	

}
