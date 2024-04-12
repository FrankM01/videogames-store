package clases;

public class Producto {
	//ATRIBUTOS
		private int ID_Producto;
		private String nombre_producto, desarrollador, plataforma, genero, Fecha_publicacion, jugadores;
		private double Precio_producto;
		private int stock;
		
		public Producto(int iD_Producto, String nombre_producto, String desarrollador, String plataforma, String genero,
				String fecha_publicacion, String jugadores, double precio_producto, int stock) {
			ID_Producto = iD_Producto;
			this.nombre_producto = nombre_producto;
			this.desarrollador = desarrollador;
			this.plataforma = plataforma;
			this.genero = genero;
			Fecha_publicacion = fecha_publicacion;
			this.jugadores = jugadores;
			Precio_producto = precio_producto;
			this.stock = stock;
		}
		public int getID_Producto() {
			return ID_Producto;
		}
		public void setID_Producto(int iD_Producto) {
			ID_Producto = iD_Producto;
		}
		public String getNombre_producto() {
			return nombre_producto;
		}
		public void setNombre_producto(String nombre_producto) {
			this.nombre_producto = nombre_producto;
		}
		public String getDesarrollador() {
			return desarrollador;
		}
		public void setDesarrollador(String desarrollador) {
			this.desarrollador = desarrollador;
		}
		public String getPlataforma() {
			return plataforma;
		}
		public void setPlataforma(String plataforma) {
			this.plataforma = plataforma;
		}
		public String getFecha_publicacion() {
			return Fecha_publicacion;
		}
		public void setFecha_publicacion(String fecha_publicacion) {
			Fecha_publicacion = fecha_publicacion;
		}
		public double getPrecio_producto() {
			return Precio_producto;
		}
		public void setPrecio_producto(double precio_producto) {
			Precio_producto = precio_producto;
		}
		public String getJugadores() {
			return jugadores;
		}
		public void setJugadores(String jugadores) {
			this.jugadores = jugadores;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		
}
