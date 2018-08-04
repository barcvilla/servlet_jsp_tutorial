/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        //1. Procesamos la peticion. Procesamos los parametros
        String accion = request.getParameter("accion");
        
        //2. Creamos los JavaBeans a compartir
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);
        
        if("agregaVariables".equals(accion))
        {
            //3. Compartimos las variables en el alcance seleccionado
            // Alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance Session
            HttpSession session = request.getSession();
            session.setAttribute("rectanguloSession", recSession);
            
            //Alcance Application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", recApplication);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4. redireccionamos al JSP seleccionado. Volvemos al index.jsp ya que solo agregamos las variables a los scopes
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if("listarVariables".equals(accion))
        {
            //4. redireccionamos ya que las variables ya han sido adicionadas a los scopes determinados ya se desplegaran
            // las que siguen disponibles segun el scope de cada variable
            request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp").forward(request, response);
        }
        else
        {
            //4. En cualquier otro caso, redireccionamos a la pagina de inicio, agregamos un mensaje
            request.setAttribute("mensaje", "Accion desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
