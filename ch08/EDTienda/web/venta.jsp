<%@page import="pe.escueladigital.modelos.VentaDetalle"%>
<%@page import="pe.escueladigital.modelos.VentaEncabezado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    /*Recupero la venta que me envia el Servlet*/
    VentaEncabezado venta = (VentaEncabezado) request.getAttribute("venta");
    float total = 0f;
%>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Factura de Venta" />
</jsp:include>


<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="carro" />
</jsp:include>

<div class="l-main ed-container">
  <div class="ed-item">
      <div class="ed-container web-80">
        <div class="ed-item main-center">
            <h1>Factura de Venta</h1>
        </div>
      </div>
      <div class="ed-container offset-25 web-50 contact-form">
          <div class="ed-item web-30">
            <label for="factura">Factura Número:</label>
          </div>
          <div class="ed-item web-70">
            <input type="text" id="factura" readonly value="<%= venta.getId() %>">
          </div>
          <div class="ed-item web-30">
            <label for="fecha">Fecha:</label>
          </div>
          <div class="ed-item web-70">
            <input type="text" id="fecha" readonly value="<%= venta.getFecha() %>">
          </div>
          <div class="ed-item web-30">
            <label for="nombre">Nombre:</label>
          </div>
          <div class="ed-item web-70">
            <input type="text" id="nombre" readonly value="<%= venta.getNombre() %>">
          </div>
          <div class="ed-item web-30">
            <label for="direccion">Dirección:</label>
          </div>
          <div class="ed-item web-70">
            <input type="text" id="direccion" readonly value="<%= venta.getDireccion() %>">
          </div>
      </div>
          <!--Tabla donde volcamos los productos vendidos-->
      <div class="ed-item offset-20 web-60">
          <table class="listado">
              <thead>
                  <tr>
                      <th>Producto</th>
                      <th>Talla</th>
                      <th>Valor</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                      for (VentaDetalle detalle : venta.getDetalle()) {
                          total += detalle.getProducto().getValor();
                  %>
                  <tr>
                      <td><%= detalle.getProducto().getNombre() %></td>
                      <td><%= detalle.getProducto().getTalla().getNombre() %></td>
                      <td><%= detalle.getProducto().getValor() %></td>
                  </tr>
                  <%
                      }
                  %>
              </tbody>
              <tfoot>
                  <tr>
                      <td colspan="2" class="suma-label">Total</td>
                      <td class="suma"><%= total %></td>
                  </tr>
              </tfoot>
          </table>
      </div>
        <div class="ed-item offset-25 web-50">
            <form class="ed-item main-center" name="_xclick" target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <!-- <form class="ed-item main-center" name="_xclick" target="paypal" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post"> -->
                <input type="hidden" name="cmd" value="_xclick">
                <input type="hidden" name="business" value="edstyles-colombia@outlook.com">
                <input type="hidden" name="currency_code" value="USD">
                <input type="hidden" name="item_name" value="Factura: <%= venta.getId() %>">
                <input type="hidden" name="amount" value="<%= total %>">
                <!-- <input type="image" src="http://www.paypal.com/es_ES/i/btn/sc-but-01.gif" border="0" name="submit" alt="Make payments with PayPal - it's fast, free and secure!"> -->
                <input type="hidden" name="add" value="1">
                <input type="hidden" name="charset" value="utf-8">
                <input type="hidden" name="on0" value="Comprador">
                <input type="hidden" name="os0" value="<%= venta.getNombre() %>">
                <input type="hidden" name="on1" value="Direccion">
                <input type="hidden" name="os1" value="<%= venta.getDireccion() %>">
                <button type="submit" class="boton icon-cart espacio product__page__buy">
                    Pagar por Paypal
                </button>
            </form>
        </div>
  </div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>