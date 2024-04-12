package clases;

public class Login {
	//ATRIBUTOS
	private String usuario, contrasenia;
	//CONSTRUCTOR
	public Login(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	//SETTERS AND GETTERS
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
  

}
