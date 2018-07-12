<%-- 
    Document   : index
    Created on : 11/07/2018, 16:27:36
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
        <!--jsp:include nos sirve para incluir paginas dinamicas (jsp) a las cuales le podemos enviar parametros para su procesamiento-->
        <jsp:include page="WEB-INF/partials-dinamic/menu-navegacion.jsp">
            <jsp:param name="pagina" value="inicio"></jsp:param>
        </jsp:include>
        
        <h1>Hello World!</h1>
        
        
        <!--Creacion de un codigo java snipped dentro de una etiqueta html-->
        <div>Los snipped comienzan con &lt;%</div>
        <p>
            <%
                int a = 5, b = 4, c;
                c = a + b;
                out.print("El resultado de la suma a + b es: " + c);
            %>
        </p>
        
        <div>Las expresiones comienzan con &lt;%=</div>
        <div><%= c %></div>

        <!--@include nos permite incluir paginas estaticas (html puro)-->
        <%@include file="WEB-INF/partials-static/footer.html" %>

    </body>
</html>
