package utils;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;

import entidades.Espectaculo;

public class GestorEspectaculos {

		private static final String RUTA_ESPECTACULOS ="ficheros/espectaculos.dat";
		
		public List<Espectaculo> cargarEspectaculos(){
			List<Espectaculo> espectaculos = new ArrayList<>();
			
			File fichero = new File(RUTA_ESPECTACULOS);
			if(!fichero.exists()) {
				System.out.println("No existe el fichero espectaculos.dat");
				return espectaculos;
				
			}
			try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(fichero))){
				espectaculos=(List<Espectaculo>)ois.readObject();
				
			}catch (EOFException e) {
				//Fin archivo 
			}catch (IOException | ClassNotFoundException e ) {
				System.out.println("Error al leer espectaculos" + e.getMessage());
			}
			return espectaculos;
		}
		
		
		public void ListEspectaculosBasicos() {
			List<Espectaculo> lista=cargarEspectaculos();
			
			if(lista.isEmpty()) {
				System.out.println("No hay espectaculos registrados");
				return;
			}
			
			lista.sort(Comparator.comparing(Espectaculo::getId));
			
			System.out.println("\n====== LISTADO DE ESPECTACULOS =====");
			System.out.printf("%-5s %-25s %-15s %-15s%n ", "ID", "Nombre","Inicio","Fin");
			System.out.println("---------------------------------------");
			for(Espectaculo e:lista) {
				System.out.printf("%-5d %-25s %-15s %-15s%n",
						e.getId(),
						e.getNombre(),
						e.getFechaInicio(),
						e.getFechaFin());
			}
			System.out.println("----------------------------------------");
			
			
		}
		
		public void guardarEspectaculos(List<Espectaculo> espectaculos) {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ESPECTACULOS))){
				oos.writeObject(espectaculos);
				System.out.println("Espectaculos guardados correctamente");
			}catch (IOException e ) {
				System.out.println("Error al guardar espectaculos"+ e.getMessage());
			}
		}
}
