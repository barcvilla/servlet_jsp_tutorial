

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Inclusion Estatica</title>
        <script type="text/JavaScript" src="recursos/funciones.js"></script>
        <link href="recursos/estilos.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>Inclusi&oacute;n de Archivos Est&aacute;ticos</h1>
        <!--Esto es por cada menu-->
        <br>
        <!--Menu Principal-->
        <span class="noticias" align="left">
            <a href="javascript:desplegar('noticias');"><!--cuando se hace clik en el link se mostrara el id="noticias"-->
                <img border="0" src="https://thumbs.dreamstime.com/b/icono-de-las-noticias-11187212.jpg">
            </a>
        </span> 
        <span id="noticias" class="ocultar_menu">
            <!--SubMenu-->
            <ul>
                <li>
                    <%@include file="pages/noticias1.html" %>
                </li>
                <li>
                    <%@include file="pages/noticias2.html" %>
                </li>
            </ul>
        </span>
        <br/>
        <!--otro Menu Principal-->
        <span class="videos" align="left">
            <a href="javascript:desplegar('videos');">
                <img border="0" src="http://www.politicaplus.com/images/playy.png">
            </a>
        </span>
        <span id="videos" class="ocultar_menu">
            <!--Sun Menu-->
            <ul>
                <li>
                    <%@include file="pages/video1.html" %>
                </li>
            </ul>
        </span>
    </body>
</html>
