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
	public long insertar(Persona elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Persona buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Persona> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Persona elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
