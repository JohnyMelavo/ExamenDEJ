/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;

import duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO;
import duoc.cl.dej4501.DejMobile.Dto.SolicitudClienteCuotaMinutosDTO;
import duoc.cl.dej4501.DejMobile.Persistencia.SolicitudSessionBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarPlanesPorRutServlet", urlPatterns = {"/listarPlanesXRutServlet","/listarPlanesXRut"})
public class ListarPlanesPorRutServlet extends HttpServlet {

    @EJB
    private SolicitudSessionBeans objSolicitudSessionBeans;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        ClienteComunasDTO infoCliente = (ClienteComunasDTO)sesion.getAttribute("usuarioConectado");
        List<SolicitudClienteCuotaMinutosDTO> listadoPlanes=this.objSolicitudSessionBeans.getSolicitudesXRut(infoCliente.getCliente().getRutCliente());
        sesion.setAttribute("listaPlanes", listadoPlanes);
  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
