package pe.escueladigital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "PrimerServlet", urlPatterns = {"/primersolicitud"})
public class PrimerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request: todo lo que nos solicita el html (cliente)
     * @param response servlet response: todo lo que respondemos o devolvemos al cliente
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*para capturar y responder caracteres especiales como ñ*/
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        /*Capturamos un parametro via get enviado desde el cliente*/
        String nombre = request.getParameter("nombre");
        
        /*Obtenemos el parametro nombre del contexto de la app, colocado por MyLitener*/
        String base = (String) getServletContext().getAttribute("bd");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrimerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet PrimerServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Hola " + nombre + ",este es nuestro primer Servlet</h1>");
            /*Escribimos el valor del atributo bd*/
            out.println("<h2>La base de datos es: " + base + "</h2>");
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

    /**
     * Handles the HTTP <code>POST</code> method. A traves de un formulario
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
