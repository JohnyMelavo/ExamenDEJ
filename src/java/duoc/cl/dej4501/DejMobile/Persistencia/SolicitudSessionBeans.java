/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import duoc.cl.dej4501.DejMobile.Dto.SolicitudClienteCuotaMinutosDTO;
import duoc.cl.dej4501.DejMobile.Entity.Solicitud;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SolicitudSessionBeans {

    @PersistenceContext(unitName = "proyectoMobilePU")
    private EntityManager em;
    
    public void addSolicitud(SolicitudClienteCuotaMinutosDTO solicitud) throws ControladorExceptions{
        Solicitud infoSolicitud = new Solicitud();
        infoSolicitud.setRutCliente(solicitud.getCliente());
        infoSolicitud.setIdCuota(solicitud.getCuota());
        infoSolicitud.setIdMinutos(solicitud.getMinutos());
        infoSolicitud.setEntrega(solicitud.getSolicitud().getEntrega());
        infoSolicitud.setFechaHora(solicitud.getSolicitud().getFechaHora());
        infoSolicitud.setTotal(solicitud.getSolicitud().getTotal());
        em.persist(infoSolicitud);
        
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SolicitudClienteCuotaMinutosDTO>getSolicitudesXRut(String rut){
        return em.createNamedQuery("Solicitud.GetPlanesXRut",SolicitudClienteCuotaMinutosDTO.class)
                .setParameter("rutCliente",rut)
                .getResultList();
    }
}
