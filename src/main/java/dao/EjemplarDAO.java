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
	public boolean insertarConID(Ejemplar elemento) {
		
		return false;
	}

	@Override
	public long insertarSinID(Ejemplar elemento) {
		
		return 0;
	}

	@Override
	public Ejemplar buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Ejemplar> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Ejemplar elemento) {
		
		return false;
	}

	@Override
	public boolean eliminar(Ejemplar elemento) {
		
		return false;
	}
}
