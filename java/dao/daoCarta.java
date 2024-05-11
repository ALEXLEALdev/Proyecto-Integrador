package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Carta;

public class daoCarta {

	//Patron Singelton aun mejor.
	
	public static Connection con = null;
	private static daoCarta instance = null;
	
	public daoCarta() throws SQLException {
		
		//this.con = DBConexion.conexion();
		this.con = DBConexion.getConexion();
		
	}
	/**
	 * Patron singelton
	 * @return
	 * @throws SQLException
	 */
	public static daoCarta getInstance() throws SQLException {
		if (instance ==null) {
			instance = new daoCarta();
		}
		return instance;
	}
	public void insertar(Carta n) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO cartas (nombre, color ,nivel , coste, costeDeDigi, poder, foto) VALUES (?,?,?,?,?,?,?)");
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
	public void insertarCesta(Carta n) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO cesta (nombre, color ,nivel , coste, costeDeDigi, poder, foto) VALUES (?,?,?,?,?,?,?)");
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
	
	public void actualizar(Carta n) throws SQLException {
		PreparedStatement ps = con.prepareStatement("UPDATE cartas SET nombre=?, color=? ,nivel=? , coste=?, costeDeDigi=?, poder=?, foto=? WHERE id=?");
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
	
	public void borrar(int id) throws SQLException {
		String sql = "DELETE FROM cartas WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		int filas = ps.executeUpdate();
		ps.close();
	}
	public Carta obterenPorID(int id) throws SQLException {
		String sql = "SELECT * FROM cartas WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		Carta u = new Carta(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
				rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
		return u;
	}
	
	//Listar todas las cartas con todos los filtros.//
	public ArrayList <Carta> listar() throws SQLException {
		
		String sql = "SELECT id,nombre,color,nivel,coste,costeDeDigi,poder,foto FROM cartas";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> ls = null;
		
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<>();
			}
			ls.add(new Carta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return ls;
	}
	
	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listar());
		return json;
	}
	
	public ArrayList <Carta> filtroRojo() throws SQLException {
		
		String sql = "SELECT id,nombre,color,nivel,coste,costeDeDigi,poder,foto FROM cartas WHERE color='rojo'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> ls = null;
		
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<>();
			}
			ls.add(new Carta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return ls;
	}
	
	public String listarRojos() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.filtroRojo());
		return json;
	}
	

	public ArrayList <Carta> filtroAzul() throws SQLException {
		
		String sql = "SELECT id,nombre,color,nivel,coste,costeDeDigi,poder,foto FROM cartas WHERE color='Azul'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> ls = null;
		
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<>();
			}
			ls.add(new Carta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return ls;
	}
	
	public String listarAzules() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.filtroAzul());
		return json;
	}
	
	public ArrayList <Carta> filtroAmarillo() throws SQLException {
		
		String sql = "SELECT id,nombre,color,nivel,coste,costeDeDigi,poder,foto FROM cartas WHERE color='Amarillo'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> ls = null;
		
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<>();
			}
			ls.add(new Carta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return ls;
	}
	
	public String listarAmarillo() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.filtroAmarillo());
		return json;
	}
	
	public ArrayList <Carta> filtroVerde() throws SQLException {
		
		String sql = "SELECT id,nombre,color,nivel,coste,costeDeDigi,poder,foto FROM cartas WHERE color='Verde'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList <Carta> ls = null;
		
		while(rs.next()) {
			if(ls == null) {
				ls = new ArrayList<>();
			}
			ls.add(new Carta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return ls;
	}
	
	public String listarVerde() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.filtroVerde());
		return json;
	}
}