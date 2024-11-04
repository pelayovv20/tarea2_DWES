package fachada;

import util.ConexionBD;

public class ViveroFachada {

	private static ViveroFachada portal;
	
	ConexionBD factoriaDAO = ConexionBD.getCon();
	
}
