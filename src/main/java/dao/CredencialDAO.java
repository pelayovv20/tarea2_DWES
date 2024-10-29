package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Credencial;

public class CredencialDAO implements OperacionesCRUD<Credencial> {

	Connection conex;

	public CredencialDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Credencial elemento) {
		
		return false;
	}

	@Override
	public long insertarSinID(Credencial elemento) {
		
		return 0;
	}

	@Override
	public Credencial buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Credencial> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Credencial elemento) {
		
		return false;
	}

	@Override
	public boolean eliminar(Credencial elemento) {
		
		return false;
	}
}
