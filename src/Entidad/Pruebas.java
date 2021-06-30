
package Entidad;

import DAO.CiudadDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Pruebas {
    
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");
    public static void main(String[] args) {
          EntityManager em = emf.createEntityManager();
        Ciudad ciudad = null;
        Query q = em.createQuery("SELECT DISTINCT u FROM Ciudad u" );
        for (int i = 0; i < q.getResultList().size(); i++) {
            ciudad = (Ciudad) q.getResultList().get(i);
            System.out.println(ciudad.getNombre_ciudad());
            
        }
        
        
    }
    
}
