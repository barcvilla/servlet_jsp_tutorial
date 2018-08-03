<%-- 
    Document   : variablesImplicitas
    Created on : 02/08/2018, 17:49:34
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL y Variables Implicitas</title>
    </head>
    <body>
        <h1>Expression Language y las Variables Implicitas en JSP</h1>
        <ul>
            <li>Nombre de la Aplicaci&oacute;n: ${pageContext.request.contextPath}</li>
            <li>Navegador del Cliente: ${header["User-Agent"]}</li>
            <li>Id Session: ${cookie.JSESSIONID.value}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor Par&aacute;metro: Usuario: ${param["usuario"]}</li>
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
