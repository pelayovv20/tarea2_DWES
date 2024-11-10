package control;

import java.util.ArrayList;

import dao.MensajeDAO;
import modelo.Mensaje;
import util.ConexionBD;

public class ServiciosMensaje {
	private ConexionBD con;
	private MensajeDAO mensajeDAO;

	public ServiciosMensaje() {
		con = ConexionBD.getInstance();
		mensajeDAO = con.getMensajeDAO();
	}

	public long insertar(Mensaje m) {

		return mensajeDAO.insertar(m);
	}

	public ArrayList<Mensaje> verMensajesEjemplar(long idEjemplar) {
		return mensajeDAO.verMensajesEjemplar(idEjemplar);
	}

	public ArrayList<Mensaje> verMensajesPersona(long idPersona) {
		return mensajeDAO.verMensajesPersona(idPersona);
	}

	public ArrayList<Mensaje> verMensajesPlanta(String codigoPlanta) {
		return mensajeDAO.verMensajesPlanta(codigoPlanta);
	}

	public boolean validarMensaje(String mensaje) {
		return mensajeDAO.validarMensaje(mensaje);
	}

}
