<%-- 
    Document   : getSetPropertyTest
    Created on : 27/03/2018, 11:24:53
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>getProperty ans setProperty</title>
    </head>
    <body>
        <h1>Using getter and setter Properties!</h1>
        <jsp:useBean id="employee" class="jspdemo.Employee"/>
        <jsp:setProperty name="employee" property="firstName" value="Abigail"/>
        First Name: <jsp:getProperty name="employee" property="firstName"/>
    </body>
</html>
