<%-- 
    Document   : index
    Created on : 01/08/2018, 23:35:59
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Inclusi&oacute;n Din&aacute;mica</title>
    </head>
    <body>
        <br/>
        <!--Aplicamos una accion para una inclusion dinamica-->
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow" />
        </jsp:include>
        <br/>
        <jsp:include page="recursoPublico.jsp" />
    </body>
</html>
