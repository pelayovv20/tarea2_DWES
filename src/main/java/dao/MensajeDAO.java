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
	public boolean insertarConID(Mensaje elemento) {
		
		return false;
	}

	@Override
	public long insertarSinID(Mensaje elemento) {
		
		return 0;
	}

	@Override
	public Mensaje buscarPorID(long id) {
		
		return null;
	}

	@Override
	public Collection<Mensaje> buscarTodos() {
		
		return null;
	}

	@Override
	public boolean modificar(Mensaje elemento) {
		
		return false;
	}

	@Override
	public boolean eliminar(Mensaje elemento) {
		
		return false;
	}
}
