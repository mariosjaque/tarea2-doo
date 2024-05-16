package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

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
        System.out.println("Muy bien, la hora prevista de inicio sera a las: "+horaPrevista);
        System.out.println("Cuanto sera la duracion prevista de la reunion en minutos?");
        n = entrada.nextLong();
        duracionPrevista = Duration.ofMinutes(n);
        System.out.println("Muy bien, la duracion prevista sera de: "+duracionPrevista.getSeconds()/60+" minutos");
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
