package control;

import java.util.Collection;

import dao.PlantaDAO;
import modelo.Planta;
import util.ConexionBD;

public class ServiciosPlanta {
	private ConexionBD con;
	private PlantaDAO plantaDAO;

	public ServiciosPlanta() {
		con = ConexionBD.getInstance();
		plantaDAO = con.getPlantaDAO();
	}

	public long insertar(Planta p) {

		return plantaDAO.insertar(p);
	}

	public boolean validarCodigo(String codigoPlanta) {
		return plantaDAO.validarCodigo(codigoPlanta);
	}

	public boolean validarPlanta(Planta p) {
		return plantaDAO.validarPlanta(p);
	}

	public boolean modificarNombreComun(String codigo, String nombrecomun) {
		return plantaDAO.modificarNombreComun(codigo, nombrecomun);
	}

	public boolean modificarNombreCientifico(String codigo, String nombrecientifico) {
		return plantaDAO.modificarNombrecientifico(codigo, nombrecientifico);
	}

	public boolean codigoEsUnico(String codigoPlanta) {
		return plantaDAO.codigoEsUnico(codigoPlanta);
	}

	public Collection<Planta> verTodos() {
		return plantaDAO.verTodos();
	}

	public boolean existeCodigoPlanta(String codigoPlanta) {
		return plantaDAO.existeCodigoPlanta(codigoPlanta);
	}

}
