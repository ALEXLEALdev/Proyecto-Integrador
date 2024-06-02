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
    File uploads = new File(pathFiles);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionCarta() {
        super();
    }

    /**
     * Maneja las solicitudes GET.
     * 
     * @param request  La solicitud HttpServletRequest.
     * @param response La respuesta HttpServletResponse.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException      Si ocurre un error de E/S.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String opParam = request.getParameter("op");

        if (opParam != null && !opParam.isEmpty()) {
            int opcion = Integer.parseInt(opParam);

            try {
                switch (opcion) {
                    case 1:
                        daoCarta cartas1 = new daoCarta();
                        out.print(cartas1.listarJson());
                        break;

                    case 2:
                        int id2 = Integer.parseInt(request.getParameter("id"));
                        Carta c2 = new Carta();
                        c2.obtenerPorID(id2);
                        out.print(c2.dameJson());
                        System.out.println(c2.dameJson());
                        break;

                    case 3:
                        int id3 = Integer.parseInt(request.getParameter("id"));
                        daoCarta c3 = new daoCarta();
                        c3.borrar(id3);
                        System.out.println("Estoy borrando " + id3);
                        System.out.println("Estoy opcion " + opcion);
                        out.print(c3.listarJson());
                        break;

                    case 4:
                        daoCarta cartas4 = new daoCarta();
                        out.print(cartas4.listarRojos());
                        break;

                    case 5:
                        daoCarta cartas5 = new daoCarta();
                        out.print(cartas5.listarAzules());
                        break;

                    case 6:
                        daoCarta cartas6 = new daoCarta();
                        out.print(cartas6.listarAmarillos());
                        break;

                    case 7:
                        daoCarta cartas7 = new daoCarta();
                        out.print(cartas7.listarVerdes());
                        break;

                    default:
                        out.print("Opción no válida");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.print("Error en la operación: " + e.getMessage());
            }
        } else {
            // Manejar el caso en que el parámetro "op" está vacío o no presente
        }
    }

    /**
     * Maneja las solicitudes POST.
     * 
     * @param request  La solicitud HttpServletRequest.
     * @param response La respuesta HttpServletResponse.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException      Si ocurre un error de E/S.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String color = request.getParameter("color");
        String nivel = request.getParameter("nivel");
        String coste = request.getParameter("coste");
        String costeDeDigi = request.getParameter("costeDeDigi");
        String poder = request.getParameter("poder");
        String id = request.getParameter("id");

        Part part = request.getPart("foto"); // Datos binarios de la foto
        Path path = Paths.get(part.getSubmittedFileName()); // Nombre del archivo original
        String fileName = path.getFileName().toString();
        InputStream input = part.getInputStream();
        File file = new File(uploads, fileName);

        try {
            Files.copy(input, file.toPath());
        } catch (Exception e) {
            System.out.println("Error en la copia del archivo");
            PrintWriter error = response.getWriter();
            error.print("<h4> Se ha producido un error</h4>");
        }

        Carta c = new Carta(nombre, color, nivel, coste, costeDeDigi, poder, fileName);
        try {
        	if (id == null || id.isEmpty()) {
                c.insertar();
                response.sendRedirect("crarCarta.html");
            } else {
                int idInt = Integer.parseInt(id);
                c.setId(idInt);
                c.actualizar();
                response.sendRedirect("editarCarta.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(c.toString());
    }
}
