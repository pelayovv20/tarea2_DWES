package dao;

import java.sql.Connection;
import java.util.Collection;

import modelo.Mensaje;

public class MensajeDAO implements OperacionesCRUD<Mensaje> {

	Connection conex;

	public MensajeDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public long insertar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mensaje buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Mensaje> verTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Mensaje elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
