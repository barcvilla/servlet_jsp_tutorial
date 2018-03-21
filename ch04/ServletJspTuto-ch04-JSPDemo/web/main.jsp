<%-- 
    Document   : main
    Created on : 21/03/2018, 11:22:04
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Including a file</title>
    </head>
    <body>
        <h1>This is the included content: </h1><hr/>
        <!--including externak file-->
        <%@include file="copyright.jsp" %>
    </body>
</html>
