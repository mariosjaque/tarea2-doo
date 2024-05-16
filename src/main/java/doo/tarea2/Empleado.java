package doo.tarea2;

import java.lang.ref.Reference;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.*;

/**
 * Clase Empleado implementa Invitable
 *
 * Crea un id unico para cada empleado y permite ordenar empleados e implementa la funcion
 * para ser invitable a traves de un conjunto de datos identificadores.
 * @author Santiago Diaz
 * @author Luis Martinez
 */
public class Empleado implements Invitable{

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor Empleado
     * Solicita datos para crear el empleado nuevo en el sistema.
     * @param ID id del empleado
     * @param NOMBRE nombre del empleado
     * @param APELLIDOS apellido del empleado
     * @param CORREO correo del empleado
     */

    public Empleado(String ID, String NOMBRE,String APELLIDOS,String CORREO){
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }
    /**
     * @return ID retorna el ID del empleado
     */
    public String getID(){
        return id;
    }

    /**
     * @return nombre retorna el nombre ingresado.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * @return apellidos retorna el apellido ingresado.
     */
    public String getApellidos(){
        return apellidos;
    }
    /**
     * @return Correo retorna el correo ingresado.
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Genera invitacion para el empleado
     * @param Invitados lista de invitados a modificar
     * @param fecha fecha en formato yyyy-MM-dd
     * @param horaHH hora de compromiso, campo Hora
     * @param horaMM hora de compromiso, campo Minutos
     */
    @Override
    public void invitar(List<Invitacion> Invitados, String fecha, int horaHH, int horaMM){
        Date fechaR;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            fechaR = format.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Instant hora = fechaR.toInstant();
        hora = hora.plus(horaHH, HOURS);
        hora = hora.plus(horaMM, MINUTES);
        Invitacion nuevaInvitacion = new Invitacion(this,hora);
        Invitados.add(nuevaInvitacion);
    }
    public String toString(){
        return "Crea un empleado, inicializando sus propiedades";
    }
}