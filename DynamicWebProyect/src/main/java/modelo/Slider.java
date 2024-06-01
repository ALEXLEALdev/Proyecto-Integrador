package modelo;

import java.sql.Connection;
import java.sql.SQLException;

import com.google.gson.Gson;

import dao.DBConexion;
import dao.DaoSlider;
import dao.daoCarta;

public class Slider {
	
	private int id;
	private String nombre;
	private String destino;
	private String imagen;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Slider(int id, String nombre, String destino, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.destino = destino;
		this.imagen = imagen;
	}

	
	public Slider(String nombre, String destino, String imagen) {
		this.nombre = nombre;
		this.destino = destino;
		this.imagen = imagen;
	}
	public Slider() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	@Override
	public String toString() {
		return "Slider [id=" + id + ", nombre=" + nombre + ", destino=" + destino + ", imagen=" + imagen + "]";
	}
	
	public void insertar() throws SQLException {
		DaoSlider dao = new DaoSlider();
		dao.insertar(this);
	}
	


	public void actualizar() throws SQLException {
		DaoSlider dao = new DaoSlider();
		dao.actualizar(this);
	}
	public void borrar(int id) throws SQLException {
		DaoSlider dao = new DaoSlider();
		dao.borrar(id);
	}
	
	public String dameJson(){
		String json="";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;			
	}
	
	public void obtenerPorId(int id) throws SQLException {
		DaoSlider dao = new DaoSlider();
		Slider aux = dao.obtenerPorId(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setDestino(aux.getDestino());
		this.setImagen(aux.getImagen());
	}
	
	
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


