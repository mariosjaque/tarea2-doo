package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Reunion {

/**
 * Clase Reunion
 *
 * Se crean las reuniones.
 */
public class Reunion {
    /**
     * Datos como fecha, hora y duracion falta menos.
     */
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;

    private Instant horaInicio;
    private Instant horaFin;

    /**
     *
     * Genera una invitacion tomando los datos y hora de la reunion a suceder
-     */
    public Reunion(){

        long n;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿En cuantas horas tiene previsto empezar su reunion?");
        n = entrada.nextLong();
        n = n*60*60;
        horaPrevista = Instant.now();
        horaPrevista = horaPrevista.plusSeconds(n);
        System.out.println("Muy bien la hora prevista de inicio sera a las: "+horaPrevista);
        System.out.println("Cuanto sera la duracion prevista de la reunion en minutos?");
        n = entrada.nextLong();
        duracionPrevista = Duration.ofMinutes(n);
        System.out.println("Muy bien, la duracion prevista sera de: "+duracionPrevista.getSeconds()/60+" minutos");
    }

    /**
     *
     * @param asistencia
     * @return Devuelve al empleado como presente.
     */
    public List Asistencia(Asistencia asistencia){
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
     * obteenerRetrasos
     * @param retraso devuelve los retrazos del empleado
     * @return
     */

    public List obtenerRetrasos(Retraso retraso){
        return retraso.getLista();
    }
    public int obtenerTotalAsistencias(Asistencia asistencia){
        return asistencia.getLista().size();
    }

    public float calcularTiempoReal(Instant a, Instant b){
        return b.getEpochSecond()-a.getEpochSecond();
    }

    /**
     * iniciar
     *
     * @return la hora a la que comenzo la reunion
     */
    public void iniciar(){
        horaInicio = Instant.now();
        fecha = new Date();
        System.out.println("La reunion empezo a las "+horaInicio);
    }

    /**
     * finalizar
     *
     * @return la hora en la que finalizo la reunion
     */
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunion finalizo a las "+horaFin);
    }

    /**
     *
     * es un metodo que permite comparar la duracion estimada vs la original.
     *
     * @return cuanto debiera haber durado la reunion
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
}
