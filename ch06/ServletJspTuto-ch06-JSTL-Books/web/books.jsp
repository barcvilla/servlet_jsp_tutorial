<%-- 
    Document   : books
    Created on : 23/05/2018, 11:41:17
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <style>
            table, tr, td
            {
                border: 1px solid brown;
            }
        </style>
    </head>
    <body>
        <h1>Books in simple Table</h1>
        <h2>Table con formato</h2>
        <table>
            <tr style="background: #ababff">
                <td>ISBN</td>
                <td>Title</td>
            </tr>
            <c:forEach items="${requestScope.books}" var="book" varStatus="status">
                <c:if test="${status.count%2 == 0}">
                    <tr style="background:#eeeeff">
                </c:if>
                <c:if test="${status.count%2 !=0}">
                    <tr style="background:#dedeff">
                </c:if>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
            </c:forEach>
        </table>
        <br/>
        ISBNs only:<br/>
        <c:forEach items="${requestScope.books}" var="book" varStatus="status">
            ${book.isbn}
            <c:if test="${!status.last}">
                
            </c:if>
            <br/>
        </c:forEach>
        <br/>
        <h2>Table sin formato</h2>
        <table>
            <tr>
                <td>ISBN</td>
                <td>Title</td>
            </tr>
            <c:forEach items="${requestScope.books}" var="book"> <!--usando forEach sin varStatus-->
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
