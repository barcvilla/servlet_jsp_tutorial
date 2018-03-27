<%-- 
    Document   : errorHandler
    Created on : 27/03/2018, 12:33:42
    Author     : barcvilla
--%>
<%--Podemos hacer de una pagina jsp en una pagina de error usando el atributo isErrorPage de la directiva page--%>
<%@page isErrorPage="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Error Page</title>
    </head>
    <body>
        <h1>Error Page!</h1>
        An error has ocurred <br/>
        Error message:
        <%
            out.println(exception.toString());
            %>
    </body>
</html>
