/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionmgt.urlrewriting;

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
 * 
 * @author barcvilla
 */
@WebServlet
(
        name="Top10Servlet",
        urlPatterns={"/top10"}
)
public class Top10Servlet extends HttpServlet
{
    private static final long serialVersionUID = 987654321L;
    
    private List<String> londonAttractions = new ArrayList<String>(10);
    private List<String> parisAttractions = new ArrayList<String>(10);
    
    /**
     * Este metodo se invoca una vez cuando el primer usuario solicita el servlet, rellena dos List
     * londonAttractions y parisAttractions, con diez sitios turisticos cada uno.
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException
    {
        londonAttractions.add("Buckingham Palace");
        londonAttractions.add("London Eye");
        londonAttractions.add("British Museum");
        londonAttractions.add("National Gallery");
        londonAttractions.add("Big Ben");
        londonAttractions.add("Tower of London");
        londonAttractions.add("Natural History Museum");
        londonAttractions.add("Canary Wharf");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Paul's Cathedral");
        
        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("The Louvre");
        parisAttractions.add("Champs Elysees");
        parisAttractions.add("Arc de Triomphe");
        parisAttractions.add("Sainte Chapelle Church");
        parisAttractions.add("Les Invalides");
        parisAttractions.add("Musee d'Orsay");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sacre Couer Basilica");       
    }
    
    /**
     * Este metodo se invoca en cada solicitud (se hace click en algun enlace), comprueba si la url contiene el parametro
     * de solicitud city y si su valor es "london" o "paris". segun el valor de este parametro
     * el metodo llama a showAttractions o showMainPage
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String city = request.getParameter("city");
        /**
         * Preguntar por "london".equals(city) es mucho mejor que preguntar por city.equals("london")
         * Ya que le primero no lanzara un NullPounterException si city es null. De lo cobtrario debemos probar
         * si city es null antes de llamar al metodo equals en city
         */
        if ("london".equals(city) || "paris".equals(city)) {
            // show attractions
            showAttractions(request, response, city);
        } 
        else 
        {
            // show main page
            showMainPage(request, response);     
        }
    }
    
    /**
     * Inicialmente el cliente llama al servlet sin un parametro de solicitud y se invocara el metodo
     * showMainPage. Este metodo envia dos hipervinculos al navegador, cada uno con una ciudad token 
     * incrustada = cityName. Al hacer click en alguno de los links se arma las sigtes ulr's
     * http://localhost:8080/ServletJspTuto-ch03-SessionMgt/top10?city=london
     * http://localhost:8080/ServletJspTuto-ch03-SessionMgt/top10?city=paris
     * seran enviados al servidor.
     */
    private void showMainPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>" + 
                "<html>" + 
                "<head>" +
                "<title>Top 10 Tourist Attractions</title>" + 
                "</head>" + 
                "<body>" + 
                "Please select a city: " + 
                "<br/><a href='?city=london'>London</a>" + 
                "<br/><a href='?city=paris'>Paris</a>" + 
                "</body></html>");
    }
    
    private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city) throws ServletException, IOException
    {
        int page = 1;
        String pageParameter = request.getParameter("page");
        if(pageParameter != null)
        {
            try
            {
                page = Integer.parseInt(pageParameter);
            }
            catch(NumberFormatException e)
            {
                // no hacemos nada y retenemos valores por defecto para la pagina.
            }
            if(page > 2)
            {
                page = 1;
            }
        }
        
        List<String> attractions = null;
        if("london".equals(city))
        {
            attractions = londonAttractions;
        }
        else if("paris".equals(city))
        {
            attractions = parisAttractions;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>" + 
                "<html>" + 
                "<head>" + 
                "<title>To 10 Tourist Attractions</title>" + 
                "</head>" + 
                "<body>");
        writer.println("<a href='top10'>Select City</a>");
        writer.println("<hr/>Page " + page + "<hr/>");
        
        int start = page * 5 - 5;
        for(int i = start; i < start + 5; i++)
        {
            writer.println(attractions.get(i) + "</br>");
        }

        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city + 
                "&page=1'>Page 1</a>");
        writer.println("&nbsp; <a href='?city=" + city + 
                "&page=2'>Page 2</a>");
        writer.println("</body></html>");

    }
}
