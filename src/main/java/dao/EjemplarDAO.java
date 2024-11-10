package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Ejemplar;

public class EjemplarDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EjemplarDAO(Connection con) {

		this.con = con;
	}

	/**
	 * Método para insertar un ejemplar en la base de datos
	 * 
	 * @param entidad de tipo Ejemplar
	 * @return id del ejemplar de tipo long (Ejemplar insertado)
	 */
	public long insertar(Ejemplar e) {
		String consulta = "INSERT INTO ejemplares (nombre, id_planta) VALUES (?, ?)";
		long idEjemplar = 0;
		try (PreparedStatement ps = con.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getId_planta());
			int filas = ps.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						idEjemplar = rs.getLong(1);
					}
				}
			}
		} catch (SQLException ex) {
			System.out.println("Error al insertar el ejemplar: " + ex.getMessage());
		}
		return idEjemplar;
	}

	/**
	 * Método para ver los ejemplares de la base de datos
	 * 
	 * @param código de la planta de tipo String
	 * @return ArrayList de tipo Ejemplar llamado ejemplares
	 */
	public ArrayList<Ejemplar> verEjemplares(String codigoPlanta) {
		ArrayList<Ejemplar> ejemplares = new ArrayList<>();
		String consulta = "SELECT * FROM ejemplares WHERE id_planta = ?";

		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setString(1, codigoPlanta);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Ejemplar e = new Ejemplar();
					e.setId(rs.getLong("id"));
					e.setNombre(rs.getString("nombre"));
					e.setId_planta(codigoPlanta);
					ejemplares.add(e);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ejemplares;
	}

	/**
	 * Método para cambiar el nombre de un ejemplar una vez creado
	 * 
	 * @param id del ejemplar que se insertó de tipo long
	 * @param el nuevo nombre del ejemplar que será el código de la planta + el id
	 *           del ejemplar
	 * @return datos de tipo int
	 */
	public boolean cambiarNombre(long idEjemplar, String nombre) {
		String consulta = "UPDATE ejemplares SET nombre = ? WHERE id = ?";
		try (PreparedStatement ps = con.prepareStatement(consulta)) {
			ps.setString(1, nombre);
			ps.setLong(2, idEjemplar);
			int datos = ps.executeUpdate();
			return datos > 0;
		} catch (SQLException e) {
			System.out.println("Error al actualizar el nombre del ejemplar: " + e.getMessage());
		}
		return false;
	}

}
