/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import duoc.cl.dej4501.DejMobile.Dto.ClienteComunasDTO;
import duoc.cl.dej4501.DejMobile.Dto.ClienteDTO;
import duoc.cl.dej4501.DejMobile.Entity.Cliente;
import duoc.cl.dej4501.DejMobile.Entity.Comunas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteSessionBeans {

    @PersistenceContext(unitName = "proyectoMobilePU")
    private EntityManager em;
    
    public void addCliente(ClienteDTO clienteDTO) throws ControladorExceptions{
        Cliente infoCliente = new Cliente();
        infoCliente.setRutCliente(clienteDTO.getRutCliente());
        infoCliente.setClave(clienteDTO.getClave());
        infoCliente.setNombre(clienteDTO.getNombre());
        infoCliente.setApellidoPaterno(clienteDTO.getApellidoPaterno());
        infoCliente.setApellidoMaterno(clienteDTO.getApellidoMaterno());
        infoCliente.setDireccion(clienteDTO.getDireccion());
        infoCliente.setNumeracion(clienteDTO.getNumeracion());
        Comunas infoComunasEntidad = em.find(Comunas.class, clienteDTO.getIdComuna());
        infoCliente.setIdComuna(infoComunasEntidad);
        infoCliente.setTelefono(clienteDTO.getTelefono());
        em.persist(infoCliente);
        
    }
    public ClienteComunasDTO ClienteValidaLogin(String rut, String clave){
        ClienteComunasDTO infoClienteComunasDTO=null;
        try{
            infoClienteComunasDTO=em.createNamedQuery("Cliente.validar",ClienteComunasDTO.class)
                    .setParameter("rutCliente",rut)
                    .setParameter("clave",clave)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoClienteComunasDTO;                
    }

    public boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public Cliente buscaUsuarioXRut(String rut){
        Cliente infoCliente=null;
        try{
            infoCliente=em.createNamedQuery("Cliente.findByRutCliente",Cliente.class)
                    .setParameter("rutCliente",rut)
                    .getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(NonUniqueResultException ex){
            throw ex;
        }
        return infoCliente;
    }
}
