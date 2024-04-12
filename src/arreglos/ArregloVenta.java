package arreglos;

import java.util.ArrayList;

import clases.Venta;

public class ArregloVenta {
	private ArrayList<Venta> venta;
	public ArregloVenta(){
		venta=new ArrayList<Venta>();
	}
	//ADICIONAR
	public void Adicionar(Venta x){
		venta.add(x);
	}
	//TAMA�O DE ARREGLO
	public int tamanio(){
		return venta.size();
	}
	//OBTENER
	public Venta Obtener (int i){
		return venta.get(i);
	}
	//BUSCAR
	public Venta Buscar(int id_prod) {
	    for (int i=0; i<tamanio(); i++){
		    if (Obtener(i).getNro_venta()== id_prod)
		       return Obtener(i);//ven.get(i)
	    }
		return null;
	}
	//ELIMINAR
	public void Eliminar(Venta x){
		venta.remove(x);
	}

}
