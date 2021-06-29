package DAO;


import Entidad.Historial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HistorialDAO {
         private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");

    public void crear(Historial object) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }


    
}
