package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import modelo.Slider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import dao.DaoSlider;

/**
 * Servlet implementation class gestionSlider
 */
@MultipartConfig
public class gestionSlider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pathFiles = "C:\\Users\\LEAL_PC\\Desktop\\Proyectos de Alejandro\\DynamicWebProyect\\src\\main\\webapp\\img\\sliders";
    File uploads = new File(pathFiles);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionSlider() {
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

		    try {
		        switch (opcion) {
		            case 1:
		                DaoSlider ds1 = new DaoSlider();
		                out.print(ds1.listarJson());
		                break;

		            case 2:
		                int n2 = Integer.parseInt(request.getParameter("id"));
		                Slider u2 = new Slider();
		                u2.obtenerPorId(n2);
		                out.print(u2.dameJson());
		                System.out.println(u2.dameJson());
		                break;

		            case 3:
		            	int n3 = Integer.parseInt(request.getParameter("id"));
		                DaoSlider u3 = new DaoSlider();
		                u3.borrar(n3);
		                System.out.println("Estoy borrando " + n3);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String destino = request.getParameter("destino");
		Part part = request.getPart("imagen");//datos binarios de la foto
        
		Path path = Paths.get(part.getSubmittedFileName());//esto me da el nombre del archivo original
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


		Slider s =  new Slider(nombre, destino, fileName);
		try {
			if(id == null || id.isEmpty()) {
				s.insertar();
				response.sendRedirect("crearSlider.html");
			}
			else {
				int idInt = Integer.parseInt(id);
				s.setId(idInt);
				s.actualizar();
				response.sendRedirect("crearSlider.html");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("listado.html");
		System.out.println(s.toString());
	}

}
