package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import control.Controlador;
import modelo.Planta;
import util.ConexionBD;

public class PlantaDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PlantaDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método para insertar una planta en la base de datos
	 * 
	 * @param Entidad de tipo Planta
	 * @return 0 (planta insertada)
	 */

	public long insertar(Planta p) {
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			ps = con.prepareStatement("INSERT INTO plantas (codigo,nombrecomun,nombrecientifico) VALUES(?,?,?)");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getNombrecomun());
			ps.setString(3, p.getNombrecientifico());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar una planta" + e.getMessage());
		}
		return 0;
	}

	/**
	 * Método para ver todas las plantas que hay en la base de datos
	 * 
	 * @return un ArrayList de tipo Planta llamado plantas
	 */

	public Collection<Planta> verTodos() {
		ArrayList<Planta> plantas = new ArrayList<>();
		String consulta = "SELECT * FROM plantas";

		try {
			if (this.con == null || this.con.isClosed()) {
				this.con = ConexionBD.getConexion();
			}

			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Planta nueva = new Planta(rs.getString("codigo"), rs.getString("nombrecomun"),
						rs.getString("nombrecientifico"));

				plantas.add(nueva);
			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}

		return plantas;

	}

	/**
	 * Método para modificar el nombre común de una planta seleccionada en la base
	 * de datos
	 * 
	 * @param código de la planta de tipo String y
	 * @param nombre común de la planta de tipo String
	 * @return datos de tipo int
	 */

	public boolean modificarNombreComun(String codigo, String nombrecomun) {
		int datos = 0;
		String consulta = "UPDATE plantas SET nombrecomun = ? WHERE codigo = ?";
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombrecomun);
			ps.setString(2, codigo);
			datos = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return datos > 0;

	}

	/**
	 * Método para modificar el nombre científico de una planta seleccionada en la
	 * base de datos
	 * 
	 * @param codigo de la planta de tipo String
	 * @param nombre cientifico de la planta de tipo String
	 * @return datos de tipo int
	 */
	public boolean modificarNombrecientifico(String codigo, String nombrecientifico) {
		int datos = 0;
		String consulta = "UPDATE plantas SET nombrecientifico = ? WHERE codigo = ?";
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombrecientifico);
			ps.setString(2, codigo);
			datos = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return datos > 0;

	}

	/**
	 * Método para validar el código de una planta en la base de datos
	 * 
	 * @param codigo de la planta de tipo String
	 * @return true si el código es correcto
	 */
	public boolean validarCodigo(String codigoPlanta) {

		if (codigoPlanta == null || codigoPlanta.isEmpty()) {
			return false;
		} else if (!codigoPlanta.matches("^[a-zA-Z]+$")) {
			return false;
		} else if (Controlador.getServicios().getServiciosPlanta().existeCodigoPlanta(codigoPlanta)) {
			return false;
		}

		return true;
	}

	/**
	 * Método para validar la planta en la base de datos
	 * 
	 * @param entidad de tipo Planta
	 * @return true si la planta es correcta
	 */
	public boolean validarPlanta(Planta p) {
		if ((p == null) || p.getCodigo() == null || p.getCodigo().isEmpty()) {
			return false;
		}

		if (p.getNombrecomun() == null || p.getNombrecomun().isEmpty()) {
			return false;
		}
		if (p.getNombrecientifico() == null || p.getNombrecientifico().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Método para comprobar que el código de la planta introducido sea único en la
	 * base de datos
	 * 
	 * @param codigo de la planta de tipo String
	 * @return true si el codigo es único
	 */
	public boolean codigoEsUnico(String codigoPlanta) {

		String consulta = "SELECT COUNT(*) FROM plantas WHERE codigo = ?";

		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, codigoPlanta);

			ResultSet rs = ps.executeQuery();

			if (rs.next() && rs.getInt(1) > 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}

	/**
	 * Método para comprobar que el código de una planta introducido exista en la
	 * base de datos
	 * 
	 * @param codigo de planta de tipo String
	 * @return true si el código de la planta existe en la base de datos
	 */

	public boolean existeCodigoPlanta(String codigoPlanta) {
		ArrayList<String> codigos = new ArrayList<String>();
		String consulta = "SELECT codigo FROM plantas";
		try {
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			while (rs.next()) {
				codigos.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (codigos.contains(codigoPlanta.toUpperCase())) {
			return true;
		} else {
			return false;
		}
		
	}

}
