<!-- Con esta directiva importamos la libreria de core JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <meta charset="UTF-8">
    <title>JSTL Core</title>
  </head>
  <body>
    <h1>JSTL Core</h1>

    <!-- Manipulacion Variables -->
    <c:set var="nombre" value="Ernesto" />
    Variable nombre: <c:out value="${nombre}" />

    <br>
    <br>

    Variable con c&oacute;digo html:
    <c:out value="<h1>Hola</h1>" escapeXml="true" />

    <br>
    <br>

    <!-- Codigo condicionado, uso del if -->
    <c:set var="bandera" value="true" />

    <c:if test="${bandera}" >
      La bandera es verdadera
    </c:if>

    <br>
    <!-- codigo condicionado, similar al switch -->
    <c:if test="${param.opcion != null}">
      <c:choose>
        <c:when test="${param.opcion == 1}">
          <br>
          Opcion 1 proporcionada
          <br>
        </c:when>
        <c:when test="${param.opcion == 2}">
          <br>
          Opcion 2 proporcionada
          <br>
        </c:when>
        <c:otherwise>
          <br>
          Opcion proporcionada desconocida: ${param.opcion}
          <br>
        </c:otherwise>
      </c:choose>
    </c:if>

    <!--Iteracion de un arreglo -->
    <%
        //Uso de Scriptlet
        //Craemos el arreglo con un scriplet (aunque no es buena practica)
        String[] nombres = {"Claudia", "Pedro", "Carlos", "Ana"};
        //Compartimos el arreglo de nombres
        //en el alcance (scope) de request
        request.setAttribute("nombres", nombres);
    %>

    <br>
    Lista de Nombres en el arreglo:
    <br>
    <ul>
      <c:forEach varStatus="status" var="persona" items="${nombres}">
        <li>${status.count} - Nombre: ${persona}</li>
      </c:forEach>
    </ul>

    <br>
    <a href="index.jsp">Regresar al Inicio</a>
  </body>
</html>
