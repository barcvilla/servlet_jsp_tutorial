<%-- 
    Document   : recursoPrivado
    Created on : 01/08/2018, 23:38:57
    Author     : PC
--%>
<%
    String colorFondo = request.getParameter("colorFondo");
    if(colorFondo == null || colorFondo.trim().equals(""))
    {
        colorFondo = "white"; // establecemos valor por default
    }
%>
<%--Aplicamos una expresion en el body--%>
<body bgcolor="<%= colorFondo%>">
    Despliegue del contenido desde una JSP privado en la carperta WEB-INF
</body>