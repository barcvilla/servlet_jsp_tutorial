<%@page import="java.util.List"%>
<%@page import="pe.escueladigital.dao.PSQLTalla"%>
<%@page import="pe.escueladigital.modelos.Producto"%>
<%@page import="pe.escueladigital.modelos.Talla"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    /*Obtenemos el producto que nos envia el servletProductoDetalle*/
    Producto producto = (Producto) request.getAttribute("producto");
    
    List<Talla> tallas = (List) request.getAttribute("listaTallas");
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="<%= producto.getNombre() %>" />
</jsp:include>

<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="productos" />
</jsp:include>

<div class="l-main ed-container">
  <div class="ed-item">
    <h1><%= producto.getNombre() %></h1>
    <div class="ed-container product__page">
      <div class="ed-item tablet-50">
          <img src="/EDTienda/<%= producto.getImagen() %>" class="product__page__img"/>
      </div>
      <div class="ed-item tablet-50 product__page__description">
          <p><%= producto.getDescripcion() %> </p>
          
          <!--Creamos un formulario que permite aniadir al carro. Usamos el metodo de envio post hacia un servlet con urlPattern 
              agregar-producto-->
          <form method="post" action="agregar-producto">
              <!--capturamos el id del producto que adicionaremos al carro-->
            <input type="hidden" name="idproducto" value="<%= producto.getId() %>">
            <div class="ed-container product__page__data">
              <div class="ed-item main-center">
                  <h3 class="product__page__size">
                      <label for="talla">Talla:</label>
                      <select id="talla" name="talla">
                        <% 
                            if (tallas != null) {
                                for(Talla talla : tallas) {
                        %>
                        
                        <option value="<%= talla.getId() %>"><%= talla.getNombre() %></option>
                        <%            
                                }
                            } 
                        %>
                      </select>
                  </h3>
              </div>
              <div class="ed-item main-center">
                <h3 class="product__page__color">Valor: $<%= producto.getValor() %></h3>
              </div>
              <div class="ed-item main-center">
                  <button class="boton icon-cart espacio product__page__buy">Añadir al Carro</button>
              </div>
              <div class="ed-item main-center product__page__share">
                <div class="sociales"><a href="http://facebook.com" class="icon-facebook"></a><a href="http://twitter.com" class="icon-twitter"></a><a href="http://instagram.com" class="icon-instagram"></a><a href="http://pinterest.com" class="icon-pinterest"></a></div>
              </div>
            </div>
              
          </form>  
            
      </div>
    </div>
  </div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>