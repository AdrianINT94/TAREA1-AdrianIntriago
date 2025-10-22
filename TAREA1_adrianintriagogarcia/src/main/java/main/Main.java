package main;

import java.time.LocalDate;
import java.util.Scanner;

import java.util.List;
import entidades.Perfil;
import entidades.Persona;
import entidades.Sesion;
import utils.GestorEspectaculos;
import utils.GestorSesion;

public class Main {
	
		private static Sesion sesion =new Sesion();
		private static GestorSesion gestorSesion =new GestorSesion(sesion);
		private static GestorEspectaculos gestorEspectaculos =new GestorEspectaculos();
		private static Scanner leer= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean salir = false;
		
		while (!salir) {
			mostrarMenuPrincipal();
			System.out.print("Elige opcion");
			String opcion =leer.nextLine();
			
			switch (opcion) {
			case"1":
				//ver espectaculos (CU1)
			gestorEspectaculos.ListEspectaculosBasicos();
			break;
			case"2":
				if(sesion.getUsuarioActual()!=null &&sesion.getUsuarioActual().getCredencial()!=null
					&& sesion.getUsuarioActual().getCredencial().getPerfil() !=Perfil.INVITADO) {
					System.out.println("Ya hay un usuario autenticado.Haz logout primero ");
					break;
					}
				login();
				break;
			case"3":
				if(sesion.getUsuarioActual()!=null
				&& sesion.getUsuarioActual().getCredencial()!=null
				&& sesion.getUsuarioActual().getCredencial().getPerfil() !=Perfil.INVITADO){
					gestorSesion.logout();
				}else {
					System.out.println("No hay usuario autenticado");
				}
				break;
			case "4":
				//salir
				salir=true;
				System.out.println("Hasta luego ");
				break;
			case "5"://registrar usuario
				if (sesion.getPerfilActual()==Perfil.ADMIN) {
					registrarNuevoUsuario();
				}else {
					System.out.println("Opcion no permitida");
				}
				break;
			case "6": //crear espectaculo
				if(sesion.getPerfilActual()== Perfil.COORDINACION|| sesion.getPerfilActual()==Perfil.ADMIN) {
					crearNuevoEspectaculo();
				}else {
					System.out.println("Opcion no permitida");
				}
			break;
			default:
				System.out.println("Opcion no valida");
			}
			
		}

	}
	private static void mostrarMenuPrincipal() {
		System.out.println("\n====== MENU PRINCIPAL =====");
		System.out.println(sesion.toString());
		System.out.println("1. Ver espectaculos");
		System.out.println("2. Login");
		System.out.println("3. Logout");
		System.out.println("4. Salir");
		System.out.println("5. Registrar usuario(ADMIN)");
		System.out.println("6. Crear nuevo espectaculo");
		
		
	}
	
	private static void login() {
		System.out.println("Usuario");
		String usuario=leer.nextLine();
		System.out.println("Contraseña");
		String password =leer.nextLine();
		
		boolean exito =gestorSesion.login(usuario,password);
		if(exito) {
			Persona p=sesion.getUsuarioActual();
			System.out.println("Login correcto .Bienvenido" + p.getNombre()+ "(" + p.getCredencial().getPerfil()+")");
			}else {
				System.out.println("Usuario o contraseña incorrectos");
			}
	}
		
		private static void registrarNuevoUsuario() {
			System.out.println("\n=====REGISTRO NUEVO USUARIO ===");
			System.out.println("Nombre de usuario ");
			String usuario =leer.nextLine();
			System.out.println("Contraseña");
			String pass =leer.nextLine();
			System.out.println("Email");
			String email = leer.nextLine();
			System.out.println("Nombre completo");
			String nombre =leer.nextLine();
			System.out.println("Nacionalidad");
			String nacionalidad =leer.nextLine();
			System.out.print("Perfil (ADMIN/COORDINACION/ARTISTA");
			String perfilStr=leer.nextLine().toUpperCase();
			
			try {
				Perfil perfil =Perfil.valueOf(perfilStr);
				
				java.io.FileWriter fw =new java.io.FileWriter("ficheros/credenciales.txt",true);
				int nuevoId =(int) (Math.random()*1000);
				fw.write(nuevoId + "|" + usuario + "|" + pass + "|" + email + "|"+nombre+ "|"+nacionalidad +"|" +perfil +"\n");
				fw.close();
				System.out.println("Usuario registrado correctamente");
			}catch(Exception e) {
				System.out.println("Error al registrar usuario"+ e.getMessage());
				
			}
		}
		
			private static void crearNuevoEspectaculo() {
				System.out.println("\n==== CREACION DE NUEVO ESPECTACULO =====");
				System.out.println("ID del espectaculo");
				int id = Integer.parseInt(leer.nextLine());
				System.out.print("Nombre del espectaculo");
				String nombre =leer.nextLine();
				System.out.print("Fecha de inicio(YYYY-MM-DD)");
				LocalDate fechaInicio =LocalDate.parse(leer.nextLine());
				System.out.print("Fecha de fin(YYYY-MM-DD)");
				LocalDate fechaFin =LocalDate.parse(leer.nextLine());
				
				entidades.Espectaculo e=new entidades.Espectaculo();
				e.setId(id);
				e.setNombre(nombre);
				e.setFechaInicio(fechaInicio);
				e.setFechaFin(fechaFin);
				
				
				//cargar los espectaculos existentes
				List<entidades.Espectaculo> lista =gestorEspectaculos.cargarEspectaculos();
				lista.add(e);
				gestorEspectaculos.guardarEspectaculos(lista);
				
				System.out.println("Espectaculo creado y guardado correctamente");
			}
		
	}

