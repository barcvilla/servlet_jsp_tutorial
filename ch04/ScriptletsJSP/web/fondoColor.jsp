<%-- 
    Document   : fondoColor
    Created on : 30/07/2018, 13:08:00
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--Scriptlet que recupera el parametro colorFondo enviado desde el index.html--%>
<%
    String fondo = request.getParameter("colorFondo");
    // si no se envio un color, asignamos un color por defecto
    if(fondo == null || fondo.equals(""))
    {
        fondo = "white";
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Color de Fondo</title>
    </head>
    <body bgcolor="<%= fondo%>">
        <h1>Color de Fondo aplicado: <%= fondo%></h1>
        <br/>
        <a href="index.html">regresar al index</a>
    </body>
</html>
