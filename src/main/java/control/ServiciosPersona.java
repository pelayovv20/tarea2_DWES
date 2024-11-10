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
		personaDAO = con.getPersonaDAO();
	}

	public long insertar(Persona p) {

		return personaDAO.insertar(p);
	}

	public Collection<Persona> verTodos() {
		return personaDAO.verTodos();
	}

	public boolean validarPersona(Persona p) {
		return personaDAO.validarPersona(p);
	}

	public long personaAutenticada(String usuario) {
		return personaDAO.personaAutenticada(usuario);
	}

	public boolean emailEsUnico(String email) {
		return personaDAO.emailEsUnico(email);
	}
}
