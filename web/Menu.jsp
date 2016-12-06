<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>       
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="Login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO" scope="session"/>
                <p style="text-align: end"> Bienvenido(a) <c:out value="${usuarioConectado.cliente.nombre} ${usuarioConectado.cliente.apellidoPaterno} ${usuarioConectado.cliente.apellidoMaterno}"></c:out> | <a href="./cerrarSesion">Cerrar Session</a></p>
                <HR width=100%>
                <h1>DEJ Mobile :: Menu</h1>
                <h1><a style="font-size: 24" href="RealizaPlan.jsp">Solicitar un Plan</a></h1>
                <h1><a style="font-size: 24" href="MisPlanes.jsp">Ver Mis Planes</a></h1>
            </c:otherwise>
        </c:choose>
    </body>
</html>
