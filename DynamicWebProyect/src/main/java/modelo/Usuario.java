package modelo;

import java.sql.SQLException;
import com.google.gson.Gson;
import dao.DaoUsuario;

/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasena;
    private String mail;
    private String permiso;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros.
     * 
     * @param id           Identificador del usuario.
     * @param nombre       Nombre del usuario.
     * @param apellido     Apellido del usuario.
     * @param nombreUsuario Nombre de usuario.
     * @param contrasena   Contraseña del usuario.
     * @param mail         Correo electrónico del usuario.
     */
    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String mail) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.mail = mail;
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param id           Identificador del usuario.
     * @param nombre       Nombre del usuario.
     * @param apellido     Apellido del usuario.
     * @param nombreUsuario Nombre de usuario.
     * @param contrasena   Contraseña del usuario.
     * @param mail         Correo electrónico del usuario.
     * @param permiso      Permiso del usuario.
     */
    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contrasena, String mail, String permiso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.mail = mail;
        this.permiso = permiso;
    }

    /**
     * Constructor sin el identificador.
     * 
     * @param nombre       Nombre del usuario.
     * @param apellido     Apellido del usuario.
     * @param nombreUsuario Nombre de usuario.
     * @param contrasena   Contraseña del usuario.
     * @param mail         Correo electrónico del usuario.
     * @param permiso      Permiso del usuario.
     */
    public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, String mail, String permiso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.mail = mail;
        this.permiso = permiso;
    }

    /**
     * Constructor sin el permiso.
     * 
     * @param nombre       Nombre del usuario.
     * @param apellido     Apellido del usuario.
     * @param nombreUsuario Nombre de usuario.
     * @param contrasena   Contraseña del usuario.
     * @param mail         Correo electrónico del usuario.
     */
    public Usuario(String nombre, String apellido, String nombreUsuario, String contrasena, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.mail = mail;
    }

    /**
     * Constructor con nombre de usuario y contraseña.
     * 
     * @param nombreUsuario Nombre de usuario.
     * @param contrasena   Contraseña del usuario.
     */
    public Usuario(String mail, String contrasena) {
        this.mail = mail;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el identificador del usuario.
     * 
     * @return Identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     * 
     * @param id Identificador del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return Apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param apellido Apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el nombre de usuario.
     * 
     * @return Nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     * 
     * @param nombreUsuario Nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasena Contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return Correo electrónico del usuario.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Establece el correo electrónico del usuario.
     * 
     * @param mail Correo electrónico del usuario.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Obtiene el permiso del usuario.
     * 
     * @return Permiso del usuario.
     */
    public String getPermiso() {
        return permiso;
    }

    /**
     * Establece el permiso del usuario.
     * 
     * @param permiso Permiso del usuario.
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    /**
     * Inserta el usuario en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al insertar el usuario.
     */
    public void insertar() throws SQLException {
        DaoUsuario dao = new DaoUsuario();
        dao.insertar(this);
    }

    /**
     * Actualiza el usuario en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al actualizar el usuario.
     */
    public void actualizar() throws SQLException {
        DaoUsuario dao = new DaoUsuario();
        dao.actualizar(this);
    }

    /**
     * Borra el usuario de la base de datos.
     * 
     * @param id Identificador del usuario a borrar.
     * @throws SQLException Si ocurre un error al borrar el usuario.
     */
    public void borrar(int id) throws SQLException {
        DaoUsuario dao = new DaoUsuario();
        dao.borrar(id);
    }

    /**
     * Obtiene el usuario por su identificador.
     * 
     * @param id Identificador del usuario.
     * @throws SQLException Si ocurre un error al obtener el usuario.
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

    /**
     * Realiza el proceso de logueo.
     * 
     * @param contrasena Contraseña del usuario.
     * @return true si el logueo es exitoso, false en caso contrario.
     * @throws SQLException Si ocurre un error durante el logueo.
     */
    public boolean logueo(String contrasena) throws SQLException {
        boolean ok = false;
        DaoUsuario dao = new DaoUsuario();
        Usuario aux = dao.logueando(this, contrasena);
        if (aux != null) {
            ok = true;
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

    /**
     * Convierte el usuario a una representación en JSON.
     * 
     * @return Cadena JSON que representa al usuario.
     */
    public String dameJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    /**
     * Retorna una representación en cadena del usuario.
     * 
     * @return Cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nombreUsuario="
                + nombreUsuario + ", contrasena=" + contrasena + ", mail=";
    }
}