<%-- 
    Document   : inc3
    Created on : 16/05/2018, 10:14:27
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="<c:url value="/image/image1.jpeg"/>"/>
        <img src="<c:url value="/image/image2.jpeg"/>"/>
    </body>
</html>
