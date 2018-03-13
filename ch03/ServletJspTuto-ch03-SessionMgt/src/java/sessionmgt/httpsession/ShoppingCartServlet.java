/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionmgt.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * /products : Muestra todos los productos
 * /viewProductsDetails : Muestra los detalles del producto
 * /addToCart : Adiciona un producto al carrito de compras
 * /viewCart : Muestra el contenido del carrito de compras.
 * Todas las URL's excepto /addToCart invocan el metodo doGet de la clase ShoppingCartServlet
 * que empieza verificando las solicitudes URI y genera contenido acorde.
 * http://localhost:8080/ServletJspTuto-ch03-SessionMgt/products invoca la pagina principal de la app.
 * @author barcvilla
 */
@WebServlet
(
        name="ShoppingCartServlet",
        urlPatterns={"/products", "/viewProductsDetails", "/addToCart", "/viewCart"}
)
public class ShoppingCartServlet extends HttpServlet
{
    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";
    
    private List<Product> products = new ArrayList<>();
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
        products.add(new Product(
            1, "Bravo 32' HDTV","Low-cost HDTV from renowned TV manufacturer",BigDecimal.valueOf(159.95F)));
        products.add(new Product(
            2, "Bravo BluRay Player","High quality stylish BluRay player",BigDecimal.valueOf(99.95F)));
        products.add(new Product(
            3, "Bravo Stereo System","5 speaker hifi system with iPod player",BigDecimal.valueOf(129.95F)));
        products.add(new Product(
            4, "Bravo iPod player","An iPod plug-in that can play multiple formats",BigDecimal.valueOf(39.95F)));
    }
    
    private void sendProductList(HttpServletResponse response)throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>"
                + "<html><head><title>Products</title>"
                + "</head><body><h2>Products</h2>");
        writer.println("<ul>");
        for (Product product : products) {
            writer.println("<li>" + product.getName() + "("
                    + currencyFormat.format(product.getPrice())
                    /* al hacer click en el link Details, el metodo doGet nos enviara los detalles del
                       producto seleccionado y veremos la pagina de detalles del producto.*/
                    + ") (" + "<a href='viewProductsDetails?id="
                    + product.getId() + "'>Details</a>)");
        }
        writer.println("</ul>");
        /*Al hacer click View Cart, se invoca nuevamente al metodo doGet y el metodo llama al metodo showCart*/
        writer.println("<a href='viewCart'>View Cart</a>");
        writer.println("</body></html>");
    }    

    private Product getProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
    
    private void sendProductDetails(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int productId = 0;
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
        } catch (NumberFormatException e) {
        }
        Product product = getProduct(productId);

        if (product != null) {
            writer.println("<!DOCTYPE html>"
                    + "<html><head>"
                    + "<title>Product Details</title></head>"
                    + "<body><h2>Product Details</h2>"
                    + "<form method='post' action='addToCart'>");
            writer.println("<input type='hidden' name='id' "
                    + "value='" + productId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                    + product.getName() + "</td></tr>");
            writer.println("<tr><td>Description:</td><td>"
                    + product.getDescription() + "</td></tr>");
            writer.println("<tr>" + "<tr>"
                    + "<td><input name='quantity'/></td>"
                    /*Al hacer click en el boton Buy, el formulario buy en la pagina product details invoca
                      el metodo doPost. Esto es donde un producto es adicionado al HttpSession del usuario.*/
                    + "<td><input type='submit' value='Buy'/>"
                    + "</td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='products'>Product List</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body></html>");
        } else {
            writer.println("No product found");
        }
    }

    private void showCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>"
                + "<html><head><title>Shopping Cart</title>"
                + "<style>table, td {border:1px solid green;}</style>"
                + "</head>");
        writer.println("<body><a href='products'>" + "Product List</a>");
        /* recuperamos el HttpSession del usuario y llama al metodo getAttribute para obtener la lista de 
           ShoppingList items*/
        HttpSession session = request.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session
                .getAttribute(CART_ATTRIBUTE);
        // Iteramos sobre la lista y enviamos el contenido de cada item en el broswer.
        if (cart != null) {
            writer.println("<table>");
            writer.println("<tr><td style='width:150px'>Quantity"
                    + "</td>"
                    + "<td style='width:150px'>Product</td>"
                    + "<td style='width:150px'>Price</td>"
                    + "<td>Amount</td></tr>");
            BigDecimal total = BigDecimal.ZERO;
            for (ShoppingItem shoppingItem : cart) {
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if (quantity != 0) {
                    BigDecimal price = product.getPrice();
                    writer.println("<tr>");
                    writer.println("<td>" + quantity + "</td>");
                    writer.println("<td>" + product.getName()
                            + "</td>");
                    writer.println("<td>"
                            + currencyFormat.format(price)
                            + "</td>");
                    BigDecimal subtotal = price.multiply(
                            BigDecimal.valueOf(quantity));

                    writer.println("<td>"
                            + currencyFormat.format(subtotal)
                            + "</td>");
                    total = total.add(subtotal);
                    writer.println("</tr>");
                }
            }
            writer.println("<tr><td colspan='4' "
                    + "style='text-align:right'>"
                    + "Total:"
                    + currencyFormat.format(total)
                    + "</td></tr>");
            writer.println("</table>");
        }
        writer.println("</table></body></html>");
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,
            IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith("/products")) {
            sendProductList(response);
        } else if (uri.endsWith("/viewProductsDetails")) {
            sendProductDetails(request, response);
        } else if (uri.endsWith("viewCart")) {
            showCart(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,
            IOException {
        // add to cart
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(
                    request.getParameter("id"));
            quantity = Integer.parseInt(request
                    .getParameter("quantity"));
        } catch (NumberFormatException e) {
        }

        Product product = getProduct(productId);
        if (product != null && quantity >= 0) {
            // construimos el ShoppingItem basado en la cantidad y el product objeto seleccionado por el usuario.
            ShoppingItem shoppingItem = new ShoppingItem(product,
                    quantity);
            /*Recuperamos el HttpSession del usuario y verifica si ya contiene una List asociada con el
              atributo cart*/
            HttpSession session = request.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session
                    .getAttribute(CART_ATTRIBUTE);
            /*Si List es encontrada, la List sera usado al ShoppingItem. Si List no se encuentra, una
              sera creada y adicionada al HttpSession*/
            if (cart == null) {
                cart = new ArrayList<ShoppingItem>();
                session.setAttribute(CART_ATTRIBUTE, cart);
            }
            cart.add(shoppingItem); // finalmente, ShoppingItem es adicionado a la List
        }
        sendProductList(response);
    }
    
}
