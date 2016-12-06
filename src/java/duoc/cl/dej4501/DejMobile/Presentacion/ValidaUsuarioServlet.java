/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;
import duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO;
import duoc.cl.dej4501.DejMobile.Persistencia.ClienteSessionBeans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "ValidarUsuarioServlet", urlPatterns = {"/validarUsuarioServlet","/validarUsuario"})
public class ValidaUsuarioServlet extends HttpServlet {

    @EJB private ClienteSessionBeans objClienteSessionBeans;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String rut = request.getParameter("txtRut");
        String clave = DigestUtils.md5Hex(request.getParameter("txtClave"));
        ClienteComunasDTO infoClienteComunasDTO = this.objClienteSessionBeans.ClienteValidaLogin(rut, clave);
        if (infoClienteComunasDTO != null) {
            sesion.setAttribute("usuarioConectado", infoClienteComunasDTO);
            response.sendRedirect("Menu.jsp");
        } else {
            sesion.setAttribute("msgError", "Usuario y/o Clave incorrecta");
            response.sendRedirect("Login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
