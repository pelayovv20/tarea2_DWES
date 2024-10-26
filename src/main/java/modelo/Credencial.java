package modelo;

public class Credencial {

	private long id;
	private String usuario;
	private String password;
	
	public Credencial() {
		
	}

	public Credencial(long id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
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

	@Override
	public String toString() {
		String ret = "";
		ret += "id: " + this.id;
		ret += "\nusuario: " + this.usuario;
		ret += "\npassword: " + this.password;
		
		return ret;
	}
	
	
}
