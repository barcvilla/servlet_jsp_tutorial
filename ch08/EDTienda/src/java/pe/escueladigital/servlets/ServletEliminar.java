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
import javax.servlet.http.HttpSession;
import pe.escueladigital.modelos.Producto;
import pe.escueladigital.utilidades.Utilidades;

@WebServlet(name = "ServletEliminar", urlPatterns = {"/eliminar"})
public class ServletEliminar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Recupero la session*/
        HttpSession sesion = request.getSession();
        
        /*Convierto el idProducto que es String a tipo short*/
        String idProducto = request.getParameter("id");
        short id;
        try {
            id = Short.parseShort(idProducto);
        } catch (NumberFormatException nfe) {
            id = 0;
        }
        
        /*Recupero el carro de la session*/
        List<Producto> carro = (List) sesion.getAttribute("carro");
        if (carro != null) {
            /*Recorro el carro para encontrar el producto que quiere el eliminar el cliente*/
            for (Producto producto : carro) {
                if (producto.getId() == id) {
                    carro.remove(producto);
                    break; //una vez que se remueve se termina salimos del for
                }
            }
        }
        
        /*Le damos al session un nuevo arraylist (carro)*/
        sesion.setAttribute("carro", carro);
        /*retornamos al carro.jsp*/
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
