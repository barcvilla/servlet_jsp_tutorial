<%-- 
    Document   : productos
    Created on : 17/07/2018, 09:38:36
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="pe.escueladigital.modelos.Producto"%>

<%
    /*Traemos el atributo (listadoProductos) que nos envia el ServletProductos*/
    List<Producto> listado = (List) request.getAttribute("listadoProductos"); //aplicamos un cast y al objeto lo convertios en un List
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Productos" />
</jsp:include>


<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="productos" />
</jsp:include>

<div class="l-main ed-container">
  <div class="ed-item">
    <h2 class="productos__title">Productos destacados</h2>
    <div class="productos-container">
      <div class="productos">
<%
    if (listado != null) {
        /*aplicamos un for each para recorrer el listado enviado desde el ServletProductos*/
        for(Producto producto : listado) {
%>
        <div class="producto">
            <h3 class="producto__title"><%= producto.getNombre() %></h3>
            <a href="producto-detalle?id=<%= producto.getId() %>">
                <img src="<%= producto.getImagen() %>" title="Camiseta" class="producto__img">
            </a>
            <p class="producto__price icon-cart">$<%= producto.getValor() %></p>
        </div>
<%
        }
    }
%>
      </div>
    </div>
  </div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>
