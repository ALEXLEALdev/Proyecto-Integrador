package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Carta;
import modelo.Slider;

/**
 * Clase DAO para gestionar las operaciones CRUD de la entidad Slider.
 * Implementa el patrón Singleton.
 */
public class DaoSlider {
    
    /**
     * Conexión a la base de datos.
     */
    public static Connection con = null;
    
    /**
     * Instancia única de DaoSlider.
     */
    private static DaoSlider instance = null;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public DaoSlider() throws SQLException {
        this.con = DBConexion.getConexion();
    }

    /**
     * Obtiene la instancia única de DaoSlider.
     * 
     * @return La instancia única de DaoSlider.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public static DaoSlider getInstance() throws SQLException {
        if (instance == null) {
            instance = new DaoSlider();
        }
        return instance;
    }

    /**
     * Inserta un nuevo slider en la base de datos.
     * 
     * @param n El slider a insertar.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertar(Slider n) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO sliders (id, nombre, destino, imagen) VALUES (?,?,?,?)");
        ps.setInt(1, n.getId());
        ps.setString(2, n.getNombre());
        ps.setString(3, n.getDestino());
        ps.setString(4, n.getImagen());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Actualiza un slider existente en la base de datos.
     * 
     * @param n El slider a actualizar.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void actualizar(Slider n) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE sliders SET id=?, nombre=?, destino=?, imagen=? WHERE id=?");
        ps.setInt(1, n.getId());
        ps.setString(2, n.getNombre());
        ps.setString(3, n.getDestino());
        ps.setString(4, n.getImagen());
        ps.setInt(5, n.getId());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Borra un slider de la base de datos por su ID.
     * 
     * @param id El ID del slider a borrar.
     * @throws SQLException Si ocurre un error durante el borrado.
     */
    public void borrar(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM sliders WHERE id=?");
        ps.setInt(1, id);

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Lista todos los sliders de la base de datos.
     * 
     * @return Una lista de sliders.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Slider> listar() throws SQLException {
        String sql = "SELECT id, nombre, destino, imagen FROM sliders";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Slider> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(new Slider(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return ls;
    }

    /**
     * Lista todos los sliders en formato JSON.
     * 
     * @return Una cadena JSON con la lista de sliders.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public String listarJson() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar());
        return json;
    }

    /**
     * Obtiene un slider de la base de datos por su ID.
     * 
     * @param id El ID del slider a obtener.
     * @return El slider obtenido.
     * @throws SQLException Si ocurre un error durante la obtención.
     */
    public Slider obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM sliders WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();

        Slider u = new Slider(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        return u;
    }
}
