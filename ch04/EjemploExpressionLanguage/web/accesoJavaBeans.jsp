<%-- 
    Document   : accesoJavaBeans
    Created on : 02/08/2018, 17:49:02
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso a JavaBeans</title>
    </head>
    <body>
        <h1>Acceso a JavaBeans</h1>
        <!--Creamos un objeto Rectangulo de tipo JavaBeans. Como no se indica el scope, entonces se agrega el objeto al 
            scope = "page" por lo tanto solo se podra utilizar el objeto en el JSP y fuera del Jsp se destruye la variable-->
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" />
       <!--asignamos los valores del formulario al JavaBean-->
       <jsp:setProperty name="rectangulo" property="base" param="base" />
       <jsp:setProperty name="rectangulo" property="altura" param="altura" />
       <br/>
       <!--Utilizamos Expression Language del JavaBean rectangulo inicializado. Implicitamente se llama a los metodos get
           del objeto por tanto no es necesario indicar el metodo getBase, getAltura, getArea-->
       Valor Base: ${rectangulo.base} 
       <br/>
       Valor Altura: ${rectangulo.altura}
       <br/>
       <!--Accedemos al metodo area del objeto rectangulo-->
       Valor Area: ${rectangulo.area}
       <br/>
       <!--Otro metodo no recomendado pero posible-->
       Calculo del area: ${rectangulo.base * rectangulo.altura}
       <br/>
       <br/>
       <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
