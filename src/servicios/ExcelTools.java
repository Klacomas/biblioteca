package servicios;

import utilidades.*;
import modelo.*;

import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelTools {
	
	static String rutaArticulos = ".\\articulos.xls";
	static String rutaUsuarios = ".\\usuarios.xls";

	public void exportar(ArrayList<String> ordenCompra){
		
		File fichero = new File("Orden_Despacho_Carro_Compra.xls");
		if (fichero.exists()) { //Evalua si existe el archivo excel con Articulos
			Util.separador(46);
			Util.msj(" Ya existe archivo con órdenes de despachos. ");
			try {
				InputStream excelStream = new FileInputStream("Orden_Despacho_Carro_Compra.xls");
				HSSFWorkbook libro = new HSSFWorkbook(excelStream);
				HSSFSheet hoja = libro.getSheetAt(0);
				int rows = hoja.getLastRowNum();
				HSSFRow fila = hoja.createRow(rows + 1);
				
				for (int i = 0; i < ordenCompra.size(); i++) {
					HSSFCell celda = fila.createCell((short) i);
					celda.setCellValue(ordenCompra.get(i));
				}
				
					try {
						FileOutputStream elFichero = new FileOutputStream("Orden_Despacho_Carro_Compra.xls");
						libro.write(elFichero);
						elFichero.close();
						libro.close();
						Util.msj(" Orden creada correctamente!");
						Util.separador(46);
					} catch (Exception e) {
						Util.msj(" Archivo excel abierto, por favor cerrar antes de crear orden de despacho.");
					} 				
				} catch (FileNotFoundException fileNotFoundException) {
					Util.msj(" No se encontró el fichero: " + fileNotFoundException);
		        } catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		else {
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet();
			HSSFRow filaNom = hoja.createRow(0);
			ArrayList<String> encabezado = new ArrayList<String>(Arrays.asList("Direccion", "NombreCliente", "Codigos", "MontoTotal", "FechaCompra"));
			for (int i = 0; i < encabezado.size(); i++) {
				HSSFCell celda = filaNom.createCell((short) i);
				celda.setCellValue(encabezado.get(i));
			}
			HSSFRow fila = hoja.createRow(1);
			for (int i = 0; i < ordenCompra.size(); i++) {
				HSSFCell celda = fila.createCell((short) i);
				celda.setCellValue(ordenCompra.get(i));
			}
			try {
				FileOutputStream elFichero = new FileOutputStream("Orden_Despacho_Carro_Compra.xls");
				libro.write(elFichero);
				elFichero.close();
				libro.close();
				Util.tempOrden(500);
				Util.separador(29);
				Util.msj(" Orden creada correctamente! ");
				Util.separador(29);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<Articulo> leerArticulos() {
		Workbook workbook = null;
		FileInputStream inputStream = null;
		List<Articulo> lista = new ArrayList<>();
		try {
			inputStream = new FileInputStream(new
			File(rutaArticulos));
			workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row;
			int cantidadFilas = sheet.getPhysicalNumberOfRows();
			// Leer filas completas
			Articulo articulo = null;
			for (int r = 1; r < cantidadFilas; r++) {
				row = sheet.getRow(r);
				if (row != null && null != row.getCell(0)) {

				if (row.getCell(0).getNumericCellValue() == 0) {//0 = Libro, 1 = Peli
					articulo = new Libro(
					(int) row.getCell(3).getNumericCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					(int) row.getCell(1).getNumericCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(6).getBooleanCellValue());
				} else {
//					public Pelicula(int plazoMaximo, String nombre, String codigo, int segundos, String calidad, Boolean reservado) {

					articulo = new Pelicula((int)
					row.getCell(3).getNumericCellValue(),
					row.getCell(4).getStringCellValue(),
					row.getCell(5).getStringCellValue(),
					(int) row.getCell(1).getNumericCellValue(),
					row.getCell(2).getStringCellValue(),
					row.getCell(6).getBooleanCellValue());
				}
				lista.add(articulo);
				} else break;
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
			return new ArrayList<Articulo>();
		}
		try {
			workbook.close();
		} catch (Exception e) {
		}
		try {
			inputStream.close();
		} catch (Exception e) {
		}
		return lista;
	}
	
	public static List<Usuario> leerUsuarios() {
		Workbook workbook = null;
		FileInputStream inputStream = null;
		List<Usuario> lista = new ArrayList<>();
		try {
			inputStream = new FileInputStream(new
			File(rutaUsuarios));
			workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row;
			int cantidadFilas = sheet.getPhysicalNumberOfRows();		
			Usuario user = new Usuario ();
		for (int r = 1; r < cantidadFilas; r++) {
			row = sheet.getRow(r);
				if (row != null) {
				user = new Usuario(row.getCell(0).getStringCellValue(),
				row.getCell(1).getStringCellValue());
				lista.add(user);
				}
		}
		
		} catch (Exception ioe) {
			ioe.printStackTrace();
			return new ArrayList<Usuario>();
		}
			try {
			workbook.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			try {
			inputStream.close();
			} catch (Exception e) {
			}
		return lista;
	}
	public static ArrayList<Articulo> buscarArticulo(String busqueda, List<Articulo> contenedor) {
	    ArrayList<Articulo> listaRet = new ArrayList<Articulo>();
	    for (int i = 0; i < contenedor.size(); i++) {
			if (contenedor.get(i).getNombre().contains(busqueda)) {
			    listaRet.add(contenedor.get(i));
			}
	    }
    	return listaRet;
	}
	    
	public boolean iniciarSesion(String userName, String password) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> buscar(String strBuscar) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public boolean reservar(String strReservar) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean guardarArticulos(List<Articulo> lista) {
	HSSFWorkbook libro = new HSSFWorkbook();
	HSSFSheet hoja = libro.createSheet();
	int tipoArticulo;
	int valorPag_Dur = 0;
	String valorImpr_Cali = "";
	HSSFCell celda = null;
	for (int i = 0; i < lista.size(); i++) {
		if (lista.get(i).getClass().equals(Libro.class)) {
			tipoArticulo = 0;
			valorPag_Dur = ((Libro) lista.get(i)).getCantPag();
			valorImpr_Cali = ((Libro) lista.get(i)).getImprenta();
		} else {
			tipoArticulo = 1;
			valorPag_Dur = ((Pelicula) lista.get(i)).getSegundos();
			valorImpr_Cali = ((Pelicula) lista.get(i)).getCalidad();
		}
		HSSFRow fila = hoja.createRow(i);
		celda = fila.createCell((short) 0);
		celda.setCellValue(tipoArticulo);
	
		celda = fila.createCell((short) 1);
		celda.setCellValue(valorPag_Dur);
		
		celda = fila.createCell((short) 2);
		celda.setCellValue(valorImpr_Cali);
		
		celda = fila.createCell((short) 3);
		celda.setCellValue(lista.get(i).getPlazoMaximo());
		
		celda = fila.createCell((short) 4);
		celda.setCellValue(lista.get(i).getNombre());
		
		celda = fila.createCell((short) 5);
		celda.setCellValue(lista.get(i).getCodigo());
		
		celda = fila.createCell((short) 6);
		celda.setCellValue(lista.get(i).isReservado());
	}
	try {
		FileOutputStream elFichero = new
		FileOutputStream(rutaArticulos);
		libro.write(elFichero);
		elFichero.close();
		libro.close();
		return true;
	} catch (Exception e) {	}
	try {
		libro.close();
	} catch (Exception e) {	}
		return false;
	}
	
}