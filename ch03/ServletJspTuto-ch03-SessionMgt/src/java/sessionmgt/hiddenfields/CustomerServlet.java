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
import javax.servlet.http.HttpServletResponse;

/**
 *
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
}
