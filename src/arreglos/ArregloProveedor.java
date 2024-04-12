package arreglos;

import java.util.ArrayList;

import clases.Proveedor;

public class ArregloProveedor {
	
	private ArrayList<Proveedor> proveedor;
	public ArregloProveedor(){
		proveedor=new ArrayList<Proveedor>();
	}
	//ADICIONAR
	public void Adicionar(Proveedor x){
		proveedor.add(x);
	}
	//TAMA�O DE ARREGLO
	public int tamanio(){
		return proveedor.size();
	}
	//OBTENER
	public Proveedor Obtener (int i){
		return proveedor.get(i);
	}
	//BUSCAR
	public Proveedor Buscar(int cod){
		for (int i=0; i<tamanio(); i++){
			if (Obtener(i).getID_Proveedor() == cod)
				return Obtener(i);	
		}
		return null;
	}
	//ELIMINAR
	public void Eliminar(Proveedor x){
		proveedor.remove(x);
	}

}
