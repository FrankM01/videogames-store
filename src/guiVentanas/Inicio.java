package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Panel;
import javax.swing.SwingConstants;

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	public JMenu mnRegistrar;
	public JMenuItem mntmVendedor;
	public JMenuItem mntmProducto;
	public JMenu mnVentas;
	public static JLabel lblusu;
	private JLabel lblUsuario;
	public static  JLabel lbltipo;
	public JMenuItem mntmRegistrarVenta;
	private JMenuItem mntmSalir;
	private JMenu mnSalir;
	public JMenu mnClientes;
	public JMenuItem mntmRegistrarCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setTitle("INICIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/Imag/gamestop-logo-icon.png")));
			lblNewLabel.setBounds(142, 117, 208, 207);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/Imag/boyhappy.png")));
			lblNewLabel_2.setBounds(-11, 228, 266, 202);
			contentPane.add(lblNewLabel_2);
		}
		{
			menuBar = new JMenuBar();
			menuBar.setBackground(new Color(255, 255, 255));
			menuBar.setBounds(0, 0, 493, 26);
			contentPane.add(menuBar);
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			{
				mnRegistrar = new JMenu("Registrar");
				menuBar.add(mnRegistrar);
				{
					mntmVendedor = new JMenuItem("Nuevo Usuario");
					mntmVendedor.addActionListener(this);
					mnRegistrar.add(mntmVendedor);
				}
				{
					mntmProducto = new JMenuItem("Videojuegos");
					mntmProducto.addActionListener(this);
					mnRegistrar.add(mntmProducto);
				}
			}
			{
				mnClientes = new JMenu("Clientes");
				menuBar.add(mnClientes);
				{
					mntmRegistrarCli = new JMenuItem("Registrar Cliente");
					mntmRegistrarCli.addActionListener(this);
					mnClientes.add(mntmRegistrarCli);
				}
			}
			{
				mnVentas = new JMenu("Ventas");
				menuBar.add(mnVentas);
				{
					mntmRegistrarVenta = new JMenuItem("Registrar Venta");
					mntmRegistrarVenta.addActionListener(this);
					mnVentas.add(mntmRegistrarVenta);
				}
			}
			{
				mnSalir = new JMenu("Salir");
				menuBar.add(mnSalir);
				{
					mntmSalir = new JMenuItem("Cerrar sesi\u00F3n");
					mnSalir.add(mntmSalir);
					mntmSalir.addActionListener(this);
				}
			}
		}
		{
			lblusu = new JLabel("");
			lblusu.setHorizontalAlignment(SwingConstants.RIGHT);
			lblusu.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			lblusu.setBounds(299, 63, 184, 25);
			contentPane.add(lblusu);
		}
		{
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblUsuario.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
			lblUsuario.setBounds(402, 37, 81, 25);
			contentPane.add(lblUsuario);
		}
		{
			lbltipo = new JLabel("");
			lbltipo.setBounds(437, 405, 46, 14);
			contentPane.add(lbltipo);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRegistrarVenta) {
			do_mntmRegistrarVenta_actionPerformed(e);
		}
		if (e.getSource() == mntmRegistrarCli) {
			do_mntmRegistrarCli_actionPerformed(e);
		}
		if (e.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(e);
		}
		if (e.getSource() == mntmProducto) {
			do_mntmProducto_actionPerformed(e);
		}
		if (e.getSource() == mntmVendedor) {
			do_mntmVendedor_actionPerformed(e);
		}
	}
	protected void do_mntmVendedor_actionPerformed(ActionEvent e) {
		RegistrarEmpleado bc = new RegistrarEmpleado();
		bc.setVisible(true);
		dispose();
	}
	protected void do_mntmProducto_actionPerformed(ActionEvent e) {
		RegistrarVideojuego product = new RegistrarVideojuego();
		product.setVisible(true);
		dispose();
	}
	
	void validar(){
		if (Integer.parseInt(lbltipo.getText()) == 1){
			mnRegistrar.setEnabled(true);
			mnVentas.setEnabled(true);
		} else if (Integer.parseInt(lbltipo.getText()) == 2){
			mnRegistrar.setEnabled(false);
			mnVentas.setEnabled(true);
		}
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent e) {
		Principal frame = new Principal();
		frame.setVisible(true);
		dispose();
	}
	protected void do_mntmRegistrarCli_actionPerformed(ActionEvent e) {
		RegistrarCliente frame = new RegistrarCliente();
		frame.setVisible(true);
		dispose();
	}
	protected void do_mntmRegistrarVenta_actionPerformed(ActionEvent e) {
		RegistrarVenta frame = new RegistrarVenta();
		frame.setVisible(true);
		dispose();
	}
}
