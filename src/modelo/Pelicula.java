package modelo;

public class Pelicula extends Articulo {
	
	private int segundos;
	private String calidad;
	
	public int getSegundos() {
		return segundos;
	}
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	public String getCalidad() {
		return calidad;
	}
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	public Pelicula(int plazoMaximo, String nombre, String codigo, int segundos, String calidad, Boolean reservado) {
		super(plazoMaximo, nombre, codigo, reservado);
		this.segundos = segundos;
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "Pelicula [segundos=" + segundos 
				+ ", calidad=" + calidad 
				+ ", plazoMaximo=" + plazoMaximo 
				+ ", nombre=" + nombre 
				+ ", codigo=" + codigo 
				+ ", reservado=" + reservado + "]";
	}
}