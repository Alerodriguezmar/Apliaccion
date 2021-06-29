
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Historial")
public class Historial  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String h_id_turista;
    private String h_nombre_turista;
    private String h_nombre_ciudad;

    public Historial() {
    }

    public String getH_id_turista() {
        return h_id_turista;
    }

    public void setH_id_turista(String h_id_turista) {
        this.h_id_turista = h_id_turista;
    }

    public String getH_nombre_turista() {
        return h_nombre_turista;
    }

    public void setH_nombre_turista(String h_nombre_turista) {
        this.h_nombre_turista = h_nombre_turista;
    }

    public String getH_nombre_ciudad() {
        return h_nombre_ciudad;
    }

    public void setH_nombre_ciudad(String h_nombre_ciudad) {
        this.h_nombre_ciudad = h_nombre_ciudad;
    }
    
    
    
}
