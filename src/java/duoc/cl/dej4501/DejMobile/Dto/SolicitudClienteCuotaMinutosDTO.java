/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Dto;

import duoc.cl.dej4501.DejMobile.Entity.Cliente;
import duoc.cl.dej4501.DejMobile.Entity.Cuota;
import duoc.cl.dej4501.DejMobile.Entity.Minutos;
import duoc.cl.dej4501.DejMobile.Entity.Solicitud;
import java.io.Serializable;


public class SolicitudClienteCuotaMinutosDTO implements Serializable{
    private Solicitud solicitud;
    private Cliente cliente;
    private Cuota cuota;
    private Minutos minutos;

    public SolicitudClienteCuotaMinutosDTO() {
    }

    public SolicitudClienteCuotaMinutosDTO(Solicitud solicitud, Cliente cliente, Cuota cuota, Minutos minutos) {
        this.solicitud = solicitud;
        this.cliente = cliente;
        this.cuota = cuota;
        this.minutos = minutos;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }

    public Minutos getMinutos() {
        return minutos;
    }

    public void setMinutos(Minutos minutos) {
        this.minutos = minutos;
    }
    
    
}
