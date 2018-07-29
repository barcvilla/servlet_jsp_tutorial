/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarritoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarritoServlet at " + request.getContextPath() + "</h1>");
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

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Procesamos los articulos
        String articuloNuevo = request.getParameter("articulo");
        // creamos o recuperamos  las session http
        HttpSession session = request.getSession();

        //Recuperamos la lista de articulos previos si es que existen en la session
        List<String> articulos = (List<String>) session.getAttribute("articulos"); //la clave articulos contiene los productos en la session
        // verificamos si la lista de articulos existe
        if (articulos == null) {
            // si no existe la lista de articulos, inicializamos esta y la adicionamos a la session
            articulos = new ArrayList<>();
            session.setAttribute("articulos", articulos);
        }
        //con la lista de articulos lista para trabajar, agregamos el nuevo articulo mediante el paso por referencia
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) //articuloNuevo no es null y no esta vacio
        {
            articulos.add(articuloNuevo);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarritoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Art&iacute;culos</h1>");
            out.println("<br/>");
            //Iteramos todos los articulos incluyendo el nuevo
            for(String articulo : articulos)
            {
               out.println("<ul><li>" + articulo + "</li></ul>");
            }
            // agregamos un link para regresar al inicio
            out.println("<a href='/EjemploCarritoCompras'>regresa </a> ");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

}
