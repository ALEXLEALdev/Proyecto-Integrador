package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DaoUsuario;
import dao.daoCarta;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String nombreUsuario;
	private String contrasena;
	private String mail;
	private String permiso;

	public Usuario() {
		
	}
	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String mail) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
	}
	
	public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String mail,
			String permiso) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
		this.permiso = permiso;
	}
	public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, String mail,
			String permiso) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
		this.permiso = permiso;
	}
	public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, String mail) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.mail = mail;
	}
	public Usuario(String nombreUsuario, String contrasena) {
		
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public void insertar() throws SQLException {
		
		DaoUsuario dao = new DaoUsuario();
		dao.insertar(this);
	}
	public void actualizar() throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.actualizar(this);
	}
	public void borrar(int id) throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.borrar(id);
	}
	/**
	 * 
	 * @throws SQLException
	 */
	public void obtenerPorId(int id) throws SQLException {
		
		DaoUsuario dao = new DaoUsuario();
		Usuario aux = dao.obtenerPorID(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setApellido(aux.getApellido());
		this.setNombreUsuario(aux.getNombreUsuario());
		this.setContrasena(aux.getContrasena());
		this.setMail(aux.getMail());
		this.setPermiso(aux.getPermiso());
	}
	
	public boolean logueo (String contrasena) throws SQLException {
		boolean ok = false;
		DaoUsuario dao = new DaoUsuario();
		
		Usuario aux = dao.logueando(this, contrasena);
		
		if(aux != null) {
			ok=true;
			this.setId(aux.getId());
			this.setNombre(aux.getNombre());
			this.setApellido(aux.getApellido());
			this.setNombreUsuario(aux.getNombreUsuario());
			this.setContrasena(aux.getContrasena());
			this.setMail(aux.getMail());
			this.setPermiso(aux.getPermiso());	
		}
		
	
		return ok;
		
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario="
				+ nombreUsuario + ", contrasena=" + contrasena + ", mail=" + mail + ", permiso=" + permiso + "]";
	}

	public String dameJson() {
		String json = "";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;	
	}
	

	
}
