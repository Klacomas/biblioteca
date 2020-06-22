package servicios;

import modelo.*;

public class SesionActiva {
	
	private static Usuario usuarioActivo = null;
	
	public static Usuario getUsuarioActivo() {
		return usuarioActivo;
	}
	
	public static void setUsuarioActivo(Usuario usuarioActivo) {
		SesionActiva.usuarioActivo = usuarioActivo;
	}
}