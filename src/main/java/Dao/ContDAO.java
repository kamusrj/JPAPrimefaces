/*
 *  Kamus Curso java Insafor 2022
 */
package Dao;

import Entity.Contribuyente;
import java.util.Date;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/*
 * @author Kamus
 */
public class ContDAO {

    public static void main(String[] args) throws ParseException {
       
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = "4/4/2022";
        Date fech = f.parse(strFecha);

       // System.out.println("fecha: " + f.format(fech));
        ContDAO cd = new ContDAO();
        Contribuyente c = new Contribuyente();

        c.setNoNit("3");
        c.setNombreContribuyente("3");
        c.setRazonSocial("c");
        c.setRepresentanteLegal("2");
        c.setRentaAnual(new BigDecimal(45.5));
        c.setFechaRegistro(fech);
        c.setEstadoContribuyente("3");

//        Crud metodos
        cd.save(c);  //-- Guardar
//        cd.search("14"); //-- Buscar
//        cd.update("72", "33", "cc", "20", new BigDecimal(55.20), fecha, "f"); //-- Actualizar
//        cd.delete("12"); //-- Eliminar
        cd.listaCont(); //-- Mostrar tabla
    }

    //---------------------------------  Crud  ---------------------------------
//--------------------------------- CREATE ---------------------------------
    public void save(Contribuyente c) {
        EntityManager em = JpaPer.getJpa().createEntityManager();
        int flag = 0;
        em.getTransaction().begin();
        try {
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    //---------------------------------  READ  ---------------------------------
    public Contribuyente search(String nit) {
        EntityManager em = JpaPer.getJpa().createEntityManager();
        Contribuyente c = null;
        em.getTransaction().begin();
        try {
            c = em.find(Contribuyente.class, nit);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return c;
    }

    //---------------------------------  UPDATE ---------------------------------
    public void update(String nit, String nombre, String razon,
            String repre, BigDecimal renta, Date fecha, String ec) {

        EntityManager em = JpaPer.getJpa().createEntityManager();
        Contribuyente c = null;
        int flag = 0;
        em.getTransaction().begin();
        try {
            c = em.find(Contribuyente.class, nit);

            c.setNoNit(nit);
            c.setNombreContribuyente(nombre);
            c.setRazonSocial(razon);
            c.setRepresentanteLegal(repre);
            c.setRentaAnual(renta);
            c.setFechaRegistro(fecha);
            c.setEstadoContribuyente(ec);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    //---------------------------------  DELETE ---------------------------------
    public String delete(String noNit) {
        EntityManager em = JpaPer.getJpa().createEntityManager();
        Contribuyente c = null;
        String flag = "";
        em.getTransaction().begin();
        try {
            c = em.find(Contribuyente.class, noNit);
            em.remove(c);
            em.getTransaction().commit();
            System.out.println("Eliminacion correcta");
        } catch (Exception e) {
            em.getTransaction().rollback();
            flag = "error";
        } finally {
            em.close();
        }
        return flag;
    }

    public List listaCont() {
        List<Contribuyente> lc = null;
        EntityManager em = JpaPer.getJpa().createEntityManager();
        em.getTransaction().begin();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Query query = em.createQuery("select c from Contribuyente c ");
            em.getTransaction().commit();
            lc = query.getResultList();

            Iterator it = lc.iterator();
            while (it.hasNext()) {
                Contribuyente c = (Contribuyente) it.next();
                System.out.println(" nit:" + c.getNoNit());
                
                System.out.println("fecha: " + f.format( c.getFechaRegistro()));

            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lc;
    }
}
