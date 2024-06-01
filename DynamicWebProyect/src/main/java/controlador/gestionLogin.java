package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Servlet implementation class gestionLogin
 */
public class gestionLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    HttpSession sesion;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public gestionLogin() {
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
        response.getWriter().append("Served at: ").append(request.getContextPath());
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
        String mail = request.getParameter("mail");
        String contrasena = getMD5(request.getParameter("contrasena"));
        
        Usuario u = new Usuario();
        u.setMail(mail); 
        
        try {
            if (u.logueo(contrasena)) {
                sesion = request.getSession();
                
                sesion.setAttribute("id", u.getId());
                sesion.setAttribute("permiso", u.getPermiso());
                System.out.println(u.toString());
                
                if (u.getPermiso().equals("a")) {
                    response.sendRedirect("menu.html");
                } else {
                    response.sendRedirect("menuDev.html");
                }
            } else {
                response.sendRedirect("error.html");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error 1");
            e.printStackTrace();
        }
    }

    /**
     * Convierte una cadena de texto a su representación MD5.
     * 
     * @param input La cadena de texto a convertir.
     * @return La representación MD5 de la cadena de texto.
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
