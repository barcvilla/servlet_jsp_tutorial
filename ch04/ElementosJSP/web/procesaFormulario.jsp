<%-- 
    Document   : procesaFormulario
    Created on : 29/07/2018, 21:01:34
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de Procesar Formluario</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br/>
        Password: <%= request.getParameter("password") %>
        <br/>
        <br/>
        <a href="index.html">regresar al inicio</a>
    </body>
</html>
