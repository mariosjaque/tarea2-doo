package doo.tarea2;

import java.time.Instant;

/**
 * Clase Invitacion
 *
 * Genera una hora para la reunion parte de la invitacion desde mi coraon
 */
public class Invitacion {
    private Instant hora;
    private Empleado emp;

    public Invitacion(Empleado e, Instant horaReunion){
        emp = e;
        hora = horaReunion;
    }
    public Empleado getEmpleado(){
        return emp;
    }
    public Instant getHora(){
        return hora;
    }
    public String toString(){
        return "Genera las invitaciones";
    }
}
