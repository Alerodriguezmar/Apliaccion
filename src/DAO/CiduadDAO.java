
package DAO;

import Entidad.Ciudad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CiduadDAO {
    
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");

    public void crear(Ciudad object) {

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

    public boolean eliminar(Ciudad object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
/*
    public Ciudad leer(Ciudad par) {
        EntityManager em = emf.createEntityManager();
        Ciudad ciudad = null;
        Query q = em.createQuery("SELECT u FROM Usuario u " +
                    "WHERE u.nombre LIKE :nombre" +
                    " AND u.password LIKE :password")
                    .setParameter("nombre", par.getNombre())
                    .setParameter("password", par.getPassword());
        try {
            usuario = (Usuario) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            usuario = (Usuario) q.getResultList().get(0);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            return usuario;
        }
    }
/*
    public boolean actualizar(Ciudad object, Ciudad nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leer(object);
            object.setNombre(nuevoObjeto.getNombre());
            object.setPassword(nuevoObjeto.getPassword());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }*/
    
}
