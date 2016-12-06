<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Dej Mobile</h1>
        <fieldset><legend>Acceso</legend>
            <form name="formValidarUsuario" method="post" action="./validaUsuario">
                <table>
                    <tr>
                        <td>Rut:</td>
                        <td><input type="text" name="txtRut" required/></td>
                    </tr>
                    <tr>
                        <td>Clave:</td>
                        <td><input type="password" name="txtClave" required/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="btnEnviar" required/></td>
                    </tr>
               
                          <td><a href="RegistraCliente.jsp">Registrate</a></td>
                </table>
            </form>
            <c:if test="${sessionScope.msgError!=null}">
                <c:out  value="${msgError}"></c:out>
                <c:remove var="msgError"></c:remove>
            </c:if>
        </fieldset>  
    </body>
</html>
