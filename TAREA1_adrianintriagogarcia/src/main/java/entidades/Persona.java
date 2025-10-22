package entidades;

import java.io.Serializable;

public abstract class Persona implements Serializable {
	public static final long serialVersion=1L;
	
	private int id;
	private String nombre;
	private String email;
	private String nacionalidad;
	private Credencial credencial;
	
	public Persona() {
		
	}

	public Persona(int id, String nombre, String email, String nacionalidad, Credencial credencial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.nacionalidad = nacionalidad;
		this.credencial = credencial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	@Override
    public String toString() {
        return "Persona{id=" + id + ", nombre='" + nombre + '\'' + ", email='" + email + '\'' +
                ", nacionalidad=" + nacionalidad +
                ", perfil=" + (credencial != null ? credencial.getPerfil() : "N/A") + '}';
}
}

