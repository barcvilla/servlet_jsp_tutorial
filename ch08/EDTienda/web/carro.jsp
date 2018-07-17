<%@page import="java.util.List"%>
<%@page import="pe.escueladigital.modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    /*Traemos de la Session el arraylist carro*/
    List<Producto> carro = (List) session.getAttribute("carro");
    float total = 0f; // variable para sumar todo lo que hay en el carro
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Carro" />
</jsp:include>


<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="carro" />
</jsp:include>

<div class="l-main ed-container">
  <div class="ed-item">
      <h1>Mi Carro de Compras</h1>
      <div class=""><!-- el container de los productos -->
          <% 
              if (carro != null) {
                  for (Producto producto : carro) {
                      total += producto.getValor();
          %>
          <div class="producto-carro"> 
              <div class="producto-carro__img"> 
                <img src="<%= producto.getImagen() %>" alt="Camiseta">
              </div>
              <div class="producto-carro__info">
                  <h3><%= producto.getNombre() %></h3>
                  <p><%= producto.getDescripcion() %></p>
              </div>
              <div class="producto-carro__talla"> 
                  <h3>Talla</h3>
                  <p><%= producto.getTalla().getAbreviatura() %></p>
              </div>
              <div class="producto-carro__precio"> 
                  <h3>Precio</h3>
                  <p>$<%= producto.getValor() %></p>
              </div>
              <!--Link que permmite eliminar un item del carro-->
              <div class="producto-carro__del">
                  <!--href que apunta a un Servlet con urlPattern eliminar-->
                  <a href="eliminar?id=<%= producto.getId() %>">
                  <img src="img/delete.png" alt="Eliminar" title="Eliminar">
                  </a>
              </div>
          </div>
          <%
                  }
              }
          %>
      </div>
      <div class="producto-carro__footer"> 
          <div class=""> <!-- el container de los botones -->
              <a class="boton icon-cart espacio product__page__buy" href="/EDTienda/productos">Seguir comprando</a>
              
          </div>
          <div class="producto-carro__total">
              <h2>Total a pagar <span class="">$<%= total %></span></h2>
          </div>
      </div>
    <!--Formulario de Confirmacion de datos que envia la informacion al ServletVenta con urlPattern vender-->
    <form method="post" action="vender" class="ed-container web-60 contact-form">
        <div class="ed-item web-30">
            <label for="nombre">Nombres y apellidos</label>
        </div>
        <div class="ed-item web-70">
            <input type="text" name="nombre" id="nombre">
        </div>
        <div class="ed-item web-30">
            <label for="direccion">Dirección completa</label>
        </div>
        <div class="ed-item web-70">
            <input type="text" name="direccion" id="direccion">
        </div>
        <div class="ed-item">
            <button class="boton icon-cart espacio product__page__buy">Confirmar Compra</button>
        </div>
    </form>
  </div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>