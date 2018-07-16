<%-- 
    Document   : listado-excel
    Created on : 16/07/2018, 13:33:55
    Author     : PC
--%>

<%
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=utf-8");
    response.setHeader("Content-Disposition", "attachment; filename=listado.xml");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Excel</h1>
        <table>
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Pedro</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Mario</td>
                    <td>25</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Juan</td>
                    <td>28</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
