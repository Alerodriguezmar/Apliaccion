
package Entidad;

import DAO.CiudadDAO;

public class Pruebas {
    
    public static void main(String[] args) {
        Ciudad ciu = new  Ciudad();
        CiudadDAO dao = new CiudadDAO();
       
        ciu.setCantidad_habitantes(0);
        ciu.setHotel_reservado("lux");
        ciu.setNombre_ciudad("mosquera");
        ciu.setSitio_turístico("Funza");
        dao.crear(ciu);
        
        
    }
    
}
