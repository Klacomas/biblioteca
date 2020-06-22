package servicios;

import modelo.*;

import java.util.*;

public class Singleton {
	private static Singleton singleton;
	private List<Articulo> articulos;
	private List<Usuario> usuarios;

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized(Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
	
	private Singleton() {}
	
	public static synchronized List<Articulo> getArticulos() {
	return getInstance().articulos;
	}
	
	public static synchronized void setArticulos(List<Articulo> articulos) {
	getInstance().articulos = articulos;
	}
	
	public static List<Usuario> getUsuarios() {
	return getInstance().usuarios;
	}
	
	public static void setUsuarios(List<Usuario> usuarios) {
	getInstance().usuarios = usuarios;
	}
	
	public static synchronized boolean guardarCambios() {
		ExcelTools excelT = new ExcelTools();
		return excelT.guardarArticulos(getArticulos());
	}
}