package control;

import dao.CredencialDAO;
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
	
	public boolean usuario(String usuario) {
		return credencialDAO.usuario(usuario);
	}

}
