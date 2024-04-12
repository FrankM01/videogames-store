package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class RegistrarVenta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel lblNroComprobante;
	private JTextField txtcomprobante;
	private JLabel lblI;
	public static JTextField txtdni;
	private JLabel lblNombres;
	public  static JTextField txtnomcli;
	private JLabel lblApellidos;
	public static JTextField txtapecli;
	private JPanel panel_2;
	private JLabel lblVendedor;
	private JPanel panel_3;
	private JButton btnagregarprod;
	private JButton btneliminar;
	private JButton btnbuscarprod;
	private JButton btnregistrarventa;
	private JButton btnbuscar;
	private JPanel panel_4;
	private JLabel lblVEN;
	private JPanel panel_5;
	private JTable tblventa;
	private JPanel panel;
	private JLabel lblProductos;
	private JLabel lblCdigo;
	public static JTextField txtcodpro;
	private JLabel lblVideojuego;
	public static  JTextField txtnomprod;
	private JLabel lblPrecio;
	public static  JTextField txtprecio;
	private JTextField txtcantidad;
	private JLabel lblCantidad;
	private JLabel lblNewLabel;
	private DefaultTableModel modelo;
	private JButton btnAgregarCliente;
	private JLabel lblCliente;
	private JLabel lblfecha;
	public static int comp;
	private JPanel panel_6;
	private JLabel label_1;
	private JLabel lblsub;
	private JLabel label_3;
	private JLabel lbligv;
	private JLabel label_5;
	private JLabel lbltotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVenta frame = new RegistrarVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrarVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel_1 = new JPanel();
			panel_1.setBounds(10, 124, 341, 127);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(222, 184, 135));
			{
				lblI = new JLabel("DNI:");
				lblI.setHorizontalAlignment(SwingConstants.RIGHT);
				lblI.setForeground(Color.BLACK);
				lblI.setFont(new Font("Calibri", Font.BOLD, 14));
				lblI.setBounds(32, 14, 120, 23);
				panel_1.add(lblI);
			}
			{
				txtdni = new JTextField();
				txtdni.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtdni.setColumns(10);
				txtdni.setBounds(162, 16, 169, 20);
				panel_1.add(txtdni);
			}
			{
				lblNombres = new JLabel("NOMBRES:");
				lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombres.setForeground(Color.BLACK);
				lblNombres.setFont(new Font("Calibri", Font.BOLD, 14));
				lblNombres.setBounds(82, 51, 70, 23);
				panel_1.add(lblNombres);
			}
			{
				txtnomcli = new JTextField();
				txtnomcli.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtnomcli.setColumns(10);
				txtnomcli.setBounds(162, 52, 169, 20);
				panel_1.add(txtnomcli);
			}
			{
				lblApellidos = new JLabel("APELLIDOS:");
				lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
				lblApellidos.setForeground(Color.BLACK);
				lblApellidos.setFont(new Font("Calibri", Font.BOLD, 14));
				lblApellidos.setBounds(82, 88, 70, 23);
				panel_1.add(lblApellidos);
			}
			{
				txtapecli = new JTextField();
				txtapecli.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtapecli.setColumns(10);
				txtapecli.setBounds(162, 88, 169, 20);
				panel_1.add(txtapecli);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBounds(10, 515, 341, 41);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			panel_2.setBackground(new Color(222, 184, 135));
			{
				lblNewLabel = new JLabel("");
				lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
				lblNewLabel.setBounds(10, 11, 321, 19);
				panel_2.add(lblNewLabel);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBounds(361, 217, 145, 132);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			panel_3.setBackground(new Color(222, 184, 135));
			{
				btnagregarprod = new JButton("Agregar Producto");
				btnagregarprod.addActionListener(this);
				btnagregarprod.setIcon(new ImageIcon(RegistrarVenta.class.getResource("/imagen/agregar.png")));
				btnagregarprod.setFont(new Font("Calibri", Font.PLAIN, 11));
				btnagregarprod.setBorder(null);
				btnagregarprod.setBackground(Color.WHITE);
				btnagregarprod.setBounds(10, 13, 125, 40);
				panel_3.add(btnagregarprod);
			}
			{
				btneliminar = new JButton("Eliminar Producto");
				btneliminar.addActionListener(this);
				btneliminar.setIcon(new ImageIcon(RegistrarVenta.class.getResource("/imagen/delete.png")));
				btneliminar.setForeground(Color.BLACK);
				btneliminar.setFont(new Font("Calibri", Font.PLAIN, 11));
				btneliminar.setBorder(null);
				btneliminar.setBackground(Color.WHITE);
				btneliminar.setBounds(10, 70, 125, 40);
				panel_3.add(btneliminar);
			}
		}
		{
			panel_4 = new JPanel();
			panel_4.setBounds(0, 0, 1046, 41);
			contentPane.add(panel_4);
			panel_4.setLayout(null);
			panel_4.setBackground(Color.WHITE);
			{
				lblVEN = new JLabel("V E N T A S");
				lblVEN.setForeground(Color.BLACK);
				lblVEN.setHorizontalAlignment(SwingConstants.CENTER);
				lblVEN.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblVEN.setBackground(Color.WHITE);
				lblVEN.setBounds(396, 9, 254, 22);
				panel_4.add(lblVEN);
			}
			{
				lblfecha = new JLabel("");
				lblfecha.setBounds(899, 8, 125, 25);
				panel_4.add(lblfecha);
				lblfecha.setHorizontalAlignment(SwingConstants.CENTER);
				lblfecha.setFont(new Font("Calibri", Font.PLAIN, 16));
			}
		}
		{
			panel_5 = new JPanel();
			panel_5.setBounds(0, 0, 926, 10);
			contentPane.add(panel_5);
			panel_5.setBackground(Color.WHITE);
		}
		{
			label = new JLabel("Por favor, s\u00EDrvase llenar los siguientes datos:");
			label.setBounds(0, 0, 333, 24);
			contentPane.add(label);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			label.setBackground(SystemColor.menu);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(516, 122, 504, 326);
			contentPane.add(scrollPane);
			{
				tblventa = new JTable();
				modelo = new DefaultTableModel();
				modelo.addColumn("Código");
				modelo.addColumn("Videojuego");
				modelo.addColumn("Precio");
				modelo.addColumn("Cantidad");
				modelo.addColumn("Total");
				tblventa.setModel(modelo);
				scrollPane.setViewportView(tblventa);
			}
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(222, 184, 135));
			panel.setBounds(10, 297, 341, 170);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblCdigo = new JLabel("C\u00D3DIGO:");
				lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCdigo.setForeground(Color.BLACK);
				lblCdigo.setFont(new Font("Calibri", Font.BOLD, 14));
				lblCdigo.setBounds(32, 15, 120, 23);
				panel.add(lblCdigo);
			}
			{
				txtcodpro = new JTextField();
				txtcodpro.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtcodpro.setColumns(10);
				txtcodpro.setBounds(162, 18, 169, 20);
				panel.add(txtcodpro);
			}
			{
				lblVideojuego = new JLabel("VIDEOJUEGO:");
				lblVideojuego.setHorizontalAlignment(SwingConstants.RIGHT);
				lblVideojuego.setForeground(Color.BLACK);
				lblVideojuego.setFont(new Font("Calibri", Font.BOLD, 14));
				lblVideojuego.setBounds(32, 53, 120, 23);
				panel.add(lblVideojuego);
			}
			{
				txtnomprod = new JTextField();
				txtnomprod.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtnomprod.setColumns(10);
				txtnomprod.setBounds(162, 56, 169, 20);
				panel.add(txtnomprod);
			}
			{
				lblPrecio = new JLabel("PRECIO:");
				lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPrecio.setForeground(Color.BLACK);
				lblPrecio.setFont(new Font("Calibri", Font.BOLD, 14));
				lblPrecio.setBounds(32, 91, 120, 23);
				panel.add(lblPrecio);
			}
			{
				txtprecio = new JTextField();
				txtprecio.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtprecio.setColumns(10);
				txtprecio.setBounds(162, 94, 169, 20);
				panel.add(txtprecio);
			}
			{
				txtcantidad = new JTextField();
				txtcantidad.setFont(new Font("Calibri", Font.PLAIN, 14));
				txtcantidad.setColumns(10);
				txtcantidad.setBounds(162, 132, 169, 20);
				panel.add(txtcantidad);
			}
			{
				lblCantidad = new JLabel("CANTIDAD:");
				lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCantidad.setForeground(Color.BLACK);
				lblCantidad.setFont(new Font("Calibri", Font.BOLD, 14));
				lblCantidad.setBounds(32, 129, 120, 23);
				panel.add(lblCantidad);
			}
		}
		{
			lblProductos = new JLabel("PRODUCTOS:");
			lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductos.setForeground(Color.WHITE);
			lblProductos.setFont(new Font("Calibri", Font.BOLD, 15));
			lblProductos.setBounds(10, 262, 113, 24);
			contentPane.add(lblProductos);
		}
		{
			lblVendedor = new JLabel("VENDEDOR:");
			lblVendedor.setBounds(10, 481, 113, 24);
			contentPane.add(lblVendedor);
			lblVendedor.setHorizontalAlignment(SwingConstants.CENTER);
			lblVendedor.setForeground(Color.WHITE);
			lblVendedor.setFont(new Font("Calibri", Font.BOLD, 14));
		}
		{
			btnbuscarprod = new JButton("Buscar Producto");
			btnbuscarprod.setBounds(222, 262, 129, 24);
			contentPane.add(btnbuscarprod);
			btnbuscarprod.addActionListener(this);
			btnbuscarprod.setForeground(Color.BLACK);
			btnbuscarprod.setFont(new Font("Calibri", Font.BOLD, 12));
			btnbuscarprod.setBorder(null);
			btnbuscarprod.setBackground(Color.WHITE);
		}
		{
			lblNroComprobante = new JLabel("NRO COMPROBANTE:");
			lblNroComprobante.setBounds(506, 88, 139, 23);
			contentPane.add(lblNroComprobante);
			lblNroComprobante.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNroComprobante.setForeground(Color.BLACK);
			lblNroComprobante.setFont(new Font("Calibri", Font.BOLD, 14));
		}
		{
			txtcomprobante = new JTextField();
			txtcomprobante.setBounds(655, 89, 139, 20);
			contentPane.add(txtcomprobante);
			txtcomprobante.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtcomprobante.setColumns(10);
		}
		{
			lblCliente = new JLabel("CLIENTE:");
			lblCliente.setBounds(10, 87, 113, 24);
			contentPane.add(lblCliente);
			lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
			lblCliente.setForeground(Color.WHITE);
			lblCliente.setFont(new Font("Calibri", Font.BOLD, 15));
		}
		{
			btnAgregarCliente = new JButton("Buscar Cliente");
			btnAgregarCliente.addActionListener(this);
			btnAgregarCliente.setBounds(222, 89, 129, 24);
			contentPane.add(btnAgregarCliente);
			btnAgregarCliente.setForeground(Color.BLACK);
			btnAgregarCliente.setFont(new Font("Calibri", Font.BOLD, 12));
			btnAgregarCliente.setBorder(null);
			btnAgregarCliente.setBackground(Color.WHITE);
		}
		{
			btnbuscar = new JButton("Buscar comprobante");
			btnbuscar.setBounds(811, 88, 129, 23);
			contentPane.add(btnbuscar);
			btnbuscar.setFont(new Font("Calibri", Font.PLAIN, 12));
			btnbuscar.addActionListener(this);
			btnbuscar.setBorder(null);
			btnbuscar.setBackground(Color.WHITE);
		}
		{
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBackground(new Color(222, 184, 135));
			panel_6.setBounds(817, 463, 203, 80);
			contentPane.add(panel_6);
			{
				label_1 = new JLabel("Subtotal:");
				label_1.setForeground(Color.BLACK);
				label_1.setFont(new Font("Calibri", Font.BOLD, 12));
				label_1.setHorizontalAlignment(SwingConstants.RIGHT);
				label_1.setBounds(15, 11, 88, 14);
				panel_6.add(label_1);
			}
			{
				lblsub = new JLabel("0.0");
				lblsub.setForeground(Color.BLACK);
				lblsub.setFont(new Font("Calibri", Font.BOLD, 12));
				lblsub.setBounds(118, 11, 69, 14);
				panel_6.add(lblsub);
			}
			{
				label_3 = new JLabel("IGV (18%):");
				label_3.setForeground(Color.BLACK);
				label_3.setFont(new Font("Calibri", Font.BOLD, 12));
				label_3.setHorizontalAlignment(SwingConstants.RIGHT);
				label_3.setBounds(25, 34, 78, 14);
				panel_6.add(label_3);
			}
			{
				lbligv = new JLabel("0.0");
				lbligv.setForeground(Color.BLACK);
				lbligv.setFont(new Font("Calibri", Font.BOLD, 12));
				lbligv.setBounds(118, 34, 69, 14);
				panel_6.add(lbligv);
			}
			{
				label_5 = new JLabel("Total:");
				label_5.setForeground(Color.BLACK);
				label_5.setFont(new Font("Calibri", Font.BOLD, 12));
				label_5.setHorizontalAlignment(SwingConstants.RIGHT);
				label_5.setBounds(57, 55, 46, 14);
				panel_6.add(label_5);
			}
			{
				lbltotal = new JLabel("0.0");
				lbltotal.setForeground(Color.BLACK);
				lbltotal.setFont(new Font("Calibri", Font.BOLD, 12));
				lbltotal.setBounds(118, 55, 69, 14);
				panel_6.add(lbltotal);
			}
		}
		{
			btnregistrarventa = new JButton("Registrar Venta");
			btnregistrarventa.setBounds(516, 483, 125, 40);
			contentPane.add(btnregistrarventa);
			btnregistrarventa.setHorizontalAlignment(SwingConstants.LEFT);
			btnregistrarventa.setFont(new Font("Calibri", Font.PLAIN, 12));
			btnregistrarventa.addActionListener(this);
			btnregistrarventa.setIcon(new ImageIcon(RegistrarVenta.class.getResource("/imagen/ventabc.png")));
			btnregistrarventa.setBorder(null);
			btnregistrarventa.setBackground(Color.WHITE);
		}
		editables();
		fecha();
		obtenernumcom();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btneliminar) {
			do_btneliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnbuscar) {
			do_btnbuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnagregarprod) {
			do_btnagregarprod_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregarCliente) {
			do_btnAgregarCliente_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnbuscarprod) {
			do_btnbuscarprod_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnregistrarventa) {
			do_btnregistrarventa_actionPerformed(arg0);
		}
	}
	
	int LeerCantidad(){
		return Integer.parseInt(txtcantidad.getText());
	}

	String mensaje(){
		return "Rellene todos los campos";
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(contentPane, s, "¡ERROR!", 0);
	}
	void Mensaje(String a){
		JOptionPane.showMessageDialog(this,a);
	}

	void obtenernumcom(){
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "select NRO_Comprobante from ventas order by NRO_Comprobante desc limit 1;";
			ResultSet resultado = sql.executeQuery(consulta);
			
			if(resultado.next()){
				int com = Integer.parseInt(resultado.getString(1)) + 1;
				txtcomprobante.setEditable(false);
				txtcomprobante.setText(String.valueOf(com));
			}else {
				txtcomprobante.setEditable(false);
				txtcomprobante.setText("1");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected void do_btnagregarprod_actionPerformed(ActionEvent arg0) {
		String[] dato = new String[5];
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "CALL PR_LISTARPRODUCTOSVENTA (" + LeerCantidad()  + ", '" + txtcodpro.getText() + "');";
			ResultSet resultado = sql.executeQuery(consulta);
			double subtotal = 0, igv = 0, tot = 0;
			while(resultado.next()){
				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				dato[4] = resultado.getString(5);
				subtotal = subtotal + Double.parseDouble(dato[4]);
				Statement sql2 = conexion.GetConexion().createStatement();
				String insertar = "insert into Detalle_venta values (" + txtcomprobante.getText() + ", '" + txtcodpro.getText() + "', "	+ txtcantidad.getText() + ")";
				sql2.executeUpdate(insertar);
				modelo.addRow(dato);
			}
			igv = subtotal * 0.18;
			tot = subtotal + igv;
			lblsub.setText(String.valueOf(subtotal));
			lbligv.setText(String.valueOf(igv));
			lbltotal.setText(String.valueOf(tot));
			txtcantidad.setText("");
			txtcodpro.setText("");
			txtprecio.setText("");
			txtnomprod.setText("");
		} catch (Exception e) {
			//System.out.println("Error: " + e);
			mensaje("El videojuego ya esta en la lista");
			txtcantidad.setText("");
			txtcodpro.setText("");
			txtprecio.setText("");
			txtnomprod.setText("");
		}
	}
	
	protected void do_btnregistrarventa_actionPerformed(ActionEvent arg0) {
		try {
			
			comp = Integer.parseInt(txtcomprobante.getText());
			
			String dni = txtdni.getText();

			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "insert into ventas values(" + comp + ", '" + dni + "', '" + lblfecha.getText() + "')";
			sql.executeUpdate(consulta);
			
			limpiar();
			eliminarfilas();
			Mensaje("Se registro la venta exitosamente");
			editables();
			
			Reporteventa repor= new Reporteventa();
			repor.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "sin conexion a tabla", "conexion: ", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Error: " + e);
		}
		
	}

	protected void do_btneliminar_actionPerformed(ActionEvent arg0) {
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String codpro = String.valueOf(tblventa.getValueAt(tblventa.getSelectedRow(), 0));
			String consulta = "SELECT NRO_Comprobante, CodProd FROM Detalle_venta WHERE NRO_Comprobante = " + txtcomprobante.getText() + " and CodProd = '" + codpro + "'";
			ResultSet resultado = sql.executeQuery(consulta);

			if (resultado.next()){
				
				String eliminar = "delete from Detalle_venta where NRO_Comprobante = " + txtcomprobante.getText() + " and CodProd= '" + codpro + "'";
				sql.execute(eliminar);
				Mensaje("Se eliminó el producto " + codpro + " exitosamente");
				
				modelotabla();
				
			}else {
				mensaje("El videojuego "+ codpro +" no existe en el registro");
			}
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	protected void do_btnbuscarprod_actionPerformed(ActionEvent arg0) {
		BuscarVideojuego buscarvideo= new BuscarVideojuego();
		buscarvideo.setVisible(true);
		//dispose();
		
	}
	protected void do_btnAgregarCliente_actionPerformed(ActionEvent arg0) {
		BuscarCliente BUSCAR= new BuscarCliente();
		BUSCAR.setVisible(true);
	}

	protected void do_btnbuscar_actionPerformed(ActionEvent arg0) {
		BuscarComprobante bc = new BuscarComprobante();
		bc.setVisible(true);
	}
	
	
	private void limpiar(){
		txtcomprobante.setText("");
		txtnomcli.setText("");
		txtdni.setText("");
		txtapecli.setText("");
		txtcantidad.setText("");
		txtcodpro.setText("");
		txtprecio.setText("");
		txtnomprod.setText("");
	}
	private void editables(){
		txtcomprobante.setEditable(true);
		txtapecli.setEditable(false);
		txtcantidad.setEditable(true);
		txtcodpro.setEditable(false);
		txtdni.setEditable(false);
		txtnomcli.setEditable(false);
		txtprecio.setEditable(false);
		txtnomprod.setEditable(false);
	}
	public void eliminarfilas() {
	    for( int i = modelo.getRowCount() - 1; i >= 0; i-- ) {
	    	modelo.removeRow(i);
	    }
	}
	public void fecha(){
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		lblfecha.setText("");
		lblfecha.setText(year + "/" + month + "/" + day);
	}

	private void modelotabla(){
		try {
			double subtotal = 0, igv = 0, tot = 0, prec = 0; int cant=0;
			String[] datos = new String[5];
			modelo = new DefaultTableModel();
			modelo.addColumn("Código");
			modelo.addColumn("Videojuego");
			modelo.addColumn("Precio");
			modelo.addColumn("Cantidad");
			modelo.addColumn("Total");
			tblventa.setModel(modelo);
			scrollPane.setViewportView(tblventa);
			Statement sql1 = conexion.GetConexion().createStatement();
			String consultadetalle = "CALL PR_LISTARDETALLEVENTA (" + txtcomprobante.getText() + ")";
			ResultSet resultado = sql1.executeQuery(consultadetalle);
			eliminarfilas();
			while (resultado.next()){
				datos[0] = resultado.getString(1);
				datos[1] = resultado.getString(2);
				datos[2] = resultado.getString(3);
				datos[3] = resultado.getString(4);
				prec = Double.parseDouble(datos[2]);
				cant = Integer.parseInt(datos[3]);
				subtotal = prec * cant;
				datos[4] = subtotal + "";
				modelo.addRow(datos);
			}
			igv = subtotal * 0.18;
			tot = subtotal + igv;
			lblsub.setText(String.valueOf(subtotal));
			lbligv.setText(String.valueOf(igv));
			lbltotal.setText(String.valueOf(tot));
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
}
