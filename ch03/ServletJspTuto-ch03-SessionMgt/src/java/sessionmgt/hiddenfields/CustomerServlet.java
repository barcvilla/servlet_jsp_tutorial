/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionmgt.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * La clase CustomerServlet extiende HttpServlet la cual mapea 3 URL: /customer - /editCustomer - /updateCustomer
 * Las dos primeros patrones invocaran el metodo doGet() del servlet y el patron url /updateCustomer invoca al 
 * metodo doPost()
 * 
 * /customer es el punto de entrada a esta pequela aplicacion. La cual lista los clientes
 * @author barcvilla
 */
@WebServlet
(
        name = "CustomerServlet",
        urlPatterns = {"/customer", "/editCustomer", "/updateCustomer"}
)
public class CustomerServlet extends HttpServlet 
{
    private static final long serialVersionUID = -20L;
    
    private List<Customer> customers = new ArrayList<Customer>();
    
    @Override
    public void init() throws ServletException
    {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donald D.");
        customer1.setCity("Miami");
        customers.add(customer1);
        
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey M.");
        customer2.setCity("Orlando");
        customers.add(customer2);
    }
    
    /**
     * Cada customer en la lista incluye un link edit. El atributo href de cada uno de estos links es dirijido hacia
     * /editCustomer?id=customerId
     */
    private void sendCustomerList(HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html"
        + "<html><head><title>Customers</title></head>"
        + "<body><h2>Customers</h2>");
        writer.println("<ul>");
        for(Customer customer : customers)
        {
            writer.println("<li>" + customer.getName()
            + "(" + customer.getCity() + ") ("
            + "<a href='editCustomer?id=" + customer.getId() + "'>edit</a>)");
        }
        writer.println("</ul>");
        writer.println("<body></html>");
    }
    
    private Customer getCustomer(int customerId)
    {
        for(Customer customer : customers)
        {
            if(customer.getId() == customerId)
            {
                return customer;
            }
        }
        return null;
    }
    
    /**
     * Si hacemos click en un cliente de la lista el servlet enviara  este formulario el cual incluye un 
     * hidden field. Este hidden field contiene el customerId, asi cuando el formulario es submitted
     * el servidor conoce que cliente esta siendo editado.
     * 
     * Hay que decir que el formulario usa el metodo post, asi cuando el usuario somete el formulario, el browser
     * utilizara el metodo HTTP POST e invocara al metodo del servlet doPost()
     */
    private void sendEditCustomerForm(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int customerId = 0;
        try
        {
            customerId = Integer.parseInt(request.getParameter("id"));
        }
        catch(NumberFormatException e)
        {
            
        }
        Customer customer = getCustomer(customerId);
        
        if(customer != null)
        {
            writer.println("<!DOCTYPE html><html><head>"
                    + "<title>Edit Customer</title></head>"
                    + "<body><h2>Edit Customer</h2>"
                    + "<form method='post' "
                    + "action='updateCustomer'>");
            writer.println("<input type='hidden' name='id' value='" 
                    + customerId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>" 
                    + "<input name='name' value='" + 
                    customer.getName().replaceAll("'", "&#39;") 
                    + "'/></td></tr>");
            writer.println("<tr><td>City:</td><td>" 
                    + "<input name='city' value='" + 
                    customer.getCity().replaceAll("'", "&#39;") 
                    + "'/></td></tr>");
            writer.println("<tr>"
                    + "<td colspan='2' style='text-align:right'>" 
                    + "<input type='submit' value='Update'/></td>" 
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='customer'>Customer List</a>" 
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body></html>");            
        }
        else
        {
            writer.println("No customer found");
        }
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String uri = request.getRequestURI();
        if(uri.endsWith("/customer"))
        {
            sendCustomerList(response);
        }
        else if(uri.endsWith("/editCustomer"))
        {
            sendEditCustomerForm(request, response);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int customerId = 0;
        try
        {
            customerId = Integer.parseInt(request.getParameter("id"));
        }
        catch(NumberFormatException e){}
        
        Customer customer = getCustomer(customerId);
        if(customer != null)
        {
            customer.setName(request.getParameter("name"));
            customer.setCity(request.getParameter("city"));
        }
        sendCustomerList(response);
    }
}
