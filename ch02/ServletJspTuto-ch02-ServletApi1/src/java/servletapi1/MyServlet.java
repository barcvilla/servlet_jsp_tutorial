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
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author barcvilla
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet implements Servlet
{
    private transient ServletConfig servletConfig;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException
    {
        this.servletConfig = servletConfig;
    }
    
    @Override
    public ServletConfig getServletConfig()
    {
        return servletConfig;
    }
    
    @Override
    public String getServletInfo()
    {
        return "My Servlet";
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        String servletName = servletConfig.getServletName();
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>"
        + "<html>"
        + "<body>Hello from: !" + servletName
        + "</body>"
        + "</html>");
    }
    
    @Override
    public void destroy()
    {
    }
}
