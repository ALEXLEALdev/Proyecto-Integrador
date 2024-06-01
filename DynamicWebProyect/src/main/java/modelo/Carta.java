package modelo;

import java.sql.SQLException;
import com.google.gson.Gson;
import dao.daoCarta;

/**
 * Clase que representa una carta en el sistema.
 */
public class Carta {
    private int id;
    private String nombre;
    private String color;
    private String nivel;
    private String coste;
    private String costeDeDigi;
    private String poder;
    private String foto;

    /**
     * Constructor por defecto.
     */
    public Carta() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param nombre       Nombre de la carta.
     * @param color        Color de la carta.
     * @param nivel        Nivel de la carta.
     * @param coste        Coste de la carta.
     * @param costeDeDigi  Coste de digievolución de la carta.
     * @param poder        Poder de la carta.
     */
    public Carta(String nombre, String color, String nivel, String coste, String costeDeDigi, String poder) {
        this.nombre = nombre;
        this.color = color;
        this.nivel = nivel;
        this.coste = coste;
        this.costeDeDigi = costeDeDigi;
        this.poder = poder;
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param id           Identificador de la carta.
     * @param nombre       Nombre de la carta.
     * @param color        Color de la carta.
     * @param nivel        Nivel de la carta.
     * @param coste        Coste de la carta.
     * @param costeDeDigi  Coste de digievolución de la carta.
     * @param poder        Poder de la carta.
     * @param foto         Foto de la carta.
     */
    public Carta(int id, String nombre, String color, String nivel, String coste, String costeDeDigi, String poder, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.nivel = nivel;
        this.coste = coste;
        this.costeDeDigi = costeDeDigi;
        this.poder = poder;
        this.foto = foto;
    }

    /**
     * Constructor sin el identificador.
     * 
     * @param nombre       Nombre de la carta.
     * @param color        Color de la carta.
     * @param nivel        Nivel de la carta.
     * @param coste        Coste de la carta.
     * @param costeDeDigi  Coste de digievolución de la carta.
     * @param poder        Poder de la carta.
     * @param foto         Foto de la carta.
     */
    public Carta(String nombre, String color, String nivel, String coste, String costeDeDigi, String poder, String foto) {
        this.nombre = nombre;
        this.color = color;
        this.nivel = nivel;
        this.coste = coste;
        this.costeDeDigi = costeDeDigi;
        this.poder = poder;
        this.foto = foto;
    }

    /**
     * Obtiene el identificador de la carta.
     * 
     * @return Identificador de la carta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la carta.
     * 
     * @param id Identificador de la carta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la carta.
     * 
     * @return Nombre de la carta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la carta.
     * 
     * @param nombre Nombre de la carta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el color de la carta.
     * 
     * @return Color de la carta.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la carta.
     * 
     * @param color Color de la carta.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el nivel de la carta.
     * 
     * @return Nivel de la carta.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel de la carta.
     * 
     * @param nivel Nivel de la carta.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtiene el coste de la carta.
     * 
     * @return Coste de la carta.
     */
    public String getCoste() {
        return coste;
    }

    /**
     * Establece el coste de la carta.
     * 
     * @param coste Coste de la carta.
     */
    public void setCoste(String coste) {
        this.coste = coste;
    }

    /**
     * Obtiene el coste de digievolución de la carta.
     * 
     * @return Coste de digievolución de la carta.
     */
    public String getCosteDeDigi() {
        return costeDeDigi;
    }

    /**
     * Establece el coste de digievolución de la carta.
     * 
     * @param costeDeDigi Coste de digievolución de la carta.
     */
    public void setCosteDeDigi(String costeDeDigi) {
        this.costeDeDigi = costeDeDigi;
    }

    /**
     * Obtiene el poder de la carta.
     * 
     * @return Poder de la carta.
     */
    public String getPoder() {
        return poder;
    }

    /**
     * Establece el poder de la carta.
     * 
     * @param poder Poder de la carta.
     */
    public void setPoder(String poder) {
        this.poder = poder;
    }

    /**
     * Obtiene la foto de la carta.
     * 
     * @return Foto de la carta.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto de la carta.
     * 
     * @param foto Foto de la carta.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Inserta la carta en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al insertar la carta.
     */
    public void insertar() throws SQLException {
        daoCarta dao = new daoCarta();
        dao.insertar(this);
    }

    /**
     * Inserta la carta en la cesta.
     * 
     * @throws SQLException Si ocurre un error al insertar la carta en la cesta.
     */
    public void insertarCesta() throws SQLException {
        daoCarta dao = new daoCarta();
        dao.insertarCesta(this);
    }

    /**
     * Actualiza la carta en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al actualizar la carta.
     */
    public void actualizar() throws SQLException {
        daoCarta dao = new daoCarta();
        dao.actualizar(this);
    }

    /**
     * Borra la carta de la base de datos.
     * 
     * @param id Identificador de la carta a borrar.
     * @throws SQLException Si ocurre un error al borrar la carta.
     */
    public void borrar(int id) throws SQLException {
        daoCarta dao = new daoCarta();
        dao.borrar(id);
    }

    /**
     * Obtiene la carta por su identificador.
     * 
     * @param id Identificador de la carta.
     * @throws SQLException Si ocurre un error al obtener la carta.
     */
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

    /**
     * Convierte la carta a una representación en JSON.
     * 
     * @return Cadena JSON que representa a la carta.
     */
    public String dameJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Retorna una representación en cadena de la carta.
     * 
     * @return Cadena que representa a la carta.
     */
    @Override
    public String toString() {
        return "Carta [id=" + id + ", nombre=" + nombre + ", color=" + color + ", nivel=" + nivel + ", coste=" + coste
                + ", costeDeDigi=" + costeDeDigi + ", poder=" + poder + ", foto=" + foto + "]";
    }
}


	