package control;

import java.util.Collection;

import dao.EjemplarDAO;
import modelo.Ejemplar;
import util.ConexionBD;

public class ServiciosEjemplar {
	private ConexionBD con;
	private EjemplarDAO ejemplarDAO;

	public ServiciosEjemplar() {
		con = ConexionBD.getInstance();
		ejemplarDAO = (EjemplarDAO) con.getEjemplarDAO();
	}
	
	public boolean validarEjemplar (Ejemplar e) {
		
		if (e.getId()!=0) {
			if (e.getId()<0) {
				return false;
			}
		}
		return true;
	}

	public long insertar(Ejemplar e) {

		return ejemplarDAO.insertar(e);
	}
	
	public boolean modificar(Ejemplar e) {
		return ejemplarDAO.modificar(e);
	}
	
	
	
	public Collection<Ejemplar> verTodos(){
		return ejemplarDAO.verTodos();
	}
	
	public Ejemplar buscarPorID(long id) {
		return ejemplarDAO.buscarPorID(id);
	}
	
}
