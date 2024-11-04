package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Credencial;

public class CredencialDAO implements OperacionesCRUD<Credencial> {

	Connection con;

	public CredencialDAO(Connection con) {
		
			this.con = con;
	}

	@Override
	public long insertar(Credencial elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Credencial buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Credencial> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Credencial elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Credencial elemento) {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
