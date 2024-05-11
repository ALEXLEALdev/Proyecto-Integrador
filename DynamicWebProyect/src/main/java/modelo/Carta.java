package modelo;

import java.sql.SQLException;

import com.google.gson.Gson;
import dao.daoCarta;

public class Carta {
	
	private int id;
	private String nombre;
	private String color;
	private String nivel;
	private String coste;
	private String costeDeDigi;
	private String poder;
	private String foto;
	
	public Carta() {
		
	}

	public Carta(String nombre, String color, String nivel, String coste, String costeDeDigi, String poder) {
		this.nombre = nombre;
		this.color = color;
		this.nivel = nivel;
		this.coste = coste;
		this.costeDeDigi = costeDeDigi;
		this.poder = poder;
	}
	public Carta( int id, String nombre, String color, String nivel, String coste, String costeDeDigi, String poder,
			String foto) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.nivel = nivel;
		this.coste = coste;
		this.costeDeDigi = costeDeDigi;
		this.poder = poder;
		this.foto = foto;
	}
	public Carta( String nombre, String color, String nivel, String coste, String costeDeDigi, String poder,
			String foto) {
		
		this.nombre = nombre;
		this.color = color;
		this.nivel = nivel;
		this.coste = coste;
		this.costeDeDigi = costeDeDigi;
		this.poder = poder;
		this.foto = foto;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public String getCosteDeDigi() {
		return costeDeDigi;
	}

	public void setCosteDeDigi(String costeDeDigi) {
		this.costeDeDigi = costeDeDigi;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void insertar() throws SQLException {
		daoCarta dao = new daoCarta();
		dao.insertar(this);
		//daoCarta.getInstance().insertar(this);
	}
	
	public void insertarCesta() throws SQLException {
		daoCarta dao = new daoCarta();
		dao.insertarCesta(this);
		//daoCarta.getInstance().insertar(this);
	}
	public void actualizar() throws SQLException {
		daoCarta dao = new daoCarta();
		dao.actualizar(this);
	}
	public void borrar(int id) throws SQLException {
		daoCarta dao = new daoCarta();
		dao.borrar(id);
	}
	
	public void obtenerPorID(int id) throws SQLException {
		daoCarta dao = new daoCarta();
		Carta aux = dao.obterenPorID(id);
		
		this.setId(aux.getId());
		this.setNombre(aux.getNombre());
		this.setColor(aux.getColor());
		this.setNivel(aux.getNivel());
		this.setCoste(aux.getCoste());
		this.setCosteDeDigi(aux.getCosteDeDigi());
		this.setPoder(aux.getPoder());
		this.setFoto(aux.getFoto());
	}
	
	public String dameJson(){
		String json="";
		Gson gson = new Gson();
		json = gson.toJson(this);
		return json;			
	}
	
	@Override
	public String toString() {
		return "Carta [id=" + id + ", nombre=" + nombre + ", color=" + color + ", nivel=" + nivel + ", coste=" + coste
				+ ", costeDeDigi=" + costeDeDigi + ", poder=" + poder + ", foto=" + foto + "]";
	}
	
	
	
	
	
	
	
}

	