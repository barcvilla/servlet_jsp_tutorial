<%-- 
    Document   : scriptletTest
    Created on : 21/03/2018, 11:57:47
    Author     : barcvilla
--%>
<%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head><title>Scriptlet example</title></head>
<body>
<b>Http headers:</b><br/>
<%-- first scriptlet --%>
<%
    for (Enumeration<String> e = request.getHeaderNames(); 
            e.hasMoreElements(); ) {
        String header = e.nextElement();
        out.println(header + ": " + request.getHeader(header) + 
                "<br/>");
    }
    String message = "Thank you."; // la variable message es visible en el segundo scriptlet
%>
<hr/>
<%-- second scriptlet --%>
<%
    out.println(message + "<br/>");
%>
<%-- thrid scriptlet using Expressions--%>
Today is
<%
    out.print(java.util.Calendar.getInstance().getTime());
%>
</body>
</html>