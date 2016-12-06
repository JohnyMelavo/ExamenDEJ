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
@Table(name = "cuota", catalog = "bdmobile", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c"),
    @NamedQuery(name = "Cuota.findByIdCuota", query = "SELECT c FROM Cuota c WHERE c.idCuota = :idCuota"),
    @NamedQuery(name = "Cuota.findByDescripcionCuota", query = "SELECT c FROM Cuota c WHERE c.descripcionCuota = :descripcionCuota"),
    @NamedQuery(name = "Cuota.findByPrecioCuota", query = "SELECT c FROM Cuota c WHERE c.precioCuota = :precioCuota")})
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuota", nullable = false)
    private Integer idCuota;
    @Size(max = 35)
    @Column(name = "descripcion_cuota", length = 35)
    private String descripcionCuota;
    @Column(name = "precio_cuota")
    private Integer precioCuota;
    @OneToMany(mappedBy = "idCuota")
    private List<Solicitud> solicitudList;

    public Cuota() {
    }

    public Cuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public String getDescripcionCuota() {
        return descripcionCuota;
    }

    public void setDescripcionCuota(String descripcionCuota) {
        this.descripcionCuota = descripcionCuota;
    }

    public Integer getPrecioCuota() {
        return precioCuota;
    }

    public void setPrecioCuota(Integer precioCuota) {
        this.precioCuota = precioCuota;
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
        hash += (idCuota != null ? idCuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idCuota == null && other.idCuota != null) || (this.idCuota != null && !this.idCuota.equals(other.idCuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.dej4501.proyectoMobile.Entity.Cuota[ idCuota=" + idCuota + " ]";
    }
    
}
