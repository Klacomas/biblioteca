package menu;

import java.util.ArrayList;

import modelo.Servicios;

public class ServiciosMenu {

	public static ArrayList<Opcion> obtenerOpciones(String nombreMenu) {
		ArrayList<Opcion> lstOpciones=new ArrayList<Opcion>();
		Opcion opcion;
		if(nombreMenu.equals("Menu Principal")) {
			opcion=new Opcion("Reservar artículo",1,1);
			lstOpciones.add(opcion);
			opcion=new Opcion("Buscar artículo",2,2);
			lstOpciones.add(opcion);
			opcion=new Opcion("Salir",3,3);
			lstOpciones.add(opcion);

		} 
		return lstOpciones;
	}

	public static String obtenerTitulo(String nombreMenu) {
		String strTitulo=new String();
		if(nombreMenu.equals("Menu Principal")) {
			strTitulo="Menu Principal";
		}
		strTitulo="---" + strTitulo + "---";
		return strTitulo;
	}

	public static void ejecutarAccion(int intOpcion, String strMenu) {
		if (strMenu.equals("Menu Principal")) {
			switch (intOpcion) {
			case 1:
				Servicios.reservarArticulo();
				break;
			case 2:
				Servicios.buscarArticulo();
				break;
			case 3:
				Servicios.salir();
				break;
			}	
		}
	}

	public static void desplegarMenu(String strMenu) {
		
		Menu menu=new Menu(strMenu,0,ServiciosMenu.obtenerOpciones(strMenu));
		menu.desplegar();
		int intOpcion=menu.leerOpcion();
		ServiciosMenu.ejecutarAccion(intOpcion,strMenu);
		desplegarMenu("Menu Principal");
	}

	
}
