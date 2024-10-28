package modelo;

public class Seguimiento {

	private long id_ejemplar;
	private long id_persona;
	private long id_mensaje;
	
	public Seguimiento() {
		
	}

	public Seguimiento(long id_ejemplar, long id_persona, long id_mensaje) {
		super();
		this.id_ejemplar = id_ejemplar;
		this.id_persona = id_persona;
		this.id_mensaje = id_mensaje;
	}

	public long getId_ejemplar() {
		return id_ejemplar;
	}

	public void setId_ejemplar(long id_ejemplar) {
		this.id_ejemplar = id_ejemplar;
	}

	public long getId_persona() {
		return id_persona;
	}

	public void setId_persona(long id_persona) {
		this.id_persona = id_persona;
	}

	public long getId_mensaje() {
		return id_mensaje;
	}

	public void setId_mensaje(long id_mensaje) {
		this.id_mensaje = id_mensaje;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "id ejemplar: " + this.id_ejemplar;
		ret += "\nid persona: " + this.id_persona;
		ret += "\nid mensaje: " + this.id_mensaje;
		
		return ret;
	}
	
	
	
	
}
