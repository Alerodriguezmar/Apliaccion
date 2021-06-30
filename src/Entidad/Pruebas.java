
package Entidad;

import DAO.CiudadDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

public class Pruebas {
    
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AplicaPU");
    public static void main(String[] args) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NOMBRE CIUDAD");
        model.addColumn("CANTIDAD VISITANTES");
        
        EntityManager em = emf.createEntityManager();
        ArrayList<String> lista = new ArrayList<>();
        
        Query q = em.createQuery("SELECT DISTINCT u.h_nombre_ciudad FROM Historial u");
        
        for (int i = 0; i < q.getResultList().size(); i++) {            
            lista.add((String) q.getResultList().get(i));
        }
        
        for (String string : lista) {
            Query q2 = em.createQuery("SELECT COUNT (u) FROM Historial u WHERE u.h_nombre_ciudad LIKE :nombre" )
                    .setParameter("nombre", string);
            System.out.println(q2.getResultList().get(0).toString());
            System.out.println(string);
        }
        
    }
    }
    

