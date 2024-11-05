package control;

import java.util.Collection;

import dao.PersonaDAO;
import modelo.Persona;
import util.ConexionBD;

public class ServiciosPersona {

	private ConexionBD con;
	private PersonaDAO personaDAO;

	public ServiciosPersona() {
		con = ConexionBD.getInstance();
		personaDAO = (PersonaDAO) con.getPersonaDAO();
	}
	
	public boolean validarPersona(Persona p) {
		return true;
	}

	public long insertar(Persona p) {

		return personaDAO.insertar(p);
	}
	
	public boolean modificar(Persona p) {
		return personaDAO.modificar(p);
	}
	
	public boolean eliminar(Persona p) {
		return personaDAO.eliminar(p);
	}
	
	public Collection<Persona> verTodos(){
		return personaDAO.verTodos();
	}
	
	public Persona buscarPorId(long id) {
		return personaDAO.buscarPorID(id);
	}
}
