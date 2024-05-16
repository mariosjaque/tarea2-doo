package doo.tarea2;

import java.time.Instant;

/**
 * Clase Invitacion
 *
 * Genera una hora para la reunion parte de la invitacion desde mi coraon
 */
public class Invitacion {
    private Instant hora;
    public Invitacion(){}

    /**
     * Constructor preguntar
     *
     * Solicita más informacion de quien de los empleaados desea invitar o si se invita a un
     * departamento completo
     */
    public void preguntar(){
        System.out.println("A quien desea invitar");
    }
}
