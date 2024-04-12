package clases;

public class Vendedor extends Empleado {
	//ATRIBUTOS
	   private int dias_asistidos,dias_falta;
	   private String tipo_cajero;
	   private double tarifa_diaria;
	   private Login logcaj;
	 //VARIABLE PRIVADA DE CLASE
		private static int canCajeros=0;

	 //CONSTANTE DE CLASE
		private static final double afp_porcentaje = 0.1;
	//CONSTRUCTOR
		public Vendedor(int iD_Empleado, String nombres, String apellidos, String cargo, int dias_asistidos, int dias_falta,
				String tipo_cajero, double tarifa_diaria, Login logcaj) {
			super(iD_Empleado, nombres, apellidos, cargo);
			this.dias_asistidos = dias_asistidos;
			this.dias_falta = dias_falta;
			this.tipo_cajero = tipo_cajero;
			this.tarifa_diaria = tarifa_diaria;
			this.logcaj = logcaj;
		}	
		public Vendedor(int iD_Empleado, String nombres, String apellidos, String cargo,
				String tipo_cajero, double tarifa_diaria, Login logcaj) {
			super(iD_Empleado, nombres, apellidos, cargo);
			this.tipo_cajero = tipo_cajero;
			this.tarifa_diaria = tarifa_diaria;
			this.logcaj = logcaj;
		}	
	//SETTERS AND GETTERS
		public int getDias_asistidos() {
			return dias_asistidos;
		}

		public void setDias_asistidos(int dias_asistidos) {
			this.dias_asistidos = dias_asistidos;
		}

		public int getDias_falta() {
			return dias_falta;
		}

		public void setDias_falta(int dias_falta) {
			this.dias_falta = dias_falta;
		}

		public String getTipo_cajero() {
			return tipo_cajero;
		}

		public void setTipo_cajero(String tipo_cajero) {
			this.tipo_cajero = tipo_cajero;
		}

		public double getTarifa_diaria() {
			return tarifa_diaria;
		}

		public void setTarifa_diaria(double tarifa_diaria) {
			this.tarifa_diaria = tarifa_diaria;
		}

		public Login getLogcaj() {
			return logcaj;
		}

		public void setLogcaj(Login logcaj) {
			this.logcaj = logcaj;
		}

		public static int getCanCajeros() {
			return canCajeros;
		}
		
	//M�TODOS
	public double Sueldo_Bruto(){
		return dias_asistidos*tarifa_diaria;
	}
	public double Descuentos_AFP(){
		return Sueldo_Bruto()*afp_porcentaje;
	}
	public double Sueldo_Neto(){
		return Sueldo_Bruto()-Descuentos_AFP();
	}
	   
}
