<%-- 
    Document   : buggy
    Created on : 27/03/2018, 12:40:09
    Author     : barcvilla
--%>
<%@page errorPage="errorHanlder.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
Deliberadamente lanza una excepcion
<%
    Integer.parseInt("Throw me");
%>