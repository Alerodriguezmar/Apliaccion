
package Entidad;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Turista")

public class Turista implements Serializable  {
    
    
    private String nombre_turista;
    private LocalDate fecha_nacimiento;
    private String identificación;
    private String tipo_identificacion;
    private int frecuencia_viaje;
    private Double Presupuesto_viaje;
    private boolean tarjeta_credito;
    private Ciudad ciudad;
    


    public Turista() {
    }

    public String getNombre_turista() {
        return nombre_turista;
    }

    public void setNombre_turista(String nombre_turista) {
        this.nombre_turista = nombre_turista;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getIdentificación() {
        return identificación;
    }

    public void setIdentificación(String identificación) {
        this.identificación = identificación;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public int getFrecuencia_viaje() {
        return frecuencia_viaje;
    }

    public void setFrecuencia_viaje(int frecuencia_viaje) {
        this.frecuencia_viaje = frecuencia_viaje;
    }

    public Double getPresupuesto_viaje() {
        return Presupuesto_viaje;
    }

    public void setPresupuesto_viaje(Double Presupuesto_viaje) {
        this.Presupuesto_viaje = Presupuesto_viaje;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isTarjeta_credito() {
        return tarjeta_credito;
    }

    public void setTarjeta_credito(boolean tarjeta_credito) {
        this.tarjeta_credito = tarjeta_credito;
    }
    
    
    

    
    
}
