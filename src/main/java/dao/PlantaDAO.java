package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import control.Controlador;
import modelo.Planta;
import util.ConexionBD;

public class PlantaDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	public PlantaDAO(Connection con) {
		this.con = con;
	}

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

	public Collection<Planta> verTodos() {
		ArrayList<Planta> plantas = new ArrayList<Planta>();
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

	public boolean modificarNombreComun(String codigo, String nombrecomun) {
		int filasActualizadas = 0;
		String consulta = "UPDATE plantas SET nombrecomun = ? WHERE codigo = ?";
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombrecomun);
			ps.setString(2, codigo);
			filasActualizadas = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return filasActualizadas > 0;

	}

	public boolean modificarNombrecientifico(String codigo, String nombrecientifico) {
		int filasActualizadas = 0;
		String consulta = "UPDATE plantas SET nombrecientifico = ? WHERE codigo = ?";
		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, nombrecientifico);
			ps.setString(2, codigo);
			filasActualizadas = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return filasActualizadas > 0;

	}

	public boolean validarCodigo(String codigo) {

		if (codigo == null || codigo.isEmpty()) {
			return false;
		} else if (!codigo.matches("^[a-zA-Z]+$")) {
			return false;
		} else if (Controlador.getServicios().getServiciosPlanta().codigoEsUnico(codigo)) {
			return false;
		}
		return true;
	}

	public boolean validarPlanta(Planta p) {
		if (p == null) {
			return false;
		}
		if (p.getCodigo() == null || p.getCodigo().isEmpty()) {
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

	public boolean codigoEsUnico(String codigo) {

		String consulta = "SELECT COUNT(*) FROM plantas WHERE codigo = ?";

		try {
			if (con == null) {
				con = ConexionBD.getConexion();
			}
			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, codigo);

			ResultSet rs = ps.executeQuery();

			if (rs.next() && rs.getInt(1) > 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}

}
