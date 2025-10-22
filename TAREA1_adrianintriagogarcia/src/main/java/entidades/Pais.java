package entidades;

import java.io.Serializable;

public class Pais  implements Serializable{
	
	private static final long serialVersion=1L;
	
	private String id;
	private String nombre;
	
	public Pais() {}

	public Pais(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return id + " - "+ nombre;
	}
}
