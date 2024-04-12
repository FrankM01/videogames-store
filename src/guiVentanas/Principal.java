package guiVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JEditorPane;
import java.awt.ScrollPane;
import java.awt.Button;

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblLOG;
	private JButton btnAdministrador;
	private JButton btnCajero;
	private JLabel lblSeleccioneQueTipo;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLOG = new JLabel("L   O  G   I   N");
		lblLOG.setForeground(Color.BLACK);
		lblLOG.setFont(new Font("Lucida Bright", Font.BOLD, 27));
		lblLOG.setBounds(231, 11, 200, 48);
		contentPane.add(lblLOG);
		
		btnAdministrador = new JButton("A D M I N I S T R A D O R");
		btnAdministrador.setForeground(new Color(255, 255, 255));
		btnAdministrador.addActionListener(this);
		btnAdministrador.setBackground(new Color(0, 139, 139));
		btnAdministrador.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnAdministrador.setBounds(96, 423, 164, 34);
		contentPane.add(btnAdministrador);
		
		btnCajero = new JButton("V E N D E D O R");
		btnCajero.setForeground(new Color(255, 255, 255));
		btnCajero.addActionListener(this);
		btnCajero.setBackground(new Color(75, 0, 130));
		btnCajero.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnCajero.setBounds(402, 423, 140, 34);
		contentPane.add(btnCajero);
		
		lblSeleccioneQueTipo = new JLabel("Seleccionar que tipo de empleado es:");
		lblSeleccioneQueTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneQueTipo.setForeground(Color.BLACK);
		lblSeleccioneQueTipo.setBackground(Color.WHITE);
		lblSeleccioneQueTipo.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSeleccioneQueTipo.setBounds(144, 85, 374, 25);
		contentPane.add(lblSeleccioneQueTipo);
		{
			label = new JLabel("");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(Principal.class.getResource("/imagen/administrador.png")));
			label.setBounds(50, 144, 256, 268);
			contentPane.add(label);
		}
		{
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(Principal.class.getResource("/imagen/vendedor.png")));
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(344, 144, 256, 268);
			contentPane.add(label_1);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCajero) {
			do_btnCajero_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAdministrador) {
			do_btnAdministrador_actionPerformed(arg0);
		}
	}
	protected void do_btnAdministrador_actionPerformed(ActionEvent arg0) {
		Ventana_login_Admin nuevoFrame = new Ventana_login_Admin();
		nuevoFrame.setVisible(true);
		dispose();
	}
	protected void do_btnCajero_actionPerformed(ActionEvent arg0) {
		Ventana_login_Cajero nuevoFrame= new Ventana_login_Cajero();
		nuevoFrame.setVisible(true);
		dispose();
	}
}
