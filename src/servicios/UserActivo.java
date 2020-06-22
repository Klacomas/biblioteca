package servicios;

import modelo.*;

public class UserActivo {
	
	private static Usuario usuarioActivo = null;
	
	public static Usuario getUsuarioActivo() {
		return usuarioActivo;
	}
	
	public static void setUsuarioActivo(Usuario usuarioActivo) {
		UserActivo.usuarioActivo = usuarioActivo;
	}
}