package entidades;

public class Sesion {
	private Persona usuarioActual;

	
		public Sesion() {
			this.usuarioActual=null;
		}


		public Persona getUsuarioActual() {
			return usuarioActual;
		}


		public void setUsuarioActual(Persona usuarioActual) {
			this.usuarioActual = usuarioActual;
		}
		public boolean isAutenticado() {
			return usuarioActual !=null &&usuarioActual.getCredencial() !=null;
			
		
	}
		public Perfil getPerfilActual() {
			if(!isAutenticado()) return Perfil.INVITADO;
			return usuarioActual.getCredencial().getPerfil();
		}
		public void cerrarSesion() {
			usuarioActual=null;
		}
		
		@Override
		public String toString() {
			if(usuarioActual ==null) {
				return "Usuario actual: INVITADO";
			}else {
				return "Usuario actual:"+usuarioActual.getNombre()+ "("+ usuarioActual.getCredencial().getPerfil()+")";
				
			}
		}
	
	
}
