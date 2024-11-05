package fachada;

import java.util.HashSet;
import java.util.Scanner;

import control.Controlador;
import modelo.Credencial;
import modelo.Ejemplar;
import modelo.Persona;
import modelo.Planta;
import util.ConexionBD;

public class ViveroFachada {
	Scanner in = new Scanner(System.in);

	private Credencial credencial;
	private static ViveroFachada portal;
	public ViveroFachada() {
        this.credencial = null; // Inicialmente, sin autenticación
    }
	
	private static Controlador controlador = Controlador.getServicios();
	//ConexionBD conexionBD = (ConexionBD) ConexionBD.getConexion();
	
//	Controlador servEjemplar = control.Controlador.getServicios();
//	Controlador servPlanta = control.Controlador.getServicios();
//	Controlador servPersona = control.Controlador.getServicios();
//	Controlador servMensaje = control.Controlador.getServicios();
	
	
	public static ViveroFachada getPortal() {
		if (portal==null)
			portal=new ViveroFachada();
		return portal;
	}
	
	public void mostrarMenuInicial() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Sistema de gestión del vivero");
		System.out.println("1. Acceder como invitado");
		System.out.println("2. Iniciar sesión como trabajador/administrador");
		
		int opcion = in.nextInt();
		switch(opcion) {
		case 1:
			mostrarMenuInvitados();
			break;
		case 2:
			autenticarUsuario();
			break;
		default:
			System.out.println("Opción no válida");
		}
	}
	
	public void mostrarMenuInvitados() {
		System.out.println("MENÚ DE INVITADOS");
		System.out.println("1. Ver plantas");
		System.out.println("2. Iniciar Sesión");
		System.out.println("3. Salir");
		
		int opcion = in.nextInt();
		
		switch(opcion) {
		case 1:
			Controlador.getServicios().getServiciosPlanta().verPorNombre(null);
			mostrarMenuInvitados();
			break;
		case 2:
			autenticarUsuario();
			break;
		case 3:
			break;
		default:
			System.out.println("Opción no válida");
			mostrarMenuInvitados();
		}
	}
	
	
	public void autenticarUsuario() {
		Scanner in = new Scanner (System.in);
		System.out.println("Usuario");
		String usuario = in.nextLine();
		System.out.println("Contraseña");
		String contraseña = in.nextLine();
		
		if (usuario.equals("admin") && contraseña.equals("admin")) {
			mostrarMenuAdministrador();
		}else {
			mostrarMenuPersonal();
		}
		
	}
	
	public void mostrarMenuAdministrador() {
		System.out.println("MENÚ DE ADMINISTRADOR");
		System.out.println("1. Gestionar Plantas");
		System.out.println("2. Gestionar Ejemplares.");
		System.out.println("3. Gestionar Personas.");
		System.out.println("4. Gestionar Mensaje.");
		System.out.println("5. Salir");
		
		int opcion = in.nextInt();
		
		switch(opcion) {
		case 1:
			mostrarMenuPrincipalPlantas();
			break;
		case 2:
			mostrarMenuPrincipalEjemplares();
			break;
		case 3:
			mostrarMenuPrincipalPersonas();
			break;
		case 4:
			mostrarMenuPrincipalMensajes();
			break;
		case 5:
			break;
		default:
			System.out.println("Opción no válida");
			mostrarMenuAdministrador();
		}
	}
	
	public void mostrarMenuPersonal() {
		System.out.println("MENÚ DE TRABAJADORES");
		System.out.println("1. Gestionar ejemplares");
		System.out.println("2. Gestionar mensajes");
		System.out.println("3. Salir");
		
int opcion = in.nextInt();
		
		switch(opcion) {
		case 1:
			mostrarMenuPrincipalEjemplares();
			break;
		case 2:
			mostrarMenuPrincipalMensajes();
			break;
		case 3:
			break;
		default:
			System.out.println("Opción no válida");
			mostrarMenuPersonal();
		}
		
	}

	 


	public void mostrarMenuPrincipalPlantas() {
		System.out.println("Seleccione una opcion:");
		System.out.println("1.  Ver plantas.");
		System.out.println("2.  Crear nueva planta.");
		System.out.println("3.  Modificar datos de Planta.");
		System.out.println("4.  Eliminar Planta.");
		System.out.println("5.  Volver al menu Principal");
		
		int opcion = in.nextInt();
		
		switch(opcion) {
		case 1:
			
		}
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
	public void menuModificarPlantas() {
		System.out.println("Selecciona una opcion:");
		System.out.println("1.  Modificar nombre común de una planta.");
		System.out.println("2.  Modificar nombre científico de una planta.");
		System.out.println("3.  Volver al menú principal de plantas.");
	}
	public void menuVerMensajes() {
		System.out.println("1.  Ver mensajes de un ejemplar.");
		System.out.println("2.  Ver mensajes de cada persona.");
		System.out.println("3.  Ver mensajes por rango de fechas.");
		System.out.println("4.  Ver mensajes por tipo de planta.");
		System.out.println("5.  Volver al menú de mensajes.");
	}
	
	
	public static Planta nuevaPlanta() {
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
		}while(!validacion);
		
			Controlador.getServicios().getServiciosPlanta().insertar(p);
			return p;
	}
	
//	private void verPlantas() {
//        Collection<Planta> plantas = plantaDAO.verTodos(); // Obtener todas las plantas
//        if (plantas.isEmpty()) {
//            System.out.println("No hay plantas registradas.");
//        } else {
//            System.out.println("Listado de plantas:");
//            for (Planta planta : plantas) {
//                System.out.println(planta); // Supone que la clase Planta tiene un método toString adecuado
//            }
//        }
//    }
	
	
	public static Ejemplar nuevoEjemplar() {
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
			
			
			
		}while(!correcto);
		Controlador.getServicios().getServiciosEjemplar().insertar(e);
		return e;
	}
	
	public static Persona nuevaPersona() {
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
			
		}while(!correcto);
		Controlador.getServicios().getServiciosPersona().insertar(p);
		return p;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mostrarMenuGestionPlantas() {
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.println("GESTIÓN DE PLANTAS");
		
		int opcion = 0;
		
		do {
			mostrarMenuPrincipalPlantas();
			opcion = in.nextInt();
			if (opcion<1 || opcion>6) {
				System.out.println("Opcion incorrecta");
				continue;
			}
			switch(opcion) {
			case 1:
				System.out.println("VER PLANTAS");
				HashSet<Planta> plantas = new HashSet<Planta>();
				String nombre = "";
				plantas = servPlanta.getServiciosPlanta().verPorNombre(nombre);
				for (Planta p:plantas) {
					System.out.println(p);
				}
			case 2:
				System.out.println("CREAR NUEVA PLANTA");
				
			}
		}while(opcion!=6);
		
		
		
		
		
	}
	
	
	
}
