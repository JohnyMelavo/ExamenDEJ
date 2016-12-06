/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import duoc.cl.dej4501.DejMobile.Entity.Comunas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ComunasSessionBeans {

    @PersistenceContext(unitName = "proyectoMobilePU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Comunas>getAllComunas(){
        return em.createNamedQuery("Comunas.findAll",Comunas.class)
                .getResultList();
    }
}
