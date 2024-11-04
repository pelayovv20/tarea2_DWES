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
		plantaDAO = (PlantaDAO) con.getPlantaDAO();
	}

	public boolean validarPlanta(Planta p) {
		boolean ret = false;
		if (p.getCodigo().isEmpty())
			return false;
		if (p.getCodigo().length() < 3 || p.getCodigo().length() > 20)
			return false;
		return true;
	}

	public long insertar(Planta p) {

		return plantaDAO.insertar(p);
	}
	
	public boolean modificar(Planta p) {
		return plantaDAO.modificar(p);
	}
	
	public boolean eliminar(Planta p) {
		return plantaDAO.eliminar(p);
	}
	
	public Collection<Planta> verTodos(){
		return plantaDAO.verTodos();
	}
	
	public Planta buscarPorId(long id) {
		return plantaDAO.buscarPorID(id);
	}
	
}
