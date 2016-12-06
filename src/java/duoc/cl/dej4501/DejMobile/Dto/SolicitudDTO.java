/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Dto;

import java.io.Serializable;
import java.util.Date;

public class SolicitudDTO implements Serializable{
    private int idSolicitud;
    private String rutCliente;
    private int idCuota;
    private int idMinutos;
    private String entrega;
    private int total;
    private Date fechaHora;

    public SolicitudDTO() {
    }

    public SolicitudDTO(int idSolicitud, String rutCliente, int idCuota, int idMinutos, String entrega, int total, Date fechaHora) {
        this.idSolicitud = idSolicitud;
        this.rutCliente = rutCliente;
        this.idCuota = idCuota;
        this.idMinutos = idMinutos;
        this.entrega = entrega;
        this.total = total;
        this.fechaHora = fechaHora;
    }
    public SolicitudDTO(String rutCliente, int idCuota, int idMinutos, String entrega, int total, Date fechaHora) {
        this.rutCliente = rutCliente;
        this.idCuota = idCuota;
        this.idMinutos = idMinutos;
        this.entrega = entrega;
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public int getIdMinutos() {
        return idMinutos;
    }

    public void setIdMinutos(int idMinutos) {
        this.idMinutos = idMinutos;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    

    
    
    
    
}
