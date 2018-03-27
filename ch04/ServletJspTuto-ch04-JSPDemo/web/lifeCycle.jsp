<%-- 
    Document   : lifeCycle
    Created on : 27/03/2018, 10:34:19
    Author     : barcvilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    /*este metodo es similar a init() en javax.servlet.Servlet.jspInit es invocado cuando la pagina JSP
      es inicializado. A diferencia de init(), jspInit no toma argumentos. Podemos obtener el objeto
      ServletConfig a traves del objeto implicito config*/
    public void jspInit()
    {
        System.out.println("jspInt ...");
    }

    /*este metodo es similar a destroy en Servlet y es invocado cuando la pagina JSP va ser destrida*/
    public void jspDestroy()
    {
        System.out.println("jspDestroy ...");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jspInit and jspDestroy</title>
    </head>
    <body>
        <h1>Override jspInit and jspDestroy!</h1>
    </body>
</html>
