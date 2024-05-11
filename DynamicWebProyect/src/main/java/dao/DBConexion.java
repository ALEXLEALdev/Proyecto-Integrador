package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConexion {
	//Conexion de Otero//
	
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/digimon";
	public static Connection instance = null;
	
	public static Connection getConexion() throws SQLException {
		if(instance == null) {
			//opcional
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			props.put("charset", "UTF-8");
			instance = DriverManager.getConnection(JDBC_URL, props);	
		}
		return instance;	
	}
	
	/*
	//Conexion de Go Codex//
	private static String url = "jdbc:mysql://localhost:3306/digimon";
	private static String usuario ="root";
	private static String password ="";
	
	//private static Connection conexion;
	//private static PreparedStatement  sentenciaPreparada;
	//private static ResultSet resultado;
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		
		return conexion;
	}
	*/
	
	/*public static void main (String[] args){
		try {
			conexion = conectar();
			String consulta = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, email, password) VALUES ('Alejandro','Leal','lealleal','leal@gmail.com','12345')";
			sentenciaPreparada = conexion.prepareStatement(consulta);
			int i = sentenciaPreparada.executeUpdate();
			
			if(i >0) {
				System.out.println("Se guardaron los datos");
			}else {
				System.out.println("No se guardaron los datos");
			}
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
	}
	*/
	
	
	
	
}
