/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "solicitud", catalog = "bdmobile", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name="Solicitud.GetPlanesXRut",
            query="SELECT NEW duoc.cl.dej4501.proyectoMobile.Dto.SolicitudClienteCuotaMinutosDTO(s,s.rutCliente,s.idCuota,s.idMinutos)"
            +" FROM Solicitud s where s.rutCliente.rutCliente = :rutCliente "
    ),
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByEntrega", query = "SELECT s FROM Solicitud s WHERE s.entrega = :entrega"),
    @NamedQuery(name = "Solicitud.findByTotal", query = "SELECT s FROM Solicitud s WHERE s.total = :total"),
    @NamedQuery(name = "Solicitud.findByFechaHora", query = "SELECT s FROM Solicitud s WHERE s.fechaHora = :fechaHora")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_solicitud", nullable = false)
    private Integer idSolicitud;
    @Size(max = 100)
    @Column(name = "entrega", length = 100)
    private String entrega;
    @Column(name = "total")
    private Integer total;
    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "rut_cliente", referencedColumnName = "rut_cliente")
    @ManyToOne
    private Cliente rutCliente;
    @JoinColumn(name = "id_cuota", referencedColumnName = "id_cuota")
    @ManyToOne
    private Cuota idCuota;
    @JoinColumn(name = "id_minutos", referencedColumnName = "id_minutos")
    @ManyToOne
    private Minutos idMinutos;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Cliente rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Cuota getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Cuota idCuota) {
        this.idCuota = idCuota;
    }

    public Minutos getIdMinutos() {
        return idMinutos;
    }

    public void setIdMinutos(Minutos idMinutos) {
        this.idMinutos = idMinutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.dej4501.proyectoMobile.Entity.Solicitud[ idComuna=" + idSolicitud + " ]";
    }
    
}
