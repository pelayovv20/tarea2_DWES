package control;

import java.util.ArrayList;

import dao.EjemplarDAO;
import modelo.Ejemplar;
import util.ConexionBD;

public class ServiciosEjemplar {
	private ConexionBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexionBD.getInstance();
		ejemplarDAO = con.getEjemplarDAO();
	}

	public long insertar(Ejemplar e) {

		return ejemplarDAO.insertar(e);
	}

	public ArrayList<Ejemplar> verEjemplares(String codigoPlanta) {
		return ejemplarDAO.verEjemplares(codigoPlanta);
	}

	public boolean cambiarNombre(long idEjemplar, String nombre) {
		return ejemplarDAO.cambiarNombre(idEjemplar, nombre);
	}

}
