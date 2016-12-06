/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "minutos", catalog = "bdmobile", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minutos.findAll", query = "SELECT m FROM Minutos m"),
    @NamedQuery(name = "Minutos.findByIdMinutos", query = "SELECT m FROM Minutos m WHERE m.idMinutos = :idMinutos"),
    @NamedQuery(name = "Minutos.findByDescripcionMinutos", query = "SELECT m FROM Minutos m WHERE m.descripcionMinutos = :descripcionMinutos"),
    @NamedQuery(name = "Minutos.findByPrecioMinutos", query = "SELECT m FROM Minutos m WHERE m.precioMinutos = :precioMinutos")})
public class Minutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_minutos", nullable = false)
    private Integer idMinutos;
    @Size(max = 35)
    @Column(name = "descripcion_minutos", length = 35)
    private String descripcionMinutos;
    @Column(name = "precio_minutos")
    private Integer precioMinutos;
    @OneToMany(mappedBy = "idMinutos")
    private List<Solicitud> solicitudList;

    public Minutos() {
    }

    public Minutos(Integer idMinutos) {
        this.idMinutos = idMinutos;
    }

    public Integer getIdMinutos() {
        return idMinutos;
    }

    public void setIdMinutos(Integer idMinutos) {
        this.idMinutos = idMinutos;
    }

    public String getDescripcionMinutos() {
        return descripcionMinutos;
    }

    public void setDescripcionMinutos(String descripcionMinutos) {
        this.descripcionMinutos = descripcionMinutos;
    }

    public Integer getPrecioMinutos() {
        return precioMinutos;
    }

    public void setPrecioMinutos(Integer precioMinutos) {
        this.precioMinutos = precioMinutos;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMinutos != null ? idMinutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Minutos)) {
            return false;
        }
        Minutos other = (Minutos) object;
        if ((this.idMinutos == null && other.idMinutos != null) || (this.idMinutos != null && !this.idMinutos.equals(other.idMinutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.dej4501.proyectoMobile.Entity.Minutos[ idMinutos=" + idMinutos + " ]";
    }
    
}
