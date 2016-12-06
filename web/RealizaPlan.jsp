<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>        
            <c:when test="${sessionScope.usuarioConectado==null}">
                <jsp:forward page="Login.jsp"/>
            </c:when>
            <c:otherwise>
                <h1>Arma tu Plan :: Paso 1</h1>
                <jsp:include page="./listarCuota" flush="true"/>
                <jsp:include page="./listarMinutos" flush="true"/>
                <jsp:useBean id="cuota" class="duoc.cl.dej4501.DejMobile.Entity.Cuota" scope="page"/>
                <jsp:useBean id="minutos" class="duoc.cl.dej4501.DejMobile.Entity.Minutos" scope="page"/>
                <fieldset><legend>Plan</legend>
                    <form name="formPaso1" method="post" action="./solicitarPlan">
                        <table>
                            <tr>
                                <td>Cuota</td>
                                <td><select name="ddlCuota" required>
                                        <option value="0">--Seleccione--</option>
                                        <c:forEach items="${listaCuota}" var="cuota">
                                            <option value="${cuota.idCuota}"><c:out value="${cuota.descripcionCuota}"/></option>
                                        </c:forEach>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Minutos</td>
                                <td >
                                    <c:forEach items="${listaMinutos}" var="minutos">

                                        <input type="radio" name="rdbMinutos" value="${minutos.idMinutos}" required><c:out value="${minutos.descripcionMinutos}"/>

                                        <br/>

                                    </c:forEach>
                                    <input type="checkbox" name="chkEntrega" value="si" /><c:out value="Entrega del Chip en domicilio"/>

                                </td>
                            </tr>
                            <tr>
                                <td>

                                </td>
                            </tr>
                            <tr>
                                <td><a href="Menu.jsp">Volver</a></td>
                                <td><input type="submit" name="btnPaso2" value="Paso 2" /></td>

                            </tr>
                        </table>
                    </form>
                </fieldset>
            </c:otherwise>
        </c:choose>

    </body>
</html>
