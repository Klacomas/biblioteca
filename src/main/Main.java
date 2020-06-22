package main;

import modelo.*;
import servicios.*;

import java.util.Scanner;

import menu.ServiciosMenu;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		cargarDatos();
		if (Servicios.iniciarSesion()) {
			ServiciosMenu.desplegarMenu("Menu Principal");
		}
	}

	private static void cargarDatos() {
		Library.setArticulos(ExcelTools.leerArticulos());
		Library.setUsuarios(ExcelTools.leerUsuarios());
	}

}