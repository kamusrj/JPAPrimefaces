/*
 *  Kamus Curso java Insafor 2022
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamus
 */
@Entity
@Table(name = "CONTRIBUYENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribuyente.findAll", query = "SELECT c FROM Contribuyente c"),
    @NamedQuery(name = "Contribuyente.findByNoNit", query = "SELECT c FROM Contribuyente c WHERE c.noNit = :noNit"),
    @NamedQuery(name = "Contribuyente.findByNombreContribuyente", query = "SELECT c FROM Contribuyente c WHERE c.nombreContribuyente = :nombreContribuyente"),
    @NamedQuery(name = "Contribuyente.findByRazonSocial", query = "SELECT c FROM Contribuyente c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Contribuyente.findByRepresentanteLegal", query = "SELECT c FROM Contribuyente c WHERE c.representanteLegal = :representanteLegal"),
    @NamedQuery(name = "Contribuyente.findByRentaAnual", query = "SELECT c FROM Contribuyente c WHERE c.rentaAnual = :rentaAnual"),
    @NamedQuery(name = "Contribuyente.findByFechaRegistro", query = "SELECT c FROM Contribuyente c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Contribuyente.findByEstadoContribuyente", query = "SELECT c FROM Contribuyente c WHERE c.estadoContribuyente = :estadoContribuyente")})
public class Contribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NO_NIT")
    private String noNit;
    @Size(max = 50)
    @Column(name = "NOMBRE_CONTRIBUYENTE")
    private String nombreContribuyente;
    @Size(max = 100)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 50)
    @Column(name = "REPRESENTANTE_LEGAL")
    private String representanteLegal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RENTA_ANUAL")
    private BigDecimal rentaAnual;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 10)
    @Column(name = "ESTADO_CONTRIBUYENTE")
    private String estadoContribuyente;

    public Contribuyente() {
    }

    public Contribuyente(String noNit) {
        this.noNit = noNit;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreContribuyente() {
        return nombreContribuyente;
    }

    public void setNombreContribuyente(String nombreContribuyente) {
        this.nombreContribuyente = nombreContribuyente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public BigDecimal getRentaAnual() {
        return rentaAnual;
    }

    public void setRentaAnual(BigDecimal rentaAnual) {
        this.rentaAnual = rentaAnual;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoContribuyente() {
        return estadoContribuyente;
    }

    public void setEstadoContribuyente(String estadoContribuyente) {
        this.estadoContribuyente = estadoContribuyente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noNit != null ? noNit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contribuyente)) {
            return false;
        }
        Contribuyente other = (Contribuyente) object;
        if ((this.noNit == null && other.noNit != null) || (this.noNit != null && !this.noNit.equals(other.noNit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "basico.practica06.Contribuyente[ noNit=" + noNit + " ]";
    }
    
}
