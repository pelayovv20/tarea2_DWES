package fachada;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import control.Controlador;
import modelo.Credencial;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;
import util.ConexionBD;

public class ViveroFachada {
	Scanner in = new Scanner(System.in);

	private static ViveroFachada portal;
	private static Controlador controlador = Controlador.getServicios();

	private ViveroFachada() {

	}

	public static ViveroFachada getPortal() {
		if (portal == null)
			portal = new ViveroFachada();
		return portal;
	}

	public void MenuInicial() {
		Scanner in = new Scanner(System.in);

		int opcion = 0;
		do {
			System.out.println("Sistema de gestión del vivero");
			System.out.println("1. Acceder como invitado");
			System.out.println("2. Iniciar sesión como personal/administrador");
			System.out.println("3. Salir");
			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				MenuInvitados();
				break;
			case 2:
				autenticarUsuario();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 3);

	}

	public void MenuInvitados() {
		Scanner in = new Scanner(System.in);

		int opcion = 0;

		do {
			System.out.println("MENÚ DE INVITADOS");
			System.out.println("1. Ver plantas");
			System.out.println("2. Iniciar Sesión");
			System.out.println("3. Salir");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verPlantas();
				MenuInvitados();
				break;
			case 2:
				autenticarUsuario();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción no válida");
				MenuInvitados();
			}
		} while (opcion != 3);
	}

	public void autenticarUsuario() {
		Scanner in = new Scanner(System.in);
		System.out.println("Usuario");
		String usuario = in.nextLine();
		System.out.println("Contraseña");
		String contraseña = in.nextLine();
		boolean autenticarUsuario = controlador.getServiciosCredencial().autenticarUsuario(usuario, contraseña);

		if (autenticarUsuario) {
			System.out.println("Sesión iniciado con el usuario " + usuario);
			if (usuario.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase("admin")) {
				MenuAdministrador();
			} else {
				MenuPersonal();
			}
		} else {
			System.out.println("Error al introducir usuario y contraseña");
		}
	}

	public void MenuAdministrador() {

		int opcion = 0;

		do {
			System.out.println("MENÚ DE ADMINISTRADOR");
			System.out.println("1. Gestionar Plantas");
			System.out.println("2. Gestionar Ejemplares.");
			System.out.println("3. Gestionar Personas.");
			System.out.println("4. Gestionar Mensaje.");
			System.out.println("5. Salir");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				MenuPrincipalPlantas();
				break;
			case 2:
				MenuPrincipalEjemplares();
				break;
			case 3:
				MenuPrincipalPersonas();
				break;
			case 4:
				MenuPrincipalMensajes();
				break;
			case 5:
				break;
			default:
				System.out.println("Opción no válida");
				MenuAdministrador();
			}
		} while (opcion != 5);

	}

	public void MenuPersonal() {

		int opcion = 0;

		do {
			System.out.println("MENÚ DEL PERSONAL");
			System.out.println("1. Gestionar ejemplares");
			System.out.println("2. Gestionar mensajes");
			System.out.println("3. Salir");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				MenuPrincipalEjemplares();
				break;
			case 2:
				MenuPrincipalMensajes();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción no válida");
				MenuPersonal();
			}

		} while (opcion != 3);
	}

	public void MenuPrincipalPlantas() {

		int opcion = 0;

		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Ver plantas.");
			System.out.println("2.  Crear nueva planta.");
			System.out.println("3.  Modificar datos de Planta(nombre común/nombre científico).");
			System.out.println("4.  Volver al menu Principal");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verPlantas();
				MenuPrincipalPlantas();
				break;
			case 2:
				insertarPlanta();
				MenuPrincipalPlantas();
				break;
			case 3:
				menuModificarPlantas();
				break;
			case 4:
				break;
			default:
				System.out.println("Opción no válida");

			}
		} while (opcion != 5);

	}

	public void menuModificarPlantas() {

		int opcion = 0;

		do {
			System.out.println("Selecciona una opcion:");
			System.out.println("1.  Modificar nombre común de una planta.");
			System.out.println("2.  Modificar nombre científico de una planta.");
			System.out.println("3.  Volver al menú principal de plantas.");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				// modificarNombreComun();
				break;
			case 2:
				// modificarNombreCientifico();
				break;
			case 3:
				break;
			default:
				System.out.println("Opcion no válida");
			}

		} while (opcion != 3);
	}

	public void MenuPrincipalEjemplares() {

		int opcion = 0;

		do {

			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Ver ejemplares por tipo de planta.");
			System.out.println("2.  Crear nuevo ejemplar.");
			System.out.println("3.  Volver al menu Principal");

			switch (opcion) {
			case 1:
				verEjemplares();
				break;
			case 2:
				insertarEjemplar();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (opcion != 3);
	}

	public void MenuPrincipalPersonas() {

		int opcion = 0;
		do {

			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Ver personas.");
			System.out.println("2.  Registrar nueva persona.");
			System.out.println("3.  Volver al menu Principal");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verPersonas();
				MenuPrincipalPersonas();
				break;
			case 2:
				insertarPersona();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (opcion != 3);
	}

	public void MenuPrincipalMensajes() {
		
		int opcion = 0;
		do {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver mensajes.");
		System.out.println("2.  Crear nuevo mensaje.");
		System.out.println("3.  Volver al menu Principal");
		
		opcion = in.nextInt();
		
		switch(opcion) {
		case 1:
			menuVerMensajes();
			break;
		case 2:
			
		}
		
		
		
		
		
	}while(opcion!=3);
	}

	public void menuVerMensajes() {
		System.out.println("1.  Ver mensajes de un ejemplar.");
		System.out.println("2.  Ver mensajes de cada persona.");
		System.out.println("3.  Ver mensajes por rango de fechas.");
		System.out.println("4.  Ver mensajes por tipo de planta.");
		System.out.println("5.  Volver al menú de mensajes.");
	}

	// MÉTODOS INSERTAR
	public static Planta insertarPlanta() {
		Scanner in = new Scanner(System.in);
		Planta p;
		boolean validacion = false;
		do {
			p = new Planta();
			System.out.println("Introduce los datos para una nueva planta");
			System.out.println("Id de la planta");
			String codigo = in.nextLine();
			p.setCodigo(codigo);
			System.out.println("Nombre comun de la planta");
			String nombrecomun = in.nextLine();
			p.setNombrecomun(nombrecomun);
			System.out.println("Nombre cientifico de la planta");
			String nombrecientifico = in.nextLine();
			p.setNombrecientifico(nombrecientifico);
			validacion = Controlador.getServicios().getServiciosPlanta().validarPlanta(p);
		} while (!validacion);

		Controlador.getServicios().getServiciosPlanta().insertar(p);
		return p;
	}

	public static Ejemplar insertarEjemplar() {
		Scanner in = new Scanner(System.in);
		Ejemplar e;
		boolean correcto = false;
		do {
			e = new Ejemplar();
			System.out.println("Introduce los datos para un nuevo ejemplar");
			System.out.println("Id del ejemplar");
			long id = in.nextLong();
			e.setId(id);
			System.out.println("Nombre del ejemplar");
			String nombre = e.getId_planta() + e.getId();
			e.setNombre(nombre);

		} while (!correcto);
		Controlador.getServicios().getServiciosEjemplar().insertar(e);
		return e;
	}

	public static Persona insertarPersona() {
		Scanner in = new Scanner(System.in);
		Persona p;
		boolean correcto = false;
		do {
			p = new Persona();
			System.out.println("Introduce los daos para una nueva persona");
			System.out.println("Id de la persona");
			long id = in.nextLong();
			p.setId(id);
			System.out.println("Nombre de la persona");
			String nombre = in.nextLine();
			p.setNombre(nombre);
			System.out.println("Email de la persona");
			String email = in.nextLine();
			p.setEmail(email);
			correcto = Controlador.getServicios().getServiciosPersona().validarPersona(p);

		} while (!correcto);
		Controlador.getServicios().getServiciosPersona().insertar(p);
		return p;
	}
	
//	public static Mensaje insertarMensaje() {
//		Scanner in = new Scanner(System.in);
//		Mensaje m;
//		boolean correcto = false;
//		do {
//			m = new Mensaje();
//			
//			
//			long id = in.nextLong();
//			p.setId(id);
//			System.out.println("Nombre de la persona");
//			String nombre = in.nextLine();
//			p.setNombre(nombre);
//			System.out.println("Email de la persona");
//			String email = in.nextLine();
//			p.setEmail(email);
//			correcto = Controlador.getServicios().getServiciosPersona().validarPersona(p);
//
//		} while (!correcto);
//		Controlador.getServicios().getServiciosPersona().insertar(p);
//		return m;
//	}

	// METODOS VER
	public void verPlantas() {
		ArrayList<Planta> plantas = (ArrayList<Planta>) controlador.getServiciosPlanta().verTodos();

		if (plantas == null || plantas.isEmpty()) {
			System.out.println("No se ha encontrado ninguna planta");
			return;
		} else {
			System.out.println("LISTADO DE PLANTAS DEL VIVERO");
			for (Planta p : plantas) {
				System.out.println(p);
			}
		}
	}

	public void verEjemplares() {
		ArrayList<Ejemplar> ejemplares = (ArrayList<Ejemplar>) controlador.getServiciosEjemplar().verTodos();

		if (ejemplares == null || ejemplares.isEmpty()) {
			System.out.println("No se ha encontrado ningun ejemplar");
			return;
		} else {
			System.out.println("LISTADO DE EJEMPLARES DEL VIVERO");
			for (Ejemplar e : ejemplares) {
				System.out.println(e);
			}
		}
	}

	public void verPersonas() {
		ArrayList<Persona> personas = (ArrayList<Persona>) controlador.getServiciosPersona().verTodos();

		if (personas == null || personas.isEmpty()) {
			System.out.println("No se ha encontrado ninguna persona");
			return;
		} else {
			System.out.println("LISTADO DE personas DEL VIVERO");
			for (Persona p : personas) {
				System.out.println(p);
			}
		}
	}
	
	

}
