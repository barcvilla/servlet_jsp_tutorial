<%--Indicamos el jsp de error que manejara las excepciones  que se produzcan en este jsp--%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date"%>
<%@page contentType="application/vnd.ms-excel" %>
<%
    //nombre del archivo
    String nombreArchivo = "reporte.xls";
    //cabecera de respuesta
    response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
%>

<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Report de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha Inicio</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <!--usamos nuestra clase conversiones-->
                <td><%= Conversiones.format("500") %></td> <!--Provocamos un error y en lugar de fecha enviamos un numero-->
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Pondremos en practica conceptos de la programacion Orientada a </td>
                <!--usamos nuestra clase conversiones-->
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
