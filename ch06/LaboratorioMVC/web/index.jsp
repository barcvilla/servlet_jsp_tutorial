<%-- 
    Document   : index
    Created on : 05/02/2014, 06:18:00 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laboratorio MVC</title>
    </head>
    <body>
        <h1>Laboratorio MVC</h1>
        <br>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listado">
            Link al servlet Controlador que lista a las personas</a>
        <br>
        <!--
         <a href="${pageContext.request.contextPath}/ServletControlador?accion=login">
            Registrate</a>
        <br>
        -->
    </body>
</html>
