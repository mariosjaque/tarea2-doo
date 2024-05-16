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

    /**
     * Este es el constructor de la lista.
     */
    private ArrayList<Empleado> Lista;

    public void estaPresente(Empleado e){
        Lista.add(e);
    }

    /**
     * getLista()
     * @return Lista permite que el comando getLista() retorne la lista de cada reunión.
     */
    public ArrayList<Empleado> getLista(){
        return Lista;
    }
}
