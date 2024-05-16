package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

/** Clase Reunion
 * @author Luis Martinez
 * @author Santiago Diaz
 * @author Mario Salgado
*/
public abstract class Reunion {
    /**
     * Se crean las reuniones.
     * Datos como fecha, hora y duracion falta menos.
    */
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Empleado Organizador;

    /**
     *
     * Genera una reunion
     * @param org Empleado que organiza la reunion
     * @param fechaR la fecha de la reunion a organizar
     * @param
     * @param duraPrev Duracion en minutos prevista para la reunion
-     */
    public Reunion(Empleado org, Date fechaR, int horaPrevistaHH, int horaPrevistaMM, int duraPrev){
        fecha = fechaR;
        horaPrevista = fecha.toInstant();
        horaPrevista = horaPrevista.plus(horaPrevistaHH, HOURS);
        horaPrevista = horaPrevista.plus(horaPrevistaMM, MINUTES);
        Organizador = org;
        duracionPrevista = Duration.ofMinutes(duraPrev);
    }

    /**
     *
     *
     * @return Devuelve la lista de asistencia.
     */
    public List obtenerAsistencias(Asistencia asistencia){
        return asistencia.getLista();
    }

    /**
     *
     * @param ausente Devuelve las ausencias de los empleados
     * @return
     */
    public List obtenerAusencias(Ausente ausente){
        return ausente.getLista();
    }

    /**
     * obtenerRetrasos
     * @param retraso devuelve los retrasos del empleado
     * @return Devuelve
     */

    public List obtenerRetrasos(Retraso retraso){
        return retraso.getLista();
    }
    public int obtenerTotalAsistencia(Asistencia asistencia){
        return asistencia.getLista().size();
    }

    public float calcularTiempoReal(Instant a, Instant b){
        return b.getEpochSecond()-a.getEpochSecond();
    }

    /**
     * iniciar
     * Define la hora de inicio real de la reunion e imprime un mensaje correspondiente
     */
    public void iniciar(){
        horaInicio = Instant.now();
        fecha = new Date();
        System.out.println("La reunion empezo a las "+horaInicio);
    }

    /**
     * finalizar
     * Finaliza la reunion e imprime un mensaje al respecto.
     */
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunion finalizo a las "+horaFin);
    }

    /**
     * getDuracionPrevista()
     * es un metodo que permite comparar la duracion estimada vs la original.
     *
     * @return cuanto debiera haber durado la reunion
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }


}
