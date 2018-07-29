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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * El objeto HttpSession dura por defecto 30 min
 * @author PC
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String titulo = null;
        // Pedimos el atributo y verificamos si existe o si es la primera vez que visita
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas"); //obtenemos el atributo si ya lo tiene en la sesion
        // si contadorVisitas es null quiere decir que es la primera vez que accedemos al recurso
        if(contadorVisitas == null)
        {
             contadorVisitas = new Integer(1);
             titulo = "Bienvenido por primera vez...";
        }
        else
        {
            //si no es la primera vez que nos visita, incrementamos el contador
            titulo = "Bienvenido nuevamente";
            contadorVisitas++;
        }
        // en cualquier caso, agregamos el valor del contador a la session
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        try (PrintWriter out = response.getWriter()) {
            /* Mostramos los valores en el Cliente */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SesionesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>T&iacute;tulo: " + titulo + "</h1>");
            out.println("<h2> Nro de accesos al recurso: " + contadorVisitas + "</h2>");
            out.println("<br/>");
            out.println("<p>Id de la Sesion: " + sesion.getId() + "</p>");
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
