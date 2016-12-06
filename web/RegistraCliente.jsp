<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Clientes</title>
    </head>
    <body>
        <h1>DEJ Mobile :: Registro</h1>

                <jsp:include page="./listarComunas" flush="true"/>
                <jsp:useBean id="comunas" class="duoc.cl.dej4501.DejMobile.Entity.Comunas" scope="page"/>
                <fieldset><legend>Registro</legend>
                    <form name="formRegistrarCliente" method="post" action="./registrarCliente">
                        <table>
                            <tr>
                                <td>Rut</td>
                                <td><input type="text" name="txtRut" placeholder="ejemplo de rut : 11111111-1" required/></td>
                                <td style="color: red"><c:if test="${sessionScope.rutInvalidoMsg!=null}">
                                        <c:out  value="${rutInvalidoMsg}"></c:out>
                                        <c:remove var="rutInvalidoMsg"></c:remove>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>Clave</td>
                                <td><input type="password" name="txtClave" required/></td>
                                <td style="color: red"><c:if test="${sessionScope.claveInvalidaMsg!=null}">
                                        <c:out  value="${claveInvalidaMsg}"></c:out>
                                        <c:remove var="claveInvalidaMsg"></c:remove>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>Confirmar Clave</td>
                                <td><input type="password" name="txtConfirmarClave" required/></td>
                            </tr>
                            <tr>
                                <td>Nombre</td>
                                <td><input type="text" name="txtNombre" required/></td>
                            </tr>
                            <tr>
                                <td>Apellido Paterno</td>
                                <td><input type="text" name="txtApellidoPaterno" required/></td>
                            </tr>
                            <tr>
                                <td>Apellido Materno</td>
                                <td><input type="text" name="txtApellidoMaterno" required/></td>
                            </tr>
                            <tr>
                                <td>Direccion</td>
                                <td><input type="text" name="txtDireccion" required/></td>
                            </tr>
                            <tr>
                                <td>Numeracion</td>
                                <td><input type="text" name="txtNumeracion" required/></td>
                            </tr>
                            <tr>
                                <td>Comuna</td>
                                <td><select name="ddlComuna">
                                        <option value="0">--Seleccione--</option>
                                        <c:forEach items="${listaComunas}" var="comunas">
                                            <option value="${comunas.idComuna}"><c:out value="${comunas.nombreComuna}"/></option>
                                        </c:forEach>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Telefono</td>
                                <td><input type="text" name="txtTelefono" required/></td>
                            </tr>
                            <tr>
                                <td><a href="Login.jsp">Volver</a></td>
                                <td><input type="submit" name="btnEnviar" value="Enviar" /></td>
                            </tr>
                        </table>
                    </form>
                    
                    <c:if test="${sessionScope.msgError!=null}">
                        <c:out  value="${msgError}"></c:out>
                        <c:remove var="msgError"></c:remove>
                    </c:if>
                    
                </fieldset>

        
        
    </body>
</html>
