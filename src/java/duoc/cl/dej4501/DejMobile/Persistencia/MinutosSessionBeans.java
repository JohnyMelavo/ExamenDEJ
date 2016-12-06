/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import duoc.cl.dej4501.DejMobile.Entity.Minutos;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class MinutosSessionBeans {

    @PersistenceContext(unitName = "proyectoMobilePU")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Minutos>getAllMinutos(){
        return em.createNamedQuery("Minutos.findAll",Minutos.class)
                .getResultList();
    }
    
    public Minutos buscaMinutosXId(int id){
        Minutos infoMinutos=null;
        try{
            infoMinutos=em.createNamedQuery("Minutos.findByIdMinutos",Minutos.class)
                    .setParameter("idMinutos",id)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoMinutos;
    }
}
