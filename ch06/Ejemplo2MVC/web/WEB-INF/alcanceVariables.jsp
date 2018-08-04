<%-- 
    Document   : alcanceVariables
    Created on : 04/08/2018, 12:12:25
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br/>
        Variable request:
        Base: ${rectanguloRequest.base}
        Altura: ${rectanguloRequest.altura}
        Area: ${rectanguloRequest.area}
        <br/>
        <br/>
        Variable Session:
        Base: ${rectanguloSession.base}
        Altura: ${rectanguloSession.altura}
        Area: ${rectanguloSession.area}
        <br/>
        <br/>
        Variable Application:
        Base: ${rectanguloApplication.base}
        Altura: ${rectanguloApplication.altura}
        Area: ${rectanguloApplication.area}
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
