/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;

import duoc.cl.dej4501.DejMobile.Dto.ClienteDTO;
import duoc.cl.dej4501.DejMobile.Persistencia.ClienteSessionBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "RegistrarClienteServlet", urlPatterns = {"/registrarClienteServlet", "/registrarCliente"})
public class RegistrarClienteServlet extends HttpServlet {

    @EJB
    private ClienteSessionBeans objClienteSessionBeans;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String rut = request.getParameter("txtRut");
        if (objClienteSessionBeans.validarRut(rut) == false) {
            sesion.setAttribute("rutInvalidoMsg", "Rut ingresado no es valido");
            request.getRequestDispatcher("./RegistroCliente.jsp").forward(request, response);
        }
        if (objClienteSessionBeans.buscaUsuarioXRut(rut) != null) {
            sesion.setAttribute("rutInvalidoMsg", "Rut ingresado ya se encuentra en el sistema");
            request.getRequestDispatcher("./RegistroCliente.jsp").forward(request, response);

        }
        String clave = DigestUtils.md5Hex(request.getParameter("txtClave"));
        String confirmarClave = DigestUtils.md5Hex(request.getParameter("txtConfirmarClave"));
        if (clave.equals(confirmarClave) == false) {
            sesion.setAttribute("claveInvalidaMsg", "Password invalida");
            response.sendRedirect("RegistroCliente.jsp");
        }
        String nombre = request.getParameter("txtNombre");
        String apellidoPaterno = request.getParameter("txtApellidoPaterno");
        String apellidoMaterno = request.getParameter("txtApellidoMaterno");
        String direccion = request.getParameter("txtDireccion");
        int numeracion = Integer.parseInt(request.getParameter("txtNumeracion"));
        int comuna = Integer.parseInt(request.getParameter("ddlComuna"));
        int telefono = Integer.parseInt(request.getParameter("txtTelefono"));
        ClienteDTO infoClienteDTO = new ClienteDTO(rut, clave, nombre, apellidoPaterno, apellidoMaterno, direccion, numeracion, comuna, telefono);
        try {
            objClienteSessionBeans.addCliente(infoClienteDTO);
            sesion.setAttribute("msgCorrecto", "Cliente Ingresado de forma correcta");
            response.sendRedirect("Login.jsp");

        } catch (Exception ex) {
            sesion.setAttribute("msgError", "Cliente no pudo ingresar a la base de datos");
            response.sendRedirect("RegistroCliente.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
