<%-- 
    Document   : inc4
    Created on : 16/05/2018, 11:55:31
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--${cp=pageContext.request.contextPath}-->
        <img src="${cp=="/"? "" : cp}/image/image1.jpeg"/>
        <img src="${cp=="/"? "" : cp}/image/image2.jpeg"/>
    </body>
</html>
