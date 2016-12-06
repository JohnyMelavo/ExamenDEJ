<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan a confirmar</title>
    </head>
    <body>
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="Login.jsp"/>
            </c:when>
            <c:otherwise>
                <h1>Solicitar Plan :: Paso2</h1>
                <jsp:useBean id="PlanAConfirmar" class="duoc.cl.dej4501.DejMobile.Dto.SolicitudClienteCuotaMinutosDTO" scope="session"/>

                <fieldset><legend>Confirmar Plan</legend>
                    <form name="formSolicitarPlan" method="get" action="./solicitarPlan">
                        <table>
                            <tr>
                                <td>${PlanAConfirmar.cuota.descripcionCuota}</td>
                            </tr>
                            <tr>
                                <td>${PlanAConfirmar.minutos.descripcionMinutos} Minutos</td>
                            </tr>
                            <tr>
                                <td>${PlanAConfirmar.solicitud.entrega}</td>
                            </tr>
                            <tr>
                                <td>Total: $ ${PlanAConfirmar.solicitud.total} Mensuales</td>
                            </tr>
                            <tr>
                                <td><a href="RealizaPlan.jsp">Volver</a> <input type="submit" name="btnSolicitarPlan" value="Solicitar Plan" /></td>
                            </tr>
                        </table>
                    </form>
                </fieldset>
                <br/>
                <h2><a href="Menu.jsp">Ir a Menu</a></h2>
            </c:otherwise>
        </c:choose>
    </body>
</html>
