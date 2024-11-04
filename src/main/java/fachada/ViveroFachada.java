package fachada;

import control.Controlador;
import util.ConexionBD;

public class ViveroFachada {

	private static ViveroFachada portal;
	
	ConexionBD conexionBD = (ConexionBD) ConexionBD.getConexion();
	
	Controlador servEjemplar = control.Controlador.getServicios();
	Controlador servPlanta = control.Controlador.getServicios();
	Controlador servPersona = control.Controlador.getServicios();
	Controlador servMensaje = control.Controlador.getServicios();
	
	
	public static ViveroFachada getPortal() {
		if (portal==null)
			portal=new ViveroFachada();
		return portal;
	}

	public void mostrarMenuPrincipal() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Gestionar Plantas.");
		System.out.println("2.  Gestionar Ejemplares.");
		System.out.println("3.  Gestionar Personas.");
		System.out.println("4.  Gestionar Mensaje.");
		System.out.println("5.  Salir");
	}


	public void mostrarMenuPrincipalPlantas() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver plantas.");
		System.out.println("2.  Crear nueva planta.");
		System.out.println("3.  Modificar datos de Planta.");
		System.out.println("4.  Eliminar Planta.");
		System.out.println("5.  Volver al menu Principal");
	}
	
	public void mostrarMenuPrincipalEjemplares() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver ejemplares por tipo de planta.");
		System.out.println("2.  Crear nuevo ejemplar.");
		System.out.println("3.  Eliminar Ejemplar.");
		System.out.println("4.  Volver al menu Principal");
	}
	
	public void mostrarMenuPrincipalPersonas() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver personas.");
		System.out.println("2.  Registrar nueva persona.");
		System.out.println("3.  Eliminar persona");
		System.out.println("4.  Volver al menu Principal");
	}
	
	public void mostrarMenuPrincipalMensajes() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver mensajes.");
		System.out.println("2.  Crear nuevo mensaje.");
		System.out.println("3.  Eliminar persona");
		System.out.println("4.  Volver al menu Principal");
	}
	
	
	
}
