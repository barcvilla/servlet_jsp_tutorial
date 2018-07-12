<%
    String pagina = request.getParameter("pagina");
%>

<nav>
    <ul>
        <li>
            <a href="/clase11/" class="<%out.print(pagina.equals("inicio") ? "seleccionado" : "");%>">Inicio</a>
        </li>
        <li>
            <a href="/clase11/nosotros.jsp" class="<%out.print(pagina.equals("nosotros") ? "seleccionado" : "");%>">Nosotros</a>
        </li>
    </ul>
</nav>
