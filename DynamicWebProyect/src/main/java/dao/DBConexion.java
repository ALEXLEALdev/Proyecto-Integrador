package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase para gestionar la conexión a la base de datos.
 */
public class DBConexion {
    // Conexión de Otero //

    /**
     * URL de conexión a la base de datos.
     */
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/digimon";

    /**
     * Instancia única de conexión.
     */
    public static Connection instance = null;

    /**
     * Obtiene la conexión a la base de datos.
     * 
     * @return La instancia de conexión a la base de datos.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public static Connection getConexion() throws SQLException {
        if (instance == null) {
            // Opcional: Configuración de propiedades de conexión.
            Properties props = new Properties();
            props.put("user", "root");
            props.put("password", "");
            props.put("charset", "UTF-8");
            instance = DriverManager.getConnection(JDBC_URL, props);
        }
        return instance;
    }

    /*
    // Conexión de Go Codex //
    private static String url = "jdbc:mysql://localhost:3306/digimon";
    private static String usuario = "root";
    private static String password = "";

    //private static Connection conexion;
    //private static PreparedStatement sentenciaPreparada;
    //private static ResultSet resultado;

    /**
     * Conecta a la base de datos utilizando los datos de Go Codex.
     * 
     * @return La conexión a la base de datos.
     *//*
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return conexion;
    }
    */

    /*
    public static void main(String[] args) {
        try {
            conexion = conectar();
            String consulta = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, email, password) VALUES ('Alejandro','Leal','lealleal','leal@gmail.com','12345')";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            int i = sentenciaPreparada.executeUpdate();

            if (i > 0) {
                System.out.println("Se guardaron los datos");
            } else {
                System.out.println("No se guardaron los datos");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    */
}
