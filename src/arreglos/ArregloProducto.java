package arreglos;

import java.util.ArrayList;

import clases.Producto;

public class ArregloProducto {
	private ArrayList<Producto> producto;
	public ArregloProducto(){
		producto=new ArrayList<Producto>();
	}
	//ADICIONAR
	public void Adicionar(Producto x){
		producto.add(x);
	}
	//TAMA�O DE ARREGLO
	public int tamanio(){
		return producto.size();
	}
	//OBTENER
	public Producto Obtener (int i){
		return producto.get(i);
	}
	//BUSCAR
	public Producto Buscar(int cod){
		for (int i=0; i<tamanio(); i++){
			if (Obtener(i).getID_Producto() == cod)
				return Obtener(i);	
		}
		return null;
	}
	//ELIMINAR
	public void Eliminar(Producto x){
		producto.remove(x);
	}

}
