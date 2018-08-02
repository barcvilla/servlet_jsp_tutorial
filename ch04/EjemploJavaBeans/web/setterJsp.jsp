<%-- 
    Document   : setterJsp
    Created on : 02/08/2018, 10:49:38
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica las propiedades del JavaBean</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean</h1>
        <!--declaramos un JavaBean a utilizar. El alcance de la variable es de tipo session.
            Esto significa que si encuentra una variable rectangulo en el alcance session lo utiliza y ya no crea
            un nuevo objeto rectangulo de lo contrario lo crea-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificamos los atributos:
        <br/>
        <br/>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        Nuevo valor Base: <%=baseValor%>
        <br/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        Nuevo valor Altura: <%=alturaValor%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Index</a>
    </body>
</html>
