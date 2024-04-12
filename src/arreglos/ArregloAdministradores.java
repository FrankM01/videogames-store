package arreglos;

import java.util.ArrayList;
import clases.Administrador;
import clases.Empleado;

public class ArregloAdministradores {
	private ArrayList<Administrador> admin;
	public ArregloAdministradores(){
		admin=new ArrayList<Administrador>();
	}
    //M�TODO ADICIONAR
	public void Adicionar(Administrador x){
		admin.add(x);
	}
	//M�TODO TAMA�O DEL ARRAY
	public int tamanio(){
		return admin.size();
	}
	//M�TODO OBTENER
	public Administrador Obtener(int i) {
		return admin.get(i);
	}
   //M�TODO BUSCAR
	public Administrador Buscar(int cod) {
	    for (int i=0; i<tamanio(); i++){
		    if (Obtener(i).getID_Empleado() == cod)
		       return Obtener(i);//admin.get(i)
	    }
		return null;
	}
   //M�TODO ELIMINAR
	public void Eliminar(Administrador x) {
		admin.remove(x);
	}
	
}
