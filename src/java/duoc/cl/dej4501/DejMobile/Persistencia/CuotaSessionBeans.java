/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import duoc.cl.dej4501.DejMobile.Entity.Cuota;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class CuotaSessionBeans {

    @PersistenceContext(unitName = "proyectoMobilePU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Cuota>getAllCuota(){
        return em.createNamedQuery("Cuota.findAll",Cuota.class)
                .getResultList();
    }
    
    public Cuota buscaCuotaXId(int id){
        Cuota infoCuota=null;
        try{
            infoCuota=em.createNamedQuery("Cuota.findByIdCuota",Cuota.class)
                    .setParameter("idCuota",id)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoCuota;
    }
}
