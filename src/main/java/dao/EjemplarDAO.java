package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Ejemplar;

public class EjemplarDAO implements OperacionesCRUD<Ejemplar> {

	Connection conex;

	public EjemplarDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public long insertar(Ejemplar elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ejemplar buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Ejemplar> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Ejemplar elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Ejemplar elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
