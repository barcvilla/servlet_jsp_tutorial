/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Rectangulo;

/**
 *
 * @author PC
 */
@WebServlet
(
        name="ServletControlador",
        urlPatterns={"/ServletControlador"}
)
public class ServletControlador extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //1. para este caso no hay necesidad de procesar parametros
        //2. creamos nuestros JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        //3. agregamos las variables en cierto alcance para compartir informacion desde el servlet al jsp
        request.setAttribute("mensaje", "Saludo desde el Servlet");
        // compartimos el objeto rec en el session, para ello recuperamos el objeto session
        HttpSession session = request.getSession();
        session.setAttribute("rectangulo", rec);
        //4. redireccionamos
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        //propagamos los objetos request y response para que puedan ser accedidos por el jsp
        rd.forward(request, response);
    }
}
