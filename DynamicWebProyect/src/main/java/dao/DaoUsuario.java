package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import controlador.gestionLogin;
import modelo.Usuario;

/**
 * Clase DAO para gestionar las operaciones CRUD de la entidad Usuario.
 */
public class DaoUsuario {

    /**
     * Conexión a la base de datos.
     */
    public static Connection con = null;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public DaoUsuario() throws SQLException {
        this.con = DBConexion.getConexion();
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * 
     * @param u El usuario a insertar.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertar(Usuario u) throws SQLException {
        gestionLogin login = new gestionLogin();
        String contrasenaCifrada = login.getMD5(u.getContrasena());

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO usuarios (nombre,apellido,nombreUsuario,contrasena,mail) VALUES (?,?,?,?,?)");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getApellido());
        ps.setString(3, u.getNombreUsuario());
        ps.setString(4, contrasenaCifrada);
        ps.setString(5, u.getMail());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     * 
     * @param u El usuario a actualizar.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void actualizar(Usuario u) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE usuarios SET nombre=?, apellido=?, nombreUsuario=?, contrasena=?, mail=? WHERE id=?");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getApellido());
        ps.setString(3, u.getNombreUsuario());
        ps.setString(4, u.getContrasena());
        ps.setString(5, u.getMail());
        ps.setInt(6, u.getId());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Borra un usuario de la base de datos por su ID.
     * 
     * @param id El ID del usuario a borrar.
     * @throws SQLException Si ocurre un error durante el borrado.
     */
    public void borrar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Obtiene un usuario de la base de datos por su ID.
     * 
     * @param id El ID del usuario a obtener.
     * @return El usuario obtenido.
     * @throws SQLException Si ocurre un error durante la obtención.
     */
    public Usuario obtenerPorID(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6), rs.getString(7));

        return u;
    }

    /**
     * Verifica las credenciales de un usuario para el inicio de sesión.
     * 
     * @param u          El usuario con las credenciales.
     * @param contrasena La contraseña a verificar.
     * @return El usuario si las credenciales son correctas, null en caso contrario.
     * @throws SQLException Si ocurre un error durante la verificación.
     */
    public Usuario logueando(Usuario u, String contrasena) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE mail=? AND contrasena=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, u.getMail());
        ps.setString(2, contrasena);

        ResultSet rs = ps.executeQuery();
        rs.next();

        Usuario aux = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6), rs.getString(7));

        return aux;
    }

    /**
     * Lista todos los usuarios de la base de datos.
     * 
     * @return Una lista de usuarios.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Usuario> listar() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        ArrayList<Usuario> ls = new ArrayList<>();

        while (rs.next()) {
            ls.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7)));
        }
        return ls;
    }

    /**
     * Filtra un usuario de la base de datos por su teléfono.
     * 
     * @param tel El teléfono del usuario a filtrar.
     * @return El usuario filtrado.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public Usuario filtrar(String tel) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE tel=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tel);
        ResultSet rs = ps.executeQuery();
        rs.next();

        Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6));

        return u;
    }

    /**
     * Lista todos los usuarios en formato JSON.
     * 
     * @return Una cadena JSON con la lista de usuarios.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public String listarJson() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar());
        return json;
    }
}
