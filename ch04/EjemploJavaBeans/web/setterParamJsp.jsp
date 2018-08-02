<%-- 
    Document   : setterParamJsp
    Created on : 02/08/2018, 10:50:01
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un JavaBean por par&aacute;metros</title>
    </head>
    <body>
        <h1>JSP que modifica a un JavaBean por par&aacute;metros</h1>
        <!--Declaramos el JavaBean a utilizar-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificaci&oacute;n de los atributos: 
        <br/>
        <br/>
        <!--especificamos el parametro traido del index.jsp. En lugar de usar el atrbuto value, usamos el atributo param-->
        <jsp:setProperty name="rectangulo" property="base" param="baseParam" />
        Nuevo valor base: <%=request.getParameter("baseParam")%>
        <br/>
        <jsp:setProperty name="rectangulo" property="altura" param="alturaParam" />
        Nuevo valor altura: <%=request.getParameter("alturaParam")%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
