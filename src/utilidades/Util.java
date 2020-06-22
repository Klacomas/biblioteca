package utilidades;

//import modelo.*;
//import main.*;
//import java.util.*;

public class Util {
	
	public static void msj(String msj) { //Mensaje con salto de linea
		System.out.println(msj);
	}
	public static void msjML(String msj) { //Mensaje Misma Linea
		System.out.print(msj);
	}
	
	public static void msj2() { //Doble salto
		System.out.print("\n\n");
	}
	
	public static void separadorA(int separador) {
		msj("");
		for (int i = 0; i < separador; i++) {		
			System.out.print("-");
		}
		msj("");
	}
	
	public static void separador(int separador) {
		for (int i = 0; i < separador; i++) {		
			System.out.print("-");
		}
		msj("");
	}

	public static void procesando(int espera) throws InterruptedException {
		String text = "Regresando a menú principal ";
		System.out.print(text);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(espera);
			System.out.print(".");
		}
		msj2();
	}
	
	public static void tempOrden(int espera) throws InterruptedException {
		String text = "Creando orden de compra ";
		System.out.print(text);
		for (int i = 1; i <= 3; i++) {
			Thread.sleep(espera);
			System.out.print(".");
		}
		msj("");
	}
}
