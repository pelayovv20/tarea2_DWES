package modelo;

import java.time.LocalDateTime;

public class Mensaje {

	private long id;
	private LocalDateTime fechahora;
	private String mensaje;
	private long id_ejemplar;
	private long id_persona;


	public Mensaje() {

	}

	public Mensaje(long id, LocalDateTime fechahora, String mensaje, long id_ejemplar, long id_persona) {
		super();
		this.id = id;
		this.fechahora = fechahora;
		this.mensaje = mensaje;
		this.id_ejemplar = id_ejemplar;
		this.id_persona = id_persona;
	}

	public Mensaje(LocalDateTime fechaHora, String mensaje, long id_ejemplar, long id_persona) {
        this.fechahora = fechaHora;
        this.mensaje = mensaje;
        this.id_ejemplar = id_ejemplar;
        this.id_persona = id_persona;
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

	@Override
	public String toString() {
		String ret = "";
		ret += "ID MENSAJE: " + this.id + " - " + " FECHA y HORA: " + this.fechahora + " - " + " MENSAJE: " + this.mensaje;
		ret += "\nID EJEMPLAR: " + this.id_ejemplar + " - " + "ID PERSONA: " + this.id_persona;
		ret += "\n-------------------------------------";

		return ret;
	}


}
