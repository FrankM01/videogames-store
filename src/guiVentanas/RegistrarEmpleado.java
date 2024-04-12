package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAdministradores;
import arreglos.ArregloLogin;
import clases.Administrador;
import clases.Vendedor;
import clases.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RegistrarEmpleado extends JFrame implements ActionListener, MouseListener {
    ArregloAdministradores aa=new ArregloAdministradores();
    ArregloLogin ala=new ArregloLogin();
	private JPanel contentPane;
	private JLabel lblPorFavorSrvase;
	private JLabel lblNombre;
	private JTextField txtNomAdmin;
	private JLabel lblApellidos;
	private JTextField txtApeAdmin;
	private JLabel lblEmail;
	private JTextField txtEmailAdmin;
	private JLabel lblDireccin;
	private JTextField txtDirecAdmin;
	private JLabel lblUsuario;
	private JTextField txtUsuarioAdmin;
	private JLabel lblContrasea;
	private JLabel lblId;
	private JTextField txtIDadmin;
	private JLabel lblCargo;
	private JTextField txtCargo;
	private JPasswordField passwordFieldAdmin;
	private JScrollPane scrollPane;
	private JComboBox comboBoxDomCorreo;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnListar;
	private DefaultTableModel modelo;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnAbrir;
	private JTable tableAdministradores;
	private JButton btnAtrs;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblADM;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEmpleado frame = new RegistrarEmpleado();
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
	public RegistrarEmpleado() {
		setTitle("Registrar Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPorFavorSrvase = new JLabel("Por favor, s\u00EDrvase llenar los siguientes datos:");
		lblPorFavorSrvase.setBackground(new Color(240, 240, 240));
		lblPorFavorSrvase.setForeground(Color.WHITE);
		lblPorFavorSrvase.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblPorFavorSrvase.setBounds(10, 47, 333, 24);
		contentPane.add(lblPorFavorSrvase);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 74, 514, 377);
		contentPane.add(scrollPane);
		
		tableAdministradores = new JTable();
		scrollPane.setViewportView(tableAdministradores);
		modelo = new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Email");
		modelo.addColumn("Cargo");
		modelo.addColumn("Direccion");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contrase�a");
		tableAdministradores.setModel(modelo);
		Listar();
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 139, 139));
			panel.setBounds(10, 74, 285, 250);
			contentPane.add(panel);
			panel.setLayout(null);
			
			lblId = new JLabel("C\u00F3digo:");
			lblId.setForeground(Color.WHITE);
			lblId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblId.setBounds(13, 16, 70, 23);
			panel.add(lblId);
			lblId.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtIDadmin = new JTextField();
			txtIDadmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtIDadmin.setBounds(96, 17, 70, 20);
			panel.add(txtIDadmin);
			txtIDadmin.setColumns(10);
			
			lblCargo = new JLabel("Cargo: ");
			lblCargo.setForeground(Color.WHITE);
			lblCargo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCargo.setBounds(13, 55, 70, 23);
			panel.add(lblCargo);
			lblCargo.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtCargo = new JTextField();
			txtCargo.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtCargo.setBounds(96, 56, 169, 20);
			panel.add(txtCargo);
			txtCargo.setColumns(10);
			
			lblNombre = new JLabel("Nombres: ");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setBounds(13, 94, 70, 23);
			panel.add(lblNombre);
			lblNombre.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtNomAdmin = new JTextField();
			txtNomAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtNomAdmin.setBounds(96, 95, 169, 20);
			panel.add(txtNomAdmin);
			txtNomAdmin.setColumns(10);
			
			lblApellidos = new JLabel("Apellidos: ");
			lblApellidos.setForeground(Color.WHITE);
			lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblApellidos.setBounds(13, 133, 70, 23);
			panel.add(lblApellidos);
			lblApellidos.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtApeAdmin = new JTextField();
			txtApeAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtApeAdmin.setBounds(96, 134, 169, 20);
			panel.add(txtApeAdmin);
			txtApeAdmin.setColumns(10);
			
			lblDireccin = new JLabel("Direcci\u00F3n:");
			lblDireccin.setForeground(Color.WHITE);
			lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDireccin.setBounds(13, 172, 70, 23);
			panel.add(lblDireccin);
			lblDireccin.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtDirecAdmin = new JTextField();
			txtDirecAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtDirecAdmin.setBounds(96, 173, 169, 20);
			panel.add(txtDirecAdmin);
			txtDirecAdmin.setColumns(10);
			
			lblEmail = new JLabel("Email: ");
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEmail.setBounds(13, 211, 70, 23);
			panel.add(lblEmail);
			lblEmail.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
			
			txtEmailAdmin = new JTextField();
			txtEmailAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			txtEmailAdmin.setBounds(96, 212, 86, 20);
			panel.add(txtEmailAdmin);
			txtEmailAdmin.setColumns(10);
			
			comboBoxDomCorreo = new JComboBox();
			comboBoxDomCorreo.setBackground(Color.WHITE);
			comboBoxDomCorreo.setBounds(192, 213, 73, 20);
			panel.add(comboBoxDomCorreo);
			comboBoxDomCorreo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "@gmail.com", "@hotmail.com", "@outlook.es","@upn.pe"}));
			comboBoxDomCorreo.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		}
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(10, 335, 285, 87);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(12, 11, 80, 23);
		panel_1.add(lblUsuario);
		lblUsuario.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		txtUsuarioAdmin = new JTextField();
		txtUsuarioAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		txtUsuarioAdmin.setBounds(96, 13, 169, 20);
		panel_1.add(txtUsuarioAdmin);
		txtUsuarioAdmin.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(12, 45, 80, 23);
		panel_1.add(lblContrasea);
		lblContrasea.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		
		passwordFieldAdmin = new JPasswordField();
		passwordFieldAdmin.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		passwordFieldAdmin.setBounds(96, 47, 169, 20);
		panel_1.add(passwordFieldAdmin);
		
		panel_2 = new JPanel();
		panel_2.setBounds(305, 74, 78, 377);
		contentPane.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setBounds(13, 64, 52, 40);
		panel_2.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/agrega.png")));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBorder(null);
		
		btnEliminar = new JButton("");
		btnEliminar.addMouseListener(this);
		btnEliminar.setBounds(13, 116, 52, 40);
		panel_2.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/delete.png")));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBorder(null);
		
		btnModificar = new JButton("");
		btnModificar.addMouseListener(this);
		btnModificar.setBounds(13, 168, 52, 40);
		panel_2.add(btnModificar);
		btnModificar.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/edit.png")));
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBorder(null);
		
		btnListar = new JButton("");
		btnListar.addMouseListener(this);
		btnListar.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/listar.png")));
		btnListar.setBounds(13, 220, 52, 40);
		panel_2.add(btnListar);
		btnListar.setForeground(Color.BLACK);
		btnListar.addActionListener(this);
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnListar.setBackground(Color.WHITE);
		btnListar.setBorder(null);
		
		btnBuscar = new JButton("");
		btnBuscar.addMouseListener(this);
		btnBuscar.setBounds(13, 272, 52, 40);
		panel_2.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/search.png")));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBorder(null);
		
		btnAbrir = new JButton("");
		btnAbrir.addMouseListener(this);
		btnAbrir.setBounds(13, 12, 52, 40);
		btnAbrir.setBorder(null);
		panel_2.add(btnAbrir);
		btnAbrir.setBackground(Color.WHITE);
		btnAbrir.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/openfile.png")));
		
		btnAtrs = new JButton("");
		btnAtrs.addMouseListener(this);
		btnAtrs.setBounds(13, 324, 52, 40);
		panel_2.add(btnAtrs);
		btnAtrs.setBackground(Color.WHITE);
		btnAtrs.setIcon(new ImageIcon(RegistrarEmpleado.class.getResource("/imagen/backblanco.png")));
		btnAtrs.addActionListener(this);
		btnAtrs.setBorder(null);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(-3, 0, 926, 41);
		contentPane.add(panel_4);
		
		lblADM = new JLabel("N U E VO  U S U A R I O");
		lblADM.setHorizontalAlignment(SwingConstants.CENTER);
		lblADM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblADM.setBackground(Color.WHITE);
		lblADM.setBounds(336, 9, 254, 22);
		panel_4.add(lblADM);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(-3, 482, 926, 10);
		contentPane.add(panel_3);
		btnAbrir.addActionListener(this);
	}
	
	
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0; i<aa.tamanio(); i++){
			Object[] fila ={
			aa.Obtener(i).getID_Empleado(),
			aa.Obtener(i).getNombres(),
			aa.Obtener(i).getApellidos(),
			aa.Obtener(i).getCargo(),
			aa.Obtener(i).getDireccion(),
			aa.Obtener(i).getEmail(),
			aa.Obtener(i).getLogad().getUsuario(),
			aa.Obtener(i).getLogad().getContrasenia()};
			
			modelo.addRow(fila);
			}
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
	int IdAmin(){
		return Integer.parseInt(txtIDadmin.getText());
	}
	
	String LeerNombre(){
		return txtNomAdmin.getText();
	}
	
	String LeerApellido(){
		return txtApeAdmin.getText();
	}
	
	String Cargo(){
		return txtCargo.getText().trim();
	}
	
	String Email(){
		return txtEmailAdmin.getText()+comboBoxDomCorreo.getSelectedItem();
	}
	
	String Login_Usuario(){ 
		return txtUsuarioAdmin.getText();
	}
	@SuppressWarnings("deprecation")
	String Login_Contrasenia(){
		return passwordFieldAdmin.getText();
	}
	
	String Direccion(){
		return txtDirecAdmin.getText();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAtrs) {
			do_btnAtrs_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAbrir) {
			do_btnAbrir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			do_buttonBuscar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnListar) {
			do_buttonListar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			do_buttonModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			do_buttonAdicionar_actionPerformed(arg0);
		}
	}
	protected void do_buttonAdicionar_actionPerformed(ActionEvent arg0) {
		try{
			int ID_Admin=IdAmin();
			String nomAd=LeerNombre(); 
			if(nomAd.length() > 0){
				try{
					String apeAdm=LeerApellido(); 
					if(apeAdm.length() > 0){
						try{
							String cargoAdm=Cargo(); 
							if(cargoAdm.length() > 0){
								try{
									String dire =Direccion(); 
									if(dire.length() > 0){
										try{
											String ema = Email(); 
											if(ema.length()> 0)
													try{
														String nombre_usuario_registrado=Login_Usuario(); 
														if(nombre_usuario_registrado.length() > 0){
															try{
																String contrasenia_registrada=Login_Contrasenia();
																if(contrasenia_registrada.length() > 0){
																	Login l=new Login(nombre_usuario_registrado,contrasenia_registrada);
																	ala.Adicionar(l);
																	Administrador ad=new Administrador(ID_Admin, LeerNombre(), LeerApellido(), Email(), Direccion(), Cargo(),l ); 
																	aa.Adicionar(ad); 
																	try{
																		 FileWriter fw=new FileWriter("RegistroAdministrador.txt",true);
																		 BufferedWriter bw=new BufferedWriter(fw);
																		 PrintWriter pw =new PrintWriter(bw);
																		 pw.print(ad.getID_Empleado()+"\t");
																		 pw.print(ad.getNombres()+"\t");
																		 pw.print(ad.getApellidos()+"\t");
																		 pw.print(ad.getCargo()+"\t");
																		 pw.print(ad.getDireccion()+"\t");
																		 pw.print(ad.getEmail()+"\t");
																		 pw.print(ad.getLogad().getUsuario()+"\t");
																		 pw.print(ad.getLogad().getContrasenia()+" \n");
																		 pw.close();
																	 }catch (Exception e){
																		 JOptionPane.showMessageDialog(null, e);
																		 mensaje("Falta llenar el campo  Contrase�a");
																	 }
																	//Listar();
																	Mensaje("Se ha a�adido un usuario exitosamente");															
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
	protected void do_buttonModificar_actionPerformed(ActionEvent arg0) {
		try{
			Administrador x = aa.Buscar(IdAmin());
			if(x != null){
				String nombre = LeerNombre();
				if(nombre.length()>0){
					try{
						int IDa = IdAmin();
						try{
							String Direc=Direccion();
							String contrasenia_registrada=Login_Contrasenia();
							String nombre_usuario_registrado=Login_Usuario();
							Login l=new Login(nombre_usuario_registrado,contrasenia_registrada);
							//Listar();
							Mensaje("Se ha modificado el usuario con ID "+IDa+" correctamente...");
							x.setNombres(LeerNombre());
							x.setApellidos(LeerApellido());
							x.setCargo(Cargo());
							x.setDireccion(Direc);
							x.setEmail(Email());
							x.setLogad(l);
							Listar();
							txtIDadmin.requestFocus();
						}
						catch(Exception e){
							mensaje(mensaje());
							txtDirecAdmin.setText("");
							txtDirecAdmin.requestFocus();
						}
					}catch(Exception e){
						mensaje(mensaje());
						txtNomAdmin.setText("");
						txtNomAdmin.requestFocus();
					}
				}else{
					mensaje(mensaje());
					txtNomAdmin.setText("");
					txtApeAdmin.requestFocus();
					txtCargo.setText("");
					txtDirecAdmin.setText("");
					txtEmailAdmin.setText("");
					txtUsuarioAdmin.setText("");
					passwordFieldAdmin.setText("");
					txtIDadmin.requestFocus();
					}
			}else{
				mensaje("�CODIGO INEXISTENTE!");
				txtIDadmin.setText("");
				txtIDadmin.requestFocus();
			}
		}
		catch(Exception e){
			mensaje("�CODIGO INEXISTENTE!");
			txtIDadmin.setText("");
			txtIDadmin.requestFocus();
		}
	}
	
	protected void do_buttonListar_actionPerformed(ActionEvent arg0) {
		String usuarioA,contraseniaA,ida,nom,appe,car,email,dr;
		String au="C:/Users/Frank Mijhael/OneDrive/Escritorio/PROYECTO FASE FINAL/TiendaDeVideojuegos/RegistroAdministrador.txt";
		Scanner linea=null;
		File doc_1e=new File(au);
				try{
					
					linea=new Scanner(doc_1e);
					
					while(linea.hasNextLine()){
						ida=linea.nextLine();
						nom=linea.nextLine();
						appe=linea.nextLine();
						car=linea.nextLine();
						dr=linea.nextLine();
						email=linea.nextLine();
						usuarioA=linea.nextLine();
						contraseniaA=linea.nextLine();

						modelo.addRow(new Object[]{ida,nom,appe,car,dr,email,usuarioA,contraseniaA});
					}
				}catch(Exception x){
					Mensaje("Se Adicin� correctamente...");
				}	
		Listar();	
	}
	public void abrirarchivoTexto(String archivoAd){

	     try {

	            File objetofileA = new File (archivoAd);
	            Desktop.getDesktop().open(objetofileA);

	     }catch (Exception exc) {

	            System.out.println(exc);
	     }
	} 
	protected void do_btnAbrir_actionPerformed(ActionEvent arg0) {
		
		try{
			abrirarchivoTexto("C:/Users/Frank Mijhael/OneDrive/Escritorio/PROYECTO FASE FINAL/TiendaDeVideojuegos/RegistroAdministrador.txt");
		}catch (Exception s){
			mensaje("El archivo no existe");
		}	
		
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		try {
			Administrador x = aa.Buscar(IdAmin());
			if (x != null) {
				aa.Eliminar(x);
				Mensaje("Se elimin� "+IdAmin()+" "+"exitosamente");
				//Listar();
				txtIDadmin.setText("");
				txtNomAdmin.setText("");
				txtApeAdmin.setText("");
				txtCargo.setText("");
				txtDirecAdmin.setText("");
				txtEmailAdmin.setText("");
				comboBoxDomCorreo.setSelectedIndex(0);
				txtUsuarioAdmin.setText("");
				passwordFieldAdmin.setText(" ");
				
			}
			else {
				mensaje("El ID del usuario: " + IdAmin() + " no existe");
				txtIDadmin.setText("");
				txtIDadmin.requestFocus();
				}
			}
			catch (Exception e) {
				mensaje("Rellene los campos");
				txtIDadmin.setText("");
				txtIDadmin.requestFocus();
			}
		
		//Listar();
	}
    protected void do_buttonBuscar_actionPerformed(ActionEvent arg0) {
    	try{
			 Administrador x = aa.Buscar(IdAmin());
			if(x != null){
				Mensaje("Se encontr� "+IdAmin()+" "+"exitosamente");
				txtNomAdmin.setText(x.getNombres());
				txtApeAdmin.setText(""+x.getApellidos());
				txtCargo.setText(""+x.getCargo());
				txtDirecAdmin.setText(""+x.getDireccion());
				txtEmailAdmin.setText(""+x.getEmail());
				txtUsuarioAdmin.setText(""+x.getLogad().getUsuario());
				passwordFieldAdmin.setText(""+x.getLogad().getContrasenia());
			}else{
				mensaje("El ID de; usuario "+IdAmin()+" no existe en el registro");
				txtIDadmin.setText("");
				txtIDadmin.requestFocus();
			}
		}
		catch (Exception e){
				mensaje("Rellene el campo requirido");
				txtIDadmin.setText("");
				txtIDadmin.requestFocus();
			}
 
   }
	protected void do_btnAtrs_actionPerformed(ActionEvent arg0) {
		Inicio nuevoFrame= new Inicio();
		nuevoFrame.setVisible(true);
		dispose();	
	}
	
//-------------------------------Cambio de color de botones con el puntero
//boton abrir
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnAtrs) {
			do_btnAtrs_mouseEntered(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_mouseEntered(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_mouseEntered(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_mouseEntered(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseEntered(e);
		}
		if (e.getSource() == btnAdicionar) {
			do_buttonAdicionar_mouseEntered(e);
		}
		if (e.getSource() == btnAbrir) {
			do_btnAbrir_mouseEntered(e);
		}
	}
	public void mouseExited(MouseEvent e) {
		btnAbrir.setBackground(Color.WHITE);
		btnAdicionar.setBackground(Color.WHITE);
		btnEliminar.setBackground(Color.WHITE);
		btnModificar.setBackground(Color.WHITE);
		btnListar.setBackground(Color.WHITE);
		btnBuscar.setBackground(Color.WHITE);
		btnAtrs.setBackground(Color.WHITE);
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_btnAbrir_mouseEntered(MouseEvent e) {
		btnAbrir.setBackground(new Color(0, 139, 139));
	}
////boton adicionar
	protected void do_buttonAdicionar_mouseEntered(MouseEvent e) {
		btnAdicionar.setBackground(new Color(0, 139, 139));
	}
	protected void do_btnEliminar_mouseEntered(MouseEvent e) {
		btnEliminar.setBackground(new Color(0, 139, 139));
	}
	protected void do_btnModificar_mouseEntered(MouseEvent e) {
		btnModificar.setBackground(new Color(0, 139, 139));
	}
	protected void do_btnListar_mouseEntered(MouseEvent e) {
		btnListar.setBackground(new Color(0, 139, 139));
	}
	protected void do_btnBuscar_mouseEntered(MouseEvent e) {
		btnBuscar.setBackground(new Color(0, 139, 139));
	}
	protected void do_btnAtrs_mouseEntered(MouseEvent e) {
		btnAtrs.setBackground(new Color(255, 215, 0));
	}
}
