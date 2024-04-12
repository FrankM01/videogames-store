package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;
import arreglos.ArregloVendedor;
import clases.Administrador;
import clases.Cliente;
import clases.Login;
import clases.Vendedor;
import config.conexion;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class RegistrarCliente extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	private JTable tblclientes;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JTextField txtdnicli;
	private JTextField txtnombre;
	private JTextField txtapellidos;
	private JTextField txtcorreo;
	private JTextField txtcel;
	private JTextField txtdireccion;
	private DefaultTableModel modelo;
	private JLabel lblDni;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JPanel panel;
	private JLabel lblCorreo;
	private JLabel lblDireccin;
	private JLabel lblTelfono;
	private JButton btneliminar;
	private JButton btnmodificar;
	private JButton btnbuscar;
	private JButton btnlistar;
	private JPanel panel_1;
	private JButton btnatras;
	private JPanel panel_2;
	private JLabel lblCLI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCliente frame = new RegistrarCliente();
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
	public RegistrarCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 260, 538, 161);
			contentPane.add(scrollPane);
			{
				tblclientes = new JTable();
				tblclientes.addMouseListener(this);
				scrollPane.setViewportView(tblclientes);
			}
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(143, 188, 143));
			panel.setBounds(20, 48, 306, 190);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblDni = new JLabel("DNI:");
				lblDni.setForeground(Color.WHITE);
				lblDni.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblDni.setBounds(34, 15, 69, 14);
				panel.add(lblDni);
			}
			{
				txtdnicli = new JTextField();
				txtdnicli.setBounds(125, 10, 156, 20);
				panel.add(txtdnicli);
				txtdnicli.setColumns(10);
			}
			{
				lblNombres = new JLabel("NOMBRES:");
				lblNombres.setForeground(Color.WHITE);
				lblNombres.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblNombres.setBounds(34, 44, 69, 14);
				panel.add(lblNombres);
			}
			{
				txtnombre = new JTextField();
				txtnombre.setBounds(125, 40, 156, 20);
				panel.add(txtnombre);
				txtnombre.setColumns(10);
			}
			{
				lblApellidos = new JLabel("APELLIDOS:");
				lblApellidos.setForeground(Color.WHITE);
				lblApellidos.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblApellidos.setBounds(34, 73, 69, 14);
				panel.add(lblApellidos);
			}
			{
				txtapellidos = new JTextField();
				txtapellidos.setBounds(125, 70, 156, 20);
				panel.add(txtapellidos);
				txtapellidos.setColumns(10);
			}
			{
				txtcorreo = new JTextField();
				txtcorreo.setBounds(125, 100, 156, 20);
				panel.add(txtcorreo);
				txtcorreo.setColumns(10);
			}
			{
				txtdireccion = new JTextField();
				txtdireccion.setBounds(125, 130, 156, 20);
				panel.add(txtdireccion);
				txtdireccion.setColumns(10);
			}
			{
				txtcel = new JTextField();
				txtcel.setBounds(125, 160, 156, 20);
				panel.add(txtcel);
				txtcel.setColumns(10);
			}
			{
				lblCorreo = new JLabel("CORREO:");
				lblCorreo.setForeground(Color.WHITE);
				lblCorreo.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblCorreo.setBounds(34, 102, 69, 14);
				panel.add(lblCorreo);
			}
			{
				lblDireccin = new JLabel("DIRECCI\u00D3N:");
				lblDireccin.setForeground(Color.WHITE);
				lblDireccin.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblDireccin.setBounds(34, 131, 69, 14);
				panel.add(lblDireccin);
			}
			{
				lblTelfono = new JLabel("TEL\u00C9FONO:");
				lblTelfono.setForeground(Color.WHITE);
				lblTelfono.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblTelfono.setBounds(34, 160, 69, 14);
				panel.add(lblTelfono);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(143, 188, 143));
			panel_1.setBounds(336, 89, 222, 108);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				btnAgregar = new JButton("");
				btnAgregar.setBounds(16, 11, 52, 40);
				btnAgregar.setBackground(Color.WHITE);
				btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAgregar.setBorder(null);
				panel_1.add(btnAgregar);
				btnAgregar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/agregar.png")));
				{
					btnbuscar = new JButton("");
					btnbuscar.addActionListener(this);
					btnbuscar.setBackground(Color.WHITE);
					btnbuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnbuscar.setBorder(null);
					btnbuscar.setBounds(39, 61, 52, 40);
					panel_1.add(btnbuscar);
					btnbuscar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/search.png")));
				}
				{
					btnlistar = new JButton("");
					btnlistar.addActionListener(this);
					btnlistar.setBackground(Color.WHITE);
					btnlistar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnlistar.setBorder(null);
					btnlistar.setBounds(130, 62, 52, 40);
					panel_1.add(btnlistar);
					btnlistar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/listar.png")));
				}
				{
					btneliminar = new JButton("");
					btneliminar.addActionListener(this);
					btneliminar.setBackground(Color.WHITE);
					btneliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btneliminar.setBorder(null);
					btneliminar.setBounds(84, 11, 52, 40);
					panel_1.add(btneliminar);
					btneliminar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/delete.png")));
				}
				{
					btnmodificar = new JButton("");
					btnmodificar.addActionListener(this);
					btnmodificar.setBackground(Color.WHITE);
					btnmodificar.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnmodificar.setBorder(null);
					btnmodificar.setBounds(152, 11, 52, 40);
					panel_1.add(btnmodificar);
					btnmodificar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/edit.png")));
				}
				{
					btnatras = new JButton("");
					btnatras.addActionListener(this);
					btnatras.setBackground(new Color(143, 188, 143));
					btnatras.setBorder(null);
					btnatras.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/backblanco.png")));
					btnatras.setBounds(21, 432, 52, 40);
					contentPane.add(btnatras);
				}
				{
					panel_2 = new JPanel();
					panel_2.setLayout(null);
					panel_2.setBackground(Color.WHITE);
					panel_2.setBounds(0, 0, 575, 41);
					contentPane.add(panel_2);
					{
						lblCLI = new JLabel("C L I E N T E S");
						lblCLI.setHorizontalAlignment(SwingConstants.CENTER);
						lblCLI.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblCLI.setBackground(Color.WHITE);
						lblCLI.setBounds(160, 9, 254, 22);
						panel_2.add(lblCLI);
					}
				}
				btnAgregar.addActionListener(this);
			}
		}
		
		//conexion a mysql
		try {
			Statement sql = conexion.GetConexion().createStatement();
			modelotabla();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnatras) {
			do_btnatras_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnmodificar) {
			do_btnmodificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnlistar) {
			do_btnlistar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnbuscar) {
			do_btnbuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btneliminar) {
			do_btneliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(arg0);
		}
	}
	
	/*** ATRIBUTOS */
	int ID_cli(){
		return Integer.parseInt(txtdnicli.getText().trim());
	}
	String Nombre_cli(){
		return txtnombre.getText().trim();
	}
	String Apellido_cli(){
		return txtapellidos.getText();
	}
	String Correo_cli(){
		return txtcorreo.getText().trim();
	}
	String  Direccion_cli(){
		return txtdireccion.getText().trim();
	}
	String Telefono_cli(){
		return txtcel.getText();
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

	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {
		
		try {
			int dni = ID_cli();
			String nom = Nombre_cli();
			String ape = Apellido_cli();
			String correo = Correo_cli();
			String direc = Direccion_cli();
			String telf = Telefono_cli();
			
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "insert into cliente values(" + dni + ", '" + nom + "', '" + ape + "','" + correo + "','" + direc + "','" + telf + "')";
			sql.executeUpdate(consulta);
			
			limpiar();
			Mensaje("Se agrego el cliente exitosamente");
			modelotabla();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "sin conexion a tabla", "conexion: ", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Error: " + e);
		}
		
	
	}
	/*
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0; i<arrcli.Tamaño(); i++){
			Object[] fila ={
			arrcli.Obtener(i).getID_Cliente(),
			arrcli.Obtener(i).getNombre(),
			arrcli.Obtener(i).getApellido(),
			arrcli.Obtener(i).getCorreo(),
			arrcli.Obtener(i).getDirección(),
			arrcli.Obtener(i).getTeléfono()};
			modelo.addRow(fila);
			}
	}*/
	
	private void limpiar(){
		txtdnicli.setText("");
		txtnombre.setText("");
		txtapellidos.setText("");
		txtcorreo.setText("");
		txtdireccion.setText("");
		txtcel.setText("");
	}
	private void modelotabla(){	
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Correo");
		modelo.addColumn("Dirección");
		modelo.addColumn("Telefono");
		tblclientes.setModel(modelo);
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
			// TODO: handle exception
		}
	}
	protected void do_btneliminar_actionPerformed(ActionEvent arg0) {
		
		try {
				Statement sql = conexion.GetConexion().createStatement();
				String consulta = "SELECT DNI_cli FROM cliente WHERE DNI_cli= " + ID_cli();
				ResultSet resu = sql.executeQuery(consulta);
				
				if (resu.next()){
					
					String eliminar = "delete from cliente where DNI_cli= " + ID_cli();
					sql.execute(eliminar);
					Mensaje("Se eliminó al cliente " + ID_cli() + " exitosamente");
					
					limpiar();
					modelotabla();
				}else {
					mensaje("El cliente con DNI "+ ID_cli() +" no existe en el registro");
					txtdnicli.setText("");
					txtdnicli.requestFocus();
				}
				
		}
		catch (Exception e) {
			mensaje("Rellene los campos");
			txtdnicli.setText("");
			txtdnicli.requestFocus();
			System.out.println("Error: "+e);
		}
		
			
	}
	protected void do_btnbuscar_actionPerformed(ActionEvent arg0) {
		try{
			
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT * FROM cliente WHERE DNI_cli= " + ID_cli();
			ResultSet resu = sql.executeQuery(consulta);
			
			if (resu.next()){
				
				Mensaje("Se encontró al cliente con DNI " + ID_cli() + " exitosamente");
				
				txtdnicli.setText(resu.getString(1));
				txtnombre.setText(resu.getString(2));
				txtapellidos.setText(resu.getString(3));
				txtcorreo.setText(resu.getString(4));
				txtdireccion.setText(resu.getString(5));
				txtcel.setText(resu.getString(6));
			}else{
				mensaje("El cliente con DNI "+ ID_cli() +" no existe en el registro");
				txtdnicli.setText("");
				txtdnicli.requestFocus();
			}
		}
		catch (Exception e){
			mensaje("Rellene el campo requirido");
			txtdnicli.setText("");
			txtdnicli.requestFocus();
			System.out.println("Error: "+e);
		}
	}
	protected void do_btnlistar_actionPerformed(ActionEvent arg0) {
		//Listar();
		modelotabla();
	}
	
	protected void do_btnmodificar_actionPerformed(ActionEvent arg0) {
		try{
			
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT DNI_cli FROM cliente WHERE DNI_cli= " + ID_cli();
			ResultSet resu = sql.executeQuery(consulta);
			
			if (resu.next()){
				
				String editar = "UPDATE cliente SET DNI_cli=" + ID_cli()
				+ ", Nom_cli='" + Nombre_cli() 
				+ "', Ape_cli='" + Apellido_cli()
				+ "', Correo_cli='" + Correo_cli()
				+ "', Direcc_cli='" + Direccion_cli() 
				+ "', Telf_cli='" + Telefono_cli()
				+ "' WHERE DNI_cli= " + ID_cli() + ";";
				sql.execute(editar);
				
				Mensaje("Se modifico al cliente " + ID_cli() + " exitosamente");
				limpiar();
				//Listar();
				modelotabla();
				
			}else{
				mensaje("El cliente con DNI "+ ID_cli() +" no existe en el registro");
				txtdnicli.setText("");
				txtdnicli.requestFocus();
			}
		}
		catch (Exception e){
			mensaje("Rellene el campo requirido");
			txtdnicli.setText("");
			txtdnicli.requestFocus();
			System.out.println("Error: "+e);
		}
	}
	protected void do_btnatras_actionPerformed(ActionEvent arg0) {
		Inicio nuevoFrame= new Inicio();
		nuevoFrame.setVisible(true);
		dispose();	
	}
	

/**seleccionamos la fila con click en el registro qu deseamos para enviarlo al registro venta*/
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblclientes) {
			do_tblclientes_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_tblclientes_mouseClicked(MouseEvent evt) {
		int seleccionar = tblclientes.rowAtPoint(evt.getPoint());
		
		
		RegistrarVenta.txtdni.setText(String.valueOf(tblclientes.getValueAt(seleccionar, 0)));
		RegistrarVenta.txtnomcli.setText(String.valueOf(tblclientes.getValueAt(seleccionar, 1)));
		RegistrarVenta.txtapecli.setText(String.valueOf(tblclientes.getValueAt(seleccionar, 2)));
		
		RegistrarVenta.txtdni.setEditable(false);
		RegistrarVenta.txtnomcli.setEditable(false);
		RegistrarVenta.txtapecli.setEditable(false);
		
		RegistrarVenta registrarv= new RegistrarVenta();
		registrarv.setVisible(true);
		dispose();
	}
}


