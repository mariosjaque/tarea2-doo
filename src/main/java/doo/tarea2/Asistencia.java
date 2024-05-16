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

    public Asistencia(Empleado e){
        emp = e;
    }

    public Empleado getEmpleado(){
        return emp;
    }
    public void tostring(){
        System.out.println("Crea una lista, donde se guardaran la gente que asista");
    }
}
