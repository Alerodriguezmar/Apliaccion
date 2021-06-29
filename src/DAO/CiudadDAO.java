
package DAO;

import Entidad.Ciudad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CiudadDAO {
    
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
            Ciudad current = em.merge(object);
            em.remove(current);
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

    public Ciudad Buscar(Ciudad par) {
        EntityManager em = emf.createEntityManager();
        Ciudad ciudad = null;
        Query q = em.createQuery("SELECT u FROM Ciudad u WHERE u.nombre_ciudad LIKE :nombre" )
                    .setParameter("nombre", par.getNombre_ciudad());
        try {
            ciudad = (Ciudad) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            ciudad = (Ciudad) q.getResultList().get(0);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            return ciudad;
        }
    }

    public boolean actualizar(Ciudad object, Ciudad nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = Buscar(object);
            object.setId_ciudad(object.getId_ciudad());
            object.setNombre_ciudad(nuevoObjeto.getNombre_ciudad());
            object.setCantidad_habitantes(nuevoObjeto.getCantidad_habitantes());
            object.setHotel_reservado(nuevoObjeto.getHotel_reservado());
            object.setSitio_turístico(nuevoObjeto.getSitio_turístico());
            
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
    }
    
}
