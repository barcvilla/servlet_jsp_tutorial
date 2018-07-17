/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.escueladigital.dao.PSQLProducto;
import pe.escueladigital.dao.PSQLTalla;
import pe.escueladigital.modelos.Producto;
import pe.escueladigital.modelos.Talla;
import pe.escueladigital.utilidades.Utilidades;

/**
 *
 * @author PC
 */
@WebServlet(name = "ServletProductoDetalle", urlPatterns = {"/producto-detalle"})
public class ServletProductoDetalle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Capturamos el id del producto que se envia desde el navegador*/
        String sId = request.getParameter("id");
        short id;
        /*convertimos el id String en smallserial su equivalente en java es short ya que en la BD le id producto es numerico*/
        try {
            id = Short.parseShort(sId);
        } catch (NumberFormatException nfe) {
            id = 0;
        }
        /*Traemos el producto correspondiente al id especificado*/
        PSQLProducto dao = new PSQLProducto();
        Producto producto = dao.obtenerPorId(id);
        
        /*Aplicamos el dao para recuperar todas la tallas que llenaran un elemento combo box*/
        PSQLTalla daoTalla = new PSQLTalla();
        List<Talla> tallas = daoTalla.obtenerTodos();
        
        request.setAttribute("listaTallas", tallas);
        
        /*enviamos el producto recuperado al cliente jsp*/
        request.setAttribute("producto", producto);
        Utilidades.getInstancia().irAPagina(request, response, getServletContext(), "/producto-detalle.jsp");
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
