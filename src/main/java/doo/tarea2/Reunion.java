package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reunion {

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;

    private Instant horaInicio;
    private Instant horaFin;

    public Reunion(){

        long n;
        Scanner entrada = new Scanner(System.in);
        System.out.println("¿En cuantas horas tiene previta empezar su reunion?");
        n = entrada.nextLong();
        n = n*60*60;
        horaPrevista = Instant.now();
        horaPrevista = horaPrevista.plusSeconds(n);
        System.out.println("Muy bien la hora prevista de inicio sera a las: "+horaPrevista);
        System.out.println("Cuanto sera la duracion prevista de la reunion en minutos?");
        n = entrada.nextLong();
        duracionPrevista = Duration.ofMinutes(n);
        System.out.println("Muy bien la duracion prevista sera de: "+duracionPrevista.getSeconds()/60+" minutos");
    }
    public List Asistencia(Asistencia asistencia){
        return asistencia.getLista();
    }
    public List obtenerAusencias(Ausente ausente){
        return ausente.getLista();
    }

    public List obetenerRetrasos(Retraso retraso){
        return retraso.getLista();
    }
    public int obtenerTotalAsistencias(Asistencia asistencia){
        return asistencia.getLista().size();
    }

    /*public int obtenerPorcentajeAsistencia(){
    }*/
    public float calcularTiempoReal(Instant a, Instant b){
        return b.getEpochSecond()-a.getEpochSecond();
    }
    public void iniciar(){
        horaInicio = Instant.now();
        fecha = new Date();
        System.out.println("La reunion empezo a las "+horaInicio);
    }
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunion finalizo a las "+horaFin);
    }
}
