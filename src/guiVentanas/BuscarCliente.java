package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import config.conexion;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BuscarCliente extends JFrame implements KeyListener, MouseListener {

	private DefaultTableModel modelo;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblBUS;
	private JScrollPane scrollPane;
	private JTable tblbuscar;
	private JLabel lblIngreseElDni;
	private JTextField txtbuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente frame = new BuscarCliente();
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
	public BuscarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 686, 39);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblBUS = new JLabel("B U S C A R  -  C L I E N T E S");
				lblBUS.setBounds(273, 12, 139, 14);
				panel.add(lblBUS);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 108, 614, 275);
			contentPane.add(scrollPane);
			{
				tblbuscar = new JTable();
				tblbuscar.addMouseListener(this);
				scrollPane.setViewportView(tblbuscar);
			}
		}
		{
			lblIngreseElDni = new JLabel("Ingrese el DNI del cliente a buscar:");
			lblIngreseElDni.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreseElDni.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblIngreseElDni.setBounds(102, 66, 243, 14);
			contentPane.add(lblIngreseElDni);
		}
		{
			txtbuscar = new JTextField();
			txtbuscar.addKeyListener(this);
			txtbuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtbuscar.setColumns(10);
			txtbuscar.setBounds(343, 63, 116, 20);
			contentPane.add(txtbuscar);
		}
		modelotabla();
	}

	private void modelotabla(){
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Correo");
		modelo.addColumn("Dirección");
		modelo.addColumn("Telefono");
		
		tblbuscar.setModel(modelo);
		
		String[] dato = new String[6];
		
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT * FROM Cliente";
			ResultSet resultado = sql.executeQuery(consulta);
			
			while(resultado.next()){
				
				dato[0] = resultado.getString(1);
				dato[1] = resultado.getString(2);
				dato[2] = resultado.getString(3);
				dato[3] = resultado.getString(4);
				dato[4] = resultado.getString(5);
				dato[5] = resultado.getString(6);
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
			do_txtbuscar_keyReleased(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_txtbuscar_keyReleased(KeyEvent arg0) {
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "select * from cliente where DNI_cli like '%' '" + txtbuscar.getText() + "' '%';";
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
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblbuscar) {
			do_tblbuscar_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tblbuscar_mouseClicked(MouseEvent evt) {
		int seleccionar = tblbuscar.rowAtPoint(evt.getPoint());
		
		RegistrarVenta.txtdni.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 0)));
		RegistrarVenta.txtnomcli.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 1)));
		RegistrarVenta.txtapecli.setText(String.valueOf(tblbuscar.getValueAt(seleccionar, 2)));
		
		RegistrarVenta.txtdni.setEditable(false);
		RegistrarVenta.txtnomcli.setEditable(false);
		RegistrarVenta.txtapecli.setEditable(false);
		
		//RegistrarVenta registrarv= new RegistrarVenta();
		//registrarv.setVisible(true);
		dispose();
	}
}
