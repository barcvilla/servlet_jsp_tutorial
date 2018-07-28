/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "CookiesServlet", urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //suponemos que el usuario esta visitando por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        
        //obtenemos todas las cookies
        Cookie[] cookies = request.getCookies();
        //buscamos si ya existe una cookie creada con anterioridad llamada visitanteRecurrente
        if(cookies != null)
        {
            for(Cookie cookie : cookies)
            {
                //preguntamos por el nombre de la cookie que estamos recuperando
                if(cookie.getName().equals("visitanteRecurrente") && cookie.getValue().equals("si"))
                {
                    /**
                     * En caso de que ya exista una cookie indicando que existe un usuario registrado con anterioridad
                     * ponemos el flag nuevoUsuario en false y salimos del ciclo
                     */
                    nuevoUsuario =  false;
                    break;
                }
            }
        }
        // Revisamos si el usuario es un nuevo visitante
        String mensaje = null;
        if(nuevoUsuario)
        {
            // en caso de ser un nuevo usuario creamos el objeto cookie
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            //agregamos la cookie en la repuesta
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio";
        }
        else
        {
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        
        response.setContentType("text/html;charset=UTF-8"); 
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookiesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Mensaje del sitio: " + mensaje + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    

}
