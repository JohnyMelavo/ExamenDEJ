<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Planes</title>
    </head>
    <body>
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="Login.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:useBean id="usuarioConectado" class="duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO" scope="session"/>
                <jsp:useBean id="planes" class="duoc.cl.dej4501.DejMobile.Dto.SolicitudClienteCuotaMinutosDTO" scope="session"/>
                <p style="text-align: end"> Bienvenido(a) <c:out value="${usuarioConectado.cliente.nombre} ${usuarioConectado.cliente.apellidoPaterno} ${usuarioConectado.cliente.apellidoMaterno}"></c:out> | <a href="./cerrarSesion">Cerrar Session</a></p>
                <HR width=100%>
                <jsp:include page="./listarPlanesXRut" flush="true"/>
                <h1>Mis Planes</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Gigas</th>
                            <th>Minutos</th>
                            <th>Entrega de Chip</th>
                            <th>Telefono</th>
                            <th>Comuna</th>
                            <th>Ingreso</th>
                            <th>Total</th>

                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listaPlanes}" var="planes">
                            <tr>
                                <td><c:out value="${planes.solicitud.idSolicitud}"/></td>  
                                <td><c:out value="${planes.cuota.descripcionCuota}"/></td>  
                                <td><c:out value="${planes.minutos.descripcionMinutos}"/></td> 
                                <td>
                                    <c:if test="${planes.solicitud.entrega.length()==28}"><c:out value="${planes.cliente.direccion} #${planes.cliente.numeracion}"/> </c:if>
                                    <c:if test="${planes.solicitud.entrega.length()==27}"><c:out value="Retiro en Sucursal"/> </c:if>
                                </td>  
                                <td><c:out value="${planes.cliente.telefono}"/></td>  
                                <td><c:out value="${planes.cliente.idComuna.nombreComuna}"/></td>  
                                <td><c:out value="${planes.solicitud.fechaHora.month+1}-${planes.solicitud.fechaHora.date}-${planes.solicitud.fechaHora.year+1900} ${planes.solicitud.fechaHora.hours}:${planes.solicitud.fechaHora.minutes}:${planes.solicitud.fechaHora.seconds}"/></td>  
                                <td><c:out value="$${planes.solicitud.total}"/></td>  


                            </tr>
                        </c:forEach>
                    </tbody>
                </table>   
                <br/>
                <a href="Menu.jsp">Volver</a>
                <c:remove var="listaPlanes"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
