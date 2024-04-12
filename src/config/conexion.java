package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexion {

	private static Connection con;
	
	public static Connection GetConexion(){
		
		Connection cnx=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver correcto");
			cnx=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/Videojuegos2?characterEncoding=latin1","root","123");
			//System.out.println("Conexión correcta");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null,  "sin conexion", "conexion: ", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Error: "+e);
		}		
		return cnx;
	}
	
}
