package control;

import dao.CredencialDAO;
import modelo.Credencial;
import util.ConexionBD;

public class ServiciosCredencial {

	private ConexionBD con;
	private CredencialDAO credencialDAO;

	public ServiciosCredencial() {
		con = ConexionBD.getInstance();
		credencialDAO = con.getCredencialDAO();
	}

	public int insertar(String usuario, String contraseña, Long idpersona) {
		return credencialDAO.insertar(usuario, contraseña, idpersona);
	}

	public boolean autenticarUsuario(String usuario, String password) {

		return credencialDAO.autenticarUsuario(usuario, password);
	}

	public boolean usuarioActual(String usuario) {
		return credencialDAO.usuarioActual(usuario);
	}

	public boolean validarCredencial(Credencial c) {
		return credencialDAO.validarCredencial(c);
	}

	public boolean usuarioEsUnico(String usuario) {
		return credencialDAO.UsuarioEsUnico(usuario);
	}

	public boolean validarContraseña(String contraseña) {
		return credencialDAO.validarContraseña(contraseña);
	}

}
