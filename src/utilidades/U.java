package utilidades;

//import java.util.ArrayList;

import main.Main;
//import modelo.*;

public class U {
	
	public static void msj(String msj) { //Mensaje con salto de linea
		System.out.println(msj);
	}
	public static void msjML(String msj) { //Mensaje Misma Linea
		System.out.print(msj);
	}
	
	public static void msj2() { //Doble salto
		System.out.print("\n\n");
	}

	public static void msjInt(int msj) { //Doble salto
		System.out.print(msj + "\n");
	}
	
	public static void separadorA(int separador) {
		msj("");
		for (int i = 0; i < separador; i++)	System.out.print("-");
		msj("");
	}
	
	public static void separador(int separador) {
		for (int i = 0; i < separador; i++) System.out.print("-");
		msj("");
	}

	public static void textSeparado(int separador, String msj) {
		separador(separador);
		msj(msj);
		separador(separador);
	}

	public static void textSeparado(int separador, String msj, boolean salto) {
		separador(separador);
		msj(msj);
		separador(separador);
		msj("");
	}

	public static void textSeparado(int separador, int separador2, String msj) {
		separador(separador);
		msj(msj);
		separador(separador2);
//		msj("");
	}
	
	public static String menuUser() {
		msjML("User: ");
		String user = Main.sc.nextLine();
		return user;
	}

	public static String menuPass() {
		msjML("Pass: ");
		String pass = Main.sc.nextLine();
		return pass;
	}
	
	public static String menuArticulos() {
		msj("¿Qué desea hacer?");
		msj("1) Reservar un articulo");
		msj("2) Buscar articulo");
		msj("3) Mostrar articulos disponibles");
		msj("0) Salir");
		String seleccion = Main.sc.nextLine();
		return seleccion;
	}

	public static void procesando(int espera) throws InterruptedException {
		String text = "Procesando ";
		System.out.print(text);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(espera);
			System.out.print(".");
		}
		msj("");
	}
	
	public static void tempOrden(int espera) throws InterruptedException {
		String text = "Reservando articulo ";
		System.out.print(text);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(espera);
			System.out.print(".");
		}
		msj("");
	}
	
}
