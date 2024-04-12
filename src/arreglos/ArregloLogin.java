package arreglos;

import java.util.ArrayList;

import clases.Login;

public class ArregloLogin {
	private ArrayList<Login> login;
	public ArregloLogin(){
		login=new ArrayList<Login>();
	}
    //M�TODO ADICIONAR
	public void Adicionar(Login x){
		login.add(x);
	}
	//M�TODO TAMA�O DEL ARRAY
	public int tamanio(){
		return login.size();
	}
	//M�TODO OBTENER
	public Login Obtener(int i) {
		return login.get(i);
	}
   //M�TODO BUSCAR POR LOGIN
	
	public Login Buscar(Login log){
        Login e;
        for(int i=0; i<tamanio(); i++){
            e = Obtener(i);
            if(e.getUsuario().equals(log)){
                return e;
            }
        }
        return null;
    }
	
	//M�TODO BUSCAR POR USUARIO Y CONTRASE�A
	
		public Login Validar(String usu,String con){
	        Login e;
	        for(int i=0; i<tamanio(); i++){
	            e = Obtener(i);
	            if(e.getUsuario().equals(usu)&& e.getContrasenia().equals(con)){
	                return e;
	            }
	        }
	        return null;
	    }
		//M�TODO BUSCAR POR USUARIO 
		
			public Login Buscar3(String usu){
		        Login e;
		        for(int i=0; i<tamanio(); i++){
		            e = Obtener(i);
		            if(e.getUsuario().equals(usu)){
		                return e;
		            }
		        }
		        return null;
		    }
   //M�TODO ELIMINAR
	public void Eliminar(Login x) {
		login.remove(x);
	}
}
