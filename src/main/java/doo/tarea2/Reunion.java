package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
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
     * Datos como fecha, hora y duracion.
    */
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Empleado Organizador;
    private List<Invitacion> Invitados;

    /**
     *
     * Genera una reunion
     * @param org Empleado que organiza la reunion
     * @param fechaR la fecha de la reunion a organizar
     * @param horaPrevistaHH la hora (hora del dia) de la reunion
     * @param horaPrevistaMM minutos de la hora del dia de la reunion
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

    public float obtenerPorcentajeAsistencia(){

        return 0;
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

    public float calcularTiempoReal(){
        float tiemporeal = horaFin.getEpochSecond()-horaInicio.getEpochSecond();
        return tiemporeal/60;
    }

    /**
     * iniciar
     * Define la hora de inicio real de la reunion e imprime un mensaje correspondiente
     */
    public void iniciar(){
        horaInicio = Instant.now();
        for(int i=0;i<Invitados.size();i++){

        }
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

    /**
     * Genera un informe en texto con detalles de la reunión.
     * @return El informe en formato de texto.
     */
    public StringBuilder generarInforme() {
        StringBuilder informe = new StringBuilder();
        DateTimeFormatter fechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Fecha y hora de la reunión
        informe.append("Fecha y hora de la reunión: ").append(fechaHora.format(horaPrevista)).append("\n");

        // Horas de inicio y fin, y duración total
        informe.append("Hora de inicio: ").append(fechaHora.format(horaInicio)).append("\n");
        informe.append("Hora de fin: ").append(fechaHora.format(horaFin)).append("\n");
        informe.append("Duración total: ").append(this.calcularTiempoReal()).append(" minutos\n");

        informe.append("Organizador: ").append(Organizador.getNombre()).append("\n");
        informe.append("Lista de participantes que llegaron a tiempo:\n");
        List<Empleado> participantes = obtenerAsistencias();
        for (Empleado participante : participantes) {
            informe.append("- ").append(participante.getNombre()).append("\n");
        }

        return informe;
    }

    /**
     * Exporta el informe a un archivo de texto.
     * @param informe El informe a exportar.
     * @param rutaArchivo La ruta del archivo de texto donde se exportará el informe.
     */
    public void exportarInforme(StringBuilder informe, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(informe.toString());
            System.out.println("Informe exportado correctamente a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar el informe: " + e.getMessage());
        }
    }
}
