package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.daoCarta;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Carta;

/**
 * Servlet implementation class gestionCesta
 */
public class gestionCesta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionCesta() {
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
        int opcion = Integer.parseInt(request.getParameter("op"));

        if (opcion == 1) {
            daoCarta cartas;
            try {
                cartas = new daoCarta();
                out.print(cartas.listarJson());
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        String foto = request.getParameter("foto");
        String id = request.getParameter("id");

        Carta c = new Carta(nombre, color, nivel, coste, costeDeDigi, poder, foto);
        try {
            if (id == null || id.isEmpty()) {
                c.insertarCesta();
                response.sendRedirect("cesta.html");
            } else {
                int idInt = Integer.parseInt(id);
                c.setId(idInt);
                c.actualizar();
                response.sendRedirect("cesta.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(c.toString());
    }
}
