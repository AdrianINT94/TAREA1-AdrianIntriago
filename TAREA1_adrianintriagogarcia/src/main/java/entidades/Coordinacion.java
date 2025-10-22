package entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Coordinacion extends Persona implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private boolean senior;
	private LocalDate fechaSenior;
	
	public Coordinacion() {
	}
	public Coordinacion(int id, String nombre,String email,String nacionalidad,Credencial credencial,boolean senior,LocalDate fechaSenior) {
		super(id,nombre,email,nacionalidad,credencial);
		this.senior=senior;
		this.fechaSenior=senior? fechaSenior : null;
		
	}
	public Coordinacion(boolean senior, LocalDate fechaSenior) {
		super();
		this.senior = senior;
		this.fechaSenior = fechaSenior;
	}
	public boolean isSenior() {
		return senior;
	}
	public void setSenior(boolean senior) {
		this.senior = senior;
	}
	public LocalDate getFechaSenior() {
		return fechaSenior;
	}
	public void setFechaSenior(LocalDate fechaSenior) {
		this.fechaSenior = fechaSenior;
	}
	@Override
	public String toString() {
		return super.toString () + "senior" + senior+"desde " +fechaSenior+ "";
	}
	
}
