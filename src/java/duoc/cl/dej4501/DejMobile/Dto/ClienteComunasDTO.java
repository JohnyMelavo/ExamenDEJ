/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Dto;

import duoc.cl.dej4501.DejMobile.Entity.Cliente;
import duoc.cl.dej4501.DejMobile.Entity.Comunas;
import java.io.Serializable;

public class ClienteComunasDTO implements Serializable{
    private Cliente cliente;
    private Comunas comuna;

    public ClienteComunasDTO() {
    }

    public ClienteComunasDTO(Cliente cliente, Comunas comuna) {
        this.cliente = cliente;
        this.comuna = comuna;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comunas getComuna() {
        return comuna;
    }

    public void setComuna(Comunas comuna) {
        this.comuna = comuna;
    }    
}
