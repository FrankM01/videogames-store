package guiVentanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BuscarVideojuego extends JFrame implements KeyListener, MouseListener {

	private DefaultTableModel modelo;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JPanel panel_1;
	private JLabel lblBUS;
	private JScrollPane scrollPane;
	private JTable tblbuscar;
	private JLabel lblEscribaElVideojuego;
	private JTextField txtbuscar;
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVideojuego frame = new BuscarVideojuego();
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
	public BuscarVideojuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(0, 0, 662, 33);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblBUS = new JLabel("B U S C A R  -  V I D E O J U E G O S");
				lblBUS.setBounds(228, 9, 206, 14);
				panel_1.add(lblBUS);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 120, 642, 272);
			contentPane.add(scrollPane);
			{
				tblbuscar = new JTable();
				tblbuscar.addMouseListener(this);
				scrollPane.setViewportView(tblbuscar);
			}
		}
		{
			lblEscribaElVideojuego = new JLabel("Ingrese el videojuego a buscar:");
			lblEscribaElVideojuego.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblEscribaElVideojuego.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEscribaElVideojuego.setBounds(10, 64, 186, 14);
			contentPane.add(lblEscribaElVideojuego);
		}
		{
			txtbuscar = new JTextField();
			txtbuscar.addKeyListener(this);
			txtbuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtbuscar.setBounds(205, 61, 447, 20);
			contentPane.add(txtbuscar);
			txtbuscar.setColumns(10);
		}
		{
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.setBounds(563, 86, 89, 23);
			contentPane.add(btnSeleccionar);
		}
		
		modelotabla();
	}
	
	
private void modelotabla(){
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Videojuego");
		modelo.addColumn("Desarrollador");
		modelo.addColumn("Plataforma");
		modelo.addColumn("Género");
		modelo.addColumn("Año");
		modelo.addColumn("Jugadores");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		
		tblbuscar.setModel(modelo);
		
		String[] dato = new String[9];
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT * FROM producto";
			ResultSet resultado = sql.executeQuery(consulta);
			
			while(resultado.next()){
				
				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				dato[4] = resultado.getString(5);
				dato[5] = resultado.getString(6);
				dato[6] = resultado.getString(7);
				dato[7] = resultado.getString(8);
				dato[8] = resultado.getString(9);
				modelo.addRow(dato);
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	

/**filtramos el videojuego por el nombre con la accion keyreleased*/
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtbuscar) {
			do_txtbuscar_keyReleased(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_txtbuscar_keyReleased(KeyEvent arg0) {
		buscarproducto();
	}
	void buscarproducto(){
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "select * from producto where NomProd like '%' '" + txtbuscar.getText() + "' '%';";
			ResultSet resultado = sql.executeQuery(consulta);
			
			eliminarfilas();
			
			String[] dato = new String[9];
			
			while(resultado.next()){
				
				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				dato[4] = resultado.getString(5);
				dato[5] = resultado.getString(6);
				dato[6] = resultado.getString(7);
				dato[7] = resultado.getString(8);
				dato[8] = resultado.getString(9);
				modelo.addRow(dato);				
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
	
/**seleccionamos la fila con doble click en el registro qeu deseamos*/
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblbuscar) {
			do_tblbuscar_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void do_tblbuscar_mouseClicked(MouseEvent evt) {

		int seleccionar = tblbuscar.rowAtPoint(evt.getPoint());
		
		
		RegistrarVenta.txtcodpro.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 0)));
		RegistrarVenta.txtnomprod.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 1)));
		RegistrarVenta.txtprecio.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 7)));
		
		RegistrarVenta.txtcodpro.setEditable(false);
		RegistrarVenta.txtnomprod.setEditable(false);
		RegistrarVenta.txtprecio.setEditable(false);
		
		//RegistrarVenta registrarv= new RegistrarVenta();
		//registrarv.setVisible(true);
		dispose();
		
	}
}
