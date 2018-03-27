<%-- 
    La accion include se utiliza para incluir otro recurso dinamicamente. Podemos incluir otra pagina JSP
    servlet o pagina html static
    Document   : jspIncludeTest
    Created on : 27/03/2018, 11:50:33
    Author     : barcvilla
--%>
<%--
    Diferencia entre directiva include y la accion include. La directiva include, la inclusion ocurre en el tiempo
    de traduccion de la pagina. Por ejemplo, cuando el contenedor JSP traduce la pagina a un servlet generado.
    Con la accion include ocurre en tiempo de ejecucion. como, pasar parametro usando la accion include pero no la
    directiva include.
    La segunda diferencia  es que con la directiva include, la extension de archivo del recurso no importa. con la
    accion include, la extension del archivo debe ser jsp para ser procesado como una pagina JSP. Usando jspf en la
    accion include, por ejemplo, hara que el segmente JSP sera tratado como un archivo static
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Include action</title>
    </head>
    <body>
        <h1>Using Include!</h1>
        <jsp:include page="jspf/menu.jsp">
            <jsp:param name="text" value="How are you"/>
        </jsp:include>
    </body>
</html>
