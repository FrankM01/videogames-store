package clases;

public class Empleado {
   //ATRIBUTOS
   private int ID_Empleado;
   private String nombres,apellidos,cargo;
   //CONSTRUCTOR
	public Empleado(int iD_Empleado, String nombres, String apellidos, String cargo) {
		ID_Empleado = iD_Empleado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cargo = cargo;
	}
   //GETTERS AND SETTERS
	public int getID_Empleado() {
		return ID_Empleado;
	}
	public void setID_Empleado(int iD_Empleado) {
		ID_Empleado = iD_Empleado;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
   
}
