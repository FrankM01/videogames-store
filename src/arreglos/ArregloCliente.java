package arreglos;

import java.util.ArrayList;

import clases.Cliente;

public class ArregloCliente {
	private ArrayList<Cliente> cliente;
	public ArregloCliente(){
		cliente = new ArrayList<Cliente>();
	}
	//ADICIONAR
	public void Adicionar (Cliente x){
		cliente.add(x);
	}
	//TAMA�O DE ARREGLO
	public int tamanio(){
		return cliente.size();
	}
	//OBTENER
	public Cliente Obtener (int i){
		return cliente.get(i);
	}
	//BUSCAR
	public Cliente Buscar(int cod){
		for (int i=0; i<tamanio(); i++){
			if (Obtener(i).getID_Cliente() == cod)
				return Obtener(i);	
		}
		return null;
	}
	//ELIMINAR
	public void Eliminar(Cliente x){
		cliente.remove(x);
	}

}
