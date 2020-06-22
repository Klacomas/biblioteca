package servicios;

import java.util.*;

import modelo.*;

public class Library {
	
	private static Library library; // <== Singleton
	private List<Articulo> articulos;
	private List<Usuario> usuarios;

	public static Library get() {
		if (library == null) {
			synchronized (Library.class) {
				if (library == null) {
					library = new Library();
				}
			}
		}
		
		return library;
	}

	private Library() {}

	public static synchronized List<Articulo> getArticulos() {
		return get().articulos;
	}

	public static synchronized void setArticulos(List<Articulo> articulos) {
		get().articulos = articulos;
	}

	public static List<Usuario> getUsuarios() {
		return get().usuarios;
	}
		
	public static void setUsuarios(List<Usuario> usuarios) {
		get().usuarios = usuarios;
	}
	
	public static synchronized boolean guardarCambios() {
		ExcelTools excelT = new ExcelTools();
		List <Articulo> lstArticulos = getArticulos();
		return excelT.guardarArticulos(lstArticulos);
	}

}