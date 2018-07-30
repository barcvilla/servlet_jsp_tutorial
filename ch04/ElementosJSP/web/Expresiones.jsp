<%-- 
    Document   : Expresiones
    Created on : 29/07/2018, 21:01:11
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- directiva jsp --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP de Expresiones</title>
    </head>
    <body>
        <h1>JSP de Expresiones</h1>
        <%--agregamos una expresio que lleva la sintaxis <%= %>    
            Lo que coloquemos dentro de ella se enviara al objeto out.println(). Podemos incluir cadenas, concatenacion 
            y operaciones matematicas--%>
        Concatenaci&oacute;n <%= "Saludos " + "JSP" %>
        <br/>
        Operaci&oacute;n Matem&aacute;atica: <%= 2 * 3 / 2  %><br/>
        La Sesion creada es : <%= session.getId() %> <%-- regresa un valor a imprimir --%>
        <br/>
        <br/>
        <a href="index.html">regresar</a>
    </body>
</html>
