<%-- 
    Document   : scriptlets
    Created on : 30/07/2018, 13:08:22
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriplets</h1>
        <br/>
        <!--Scriptlet para enviar informacion al navegador-->
        <% out.println("Saludos desde un Scriptlet"); %>
        <br/>
        <%
            String nombreAplicacion = request.getContextPath();
            out.println("Nombre de la Aplicacion: " + nombreAplicacion);
        %>
        <br/>
        <!--Scriptlet con codigo condicionado-->
        <%
            if(session != null && session.isNew()){
        %>
           La session si es nueva
        <%
            }
            else if(session != null){
        %>
            La session no es nueva
        <%
            }
        %>
    </body>
</html>
