package control;

import dao.CredencialDAO;
import dao.EjemplarDAO;
import util.ConexionBD;

public class ServiciosCredencial {

	private ConexionBD con;
	private CredencialDAO credencialDAO;
	
	
	public ServiciosCredencial() {
		con=ConexionBD.getInstance();
		credencialDAO = (CredencialDAO) con.getCredencialDAO();
	}
	
	public boolean autenticarUsuario(String usuario, String password) {
		return credencialDAO.autenticarUsuario(usuario, password);
	}

}
