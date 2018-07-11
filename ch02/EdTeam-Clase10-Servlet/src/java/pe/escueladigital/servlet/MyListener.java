/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Servlet Listener que se inicia tan pronto se llama a la Aplicacion y lee el archivo web.xml para pasar parametros a los 
 * servlets de la aplicacion
 * @author PC
 */
@WebListener
public class MyListener implements ServletContextListener 
{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*Obtenemos el contexto*/
        ServletContext ctx = sce.getServletContext();
        String nombre = ctx.getInitParameter("basededatos");
        /*pasamos a todos los servlets de la app el parametro nombre como atributo*/
        ctx.setAttribute("bd", nombre);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
