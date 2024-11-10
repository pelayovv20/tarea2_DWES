package modelo;

public class Ejemplar {

	private long id;
	private String nombre;
	private String id_planta;


	public Ejemplar() {

	}


	public Ejemplar(long id, String nombre, String id_planta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_planta = id_planta;
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



	public String getId_planta() {
		return id_planta;
	}


	public void setId_planta(String id_planta) {
		this.id_planta = id_planta;
	}


	@Override
	public String toString() {
		String ret ="";
		ret += "ID: " + this.id + " - " + "NOMBRE: " + this.nombre + " - " + "ID PLANTA: " + this.id_planta;
		

		return ret;
	}


}
