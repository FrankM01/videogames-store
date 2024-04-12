package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Canvas;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextArea;

public class BuscarComprobante extends JFrame implements KeyListener, MouseListener {

	private DefaultTableModel modelo;

	private DefaultTableModel modelo1;
	private JPanel contentPane;
	private JLabel lblIngreseComprobanteA;
	private JTextField txtbuscar;
	private JScrollPane scrollPane;
	private JTable tblbuscarcom;
	private JScrollPane scrollPane_1;
	private JTable tbldetalle;
	private JLabel lblBUS;
	private JLabel lblDetalleVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarComprobante frame = new BuscarComprobante();
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
	public BuscarComprobante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 378);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblIngreseComprobanteA = new JLabel("Ingrese comprobante a buscar:");
			lblIngreseComprobanteA.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseComprobanteA.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblIngreseComprobanteA.setBounds(30, 69, 243, 14);
			contentPane.add(lblIngreseComprobanteA);
		}
		{
			txtbuscar = new JTextField();
			txtbuscar.addKeyListener(this);
			txtbuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtbuscar.setColumns(10);
			txtbuscar.setBounds(260, 66, 116, 20);
			contentPane.add(txtbuscar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(13, 110, 452, 219);
			contentPane.add(scrollPane);
			{
				tblbuscarcom = new JTable();
				tblbuscarcom.addMouseListener(this);
				scrollPane.setViewportView(tblbuscarcom);
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(13, 367, 452, 203);
			contentPane.add(scrollPane_1);
			{
				tbldetalle = new JTable();
				scrollPane_1.setViewportView(tbldetalle);
			}
		}
		{
			lblBUS = new JLabel("B U S C A R  -  V E N T A S");
			lblBUS.setBounds(159, 21, 139, 14);
			contentPane.add(lblBUS);
		}
		{
			lblDetalleVenta = new JLabel("DETALLE VENTA:");
			lblDetalleVenta.setFont(new Font("Calibri", Font.PLAIN, 12));
			lblDetalleVenta.setBounds(23, 342, 127, 14);
			contentPane.add(lblDetalleVenta);
		}
		modelotabla();
	}
	

	private void modelotabla(){
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NRO COMPROBANTE");
		modelo.addColumn("DNI");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		
		tblbuscarcom.setModel(modelo);
		
		String[] dato = new String[4];
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT v.NRO_Comprobante, c.DNI_cli, c.Nom_cli, c.Ape_cli "
					+ "FROM CLIENTE AS C INNER JOIN VENTAS AS V "
					+ "ON C.DNI_cli = v.DNI_cli";
			ResultSet resultado = sql.executeQuery(consulta);
			
			while(resultado.next()){
				
				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				modelo.addRow(dato);
			}
		} catch (Exception e) {

			System.out.println("Error: "+e);
		}
	}

	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtbuscar) {
			do_textField_keyReleased(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_textField_keyReleased(KeyEvent arg0) {
		
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT v.NRO_Comprobante, c.DNI_cli, c.Nom_cli, c.Ape_cli"
					+ " FROM CLIENTE AS C INNER JOIN VENTAS AS V "
					+ " ON C.DNI_cli = v.DNI_cli where v.NRO_Comprobante like '%' '" + txtbuscar.getText() + "' '%';";
			ResultSet resultado = sql.executeQuery(consulta);
			
			eliminarfilas();
			
			String[] dato = new String[4];
			
			while(resultado.next()){

				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				modelo.addRow(dato);

				//mostrardetalleventa();
			}

		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	public void eliminarfilas() {
	    for( int i = modelo.getRowCount() - 1; i >= 0; i-- ) {
	    	modelo.removeRow(i);
	    }
	}
	
	public void eliminarfiladetalle() {
	    for( int i = modelo1.getRowCount() - 1; i >= 0; i-- ) {
	    	modelo1.removeRow(i);
	    }
	}
	
	public void mostrardetalleventa(){
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblbuscarcom) {
			do_tblbuscarcom_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tblbuscarcom_mouseClicked(MouseEvent arg0) {
		setBounds(100, 100, 498, 620);
		try{

			modelo1 = new DefaultTableModel();
			modelo1.addColumn("Código");
			modelo1.addColumn("Videojuego");
			modelo1.addColumn("Precio");
			modelo1.addColumn("Cantidad");
			modelo1.addColumn("Total");
			tbldetalle.setModel(modelo1);
			scrollPane_1.setViewportView(tbldetalle);
			
			String[] datos = new String[5];
			Statement sql1 = conexion.GetConexion().createStatement();
			String consultadetalle = "CALL PR_LISTARDETALLEVENTA (" + (tblbuscarcom.getSelectedRow() +1) + ")";
			ResultSet resultado = sql1.executeQuery(consultadetalle);

			eliminarfiladetalle();
			
			while (resultado.next()){
				
				datos[0] = resultado.getString(1);
				datos[1] = resultado.getString(2);
				datos[2] = resultado.getString(3);
				datos[3] = resultado.getString(4);
				double prec = Double.parseDouble(datos[2]);
				int cant = Integer.parseInt(datos[3]);
				double mul = prec * cant;
				datos[4] = mul + "";
				modelo1.addRow(datos);
			}
		}
		catch (Exception e){
			System.out.println("Error: "+e);
		}
	}
}
