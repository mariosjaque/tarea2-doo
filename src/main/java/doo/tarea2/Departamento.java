package doo.tarea2;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.*;

/**
 * Clase Departamento
 *
 * Crea Departamentos a los que asignar empleados e implementa la funcion para ser invitable a traves
 * de una lista modificable por cada departamento.
 */
public class Departamento implements Invitable{
    /**
     * String nombre del empleado que participa
     */
    private String nombre;

    private ArrayList<Empleado> Lista;

    /**
     * Constructor Genera un departamento nuevo con la posibilidad de asignarle un nombre.
     * @param NOMBRE el nombre asignado al departamento
     */
    public Departamento(String NOMBRE){
        Lista = new ArrayList<>();
        nombre = NOMBRE;
    }

    /**
     * Devuelve el numero de empleados en el departamento a ser invitados.
     * @return int que representa el numero
     */
    public int obtenerCantidadEmpleados(){
        return Lista.size();
    }

    /**
     * AñadirEmpleado añade empleados a la lista de un departamento
     * @param e id de empleado
     */
    public void AñadirEmpleado(Empleado e){
        Lista.add(e);
    }

    /**
     * Genera invitaciones para todos los empleados que pertenecen al departamento.
     * Usa como parametro para el bucle for el tamaño de la lista de empleados.
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
        for(int i=0;i<Lista.size();i++){
            Invitacion nuevaInvitacion = new Invitacion(Lista.get(i),hora);
            Invitados.add(i,nuevaInvitacion);
        }
    }

    /**
     * @return nombre Devuelve el nombre solicitado.
     */
    public String getNombre(){
        return nombre;
    }
    public String toString(){
        return "Crea un departamento de la empresa, inicializando su nombre";
    }

}