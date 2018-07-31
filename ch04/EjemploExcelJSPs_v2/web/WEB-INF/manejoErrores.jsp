<%-- 
    Document   : manejoErrores
    Created on : 31/07/2018, 11:48:47
    Author     : PC
--%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
        <!--Mediante una expresiones obtenemos el nombre de la aplicacion-->
        <script type="text/javascript" src="<%=request.getContextPath()%>/recursos/funciones.js"></script>
    </head>
    <body>
        <h1>Manejo de Errores</h1>
        <br/>
        <br/>
        Ocurri&oacute; un error: 
        <%= exception.getMessage() %>        
        <br/>
        <br/>
        <a href="<%=request.getContextPath()%>/index.html">Regresar al inicio</a>
        <br/> 
        <br/>
        <a href="#" onclick="cambio('mensaje1')"> 
            Ver detalles
        </a>
        <div id="mensaje1" style="position:relative;visibility: hidden">
            <pre>
                <% exception.printStackTrace(new PrintWriter(out));%>
            </pre>
        </div>
    </body>
</html>
