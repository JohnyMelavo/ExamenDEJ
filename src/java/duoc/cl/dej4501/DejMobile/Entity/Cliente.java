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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cliente", catalog = "bdmobile", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name="Cliente.validar",
            query="SELECT NEW duoc.cl.dej4501.proyectoMobile.Dto.ClienteComunasDTO(c,c.idComuna)"
            +" FROM Cliente c where c.rutCliente = :rutCliente and c.clave = :clave"
    ),
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByRutCliente", query = "SELECT c FROM Cliente c WHERE c.rutCliente = :rutCliente"),
    @NamedQuery(name = "Cliente.findByClave", query = "SELECT c FROM Cliente c WHERE c.clave = :clave"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellidoPaterno", query = "SELECT c FROM Cliente c WHERE c.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Cliente.findByApellidoMaterno", query = "SELECT c FROM Cliente c WHERE c.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByNumeracion", query = "SELECT c FROM Cliente c WHERE c.numeracion = :numeracion"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numeracion", nullable = false)
    private int numeracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono", nullable = false)
    private int telefono;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "rut_cliente", nullable = false, length = 11)
    private String rutCliente;
    @Size(max = 100)
    @Column(name = "clave", length = 15)
    private String clave;
    @Size(max = 10)
    @Column(name = "nombre", length = 10)
    private String nombre;
    @Size(max = 15)
    @Column(name = "apellido_paterno", length = 15)
    private String apellidoPaterno;
    @Size(max = 25)
    @Column(name = "apellido_materno", length = 25)
    private String apellidoMaterno;
    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;
    @JoinColumn(name = "id_comuna", referencedColumnName = "id_comuna")
    @ManyToOne
    private Comunas idComuna;
    @OneToMany(mappedBy = "rutCliente")
    private List<Solicitud> solicitudList;

    public Cliente() {
    }

    public Cliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Comunas getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comunas idComuna) {
        this.idComuna = idComuna;
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
        hash += (rutCliente != null ? rutCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rutCliente == null && other.rutCliente != null) || (this.rutCliente != null && !this.rutCliente.equals(other.rutCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "duoc.cl.dej4501.proyectoMobile.Entity.Cliente[ rutCliente=" + rutCliente + " ]";
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
