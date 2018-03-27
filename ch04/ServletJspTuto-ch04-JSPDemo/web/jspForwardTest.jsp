<%-- 
    Document   : jspForwardTest
    Created on : 27/03/2018, 12:16:30
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forward action</title>
    </head>
    <body>
        <h1>Working with Forward action!</h1>
        <jsp:forward page="jspf/login.jsp">
            <jsp:param name="text" value="Please login"/>
        </jsp:forward>
    </body>
</html>
