<%-- 
    Document   : index
    Created on : 02/08/2018, 17:48:11
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Expression Lanuage</title>
    </head>
    <body>
        <h1>Ejemplo Expression Language</h1>
        <br/>
        <a href="variablesImplicitas.jsp?usuario=juan">Objetos impl&iacute;citos con Expression Language</a>
        <br/>
        <br/>
        <!--Entramos al JSP que accede al JavaBean-->
        Formulario HTML:
        <br>
        <form name="form1" action="accesoJavaBeans.jsp">
            Base: <input type="text" name="base" />
            <br/>
            Altura: <input type="text" name="altura" />
            <br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
