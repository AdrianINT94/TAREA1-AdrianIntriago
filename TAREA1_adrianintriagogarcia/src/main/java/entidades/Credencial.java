package entidades;

import java.io.Serializable;

public class Credencial  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
		private String nombreUsuario;
		private String password;
		private Perfil perfil;
		
		public Credencial() {
			
		}

		public Credencial(String nombreUsuario, String password, Perfil perfil) {
			super();
			this.nombreUsuario = nombreUsuario;
			this.password = password;
			this.perfil = perfil;
		}

		public String getNombreUsuario() {
			return nombreUsuario;
		}

		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}
		@Override 
		public String toString() {
			return "Credencial" + "usuario"+nombreUsuario+ '\''+"perfil"+perfil+"}";
		}
}
