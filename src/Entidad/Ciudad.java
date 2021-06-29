
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudad")

public class Ciudad implements Serializable{
    

private String nombre_ciudad; 
private int cantidad_habitantes; 
private String sitio_turístico;
private String hotel_reservado; 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_ciudad;

    public Ciudad() {
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public int getCantidad_habitantes() {
        return cantidad_habitantes;
    }

    public void setCantidad_habitantes(int cantidad_habitantes) {
        this.cantidad_habitantes = cantidad_habitantes;
    }

    public String getSitio_turístico() {
        return sitio_turístico;
    }

    public void setSitio_turístico(String sitio_turístico) {
        this.sitio_turístico = sitio_turístico;
    }

    public String getHotel_reservado() {
        return hotel_reservado;
    }

    public void setHotel_reservado(String hotel_reservado) {
        this.hotel_reservado = hotel_reservado;
    }
 
}
