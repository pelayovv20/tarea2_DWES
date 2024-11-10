package control;



public class Controlador {


	private static Controlador servicios;
	private String usuarioActual;
	private ServiciosPlanta servPlanta;
	private ServiciosEjemplar servEjemplar;
	private ServiciosPersona servPersona;
	private ServiciosMensaje servMensaje;
	private ServiciosCredencial servCredencial;
	


	public static Controlador getServicios() {
		if (servicios == null) {
			servicios = new Controlador();
		}
		return servicios;
	}


	private Controlador() {
		servPlanta = new ServiciosPlanta();
		servEjemplar = new ServiciosEjemplar();
		servPersona = new ServiciosPersona();
		servMensaje = new ServiciosMensaje();
		servCredencial = new ServiciosCredencial();
	}


	public ServiciosPlanta getServiciosPlanta() {
		return servPlanta;
	}
	public ServiciosEjemplar getServiciosEjemplar() {
		return servEjemplar;
	}
	public ServiciosPersona getServiciosPersona() {
		return servPersona;
	}
	public ServiciosMensaje getServiciosMensaje() {
		return servMensaje;
	}

	public ServiciosCredencial getServiciosCredencial() {
		return servCredencial;
	}


	public String getUsuarioActual() {
		return usuarioActual;
	}


	public void setUsuarioActual(String usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public void cerrarSesion() {
		this.usuarioActual=null;
	}









}
