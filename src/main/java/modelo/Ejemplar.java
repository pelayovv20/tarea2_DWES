package modelo;

public class Ejemplar {

	private long id;
	private String nombre;
	
	
	public Ejemplar() {
		
	}


	public Ejemplar(long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Ejemplar [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
