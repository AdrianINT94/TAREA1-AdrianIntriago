package utils;

import entidades.Sesion;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import entidades.Especialidad;
import entidades.Artista;
import entidades.Coordinacion;
import entidades.Credencial;
import entidades.Perfil;
import entidades.Persona;


public class GestorSesion {

		private static final String RUTA_CREDENCIALES="ficheros/credenciales.txt";
		private Sesion sesion;
		
		public GestorSesion(Sesion sesion) {
			this.sesion =sesion;
		}
		
		public boolean login (String usuario,String password) {
				if(usuario.equalsIgnoreCase("admin")&& password.equals("admin")) {
					Credencial cred = new Credencial("admin","admin",Perfil.ADMIN);
					Persona admin = new Persona(0,"Administrado general","admin@circo.es","España",cred) {};
					sesion.setUsuarioActual(admin);
					return true;
				}
				
				try(BufferedReader br=new BufferedReader(new FileReader(RUTA_CREDENCIALES))){
					String linea;
					while((linea = br.readLine()) !=null) {
						String []partes =linea.split("\\|");
						if(partes.length !=7)continue;
						
						String idStr =partes[0];
						String nombreUsuario =partes [1];
						String pass=partes[2];
						String email =partes[3];
						String nombrePersona =partes [4];
						String nacionalidad =partes[5];
						String perfilStr =partes [6];
						
						
						if(nombreUsuario.equalsIgnoreCase(usuario)&& pass.equals(password)) {
							Perfil perfil =Perfil.valueOf(perfilStr.toUpperCase());
							Credencial cred = new Credencial (nombreUsuario,pass,perfil);
							
							Persona persona;
							if(perfil == Perfil.COORDINACION) {
								persona = new Coordinacion(Integer.parseInt(idStr),nombrePersona,email,nacionalidad,cred,false,null);
								}else if(perfil==Perfil.ARTISTA) {
									persona = new Artista(Integer.parseInt(idStr),nombrePersona,email,nacionalidad,cred,null,new ArrayList<Especialidad>());
								}else {
									persona =new Persona(Integer.parseInt(idStr),nombrePersona,email,nacionalidad,cred) {};
									}
							sesion.setUsuarioActual(persona);
							return true;
						}
					}
				}catch (IOException e) {
					System.out.println("Error al leer el fichero credenciales" + e.getMessage());
					
				}
				return false;
		}
		public void logout() {
			sesion.cerrarSesion();
			System.out.println("Sesion cerrada .Usuario actual:Invitado ");
		}
}
