package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Carta;

/**
 * Clase DAO para gestionar las operaciones CRUD de la entidad Carta.
 * Implementa el patrón Singleton.
 */
public class daoCarta {

    /**
     * Conexión a la base de datos.
     */
    public static Connection con = null;

    /**
     * Instancia única de daoCarta.
     */
    private static daoCarta instance = null;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     * 
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public daoCarta() throws SQLException {
        this.con = DBConexion.getConexion();
    }

    /**
     * Obtiene la instancia única de daoCarta.
     * 
     * @return La instancia única de daoCarta.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public static daoCarta getInstance() throws SQLException {
        if (instance == null) {
            instance = new daoCarta();
        }
        return instance;
    }

    /**
     * Inserta una nueva carta en la base de datos.
     * 
     * @param n La carta a insertar.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertar(Carta n) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO cartas (nombre, color, nivel, coste, costeDeDigi, poder, foto) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, n.getNombre());
        ps.setString(2, n.getColor());
        ps.setString(3, n.getNivel());
        ps.setString(4, n.getCoste());
        ps.setString(5, n.getCosteDeDigi());
        ps.setString(6, n.getPoder());
        ps.setString(7, n.getFoto());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Inserta una carta en la cesta.
     * 
     * @param n La carta a insertar en la cesta.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void insertarCesta(Carta n) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO cesta (nombre, color, nivel, coste, costeDeDigi, poder, foto) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, n.getNombre());
        ps.setString(2, n.getColor());
        ps.setString(3, n.getNivel());
        ps.setString(4, n.getCoste());
        ps.setString(5, n.getCosteDeDigi());
        ps.setString(6, n.getPoder());
        ps.setString(7, n.getFoto());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Actualiza una carta existente en la base de datos.
     * 
     * @param n La carta a actualizar.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void actualizar(Carta n) throws SQLException {
        PreparedStatement ps = con.prepareStatement("UPDATE cartas SET nombre=?, color=?, nivel=?, coste=?, costeDeDigi=?, poder=?, foto=? WHERE id=?");
        ps.setString(1, n.getNombre());
        ps.setString(2, n.getColor());
        ps.setString(3, n.getNivel());
        ps.setString(4, n.getCoste());
        ps.setString(5, n.getCosteDeDigi());
        ps.setString(6, n.getPoder());
        ps.setString(7, n.getFoto());
        ps.setInt(8, n.getId());

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Borra una carta de la base de datos por su ID.
     * 
     * @param id El ID de la carta a borrar.
     * @throws SQLException Si ocurre un error durante el borrado.
     */
    public void borrar(int id) throws SQLException {
        String sql = "DELETE FROM cartas WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int filas = ps.executeUpdate();
        ps.close();
    }

    /**
     * Obtiene una carta de la base de datos por su ID.
     * 
     * @param id El ID de la carta a obtener.
     * @return La carta obtenida.
     * @throws SQLException Si ocurre un error durante la obtención.
     */
    public Carta obtenerPorID(int id) throws SQLException {
        String sql = "SELECT * FROM cartas WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        rs.next();
        Carta u = new Carta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
        return u;
    }

    /**
     * Lista todas las cartas de la base de datos.
     * 
     * @return Una lista de cartas.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Carta> listar() throws SQLException {
        String sql = "SELECT id, nombre, color, nivel, coste, costeDeDigi, poder, foto FROM cartas";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Carta> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(new Carta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
        }
        return ls;
    }

    /**
     * Lista todas las cartas en formato JSON.
     * 
     * @return Una cadena JSON con la lista de cartas.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public String listarJson() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.listar());
        return json;
    }

    /**
     * Lista las cartas de color rojo.
     * 
     * @return Una lista de cartas de color rojo.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Carta> filtroRojo() throws SQLException {
        String sql = "SELECT id, nombre, color, nivel, coste, costeDeDigi, poder, foto FROM cartas WHERE color='rojo'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Carta> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(new Carta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
        }
        return ls;
    }

    /**
     * Lista las cartas de color rojo en formato JSON.
     * 
     * @return Una cadena JSON con la lista de cartas de color rojo.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public String listarRojos() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.filtroRojo());
        return json;
    }

    /**
     * Lista las cartas de color azul.
     * 
     * @return Una lista de cartas de color azul.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Carta> filtroAzul() throws SQLException {
        String sql = "SELECT id, nombre, color, nivel, coste, costeDeDigi, poder, foto FROM cartas WHERE color='Azul'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Carta> ls = new ArrayList<>();
        while (rs.next()) {
            ls.add(new Carta(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
        }
        return ls;
    }

    /**
     * Lista las cartas de color azul en formato JSON.
     * 
     * @return Una cadena JSON con la lista de cartas de color azul.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public String listarAzules() throws SQLException {
        String json = "";
        Gson gson = new Gson();
        json = gson.toJson(this.filtroAzul());
        return json;
    }

    /**
     * Lista las cartas de color amarillo.
     * 
     * @return Una lista de cartas de color amarillo.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public ArrayList<Carta> filtroAmarillo() throws SQLException {
        String sql = "SELECT id, nombre, color, nivel, coste, costeDeDigi, poder, foto FROM cartas WHERE color='Amarillo'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Carta> ls = new ArrayList<>();
        while (rs
