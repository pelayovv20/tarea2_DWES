package control;

import java.text.Normalizer;
import java.util.Collection;
import java.util.HashSet;

import dao.PlantaDAO;
import modelo.Planta;
import util.ConexionBD;

public class ServiciosPlanta {
	private ConexionBD con;
	private PlantaDAO plantaDAO;

	public ServiciosPlanta() {
		con = ConexionBD.getInstance();
		plantaDAO = (PlantaDAO) con.getPlantaDAO();
	}

	public boolean validarCodigo(String codigo) {
		return plantaDAO.validarCodigo(codigo);
	}

	public boolean validarPlanta(Planta p) {
		return plantaDAO.validarPlanta(p);
	}

	public long insertar(Planta p) {

		return plantaDAO.insertar(p);
	}

	public boolean modificarNombreComun(String codigo, String nombrecomun) {
		return plantaDAO.modificarNombreComun(codigo, nombrecomun);
	}

	public boolean modificarNombreCientifico(String codigo, String nombrecientifico) {
		return plantaDAO.modificarNombrecientifico(codigo, nombrecientifico);
	}

	public boolean codigoEsUnico(String codigo) {
		return plantaDAO.codigoEsUnico(codigo);
	}

	public Collection<Planta> verTodos() {
		return plantaDAO.verTodos();
	}

}
