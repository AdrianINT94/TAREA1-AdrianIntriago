package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Espectaculo  implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private int id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Coordinacion coordinador;
	private List<Numero>numeros;
	
	public Espectaculo() {
		this.numeros=new ArrayList<>();
	}

	public Espectaculo(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, Coordinacion coordinador,
			List<Numero> numeros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.coordinador = coordinador;
		this.numeros = numeros;
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Coordinacion getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Coordinacion coordinador) {
		this.coordinador = coordinador;
	}

	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}
	@Override 
	public String toString() {
		return "Espectaculo ID" +id+ "nombre"+nombre+'\''+"fechas"+fechaInicio+ "-"+fechaFin+"coordinador" + (coordinador != null ?coordinador.getNombre(): "N/A");
	}
	
	public String toDetalleCompleto() {
		StringBuilder sb=new StringBuilder();
		sb.append("\nNumeros:\n");
		for (Numero n:numeros) {
			sb.append(" ").append(n).append("\n");
		}
		return sb.toString();
		}
	}
	

