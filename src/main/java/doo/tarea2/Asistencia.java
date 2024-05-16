package doo.tarea2;

import java.util.ArrayList;

/**
 * Clase Asistencia
 *
 * Genera la lista de invitados que asistieron a la reunión.
 * @author Luis Martinez
 * @author Mario Salgado
 */
public class Asistencia {

    private Empleado emp;


    /**
     * Constructor de Asistencia
     * @param e el empleado que asistió
     */
    public Asistencia(Empleado e){
        emp = e;
    }

    /**
    * @return devuelve el empleado que asistió
     */
    public Empleado getEmpleado(){
        return emp;
    }
    public String toString(){
        return "Crea una lista, donde se guardaran la gente que asista";
    }
}
