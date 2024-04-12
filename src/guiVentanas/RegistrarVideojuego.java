package guiVentanas;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloProducto;
import clases.Producto;
import config.conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RegistrarVideojuego extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblAo;
	private JLabel lblNombre;
	private JLabel lblCategoria;
	private JLabel lblTipo;
	private JLabel lblPrecio;
	private JLabel lblDesarro;
	private JLabel lblCalidad;
	private JLabel lblPlataforma;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtgenero;
	private JTextField txtDes;
	private JTextField txtPlat;
	private JTextField txtYear;
	private JTextField txtjugadores;
	private JTextField txtPre;
	private JTextField txtstock;
	private JButton btnadicionar;
	private JButton btnactualizar;
	private JButton btneliminar;
	private JButton btnconsultar;
	private JButton btnmodificar;
	private JScrollPane scrollPane;
	private JTable tblvideojuego;
	private DefaultTableModel modelo;
	private JButton btnAtras;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblVID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVideojuego frame = new RegistrarVideojuego();
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
	public RegistrarVideojuego() {
		setBackground(Color.DARK_GRAY);
		setTitle("Registrar Videojuegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 638);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(330, 77, 638, 444);
			contentPane.add(scrollPane);
			{
				tblvideojuego = new JTable();
				scrollPane.setViewportView(tblvideojuego);
				tblvideojuego.setFillsViewportHeight(true);
			}
		}
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 978, 41);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				lblVID = new JLabel("V I D E O J U E G O S");
				lblVID.setBounds(362, 9, 253, 22);
				lblVID.setHorizontalAlignment(SwingConstants.CENTER);
				lblVID.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblVID.setBackground(Color.WHITE);
				panel.add(lblVID);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(245, 245, 220));
			panel_1.setBounds(21, 77, 285, 444);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblCodigo = new JLabel("Codigo:");
				lblCodigo.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblCodigo.setBackground(new Color(173, 255, 47));
				lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCodigo.setBounds(34, 26, 69, 20);
				panel_1.add(lblCodigo);
			}
			{
				txtCod = new JTextField();
				txtCod.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtCod.setBounds(123, 21, 146, 26);
				panel_1.add(txtCod);
				txtCod.setColumns(10);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNombre.setBounds(34, 72, 69, 20);
				panel_1.add(lblNombre);
			}
			{
				txtNom = new JTextField();
				txtNom.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtNom.setBounds(123, 68, 146, 26);
				panel_1.add(txtNom);
				txtNom.setColumns(10);
			}
			{
				lblTipo = new JLabel("G\u00E9nero:");
				lblTipo.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblTipo.setBounds(34, 211, 69, 20);
				panel_1.add(lblTipo);
			}
			{
				txtgenero = new JTextField();
				txtgenero.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtgenero.setBounds(123, 209, 146, 26);
				panel_1.add(txtgenero);
				txtgenero.setColumns(10);
			}
			{
				lblDesarro = new JLabel("Desarrollador:");
				lblDesarro.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblDesarro.setHorizontalAlignment(SwingConstants.RIGHT);
				lblDesarro.setBounds(0, 118, 103, 20);
				panel_1.add(lblDesarro);
			}
			{
				txtDes = new JTextField();
				txtDes.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtDes.setBounds(123, 115, 146, 26);
				panel_1.add(txtDes);
				txtDes.setColumns(10);
			}
			{
				lblPlataforma = new JLabel("Plataforma");
				lblPlataforma.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblPlataforma.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPlataforma.setBounds(34, 164, 69, 20);
				panel_1.add(lblPlataforma);
			}
			{
				txtPlat = new JTextField();
				txtPlat.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtPlat.setBounds(123, 162, 146, 26);
				panel_1.add(txtPlat);
				txtPlat.setColumns(10);
			}
			{
				lblAo = new JLabel("A\u00F1o (yyyy-mm-dd):");
				lblAo.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblAo.setHorizontalAlignment(SwingConstants.RIGHT);
				lblAo.setBounds(0, 258, 103, 20);
				panel_1.add(lblAo);
			}
			{
				txtYear = new JTextField();
				txtYear.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtYear.setBounds(123, 256, 146, 26);
				panel_1.add(txtYear);
				txtYear.setColumns(10);
			}
			{
				lblCategoria = new JLabel("Jugadores:");
				lblCategoria.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCategoria.setBounds(34, 305, 69, 20);
				panel_1.add(lblCategoria);
			}
			{
				txtjugadores = new JTextField();
				txtjugadores.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtjugadores.setBounds(123, 303, 146, 26);
				panel_1.add(txtjugadores);
				txtjugadores.setColumns(10);
			}
			{
				txtPre = new JTextField();
				txtPre.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtPre.setBounds(123, 350, 146, 26);
				panel_1.add(txtPre);
				txtPre.setColumns(10);
			}
			{
				txtstock = new JTextField();
				txtstock.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				txtstock.setBounds(123, 397, 146, 26);
				panel_1.add(txtstock);
				txtstock.setColumns(10);
			}
			{
				lblPrecio = new JLabel("Precio:");
				lblPrecio.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
				lblPrecio.setBounds(34, 352, 69, 20);
				panel_1.add(lblPrecio);
			}
			{
				lblCalidad = new JLabel("Stock:");
				lblCalidad.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
				lblCalidad.setHorizontalAlignment(SwingConstants.RIGHT);
				lblCalidad.setBounds(34, 399, 69, 20);
				panel_1.add(lblCalidad);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(245, 245, 220));
			panel_2.setBounds(302, 530, 373, 58);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			{
				btnadicionar = new JButton("");
				btnadicionar.setBounds(68, 11, 52, 40);
				btnadicionar.setBackground(Color.WHITE);
				btnadicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnadicionar.setBorder(null);
				btnadicionar.addActionListener(this);
				btnadicionar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/agregar.png")));
				panel_2.add(btnadicionar);
			}
			{
				btnactualizar = new JButton("");
				btnactualizar.setBounds(128, 11, 52, 40);
				btnactualizar.setBackground(Color.WHITE);
				btnactualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnactualizar.setBorder(null);
				btnactualizar.addActionListener(this);
				btnactualizar.setIcon(new ImageIcon(RegistrarVideojuego.class.getResource("/imagen/actualizar.png")));
				panel_2.add(btnactualizar);
			}
			{
				btneliminar = new JButton("");
				btneliminar.setBounds(188, 11, 52, 40);
				btneliminar.setBackground(Color.WHITE);
				btneliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btneliminar.setBorder(null);
				btneliminar.addActionListener(this);
				btneliminar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/delete.png")));
				panel_2.add(btneliminar);
			}
			{
				btnconsultar = new JButton("");
				btnconsultar.setBounds(248, 11, 52, 40);
				btnconsultar.addActionListener(this);
				btnconsultar.setBackground(Color.WHITE);
				btnconsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnconsultar.setBorder(null);
				btnconsultar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/search.png")));
				panel_2.add(btnconsultar);
			}
			{
				btnmodificar = new JButton("");
				btnmodificar.addActionListener(this);
				btnmodificar.setBounds(308, 11, 52, 40);
				btnmodificar.setBackground(Color.WHITE);
				btnmodificar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnmodificar.setBorder(null);
				btnmodificar.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/edit.png")));
				panel_2.add(btnmodificar);
			}
			{
				btnAtras = new JButton("");
				btnAtras.setBounds(8, 11, 52, 40);
				panel_2.add(btnAtras);
				btnAtras.setIcon(new ImageIcon(RegistrarVideojuego.class.getResource("/Imag/back.png")));
				btnAtras.addActionListener(this);
				btnAtras.setBackground(new Color(245, 245, 220));
				btnAtras.setBorder(null);
				btnAtras.setIcon(new ImageIcon(RegistrarCliente.class.getResource("/imagen/backblanco.png")));
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
		if (arg0.getSource() == btnmodificar) {
			do_btnmodificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAtras) {
			do_btnAtras_actionPerformed(arg0);
		}
		if (arg0.getSource() == btneliminar) {
			do_btneliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnactualizar) {
			do_btnactualizar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnconsultar) {
			do_btnconsultar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnadicionar) {
			do_btnadicionar_actionPerformed(arg0);
		}
	}
	

	String LeerCod(){
		return txtCod.getText();
	}
	String LeerNom(){
		return txtNom.getText();
	}
	String LeerGenero(){
		return txtgenero.getText();
	}
	String LeerDesarrolladora(){
		return txtDes.getText();
	}
	String LeerPlataforma(){
		return txtPlat.getText();
	}
	String LeerYear(){
		return txtYear.getText();
	}
	String LeerJugadores(){
		return txtjugadores.getText();
	}
	Double LeerPrecio(){
		return Double.parseDouble(txtPre.getText());
	}
	int LeerStock(){
		return Integer.parseInt(txtstock.getText());
	}
	void Mensaje (String s){
		JOptionPane.showMessageDialog(this, s);
	}
	void mensaje(String s){
		JOptionPane.showMessageDialog(contentPane, s, "�ERROR!", 0);
	}
	String mensaje(){
		return "Rellene todos los campos";
	}
