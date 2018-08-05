<%-- 
    Document   : listado
    Created on : 05/02/2014, 06:19:39 PM
    Author     : Jorge
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Personas</h1>
        El usuario es : ${login}
        <br>
        <ul> <c:forEach varStatus="status" var="persona" items ="${lista.lista}" >
                <li>
                    ${status.count} -
                    Nombre: ${persona.nombre}
                    Apellido: ${persona.apellido}
                </li>
        </c:forEach>
        </ul>
    </body>
</html>
