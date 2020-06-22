package modelo;

public class Libro extends Articulo {

	private int cantPag;
	private String imprenta;
	
	public int getCantPag() {
		return cantPag;
	}
	public void setCantPag(int cantPag) {
		this.cantPag = cantPag;
	}
	public String getImprenta() {
		return imprenta;
	}
	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}
	
	public Libro(int plazoMaximo, String nombre, String codigo, int cantPag, String imprenta, Boolean reservado) {
		super(plazoMaximo, nombre, codigo, reservado);
		this.cantPag = cantPag;
		this.imprenta = imprenta;
	}

	@Override
	public String toString() {
		return "Libro [cantPag=" + cantPag 
				+ ", imprenta=" + imprenta 
				+ ", plazoMaximo=" + plazoMaximo 
				+ ", nombre=" + nombre 
				+ ", codigo=" + codigo 
				+ ", reservado=" + reservado + "]";
	}
}