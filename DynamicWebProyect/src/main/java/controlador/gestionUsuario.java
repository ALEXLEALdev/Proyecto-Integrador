package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoUsuario;

/**
 * Servlet implementation class GestionUsuario
 */
public class gestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gestionUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sesion = request.getSession();
		Integer idSesion = (Integer) sesion.getAttribute("id");

		// if(idSesion == null) {

		PrintWriter out = response.getWriter();

		String opParam = request.getParameter("op");

		if (opParam != null && !opParam.isEmpty()) {
		    int opcion = Integer.parseInt(opParam);

		    try {
		        switch (opcion) {
		            case 1:
		                DaoUsuario usuarios1 = new DaoUsuario();
		                out.print(usuarios1.listarJson());
		                break;

		            case 2:
		                int id2 = Integer.parseInt(request.getParameter("id"));
		                Usuario u2 = new Usuario();
		                u2.obtenerPorId(id2);
		                out.print(u2.dameJson());
		                System.out.println(u2.dameJson());
		                break;

		            case 3:
		                int id3 = Integer.parseInt(request.getParameter("id"));
		                DaoUsuario u3 = new DaoUsuario();
		                u3.borrar(id3);
		                System.out.println("Estoy borrando " + id3);
		                System.out.println("Estoy opcion " + opcion);
		                out.print(u3.listarJson());
		                break;

		            default:
		                out.print("Opción no válida");
		                break;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        out.print("Error en la operación: " + e.getMessage());
		    }
		}
	}

		// } else {
		//	System.out.println("No puedes entrar");
		//	response.sendRedirect("login.html");
		// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String nombreUsuario = request.getParameter("nombreUsuario");
		String contrasena = request.getParameter("contrasena");
		String mail = request.getParameter("mail");
		String permiso = request.getParameter("permiso");//
		String id = request.getParameter("id");

		Usuario u = new Usuario(nombre, apellido, nombreUsuario, contrasena, mail,permiso);

		try {
			if(id == null || id.isEmpty()) {
				u.insertar();
				response.sendRedirect("index.html");		
			}
			else {
				int idInt = Integer.parseInt(id);
				u.setId(idInt);
				u.actualizar();
				response.sendRedirect("listarUsuarios.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("listado.html");
		System.out.println(u.toString());
	}



}