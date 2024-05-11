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

		sesion = request.getSession();
		Integer idSesion = (Integer) sesion.getAttribute("id");


		//if(idSesion == null) {

		PrintWriter out = response.getWriter();

		String opParam = request.getParameter("op");

		if (opParam != null && !opParam.isEmpty()) {
			int opcion = Integer.parseInt(opParam);

			if(opcion==3) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					DaoUsuario u= new DaoUsuario();
					u.borrar(id);
					System.out.println("Estoy borrando " + id);
					System.out.println("Estoy opcion " + opcion);
					out.print(u.listarJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(opcion == 2) {
				//proceso logica edicion
				int id = Integer.parseInt(request.getParameter("id"));

				Usuario u = new Usuario();
				try {
					u.obtenerPorId(id);
					out.print(u.dameJson());
					System.out.println(u.dameJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		

			}else if(opcion==1) {
				DaoUsuario usuarios;
				try {
					usuarios = new DaoUsuario();
					out.print(usuarios.listarJson());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		//}else {
		//	System.out.println("No puedes entrar");
		//	response.sendRedirect("login.html");
		//}
	}


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