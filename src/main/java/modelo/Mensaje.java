package modelo;

import java.time.LocalDateTime;

public class Mensaje {

	private long id;
	private LocalDateTime fechahora;
	private String mensaje;
	
	public Mensaje() {
		
	}

	public Mensaje(long id, LocalDateTime fechahora, String mensaje) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.mensaje = mensaje;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "id: " + this.id;
		ret += "\nfecha y hora: " + this.fechahora;
		ret += "\nmensaje: " + this.mensaje;
		
		return ret;
	}
	
	
}
