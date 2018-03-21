<%-- 
    Document   : implicitObjects
    Created on : 21/03/2018, 10:01:44
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using JSP Implicit Objects</title>
    </head>
    <body>
        <b>Http headers:</b><br/>
        <%
            for(Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();)
            {
                String header = e.nextElement();
                out.println(header + ": " + request.getHeader(header) + "<br/> ");
            }
        %>
        <hr/>
        <%
            out.println("Buffer size: " + response.getBufferSize() + "<br/>");
            out.println("Session id: " + session.getId() + "<br/>");
            out.println("Servlet name: " + config.getServletName() + "<br/>");
            out.println("Server info: " + application.getServerInfo());
        %>
    </body>
</html>
