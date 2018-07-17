/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.escueladigital.dao.PSQLProducto;
import pe.escueladigital.dao.PSQLTalla;
import pe.escueladigital.modelos.Producto;
import pe.escueladigital.modelos.Talla;
import pe.escueladigital.utilidades.Utilidades;

@WebServlet(name = "ServletComprar", urlPatterns = {"/agregar-producto"})
public class ServletComprar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Obtenemos la session actual*/
        HttpSession sesion = request.getSession();
        
        String sId = request.getParameter("idproducto");
        String sTalla = request.getParameter("talla");
        
        short idProducto, idTalla;
        try {
            idProducto = Short.parseShort(sId);
            idTalla = Short.parseShort(sTalla);
        } catch (NumberFormatException nfe) {
            idProducto = 0;
            idTalla = 0;
        }
        
        PSQLProducto daoProducto = new PSQLProducto();
        PSQLTalla daoTalla = new PSQLTalla();
        
        Producto producto = daoProducto.obtenerPorId(idProducto);
        Talla talla = daoTalla.obtenerPorId(idTalla);
        producto.setTalla(talla);
        
        /*Lista de producto que obtiene lo que haya en la session con el atributo carro*/
        List<Producto> carro = (List) sesion.getAttribute("carro");
        
        /*Si la session es null ya que aun no ha comprado  nada o ya realizo la compra y termino el proceso, creamos un nuevo carro*/
        if (carro == null) {
            carro = new ArrayList<>();
        }
        /*adiciono al carro el producto visualizado*/
        carro.add(producto);
        /*Todo el arraylist es el carro de la session*/
        sesion.setAttribute("carro", carro);
        Utilidades.getInstancia().irAPagina(request, response, getServletContext(), "/carro.jsp");
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
