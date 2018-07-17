<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Bienvenidos" />
</jsp:include>

<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="inicio" />
</jsp:include>

<div class="l-slider">
  <div class="ed-container">
    <div class="ed-item">
      <img src="img/banner.jpg"/>
    </div>
  </div>
</div>

<div class="l-main ed-container">
  <div class="ed-item">
    <h2 class="sociales__title">Síguenos y enterate de más</h2>
    <div class="sociales">
        <a href="http://facebook.com" class="icon-facebook"></a>
        <a href="http://twitter.com" class="icon-twitter"></a>
        <a href="http://instagram.com" class="icon-instagram"></a>
        <a href="http://pinterest.com" class="icon-pinterest"></a>
    </div>
  </div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>
