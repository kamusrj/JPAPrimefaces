package ManagerBean;

import Dao.ContDAO;
import Entity.Contribuyente;
import java.math.BigDecimal;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kamus
 */
@ManagedBean
@RequestScoped
public class ConBean {

    private String noNit;
    private String nombreC;
    private String razonS;
    private String repre;
    private BigDecimal rentaAnual;
    private Date fechaReg;
    private String EstadoCont;
    private String msj;

    public ConBean() {
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getRazonS() {
        return razonS;
    }

    public void setRazonS(String razonS) {
        this.razonS = razonS;
    }

    public String getRepre() {
        return repre;
    }

    public void setRepre(String repre) {
        this.repre = repre;
    }

    public BigDecimal getRentaAnual() {
        return rentaAnual;
    }

    public void setRentaAnual(BigDecimal rentaAnual) {
        this.rentaAnual = rentaAnual;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getEstadoCont() {
        return EstadoCont;
    }

    public void setEstadoCont(String EstadoCont) {
        this.EstadoCont = EstadoCont;
    }

    //------------ CRUD ------------\\
    //------------ Guardar ------------\\
    public void saveC() {
        ContDAO cd = new ContDAO();
        Contribuyente c = new Contribuyente();
        if (cd.search(noNit) == null) {

            c.setNoNit(noNit);
            c.setNombreContribuyente(nombreC);
            c.setRazonSocial(razonS);
            c.setRepresentanteLegal(repre);
            c.setRentaAnual(rentaAnual);
            c.setFechaRegistro(fechaReg);
            c.setEstadoContribuyente(EstadoCont);

            cd.save(c);

            FacesMessage msg = new FacesMessage("Guardando datos...");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Contribuyente ya registrado");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

//------------ Buscar ------------\\
    public void search(String noNit) {

        ContDAO cd = new ContDAO();
        Contribuyente c = cd.search(noNit);
        if (c != null) {

            this.noNit = c.getNoNit();
            this.nombreC = c.getNombreContribuyente();
            this.razonS = c.getRazonSocial();
            this.repre = c.getRepresentanteLegal();
            this.rentaAnual = c.getRentaAnual();
            this.fechaReg = c.getFechaRegistro();

            FacesMessage msg = new FacesMessage("encontrado");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("Usuario no Encontrado");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    //------------ Actualizar ------------\\

    public void update() {

        ContDAO cd = new ContDAO();
        Contribuyente c = new Contribuyente();
        if (cd.search(noNit) != null) {
               
      
            
            cd.update(this.noNit, this.nombreC, razonS, repre, rentaAnual, fechaReg, EstadoCont);

            FacesMessage msg = new FacesMessage("Actualizado datos...");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("No se pudo actualizar");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
    //------------ Eliminar ------------\\

    public void delete() {
        try {

            ContDAO cd = new ContDAO();
            Contribuyente c = new Contribuyente();

            c.setNoNit(noNit);
            cd.delete(noNit);
            this.msj = "Registro Eliminado con éxito ";
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado con exito", msj);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error Grave : " + e.getMessage();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "no se elimino", msj);
        }
    }

    public void clear() {

        this.noNit = "";
        this.nombreC = "";
        this.razonS = "";
        this.repre = "";
        this.rentaAnual = new BigDecimal(0);
        this.fechaReg = null;
    }
}
