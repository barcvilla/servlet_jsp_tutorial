<%-- 
    Document   : login
    Created on : 05/02/2014, 06:19:33 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrate</h1>
        <br>
        <form name="form1" action="${pageContext.request.contextPath}/ServletControlador" method="post">
           <!--enviamos un parametro oculto que indica la accion-->
           <input type="hidden" name="accion" value="login" />
            Usuario: <input type="text" name="usuarioP"  />
            <br>
            Password: <input type="text" name="passP" />
            <br>
            <input type="submit" value="Entrar" />
        </form>
    </body>
</html>
