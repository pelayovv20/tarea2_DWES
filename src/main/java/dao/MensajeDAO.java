package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
import util.ConexionBD;

public class MensajeDAO implements OperacionesCRUD<Mensaje> {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public MensajeDAO(Connection con) {

		this.con = con;
	}

	@Override
	public long insertar(Mensaje m) {
		try {
			ps = con.prepareStatement(
					"INSERT INTO mensajes (id,fechahora,mensaje,idejemplar,idpersona) VALUES(?,?,?,?,?)");
			ps.setLong(1, m.getId());
			ps.setLocalDateTime(2, m.getFechahora());
			ps.setString(3, m.getMensaje());
			ps.setLong(4, m.getId_ejemplar());
			ps.setLong(5, m.getId_persona());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar un mensaje" + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Mensaje buscarPorID(long id) {
		return null;

	}

	@Override
	public Collection<Mensaje> verTodos() {
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		String consulta = "SELECT * FROM mensajes";

		try {
			if (con == null || con.isClosed()) {
				con = ConexionBD.getConexion();
			}

			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();

			while (rs.next()) {
				Mensaje m = new Mensaje(rs.getLong("id"), rs.getLocalDateTime("fechahora"), rs.getString("mensaje"),
						rs.getLong("idejemplar"), rs.getLong("idpersona"));

				mensajes.add(m);
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return mensajes;

	}

	@Override
	public boolean modificar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
