/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ListadoPersonas;
import model.Persona;

public class ServletControlador extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        //Usuario en codigo duro
        String usuario = "juan";
        String pass = "123";

        //Agregamos el listado de personas a la sesion
        HttpSession sesion = request.getSession();
        Persona persona1 = new Persona("Ricardo", "Alvarado");
        Persona persona2 = new Persona("Dana", "Donato");
        Persona persona3 = new Persona("Ana", "Aponte");

        ListadoPersonas lista = new ListadoPersonas();
        lista.setPersona(persona1);
        lista.setPersona(persona2);
        lista.setPersona(persona3);
        sesion.setAttribute("lista", lista);

        //Recuperamos la accion a ejecutar
        String accion = request.getParameter("accion");

       

        if ("listado".equals(accion)) {
            //Verificamos si tenemos algún usuario en sesion
            if (sesion.getAttribute("login") == null) {
                //Si no hay usuario en sesion, ejecutamos el proceso de login
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //Quiere decir que ya está un usuario en sesion
                request.getRequestDispatcher("listado.jsp").forward(request, response);
            }
        } else if ("login".equals(accion)) {
            //Recuperamos el usuario proporcionado
            String usua = request.getParameter("usuarioP");
            String pss = request.getParameter("passP");
//        out.print(usua);
//        out.print(pss);
            //Verificamos que el usuario sea valido
            if (usuario.equals(usua) && pass.equals(pss)) {
                //Solo en caso de que el usuario sea valid
                //se agrega a la sesion, de lo contrario NO se agrega
                sesion.setAttribute("login", usua);
                request.getRequestDispatcher("listado.jsp").forward(request, response);
            } else {
                //Volvemos a pedir el usuario si este no es valido
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
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
