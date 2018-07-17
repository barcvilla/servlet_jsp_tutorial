<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Nosotros" />
</jsp:include>

<jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
  <jsp:param name="item" value="nosotros" />
</jsp:include>

<div class="l-main ed-container">
<div class="ed-item">
  <div class="ed-container web-80">
    <div class="ed-item main-center">
      <h1>Nosotros</h1>
    </div>
    <div class="ed-item tablet-60 web-75">
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean egestas feugiat dolor. Quisque eget eros quis neque egestas ultricies. Aliquam porttitor metus ut egestas consequat. Nullam vel dui in justo scelerisque egestas. Cras non facilisis justo. Nunc in faucibus risus. Pellentesque felis diam, condimentum vitae mattis ut, sollicitudin a libero. Pellentesque malesuada pharetra justo, nec fringilla tortor adipiscing at. Maecenas accumsan, enim id mattis blandit, urna enim bibendum est, at volutpat massa neque vitae libero. Phasellus cursus leo hendrerit neque consequat gravida.</p>
    </div>
    <div class="ed-item tablet-40 web-25"><img src="img/css.jpg"/></div>
  </div>
</div>
</div>

<%@include file="WEB-INF/partials-static/footer.html" %>
