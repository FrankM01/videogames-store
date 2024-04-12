package clases;

public class Proveedor {
  //ATRIBUTOS
	private int ID_Proveedor;
	private String Nombre_proveedor,direccion,telefono;
  //CONSTRUCTOR
	public Proveedor(int iD_Proveedor, String nombre_proveedor, String direccion, String telefono) {
		ID_Proveedor = iD_Proveedor;
		Nombre_proveedor = nombre_proveedor;
		this.direccion = direccion;
		this.telefono = telefono;
	}
  //SETTER AND GETTERS
	public int getID_Proveedor() {
		return ID_Proveedor;
	}
	public void setID_Proveedor(int iD_Proveedor) {
		ID_Proveedor = iD_Proveedor;
	}
	public String getNombre_proveedor() {
		return Nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		Nombre_proveedor = nombre_proveedor;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
