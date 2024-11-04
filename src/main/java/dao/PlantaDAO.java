package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import com.mysql.cj.xdevapi.Statement;

import modelo.Planta;
import util.MySqlDAOFactory;

public class PlantaDAO implements OperacionesCRUD<Planta> {

	Connection conex;

	public PlantaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
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
			if (conex == null) {
				conex = MySqlDAOFactory.getConexion();
			}

			PreparedStatement ps = conex.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();

		while (rs.next()) {
				Planta nueva = new Planta(
						rs.getString("codigo"),
						rs.getString("nombrecomun"),
						rs.getString("nombrecientifico")
						);
				
				plantas.add(nueva);
			}
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return plantas;
		
		
	}

	@Override
	public boolean modificar(Planta elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Planta elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
