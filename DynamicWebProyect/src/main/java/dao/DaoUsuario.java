package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import controlador.gestionLogin;
import modelo.Usuario;

// TAD-DAO
public class DaoUsuario {

	
	
	public static Connection con = null;

	public DaoUsuario() throws SQLException {

		this.con = DBConexion.getConexion();
	}

	public void insertar(Usuario u) throws SQLException {
		gestionLogin login = new gestionLogin();
		String contrasenaCifrada = login.getMD5(u.getContrasena());

		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO usuarios (nombre,apellido,nombreUsuario,contrasena,mail) VALUES (?,?,?,?,?) ");
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellido());
		ps.setString(3, u.getNombreUsuario());
		ps.setString(4, contrasenaCifrada);
		ps.setString(5, u.getMail());

		int filas = ps.executeUpdate();
		ps.close();
	}

	public void actualizar(Usuario u) throws SQLException {
		PreparedStatement ps = con.prepareStatement(
				"UPDATE usuarios SET nombre=?, apellido=?, nombreUsuario=? ,contrasena=? , mail=? WHERE id=?");
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellido());
		ps.setString(3, u.getNombreUsuario());
		ps.setString(4, u.getContrasena());
		ps.setString(5, u.getMail());
		ps.setInt(6, u.getId());

		int filas = ps.executeUpdate();
		ps.close();
	}

	public void borrar(int id) throws SQLException {
		String sql = "DELETE FROM usuarios WHERE id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		int filas = ps.executeUpdate();
		ps.close();
	}

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

	public ArrayList<Usuario> listar() throws SQLException {

		String sql = "SELECT * FROM usuarios ";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		ArrayList<Usuario> ls = null;

		while (rs.next()) {
			if (ls == null) {
				ls = new ArrayList<Usuario>();
			}

			ls.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6)));
		}
		return ls;

	}

	public Usuario filtrar(String tel) throws SQLException {

		String sql = "SELECT * FROM usuarios WHERE tel=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ResultSet rs = ps.executeQuery();

		ArrayList<Usuario> ls = null;
		rs.next();
		Usuario u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6));

		return u;

	}

	public String listarJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this.listar());
		return json;
	}

}
