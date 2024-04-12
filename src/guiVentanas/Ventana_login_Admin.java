package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloLogin;
import arreglos.ArregloAdministradores;
import clases.Administrador;
import clases.Login;
import config.conexion;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class Ventana_login_Admin extends JFrame implements ActionListener {
	ArregloLogin ala= new ArregloLogin();
	ArregloAdministradores aa=new ArregloAdministradores();
	private JPanel contentPane;
	private JLabel lblLOG;
	public static JTextField txtLoginUsuario;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JPasswordField passwordLoginAdmin;
	private JLabel label_1;
	private JPanel panel;
	private JLabel label;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_login_Admin frame = new Ventana_login_Admin();
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
	public Ventana_login_Admin() {
		setTitle("Login Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 377);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 76, 245, 196);
		contentPane.add(panel);
		panel.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Ventana_login_Admin.class.getResource("/imagen/user.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		label.setBackground(Color.WHITE);
		label.setBounds(16, 28, 38, 33);
		panel.add(label);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(70, 34, 157, 20);
		panel.add(txtLoginUsuario);
		txtLoginUsuario.setBackground(Color.WHITE);
		txtLoginUsuario.setColumns(10);
		
		passwordLoginAdmin = new JPasswordField();
		passwordLoginAdmin.setBounds(70, 95, 157, 20);
		panel.add(passwordLoginAdmin);
		passwordLoginAdmin.setBackground(Color.WHITE);
		
		btnIngresar = new JButton("I N G R E S A R");
		btnIngresar.setBounds(20, 146, 205, 25);
		panel.add(btnIngresar);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(new Color(255, 215, 0));
		btnIngresar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnIngresar.setBorder(null);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Ventana_login_Admin.class.getResource("/imagen/pass.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		label_2.setBounds(16, 89, 38, 33);
		panel.add(label_2);
		
		lblLOG = new JLabel("A D M I N I S T R A D O R");
		lblLOG.setBounds(-5, 11, 351, 61);
		contentPane.add(lblLOG);
		lblLOG.setHorizontalAlignment(SwingConstants.CENTER);
		lblLOG.setForeground(Color.WHITE);
		lblLOG.setFont(new Font("Gill Sans MT", Font.BOLD, 25));
		
		label_1 = new JLabel("");
		label_1.setBounds(10, 290, 83, 37);
		contentPane.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Ventana_login_Admin.class.getResource("/imagen/logonombre.png")));
		
		btnSalir = new JButton("");
		btnSalir.setBounds(285, 283, 46, 44);
		contentPane.add(btnSalir);
		btnSalir.setIcon(new ImageIcon(Ventana_login_Admin.class.getResource("/imagen/salir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBackground(new Color(0, 139, 139));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalir.setBorder(null);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(arg0);
		}
	}
	
	protected void do_btnIngresar_actionPerformed(ActionEvent arg0) {

		String usuario = leerNombreUsuario();
		String contrasenia = leerContrasenia();

		try{
			
			Statement sql = conexion.GetConexion().createStatement();
			String consulta = "SELECT * FROM login WHERE Usuario =  '" + usuario + "' and Contrase�a = '" + contrasenia + "'";
			ResultSet resu = sql.executeQuery(consulta);
			
			if (resu.next()){
				
				Mensaje("Bienvenido " + usuario);
				dispose();
				Inicio inicioadmi = new Inicio();
				
				if (resu.getInt(4) == 1){
					inicioadmi.mnRegistrar.setEnabled(true);
					inicioadmi.mnClientes.setEnabled(true);
					inicioadmi.mnVentas.setEnabled(true);
				} else if (resu.getInt(4) == 2){
					inicioadmi.mnRegistrar.setVisible(false);
					inicioadmi.mnClientes.setEnabled(true);
					inicioadmi.mnVentas.setEnabled(true);
				}				
				
				inicioadmi.lblusu.setText(txtLoginUsuario.getText());
				inicioadmi.setVisible(true);
				
			}else{
				Mensaje("El usuario " + usuario+" no existe en el registro");
				txtLoginUsuario.setText("");
				passwordLoginAdmin.setText("");
				txtLoginUsuario.requestFocus();
			}
		}
		catch (Exception e){
			Mensaje("Rellene los campos");
			txtLoginUsuario.setText("");
			passwordLoginAdmin.setText("");
			txtLoginUsuario.requestFocus();
			System.out.println("Error: "+e);
		}
				
	}
		
    String leerNombreUsuario(){
    	return txtLoginUsuario.getText();
    }
    
    String leerContrasenia(){
    	return passwordLoginAdmin.getText();
    }
    
	void Mensaje (String s){
		JOptionPane.showMessageDialog(this, s);
	}
	
	protected void do_btnSalir_actionPerformed(ActionEvent arg0) {
		Principal nuevoFrame = new Principal();
		nuevoFrame.setVisible(true); 
		dispose();
	}
	
}
