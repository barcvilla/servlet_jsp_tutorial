<%-- 
    Document   : todaysDate
    Created on : 21/03/2018, 09:47:42
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Today's date</title>
    </head>
    <body>
        <%
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
            String s = dateFormat.format(new Date());
            out.println("Today is " + s);
        %>
    </body>
</html>
