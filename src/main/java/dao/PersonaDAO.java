package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Persona;

public class PersonaDAO implements OperacionesCRUD<Persona> {

	Connection conex;

	public PersonaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Persona elemento) {
		
		return false;
	}

	@Override
	public long insertarSinID(Persona elemento) {
		
		return 0;
	}

	@Override
	public Persona buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Persona> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Persona elemento) {
		
		return false;
	}

	@Override
	public boolean eliminar(Persona elemento) {
		
		return false;
	}
}
