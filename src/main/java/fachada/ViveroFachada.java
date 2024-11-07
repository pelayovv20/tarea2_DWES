package fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import control.Controlador;
import modelo.Credencial;
import modelo.Ejemplar;
import modelo.Mensaje;
import modelo.Persona;
import modelo.Planta;

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

	public void menuInicial() {
		Scanner in = new Scanner(System.in);

		int opcion = 0;
		do {
			System.out.println("Sistema de gestión del vivero");
			System.out.println("1. Acceder como invitado");
			System.out.println("2. Iniciar sesión como personal/administrador");
			System.out.println("3. Salir del vivero");
			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				menuInvitados();
				break;
			case 2:
				autenticarUsuario();
				break;
			case 3:
				break;
			default:
				System.out.println("Opción incorrecta.");
			}
		} while (opcion != 3);

	}

	public void menuInvitados() {
		Scanner in = new Scanner(System.in);

		int opcion = 0;

		do {
			System.out.println("MENÚ DE INVITADOS");
			System.out.println("1. Ver plantas");
			System.out.println("2. Iniciar sesión como personal/administrador");
			System.out.println("3. Volver al menú inicial");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verPlantas();
				break;
			case 2:
				autenticarUsuario();
				break;
			case 3:
				System.out.println("Saliendo del menú de INVITADOS");
			}

			if (opcion < 1 || opcion > 3) {
				System.out.println("Opción incorrecta");
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
			controlador.getServiciosCredencial().usuario(usuario);
			if (usuario.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase("admin")) {
				menuAdministrador();
			} else {
				menuPersonal();
			}
		} else {
			System.out.println("Error al introducir usuario y contraseña");
		}
	}

	public void menuAdministrador() {

		int opcion = 0;

		do {
			System.out.println("MENÚ DE ADMINISTRADOR");
			System.out.println("1. Gestionar Plantas");
			System.out.println("2. Gestionar Ejemplares.");
			System.out.println("3. Gestionar Personas.");
			System.out.println("4. Gestionar Mensaje.");
			System.out.println("5. Cerrar Sesión");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				menuPrincipalPlantas();
				break;
			case 2:
				menuPrincipalEjemplares();
				break;
			case 3:
				menuPrincipalPersonas();
				break;
			case 4:
				menuPrincipalMensajes();
				break;
			case 5:
				System.out.println("Saliendo del menú de ADMINISTRADOR");
			}

			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 5);

	}

	public void menuPersonal() {

		int opcion = 0;

		do {
			System.out.println("MENÚ DEL PERSONAL");
			System.out.println("1. Ver plantas");
			System.out.println("2. Gestionar ejemplares");
			System.out.println("3. Gestionar mensajes");
			System.out.println("4. Cerrar Sesión");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verPlantas();

				break;
			case 2:
				menuPrincipalEjemplares();
				break;
			case 3:
				menuPrincipalMensajes();
				break;
			case 4:
				System.out.println("Saliendo del menú de PERSONAL");
			}
			if (opcion < 1 || opcion > 4) {
				System.out.println("Opción incorrecta");
			}

		} while (opcion != 4);
	}

	public void menuPrincipalPlantas() {

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

				break;
			case 2:
				insertarPlanta();

				break;
			case 3:
				menuModificarPlantas();
				break;
			default:
				System.out.println("Opción incorrecta.");

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
				modificarNombreComunPlanta();
				break;
			case 2:
				// modificarNombreCientifico();
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcion != 3);
	}

	public void menuPrincipalEjemplares() {

		int opcion = 0;

		do {

			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Ver ejemplares por tipo de planta.");
			System.out.println("2.  Crear nuevo ejemplar.");
			System.out.println("3.  Volver al menu Principal");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verEjemplares();
				break;
			case 2:
				insertarEjemplar();
				break;
			default:
				System.out.println("Opción incorrecta.");
			}
		} while (opcion != 3);
	}

	public void menuPrincipalPersonas() {

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

				break;
			case 2:
				insertarPersona();

				break;
			default:
				System.out.println("Opción incorrecta.");

			}

		} while (opcion != 3);
	}

	public void menuPrincipalMensajes() {

		int opcion = 0;
		do {
			System.out.println("Seleccione una opcion:");
			System.out.println("1.  Ver mensajes.");
			System.out.println("2.  Crear nuevo mensaje.");
			System.out.println("3.  Volver al menu Principal");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				menuVerMensajes();
				break;
			case 2:
				// insertarMensaje();
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcion != 3);
	}

	public void menuVerMensajes() {
		int opcion = 0;
		do {
			System.out.println("1.  Ver mensajes de un ejemplar.");
			System.out.println("2.  Ver mensajes de cada persona.");
			System.out.println("3.  Ver mensajes por rango de fechas.");
			System.out.println("4.  Ver mensajes por tipo de planta.");
			System.out.println("5.  Volver al menú de mensajes.");

			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				verMensajes();
				break;
			case 2:
				// verMensajesPersona();
				break;
			case 3:
				// verMensajesFecha();
				break;
			case 4:
				// verMensajesPlanta();
				break;
			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcion != 5);
	}

	// MÉTODOS INSERTAR
	public Planta insertarPlanta() {
		Scanner in = new Scanner(System.in);
		Planta p;
		boolean correcto = false;
		boolean validarCodigo = false;
		do {
			p = new Planta();
			do {
				System.out.println("Codigo de la planta");
				String codigo = in.nextLine().trim().toUpperCase();
				try {
				validarCodigo = controlador.getServiciosPlanta().validarCodigo(codigo);
				}catch(Exception e) {
					System.out.println("Error en la base de datos" + e.getMessage());
				}
				if (validarCodigo == false) {
					System.out.println("Codigo de planta incorrecto");
				} else {
					p.setCodigo(codigo);
				}
			} while (validarCodigo==false);

			System.out.print("Nombre común: ");
			String nombrecomun = in.nextLine();
			p.setNombrecomun(nombrecomun);
			System.out.print("Nombre científico: ");
			String nombrecientifico = in.nextLine();
			p.setNombrecientifico(nombrecientifico);
			correcto = controlador.getServiciosPlanta().validarPlanta(p);
			if (!correcto) {
				System.out.println("Los datos que has introducido no son correctos.");
			}

		} while (!correcto);

		try {
			controlador.getServiciosPlanta().insertar(p);
			System.out.println("Planta insertada");
		} catch (Exception ex) {
			System.out.println("Error al insertar la planta: " + ex.getMessage());
		}
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
		Credencial c;
		boolean correcto = false;
		String perfil="";
		String password="";
		do {
			p = new Persona();
			c = new Credencial();
			System.out.println("Introduce los daos para una nueva persona");
			System.out.println("Nombre de la persona");
			String nombre = in.nextLine().trim();
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
			System.out.println("LISTADO DE PERSONAS DEL VIVERO");
			for (Persona p : personas) {
				System.out.println(p);
			}
		}
	}

	public void verMensajes() {
		ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) controlador.getServiciosMensaje().verTodos();

		if (mensajes == null || mensajes.isEmpty()) {
			System.out.println("No se ha encontrado ningun mensaje");
			return;
		} else {
			System.out.println("LISTADO DE MENSAJES DEL VIVERO");
			for (Mensaje m : mensajes) {
				System.out.println(m);
			}
		}
	}

	public void modificarNombreComunPlanta() {
		Scanner in = new Scanner(System.in);
		boolean validacion;
		String codigoPlanta;

		do {
			System.out.println("Codigo de la planta");
			codigoPlanta = in.nextLine().trim().toUpperCase();
			validacion = controlador.getServiciosPlanta().validarCodigo(codigoPlanta);
			if (validacion == false) {
				System.out.println("Codigo de planta incorrecto");
			}
		} while (validacion == false);
		System.out.println("Codigo de planta correcto");

		System.out.println("Nuevo nombre común de la planta");
		String nombrecomun = in.nextLine().trim();
		try {
			boolean nuevo = controlador.getServiciosPlanta().modificarNombreComun(codigoPlanta, nombrecomun);
			if (nuevo) {
				System.out.println("El nombre común de la planta con código " + codigoPlanta
						+ "ha sido actualizado, ahora el nombre es" + nombrecomun);
			} else {
				System.out.println("Error al intentar actualizar el nombre común");
			}
		} catch (Exception ex) {
			System.out.println("Error al actualizar el nombre común: " + ex.getMessage());
		}

	}

}
