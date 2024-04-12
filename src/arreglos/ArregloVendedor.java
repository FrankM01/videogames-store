package arreglos;

import java.util.ArrayList;
import clases.Vendedor;

public class ArregloVendedor {
	private ArrayList<Vendedor> vendedor;
	public ArregloVendedor(){
		vendedor=new ArrayList<Vendedor>();
	}
	//ADICIONAR
	public void Adicionar(Vendedor x){
		vendedor.add(x);
	}
	//TAMA�O DE ARREGLO
	public int tamanio(){
		return vendedor.size();
	}
	//OBTENER
	public Vendedor Obtener (int i){
		return vendedor.get(i);
	}
	//BUSCAR
	public Vendedor Buscar(int cod){
		for (int i=0; i<tamanio(); i++){
			if (Obtener(i).getID_Empleado() == cod)
				return Obtener(i);	
		}
		return null;
	}
	//ELIMINAR
	public void Eliminar(Vendedor x){
		vendedor.remove(x);
	}

}
