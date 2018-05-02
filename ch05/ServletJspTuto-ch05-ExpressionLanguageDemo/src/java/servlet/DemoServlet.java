/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;

/**
 *
 * @author PC
 */
@WebServlet
(
        name = "DemoServlet",
        urlPatterns = {"/demo"}
)
public class DemoServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<String> cities = new ArrayList<>();
        cities.add("Paris");
        cities.add("Strasburgo");
        cities.add("London");
        cities.add("New York");
        cities.add("Beijing");
        cities.add("Amsterdam");
        cities.add("San Francisco");
        request.setAttribute("cities", cities);
        
        Address a1 = new Address("100 Rue Lilas", "Ottawa", "10004");
        Address a2 = new Address("99 Aloha street", "Montreal", "20940");
        
        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);
        
        request.setAttribute("Address", addresses);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
