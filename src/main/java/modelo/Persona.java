package modelo;

public class Persona {

	private long id;
	private String nombre;
	private String email;
	
	
	public Persona() {
		
	}

	public Persona(long id, String nombre, String email, long id_credencial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.id_credencial = id_credencial;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public long getId_credencial() {
		return id_credencial;
	}

	public void setId_credencial(long id_credencial) {
		this.id_credencial = id_credencial;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "id: " + this.id;
		ret += "\nnombre: " + this.nombre;
		ret += "\nemail: " + this.email;
		ret += "\nid credencial: " + this.id_credencial;
		
		return ret;
	}
	
	
}
