package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class Reporteventa extends JFrame {
	private DefaultTableModel modelo;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblBoletaDeVenta;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lbldni;
	private JLabel lblcomprobante;
	private JLabel lblDetalleDeVenta;
	private JTable tblreporte;
	private JScrollPane scrollPane;
	private JLabel label;
	private JLabel lblnomapel;
	private JLabel lblTotalAPagar;
	private JLabel lblsubtotal;
	private JPanel panel_2;
	private JLabel lbl;
	private JLabel lbligv;
	private JLabel label123123;
	private JLabel lbltotal;
	private JLabel lblFecha;
	private JLabel lblfecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporteventa frame = new Reporteventa();
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
	public Reporteventa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 582);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(117, 11, 238, 32);
			panel.setBackground(Color.WHITE);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblBoletaDeVenta = new JLabel("BOLETA DE VENTA");
				lblBoletaDeVenta.setBounds(61, 9, 116, 14);
				panel.add(lblBoletaDeVenta);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBounds(8, 57, 459, 114);
			panel_1.setBackground(Color.WHITE);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblNewLabel = new JLabel("NRO COMPROBANTE:");
				lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel.setBounds(15, 11, 153, 14);
				panel_1.add(lblNewLabel);
			}
			{
				lblNewLabel_1 = new JLabel("DNI:");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_1.setBounds(10, 61, 158, 14);
				panel_1.add(lblNewLabel_1);
			}
			{
				lbldni = new JLabel("");
				lbldni.setBounds(201, 61, 228, 14);
				panel_1.add(lbldni);
			}
			{
				lblcomprobante = new JLabel("");
				lblcomprobante.setBounds(201, 11, 98, 14);
				panel_1.add(lblcomprobante);
			}
			{
				label = new JLabel("NOMBRES Y APELLIDOS:");
				label.setHorizontalAlignment(SwingConstants.RIGHT);
				label.setBounds(10, 86, 158, 14);
				panel_1.add(label);
			}
			{
				lblnomapel = new JLabel("");
				lblnomapel.setBounds(201, 86, 228, 14);
				panel_1.add(lblnomapel);
			}
			{
				lblFecha = new JLabel("FECHA:");
				lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
				lblFecha.setBounds(15, 36, 153, 14);
				panel_1.add(lblFecha);
			}
			{
				lblfecha = new JLabel("");
				lblfecha.setBounds(201, 36, 98, 14);
				panel_1.add(lblfecha);
			}
		}
		{
			lblDetalleDeVenta = new JLabel("DETALLE DE VENTA");
			lblDetalleDeVenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetalleDeVenta.setFont(new Font("Calibri", Font.PLAIN, 11));
			lblDetalleDeVenta.setBounds(8, 193, 459, 14);
			contentPane.add(lblDetalleDeVenta);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 207, 457, 203);
			contentPane.add(scrollPane);
			{
				tblreporte = new JTable();
				tblreporte.setBackground(Color.WHITE);
				tblreporte.setEnabled(false);
				modelo = new DefaultTableModel();
				modelo.addColumn("Código");
				modelo.addColumn("Videojuego");
				modelo.addColumn("Precio");
				modelo.addColumn("Cantidad");
				modelo.addColumn("Total");
				tblreporte.setModel(modelo);
				scrollPane.setViewportView(tblreporte);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(263, 421, 203, 80);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			{
				lblTotalAPagar = new JLabel("Subtotal:");
				lblTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTotalAPagar.setBounds(15, 11, 88, 14);
				panel_2.add(lblTotalAPagar);
			}
			{
				lblsubtotal = new JLabel("");
				lblsubtotal.setBounds(118, 11, 69, 14);
				panel_2.add(lblsubtotal);
			}
			{
				lbl = new JLabel("IGV (18%):");
				lbl.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl.setBounds(25, 34, 78, 14);
				panel_2.add(lbl);
			}
			{
				lbligv = new JLabel("");
				lbligv.setBounds(118, 34, 69, 14);
				panel_2.add(lbligv);
			}
			{
				label123123 = new JLabel("Total:");
				label123123.setHorizontalAlignment(SwingConstants.RIGHT);
				label123123.setBounds(57, 55, 46, 14);
				panel_2.add(label123123);
			}
			{
				lbltotal = new JLabel("");
				lbltotal.setBounds(118, 55, 69, 14);
				panel_2.add(lbltotal);
			}
		}
		datos();
		cargartabla();
	}
	
	
	public void datos(){
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT v.NRO_Comprobante as 'NUM COMPROBANTE', v.FechaVenta, c.DNI_cli as DNI, c.Nom_cli as NOMBRE, c.Ape_cli as APELLIDO "
					+ "FROM CLIENTE AS C INNER JOIN VENTAS AS V "
					+ "ON C.DNI_cli = v.DNI_cli where v.NRO_Comprobante = " + RegistrarVenta.comp;
			ResultSet resultado = sql.executeQuery(consulta);
			
			
			while(resultado.next()){

				lblcomprobante.setText(resultado.getString(1));
				lblfecha.setText(resultado.getString(2));
				lbldni.setText(resultado.getString(3));
				lblnomapel.setText(resultado.getString(4) + " " + resultado.getString(4));
				
			}
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	public void cargartabla(){
		
		try{
		
			String[] dato = new String[5];
			Statement sql = conexion.GetConexion().createStatement();
	
			String consulta = "CALL PR_LISTARDETALLEVENTA (" + RegistrarVenta.comp + ")";
			ResultSet resu = sql.executeQuery(consulta);
			
			double subtotal = 0, igv = 0, tot = 0;
			
			while (resu.next()){
				
				dato[0] = resu.getString(1);
				dato[1] = resu.getString(2);
				dato[2] = resu.getString(3);
				dato[3] = resu.getString(4);
				
					double prec = Double.parseDouble(dato[2]);
					int cant = Integer.parseInt(dato[3]);
					double subto = prec * cant;
					subtotal = subtotal + subto;
				
				dato[4] = subto + "";
				modelo.addRow(dato);
			}

			igv = subtotal * 0.18;
			tot = subtotal + igv;
			
			lblsubtotal.setText(String.valueOf(subtotal));
			lbligv.setText(String.valueOf(igv));
			lbltotal.setText(String.valueOf(tot));
		}
		catch (Exception e){
			System.out.println("Error: "+e);
		}
	}
}
 