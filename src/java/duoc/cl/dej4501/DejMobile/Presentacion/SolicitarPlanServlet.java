/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;
import duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO;
import duoc.cl.dej4501.DejMobile.Dto.SolicitudClienteCuotaMinutosDTO;
import duoc.cl.dej4501.DejMobile.Dto.SolicitudDTO;
import duoc.cl.dej4501.DejMobile.Entity.Cliente;
import duoc.cl.dej4501.DejMobile.Entity.Cuota;
import duoc.cl.dej4501.DejMobile.Entity.Minutos;
import duoc.cl.dej4501.DejMobile.Entity.Solicitud;
import duoc.cl.dej4501.DejMobile.Persistencia.ClienteSessionBeans;
import duoc.cl.dej4501.DejMobile.Persistencia.CuotaSessionBeans;
import duoc.cl.dej4501.DejMobile.Persistencia.MinutosSessionBeans;
import duoc.cl.dej4501.DejMobile.Persistencia.SolicitudSessionBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SolicitarPlanServlet", urlPatterns = {"/solicitarPlanServlet" ,"/solicitarPlan"})
public class SolicitarPlanServlet extends HttpServlet {

    @EJB
    private MinutosSessionBeans objMinutosSessionBeans;
    @EJB
    private CuotaSessionBeans objCuotaSessionBeans;
    @EJB
    private ClienteSessionBeans objClienteSessionBeans;
    @EJB
    private SolicitudSessionBeans objSolicitudSessionBeans;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion =request.getSession();
        SolicitudClienteCuotaMinutosDTO infoSolicitudClienteCuotaMinutosDTO = (SolicitudClienteCuotaMinutosDTO)sesion.getAttribute("PlanAConfirmar");
        try {
            this.objSolicitudSessionBeans.addSolicitud(infoSolicitudClienteCuotaMinutosDTO);
            response.sendRedirect("MisPlanes.jsp");
        } catch (Exception e) {
            sesion.setAttribute("msgError", "Error al solicitar plan");
            response.sendRedirect("ConfirmarPlan.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion =request.getSession();
        ClienteComunasDTO clienteConectado=(ClienteComunasDTO)sesion.getAttribute("usuarioConectado");
        String rut = clienteConectado.getCliente().getRutCliente();
        Cliente infoCliente =this.objClienteSessionBeans.buscaUsuarioXRut(rut);
        int idCuota = Integer.parseInt(request.getParameter("ddlCuota"));
        Cuota infoCuota = this.objCuotaSessionBeans.buscaCuotaXId(idCuota);
        int idMinutos = Integer.parseInt(request.getParameter("rdbMinutos"));
        Minutos infoMinutos =this.objMinutosSessionBeans.buscaMinutosXId(idMinutos);
        String entrega = "si";
        if (entrega.equals(request.getParameter("chkEntrega"))) {
            entrega = "Chip se entregara a domicilio";
        }else{
            entrega = "Chip debe ser retirado en sucursal";
        }
        
        int total = infoCuota.getPrecioCuota()+infoMinutos.getPrecioMinutos();        
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yy H:mm:ss"); 
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH)+1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int seg = calendario.get(Calendar.SECOND);
        String fechaCompra = String.valueOf(mes)+"/"+String.valueOf(dia)+"/"+String.valueOf(ano)+" "+String.valueOf(hora)+":"+String.valueOf(min)+":"+String.valueOf(seg);
         Date fecha = null;
        try {
            fecha = sd.parse(fechaCompra);
        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        
        SolicitudClienteCuotaMinutosDTO infoSolicitudClienteCuotaMinutosDTO = new SolicitudClienteCuotaMinutosDTO();
        
        try {
            infoSolicitudClienteCuotaMinutosDTO.setCliente(infoCliente);
            infoSolicitudClienteCuotaMinutosDTO.setCuota(infoCuota);
            infoSolicitudClienteCuotaMinutosDTO.setMinutos(infoMinutos);
            Solicitud infoSolicitud =new Solicitud();
            infoSolicitud.setEntrega(entrega);
            infoSolicitud.setFechaHora(fecha);
            infoSolicitud.setTotal(total);
            infoSolicitudClienteCuotaMinutosDTO.setSolicitud(infoSolicitud);
            sesion.setAttribute("PlanAConfirmar", infoSolicitudClienteCuotaMinutosDTO);
            response.sendRedirect("ConfirmarPlan.jsp");
        } catch (Exception ex) {
            sesion.setAttribute("msgError", "Error al solicitar plan");
            response.sendRedirect("RealizaPlan.jsp");
        }     

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
