package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import servicios.ExcelTools;
import servicios.Library;
import servicios.SesionActiva;
import servicios.Singleton;
import utilidades.U; 

public class Servicios {
	static Scanner sc = new Scanner(System.in);
	static String userName ="";
	
	public static boolean iniciarSesion(){
		while(SesionActiva.getUsuarioActivo() == null) {
			userName = U.menuUser();
			String pass = U.menuPass();
			SesionActiva.setUsuarioActivo(buscarUsuario(userName, pass));
			if(SesionActiva.getUsuarioActivo() == null) U.textSeparado(53, "Usuario / Password erroneo, favor volver a intentar.");
		}
		U.textSeparado(14 + userName.length(), " Bienvenido " + SesionActiva.getUsuarioActivo().getUser() + "!", true);
		return true;
		
		
	}
	private static Usuario buscarUsuario(String nombre, String clave) {
		List<Usuario> listaSingleton = Library.getUsuarios();
//		System.out.println(Library.get().getUsuarios().get(0).getUser());
		for (int i = 0; i < listaSingleton.size(); i++) {
			listaSingleton.get(i).getPass();
			if (listaSingleton.get(i).getPass().equals(clave) &&
				listaSingleton.get(i).getUser().equals(nombre)) {
			return listaSingleton.get(i);
			}
		}
		return null;
	}

	public static void reservarArticulo() {
		System.out.println("Ingrese el código del artículo");
		String strBuscar=sc.nextLine();
		Integer indice =  buscarArticuloReserva( strBuscar);
		if(indice == null) U.textSeparado(47 + userName.length(), " " + userName + ", articulo no encontrado, intente nuevamente.");
		generarReserva(indice);
	}

	public static void buscarArticulo() {
		System.out.println("Ingrese un nombre para buscar en la lista");
		String strBuscar=sc.nextLine();
		System.out.println("Buscando articulos con " + strBuscar + " en su nombre");
		ArrayList <Articulo> lstResultado = ExcelTools.buscarArticulo(strBuscar, Library.getArticulos());
		if(lstResultado.size()!=0) {
			for(Articulo resultado:lstResultado) {
				System.out.println(resultado);
			}
			System.out.println("Búsqueda finalizada");
		}else {
			System.out.println("***No se encontraron artículos con el nombre " + strBuscar + "***");
		}
	}

	private static void generarReserva(Integer indice) {
		if(!Library.getArticulos().get(indice).isReservado()) {
			Library.getArticulos().get(indice).setReservado(true);
			Library.guardarCambios();
			U.textSeparado(22 + userName.length(), " " + userName + ", reserva realizada.");
		} else {
			U.textSeparado(43 + userName.length(), " " + userName + ", el articulo no se encuentra disponible.");
		}
	}

	private static Integer buscarArticuloReserva(String codigoArticulo) {
		List<Articulo> listaSingleton = Library.getArticulos();
		for (int i = 0; i < listaSingleton.size(); i++) {
			if (listaSingleton.get(i).getCodigo().equals(codigoArticulo)) return i;
		}
		return null;
	}

	public static void salir() {
		U.textSeparado(16 + userName.length(), " Hasta pronto " + userName + "!");
		System.exit(0);
	}

}
