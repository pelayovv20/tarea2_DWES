package modelo;

public class Credencial {

	private long id;
	private String usuario;
	private String password;
	private long id_persona;

	public Credencial() {

	}

	public Credencial(long id, String usuario, String password,Long id_persona) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.id_persona = id_persona;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public long getId_persona() {
		return id_persona;
	}

	public void setId_persona(long id_persona) {
		this.id_persona = id_persona;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "id: " + this.id;
		ret += "\nusuario: " + this.usuario;
		ret += "\npassword: " + this.password;
		ret += "\nid persona: " + this.id_persona;

		return ret;
	}


}
