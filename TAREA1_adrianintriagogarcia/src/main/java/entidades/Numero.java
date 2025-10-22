package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Numero  implements Serializable{
	
	private static final long serialVersionUID=1L; 
	
		private int id;
		private int orden;
		private String nombre;
		private double duracion;
		private List<Artista> artistas;
		
		
		public Numero () {
			this.artistas=new ArrayList<>();
		}


		public Numero(int id, int orden, String nombre, double duracion, List<Artista> artistas) {
			super();
			this.id = id;
			this.orden = orden;
			this.nombre = nombre;
			this.duracion = duracion;
			this.artistas = artistas;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getOrden() {
			return orden;
		}


		public void setOrden(int orden) {
			this.orden = orden;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public double getDuracion() {
			return duracion;
		}


		public void setDuracion(double duracion) {
			this.duracion = duracion;
		}


		public List<Artista> getArtistas() {
			return artistas;
		}


		public void setArtistas(List<Artista> artistas) {
			this.artistas = artistas;
		}
		@Override 
		public String toString() {
			return "Numero"+"id"+id+"orden"+orden+"nombre"+nombre+'\''+"duracion"+duracion+"minutos"+"artistas"+artistas.stream().map(Artista::getNombre).toList();
		}
}
