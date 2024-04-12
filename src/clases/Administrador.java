package clases;
 ;

public class Administrador extends Empleado {
	//ATRIBUTOS
	   private String email,direccion;
	   private Login logad;
	 //CONSTRUCTOR
		public Administrador(int iD_Empleado, String nombres, String apellidos, String cargo, String email,
				String direccion, Login logad) {
			super(iD_Empleado, nombres, apellidos, cargo);
			this.email = email;
			this.direccion = direccion;
			this.logad = logad;
		}
		//SETTERS AND GETTERS
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public Login getLogad() {
			return logad;
		}
		public void setLogad(Login logad) {
			this.logad = logad;
		}
}
