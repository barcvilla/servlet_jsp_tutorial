<%-- 
    Document   : useBean
    Created on : 27/03/2018, 11:13:36
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using Bean</title>
    </head>
    <body>
        <h1>Working with Bean!</h1>
        <jsp:useBean id="today" class="java.util.Date"/>
        <%=today%>
    </body>
</html>
