package fachada;

import util.MySqlDAOFactory;

public class ViveroFachada {

	private static ViveroFachada portal;
	
	MySqlDAOFactory factoriaDAO = MySqlDAOFactory.getCon();
	
}
