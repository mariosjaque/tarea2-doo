package doo.tarea2;
import java.time.*;
import java.util.List;

public class Reunion {

    private int fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private  Instant horaInicio;
    private  Instant horaFin;

    /*public List Asistencia(){}
    public List obtenerAusencias(){}
    public List obetenerRetrasos(){}
    public int obtenerTotalAsistencias(){}
    public int obtenerPorcentajeAsistencia(){}*/
    public float calcularTiempoReal(Instant a, Instant b){
        return b.getEpochSecond()-a.getEpochSecond();
    }
    public void iniciar(){
        horaInicio = Instant.now();
        System.out.println("La reunio empezo a las "+horaInicio);
    }
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunio finalizo a las "+horaFin);
    }
    public Instant gethoraInicio(){
        return horaInicio;
    }
    public Instant gethoraFin(){
        return horaFin;
    }
}