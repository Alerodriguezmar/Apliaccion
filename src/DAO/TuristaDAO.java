
package DAO;

import Entidad.Turista;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TuristaDAO {
    
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");

    public void crear(Turista object) {

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

    public boolean eliminar(Turista object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
             Turista current = em.merge(object);
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
    
      public  Turista Buscar(Turista par) {
        EntityManager em = emf.createEntityManager();
        Turista turista = null;
        Query q = em.createQuery("SELECT u FROM Turista u WHERE u.identificación LIKE :nombre" )
                    .setParameter("nombre", par.getIdentificación());
        try {
            turista = (Turista) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            turista = (Turista) q.getResultList().get(0);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            return turista;
        }
    }
    
    
    


    public boolean actualizar( Turista object, Turista  nuevoObjeto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = Buscar(object);
            
            object.setNombre_turista(nuevoObjeto.getNombre_turista());
            object.setFecha_nacimiento(nuevoObjeto.getFecha_nacimiento());
            object.setIdentificación(nuevoObjeto.getIdentificación());
            object.setTipo_identificacion(nuevoObjeto.getTipo_identificacion());
            object.setPresupuesto_viaje(nuevoObjeto.getPresupuesto_viaje());
            object.setFrecuencia_viaje(nuevoObjeto.getFrecuencia_viaje());
            object.setTarjeta_credito(nuevoObjeto.isTarjeta_credito());
            object.setCiudad(nuevoObjeto.getCiudad());
            
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
