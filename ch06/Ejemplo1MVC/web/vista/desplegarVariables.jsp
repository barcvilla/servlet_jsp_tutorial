<%-- 
    Document   : desplegarVariables
    Created on : 03/08/2018, 21:07:30
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en el alcance request: 
        <!--no es necesario indicar el alcance, automaticamente se busca la variable en el alcance page, request, session, application-->
        ${mensaje}
        <br/>
        <br/>
        Variable en alcance session:
        <br/>
        <!--Internamente se busca a los metodos getBase(), getAltura(), getArea()-->
        Rectangulo:
        Base: ${rectangulo.base}
        Altura: ${rectangulo.altura}
        Area: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
