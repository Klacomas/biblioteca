package modelo;

public abstract class Articulo {
	
	protected int plazoMaximo;
	protected String nombre;
	protected String codigo;
	protected Boolean reservado;
	
	public int getPlazoMaximo() {
		return plazoMaximo;
	}
	public void setPlazoMaximo(int plazoMaximo) {
		this.plazoMaximo = plazoMaximo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Boolean isReservado() {
		return reservado;
	}
	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	public Articulo(int plazoMaximo, String nombre, String codigo, Boolean reservado) {
		super();
		this.plazoMaximo = plazoMaximo;
		this.nombre = nombre;
		this.codigo = codigo;
		this.reservado = reservado;
	}
}