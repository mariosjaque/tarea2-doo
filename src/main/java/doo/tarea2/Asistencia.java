package doo.tarea2;

import java.util.ArrayList;

/**
 * Clase Asistencia
 *
 * Genera la lista de invitados que asistieron a la reunión.
 *
 */
public class Asistencia {

    private ArrayList<String> Lista;
    //Constructor

    /**
     * Este es el constructor de la lista, solo recibe los datos y los pasa a un string.
     * @return Lista permite que el comando getLista() retorne la lista de cada reunión.
     */
    public ArrayList<String> getLista(){
        return Lista;
    }
}
