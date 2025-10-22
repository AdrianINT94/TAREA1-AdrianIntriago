package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artista extends Persona implements Serializable{
	private static final long serialVersionUID=1L;
	
	
	private String apodo;
	private List<Especialidad> especialidades;

		public Artista() {
		this.especialidades=new ArrayList<>();
		}

		public Artista(int id,String nombre, String email,String nacionalidad,Credencial credencial,
		               String apodo,List<Especialidad>especialidades){
		            	   super(id,nombre,email,nacionalidad,credencial);
		            	   this.apodo=apodo;
		            	   this.especialidades = especialidades !=null ?especialidades :new ArrayList<>();
		               }
		


		public String getApodo() {
			return apodo;
		}

		public void setApodo(String apodo) {
			this.apodo = apodo;
		}

		public List<Especialidad> getEspecialidades() {
			return especialidades;
		}

		public void setEspecialidades(List<Especialidad> especialidades) {
			this.especialidades = especialidades;
		}
		
		}
