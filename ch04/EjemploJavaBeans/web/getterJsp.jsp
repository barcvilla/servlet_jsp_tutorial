<%-- 
    Document   : getterJsp
    Created on : 02/08/2018, 10:49:29
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que lee valores del JavaBean</title>
    </head>
    <body>
        <h1>JSP que lee valores del JavaBean</h1>
        <!--Declaramos el JavaBean a utilizar, si ya existe un bean en la session llamado "rectangulo"
            regresa el mismo objeto y no se crea uno nuevo. Con el scope session significa que el bean estara
            disponible durante muchas peticiones.-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        <!--Recuperamos los valores y los desplegamos-->
        <br/>
        Valor Base: <jsp:getProperty name="rectangulo" property="base" />
        <br/>
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura" />
        <!--En este caso, no importa que la propiedad no exista en el JavaBean, solo con tener un metodo llamado getArea()
            es posible simular una propiedad y llamamos el metodo getArea()-->
        <br/>
        Valor &aacute;rea: <jsp:getProperty name="rectangulo" property="area" />
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
