/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletapi1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * ENTENDIENDO SERVLET API PARTE II
 * @author barcvilla
 */
@WebServlet
(
        name = "ServletConfigDemo", urlPatterns = {"/ServletConfigDemo"}, 
        initParams = 
                {
                    @WebInitParam(name="admin", value = "Harry Taciak"), 
                    @WebInitParam(name = "email", value = "admin@Example.com")
                }
)
public class ServletConfigDemoServlet implements Servlet 
{
    private transient ServletConfig servletConfig;
    
    @Override
    public ServletConfig getServletConfig()
    {
        return servletConfig;
    }
    
    /**
     * pasamos un servlet config cuando el servlet container incializa el servlet
     * El ServletConfig encapsula la informacion de configuracion que pasamos al servlet a traves de @WebServlet
     * o en el deployment descriptor.
     * @param servletConfig 
     */
    @Override
    public void init(ServletConfig servletConfig)
    {
        this.servletConfig = servletConfig;
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        ServletConfig servletConfig = getServletConfig();
        // recuperamos los valores dl Initial Parameter
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>"
        + "<html>"
        + "<body>"
        + "Admin:" + admin
        + "<br/>Email: " + email
        + "</body>"
        + "</html>");
    }
    
    @Override
    public String getServletInfo()
    {
        return "ServletConfig Demo";
    }
    
    @Override
    public void destroy()
    {
        
    }
}
