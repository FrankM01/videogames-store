package clases;

public class Venta {
	//ATRIBUTOS
	private int Nro_venta;
	private String Fec_Venta;
	private Vendedor caj;
	private Producto producto;
		
	//CONSTRUCTOR
	public Venta(int nro_venta, String fec_Venta, Vendedor caj, Producto producto) {
		Nro_venta = nro_venta;
		Fec_Venta = fec_Venta;
		this.caj = caj;
		this.producto = producto;
	}
	//SETTERS AND GETTERS
	public int getNro_venta() {
		return Nro_venta;
	}

	public void setNro_venta(int nro_venta) {
		Nro_venta = nro_venta;
	}

	public String getFec_Venta() {
		return Fec_Venta;
	}

	public void setFec_Venta(String fec_Venta) {
		Fec_Venta = fec_Venta;
	}

	public Vendedor getCaj() {
		return caj;
	}

	public void setCaj(Vendedor caj) {
		this.caj = caj;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
