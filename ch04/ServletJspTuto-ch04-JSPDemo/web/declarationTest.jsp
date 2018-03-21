<%-- 
    Document   : declarationTest
    Created on : 21/03/2018, 12:19:35
    Author     : barcvilla
--%>
<%--Podemos declarar variables y metodos que puede ser usados en las pagina JSP. Una declaracion
    puede aparecer en cualquier lugar de la pagina JSP y puede tener multiples declaraciones.--%>
<%!
    public java.util.Date getTodaysDate()
    {
        return new java.util.Date();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usign Declarations in JSP Page</title>
    </head>
    <body>
        <h1>Today is <%=getTodaysDate()%></h1>
    </body>
</html>
