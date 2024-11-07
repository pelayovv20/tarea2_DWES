package fachada;

import control.Controlador;

public class Principal {
	

	public static void main(String[] args) {
		
		
		ViveroFachada portal = ViveroFachada.getPortal();
		
		ViveroFachada.getPortal().menuInicial();
		
		
	
	}

}