/*
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0; i<ap.Tama�o(); i++){
			Object[] fila ={
			ap.Obtener(i).getID_Producto(),
			ap.Obtener(i).getNombre_producto(),
			ap.Obtener(i).getDesarrollador(),
			ap.Obtener(i).getPlataforma(),
			ap.Obtener(i).getGenero(),
			ap.Obtener(i).getFecha_publicacion(),
			ap.Obtener(i).getJugadores(),
			ap.Obtener(i).getPrecio_producto(),
			ap.Obtener(i).getStock()};
			modelo.addRow(fila);
			}
	}
*/
	
	protected void do_btnadicionar_actionPerformed(ActionEvent arg0) {
		
		try{
			String CodProd=LeerCod();
			String nomProd=LeerNom(); 
			if(nomProd.length() > 0){
		try{
			String desarrollador=LeerDesarrolladora(); 
			if(desarrollador.length() > 0){
		try{
			String plataform=LeerPlataforma(); 
			if(plataform.length() > 0){
		try{
			String gen =LeerGenero();
			if(gen.length() > 0){
		try{
			String year = LeerYear(); 
			if(year.length()> 0){
		try{
			String jugad=LeerJugadores(); 
			if(jugad.length() > 0){
		try{
			int stock=LeerStock();
		try {
			double precio = LeerPrecio();
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "insert into producto values('" + CodProd + "', '" + nomProd + "', '" + desarrollador + "','" + plataform + "','" + gen + "','" + year + "','" + jugad + "'," + precio + ", " + stock + ")";
			sql.executeUpdate(consulta);
			
			//Listar();
			modelotabla();
																	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				mensaje("Falta llenar el campo  CodProd");
				JOptionPane.showMessageDialog(null,  "sin conexion a tabla", "conexion: ", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Error: " + e);
			}
			Mensaje("Se ha a�adido un producto exitosamente");
																
															}catch(Exception e){
																mensaje("Hay uno o muchos campos vac�os");
															}}
														}catch(Exception e){
															mensaje("Hay uno o muchos campos vac�os");
														}}
													else{
														mensaje("Hay uno o muchos campos vac�os");
													}
												}catch(Exception e){
													mensaje("Hay uno o muchos campos vac�os");
												}}
											else{
												mensaje("Hay uno o muchos campos vac�os");
											}
										}catch(Exception e){
											mensaje("Hay uno o muchos campos vac�os");
										}
									}else{
										mensaje("Hay uno o muchos campos vac�os");
									}
								}catch(Exception e){
									mensaje("Hay uno o muchos campos vac�os");
								}
							}else{
								mensaje("Hay uno o muchos campos vac�os");
							}
						}catch(Exception e){
							mensaje("Hay uno o muchos campos vac�os");
						}
					}else{
						mensaje("Hay uno o muchos campos vac�os");
					}
				}catch(Exception e){
					mensaje("Ning�n campo est� lleno");
				}
		

	}
	
	protected void do_btnactualizar_actionPerformed(ActionEvent arg0) {
		
		try {
			//Listar();
			modelotabla();
			Mensaje("Registros actualizados");
		} catch (Exception e) {

			System.out.println("Error: "+e);
		}
		
	}
	
	protected void do_btneliminar_actionPerformed(ActionEvent arg0) {
		try {
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT CodProd FROM producto WHERE CodProd= '" + LeerCod() + "'";
			ResultSet resu = sql.executeQuery(consulta);
			
			if (resu.next()){
				
				String eliminar = "delete from producto where CodProd= '" + LeerCod() + "'";
				sql.execute(eliminar);
				Mensaje("Se elimin� el producto " + LeerCod() + " exitosamente");
				
				txtCod.setText("");
				txtNom.setText("");
				txtDes.setText("");
				txtPlat.setText("");
				txtgenero.setText("");
				txtYear.setText("");
				txtjugadores.setText("");
				txtPre.setText("");
				txtstock.setText("");
				//Listar();
				modelotabla();
				
			}else {
				mensaje("El producto con cod "+ LeerCod() +" no existe en el registro");
				txtCod.setText("");
				txtCod.requestFocus();
			}
			
		}
		catch (Exception e) {
			mensaje("Rellene los campos");
			txtCod.setText("");
			txtCod.requestFocus();
			System.out.println("Error: "+e);
		}
	}
	protected void do_btnconsultar_actionPerformed(ActionEvent arg0) {
		try{
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT * FROM Producto WHERE CodProd= '"  + LeerCod() + "'";
			ResultSet resu = sql.executeQuery(consulta);			
			if (resu.next()){				
				Mensaje("Se encontr� el videojuego " + LeerCod() + " exitosamente");				
				txtCod.setText(resu.getString(1));
				txtNom.setText(resu.getString(2));
				txtDes.setText(resu.getString(3));
				txtPlat.setText(resu.getString(4));
				txtgenero.setText(resu.getString(5));
				txtYear.setText(resu.getString(6));
				txtjugadores.setText(resu.getString(7));
				txtPre.setText( resu.getString(8));
				txtstock.setText( resu.getString(9));
			}else{
				mensaje("El videojuego "+ LeerCod() +" no existe en el registro");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}
		catch (Exception e){
			mensaje("Rellene el campo requirido");
			txtCod.setText("");
			txtCod.requestFocus();
			System.out.println("Error: "+e);
		}
	}
	protected void do_btnmodificar_actionPerformed(ActionEvent arg0) {
		try{			
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT CodProd FROM Producto WHERE CodProd= '"  + LeerCod() + "'";
			ResultSet resu = sql.executeQuery(consulta);			
			if (resu.next()){
				// PRIMERO SE BUSCA CON EL BOTON CONSULTAR
				String editar = "UPDATE producto SET CodProd= '"  + LeerCod() + "'"
				+ ", NomProd='" + LeerNom() 
				+ "', Desarrollador='" + LeerDesarrolladora()
				+ "', Plataforma='" + LeerPlataforma()
				+ "', Genero='" + LeerGenero()
				+ "', A�o='" + LeerYear()
				+ "', Jugadores='" + LeerJugadores()
				+ "', Precio=" + LeerPrecio()
				+ ", Stock=" + LeerStock()
				+ " WHERE CodProd= '"  + LeerCod() + "';";
				sql.execute(editar);				
				Mensaje("Se modifico al videojuego " + LeerCod() + " exitosamente");				
				//Listar();
				modelotabla();				
			}else{
				mensaje("El videojuego "+ LeerCod() +" no existe en el registro");
				txtCod.setText("");
				txtCod.requestFocus();
			}
		}
		catch (Exception e){
			mensaje("Rellene el campo requirido");
			txtCod.setText("");
			txtCod.requestFocus();
			System.out.println("Error: "+e);
		}
	}
	protected void do_btnAtras_actionPerformed(ActionEvent arg0) {
		Inicio nuevoFrame= new Inicio();
		nuevoFrame.setVisible(true);
		dispose();	
	}
	
	
	private void modelotabla(){
		
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Videojuego");
		modelo.addColumn("Desarrollador");
		modelo.addColumn("Plataforma");
		modelo.addColumn("G�nero");
		modelo.addColumn("A�o");
		modelo.addColumn("Jugadores");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		
		tblvideojuego.setModel(modelo);
		
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
	
}
