package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloLogin;
import arreglos.ArregloAdministradores;
import arreglos.ArregloVendedor;
import clases.Administrador;
import clases.Login;
import config.conexion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Ventana_login_Cajero extends JFrame implements ActionListener {
	ArregloLogin alc= new ArregloLogin();
	ArregloVendedor ac=new ArregloVendedor();
	private JPanel contentPane;
	private JLabel lblLOG;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtLoginUsuarioCajero;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JPasswordField passwordLogincajero;
	private JLabel lblNewLabel_1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
	public Ventana_login_Cajero() {
		setTitle("Login Vendedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLOG = new JLabel("V E N D E D O R");
		lblLOG.setHorizontalAlignment(SwingConstants.CENTER);
		lblLOG.setForeground(Color.WHITE);
		lblLOG.setFont(new Font("Gill Sans MT", Font.PLAIN, 27));
		lblLOG.setBounds(48, 11, 223, 61);
		contentPane.add(lblLOG);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Ventana_login_Cajero.class.getResource("/imagen/logonombre.png")));
		lblNewLabel_1.setBounds(26, 276, 77, 44);
		contentPane.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(26, 83, 268, 182);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setIcon(new ImageIcon(Ventana_login_Cajero.class.getResource("/imagen/user.png")));
		lblUsuario.setBounds(29, 32, 38, 33);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		
		txtLoginUsuarioCajero = new JTextField();
		txtLoginUsuarioCajero.setBounds(76, 36, 157, 25);
		panel.add(txtLoginUsuarioCajero);
		txtLoginUsuarioCajero.setText("");
		txtLoginUsuarioCajero.setColumns(10);
		
		lblContrasea = new JLabel("");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setIcon(new ImageIcon(Ventana_login_Cajero.class.getResource("/imagen/pass.png")));
		lblContrasea.setBounds(29, 87, 38, 33);
		panel.add(lblContrasea);
		lblContrasea.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
		
		passwordLogincajero = new JPasswordField();
		passwordLogincajero.setBounds(76, 91, 157, 25);
		panel.add(passwordLogincajero);
		
		btnIngresar = new JButton("I N G R E S A R");
		btnIngresar.setBounds(32, 133, 204, 25);
		panel.add(btnIngresar);
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(new Color(255, 215, 0));
		btnIngresar.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		btnIngresar.setBorder(null);
		
		btnSalir = new JButton("");
		btnSalir.setForeground(new Color(51, 204, 204));
		btnSalir.setBounds(256, 276, 41, 44);
		contentPane.add(btnSalir);
		btnSalir.setIcon(new ImageIcon(Ventana_login_Cajero.class.getResource("/imagen/salir.png")));
		btnSalir.addActionListener(this);
		btnSalir.setBackground(new Color(147, 112, 219));
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
			String consulta = "SELECT * FROM login WHERE Usuario =  'Cajero" + usuario + "' and Contrase�a = '" + contrasenia + "'";
			ResultSet resu = sql.executeQuery(consulta);
			
			if (resu.next()){
				
				Mensaje("Bienvenido Cajero " + usuario);
				dispose();
				Inicio nuevoFrame = new Inicio();
				
				if (resu.getInt(4) == 2){
					nuevoFrame.mnRegistrar.setVisible(false);
					nuevoFrame.mnClientes.setEnabled(true);
					nuevoFrame.mnVentas.setEnabled(true);
				}else{
					Mensaje("Usuario NO encontrado");
					txtLoginUsuarioCajero.setText("");
					passwordLogincajero.setText("");
					txtLoginUsuarioCajero.requestFocus();
				}
				nuevoFrame.lblusu.setText(resu.getString(2));
				nuevoFrame.setVisible(true);
				
			}else{
				Mensaje("Usuario NO encontrado");
				txtLoginUsuarioCajero.setText("");
				passwordLogincajero.setText("");
				txtLoginUsuarioCajero.requestFocus();
			}
		}
		catch (Exception e){
			Mensaje("Rellene los campos");
			txtLoginUsuarioCajero.setText("");
			passwordLogincajero.setText("");
			txtLoginUsuarioCajero.requestFocus();
			System.out.println("Error: "+e);
		}
				
	}
			
    String leerNombreUsuario(){
    	return txtLoginUsuarioCajero.getText();
    }
    String leerContrasenia(){
    	return passwordLogincajero.getText();
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
