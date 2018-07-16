<%-- 
    Document   : nosotros
    Created on : 11/07/2018, 17:01:01
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            nav{
                background-color: #333;
            }
            nav ul li{
                display: inline-block;
            }
            nav ul li a{
                color: #eee;
                text-decoration: none;
            }
            .seleccionado{
                background-color: white;
                color: black;
            }
        </style>
    </head>
    <body>
        <jsp:include page="WEB-INF/partials-dinamic/menu-navegacion.jsp">
            <jsp:param name="pagina" value="nosotros"></jsp:param>
        </jsp:include>        
        <h1>Aqui explicamos quienes somos</h1>
        <%@include file="WEB-INF/partials-static/footer.jsp" %>
    </body>
</html>
