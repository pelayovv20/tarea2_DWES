package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import modelo.Mensaje;
import util.ConexionBD;

public class MensajeDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public MensajeDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Método para insertar un mensaje en la base de datos
	 * 
	 * @param entidad de tipo Mensaje
	 * @return datos de tipo int (mensaje insertado)
	 */
	public long insertar(Mensaje m) {
		int datos = 0;
		String consulta = "INSERT INTO mensajes (fechahora, mensaje, idejemplar, idpersona) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setTimestamp(1, Timestamp.valueOf(m.getFechahora()));
			ps.setString(2, m.getMensaje());
			ps.setLong(3, m.getId_ejemplar());
			ps.setLong(4, m.getId_persona());
			datos = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Método para ver los mensajes dependiendo del ejmplar introducido
	 * 
	 * @param id del ejemplar de tipo long
	 * @return ArrayList de tipo Mensaje llamado mensajes
	 */
	public ArrayList<Mensaje> verMensajesEjemplar(long idEjemplar) {
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		String consulta = "SELECT id,fechahora,mensaje,idejemplar,idpersona FROM mensajes WHERE idejemplar = ?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {

			if (con == null || con.isClosed()) {
				con = ConexionBD.getConexion();
			}
			ps.setLong(1, idEjemplar);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Mensaje m = new Mensaje();
					m.setId(rs.getLong("id"));
					m.setFechahora(rs.getTimestamp("fechahora").toLocalDateTime());
					m.setMensaje(rs.getString("mensaje"));
					m.setId_ejemplar(rs.getLong("idejemplar"));
					m.setId_persona(rs.getLong("idpersona"));
					mensajes.add(m);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los mensajes del ejemplar: " + e.getMessage());
		}
		return mensajes;
	}

	/**
	 * Método para ver los mensajes dependiendo de la persona introducida
	 * 
	 * @param id de la persona de tipo long
	 * @return ArrayList de tipo Mensaje llamado mensajes
	 */
	public ArrayList<Mensaje> verMensajesPersona(long idPersona) {
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		String consulta = "SELECT id,fechahora,mensaje,idejemplar,idpersona FROM mensajes WHERE idpersona = ?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {

			if (con == null || con.isClosed()) {
				con = ConexionBD.getConexion();
			}
			ps.setLong(1, idPersona);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Mensaje m = new Mensaje();
					m.setId(rs.getLong("id"));
					m.setFechahora(rs.getTimestamp("fechahora").toLocalDateTime());
					m.setMensaje(rs.getString("mensaje"));
					m.setId_ejemplar(rs.getLong("idejemplar"));
					m.setId_persona(rs.getLong("idpersona"));
					mensajes.add(m);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return mensajes;
	}

	/**
	 * Método para ver los mensajes dependiendo de la planta introducida
	 * 
	 * @param codigo de la planta de tipo String
	 * @return ArrayList de tipo Mensaje llamado mensajes
	 */
	public ArrayList<Mensaje> verMensajesPlanta(String codigoPlanta) {
		ArrayList<Mensaje> mensajes = new ArrayList<>();
		String consulta = "SELECT mensajes.id, fechahora, mensaje, mensajes.idejemplar, mensajes.idpersona "
				+ "FROM mensajes " + "INNER JOIN ejemplares ON mensajes.idejemplar = ejemplares.id "
				+ "INNER JOIN plantas ON ejemplares.id_planta = plantas.codigo " + "WHERE plantas.codigo = ?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {

			if (con == null || con.isClosed()) {
				con = ConexionBD.getConexion();
			}
			ps.setString(1, codigoPlanta);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Mensaje m = new Mensaje();
					m.setId(rs.getLong("id"));
					m.setFechahora(rs.getTimestamp("fechahora").toLocalDateTime());
					m.setMensaje(rs.getString("mensaje"));
					m.setId_ejemplar(rs.getLong("idejemplar"));
					m.setId_persona(rs.getLong("idpersona"));
					mensajes.add(m);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return mensajes;
	}

	/**
	 * Método para validar el mensaje
	 * 
	 * @param mensaje de tipo String
	 * @return true si el mensaje es válido
	 */
	public boolean validarMensaje(String mensaje) {
		if (mensaje == null || mensaje.isEmpty()) {
			return false;
		}
		if (mensaje.length() > 500) {
			return false;
		}
		return true;
	}

}
