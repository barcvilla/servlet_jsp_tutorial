<%-- 
    Document   : setterParamAllJsp
    Created on : 02/08/2018, 10:50:36
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un JavaBean por Par&aacute;metros</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean por Par&aacute;metros</h1>
        <!--Declaramos el JavaBean a utilizar-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <!--Modificamos todas las propiedades cuyo parametro coincida con el nombre de la propiedad-->
        <jsp:setProperty name="rectangulo" property="*" />
        Se modificaron todos los atributos:
        <br/>
        <br/>
        Nuevo valor base: <%= request.getParameter("base")%>
        <br/>
        Nuevo valor altura: <%=request.getParameter("altura")%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
