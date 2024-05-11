package controlador;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import dao.daoCarta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Carta;

/**
 * Servlet implementation class gestionCarta
 */

@MultipartConfig
public class gestionCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pathFiles = "C:\\Users\\LEAL_PC\\Desktop\\Proyectos de Alejandro\\DynamicWebProyect\\src\\main\\webapp\\img\\cartas";
    File uploads =  new File(pathFiles);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gestionCarta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        
		PrintWriter out = response.getWriter();


		String opParam = request.getParameter("op");
		if (opParam != null && !opParam.isEmpty()) {
			int opcion = Integer.parseInt(opParam);


			if(opcion==1){

				daoCarta cartas;
				try {
					cartas = new daoCarta();
					out.print(cartas.listarJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==2) {
				int id = Integer.parseInt(request.getParameter("id"));
				//Proceso logica de edicion//
				Carta c = new Carta();

				try {
					c.obtenerPorID(id);
					out.print(c.dameJson());
					System.out.println(c.dameJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==3) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					daoCarta c = new daoCarta();
					c.borrar(id);
					System.out.println("Estoy borrando " + id);
					System.out.println("Estoy opcion " + opcion);
					out.print(c.listarJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}else if(opcion==2) {
				int id = Integer.parseInt(request.getParameter("id"));
				//Proceso logica de edicion//
				Carta c = new Carta();

				try {
					c.obtenerPorID(id);
					out.print(c.dameJson());
					System.out.println(c.dameJson());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==4){
				daoCarta cartas;
				try {
					cartas = new daoCarta();
					out.print(cartas.listarRojos());
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==5){
				daoCarta cartas;
				try {
					cartas = new daoCarta();
					out.print(cartas.listarAzules());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==6){
				daoCarta cartas;
				try {
					cartas = new daoCarta();
					out.print(cartas.listarAmarillo());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(opcion==7){
				daoCarta cartas;
				try {
					cartas = new daoCarta();
					out.print(cartas.listarVerde());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// Manejar el caso en que el parámetro "op" está vacío o no presente
			}
		}


		//Prueba de que se lista en consola la tabla de MySQL//
		/*
		try {
		ArrayList<Carta> listaCartas = daoCarta.getInstance().listar();

		for(Carta a : listaCartas) {
			System.out.println(a.toString());
		}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Auto-generated method stub
		
		
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		String nivel = request.getParameter("nivel");
		String coste = request.getParameter("coste");
		String costeDeDigi = request.getParameter("costeDeDigi");
		String poder = request.getParameter("poder");
		// String foto = request.getParameter("foto");//Datos binarios de la foto
		String id = request.getParameter("id");

		Part part =request.getPart("foto");//datos binarios de la foto
        Path path =Paths.get(part.getSubmittedFileName());//esto me da el nombre del archivo original
        String fileName = path.getFileName().toString();

        InputStream input = part.getInputStream();

        File file = new File(uploads,fileName);
        
        try {
        	Files.copy(input, file.toPath());
        	} catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la copia del archivo");
            PrintWriter error = response.getWriter();
            error.print("<h4> Se ha producido un error</h4>");
        }


		Carta c =  new Carta(nombre, color, nivel, coste, costeDeDigi, poder, fileName);
		try {
			if(id == "") {
				c.insertar();
				response.sendRedirect("crarCarta.html");
			}
			else {
				int idInt = Integer.parseInt(id);
				c.setId(idInt);
				c.actualizar();
				response.sendRedirect("lista.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("listado.html");
		System.out.println(c.toString());
	}
}
