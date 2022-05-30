/*
 *  Kamus Curso java Insafor 2022
 */
package Dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author Kamus
 */
public class JpaPer {

    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("perJpa");
        } catch (Throwable e) {
            System.out.println("Error : " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManagerFactory getJpa() {
        return emf;
    }

}
