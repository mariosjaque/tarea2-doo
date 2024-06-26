package doo.tarea2;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.*;

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
    private tipoReunion tipo;
    private List<Invitacion> Invitados;
    private List<Nota> Notas = new ArrayList<>();
    private List<Asistencia> Asistentes = new ArrayList<>();
    DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withZone(ZoneId.systemDefault());;
    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());;


    /**
     * Genera una reunion
     * @param org Empleado que organiza la reunion
     * @param fechaR la fecha de la reunion a organizar
     * @param horaPrevistaHH la hora (hora del dia) de la reunion
     * @param horaPrevistaMM minutos de la hora del dia de la reunion
     * @param duraPrev Duracion en minutos prevista para la reunion
     * @param tipo Describe el tipo de la reunion
-     */
    public Reunion(Empleado org, String fechaR, int horaPrevistaHH, int horaPrevistaMM, int duraPrev, int tipo, List<Invitacion> ListaInv){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            fecha = format.parse(fechaR);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        horaPrevista = fecha.toInstant();
        horaPrevista = horaPrevista.plus(horaPrevistaHH, HOURS);
        horaPrevista = horaPrevista.plus(horaPrevistaMM, MINUTES);
        Organizador = org;
        duracionPrevista = Duration.ofMinutes(duraPrev);
        this.tipo = tipoReunion.values()[tipo];
        Invitados = ListaInv;
    }

    /**
     * @return Devuelve la lista de asistencia.
     */
    public List obtenerAsistencias(){
        List<Empleado> empAsistente = new ArrayList<>();
        for(int i=0;i<Asistentes.size();i++){
            Asistencia asistente = Asistentes.get(i);
            empAsistente.add(asistente.getEmpleado());
        }
        return empAsistente;
    }

    /**
     * @return Devuelve porcentaje de asistentes
     */
    public float obtenerPorcentajeAsistencia(){
        float porcentaje = obtenerTotalAsistencia()*100;
        porcentaje/=Invitados.size();
        return porcentaje;
    }

    /**
     * @return Devuelve lista de ausentes
     */
    public List obtenerAusencias(){
        List<Empleado> ausente = new ArrayList<>();
        for(int i=0;i<Invitados.size();i++){
            boolean asistio=false;
            Empleado invitado = Invitados.get(i).getEmpleado();
            for(int j=0;j<Asistentes.size();j++){
                Empleado asistente = Asistentes.get(j).getEmpleado();
                if(invitado==asistente){
                    asistio=true;
                }
            };
            if(asistio==false){
                ausente.add(invitado);
            }
        }
        return ausente;
    }

    /**
     * @return Devuelve lista con empleados que hayan llegado despues del inicio
     */
    public List obtenerRetrasos(){
        List<Retraso> retrasos = new ArrayList<Retraso>();
        for(int i=0;i<Asistentes.size();i++){
            Asistencia asistente = Asistentes.get(i);
            if(asistente instanceof Retraso){
                retrasos.add((Retraso) Asistentes.get(i));
            }
        }
        return retrasos;
    }

    /**
     * @return Devuelve numero de asistentes a reunion
     */
    public int obtenerTotalAsistencia(){
        return Asistentes.size();
    }

    /**
     * @return Devuelve tiempo real de la reunion en minutos
     */
    public float calcularTiempoReal(){
        Duration tiemporeal = Duration.between(horaInicio, horaFin);
        return tiemporeal.toMinutes();
    }

    /**
     * Agrega nota a la reunion
     */
    public void agregarNota(String contenido){
        Nota nota = new Nota(contenido);
        Notas.add(nota);
    }

    /**
     * @return obtiene lista de todas las notas de la reunion
     */
    public String obtenerNotas(){
        if(Notas.isEmpty()){
            return null;
        }
        StringBuilder todasNotas = new StringBuilder("");
        for (Nota notaInforme : Notas) {
            todasNotas.append("- ").append(notaInforme.getContenido()).append("\n");
        }
        return todasNotas.toString();
    }

    /**
     * Define la hora de inicio real de la reunion e imprime un mensaje correspondiente
     */
    public void iniciar(){
        horaInicio = Instant.now();
        System.out.println("La reunion empezo a las "+formatoHora.format(horaInicio));
    }

    /**
     * Finaliza la reunion e imprime un mensaje al respecto.
     */
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunion finalizo a las "+formatoHora.format(horaFin));
    }

    /**
     * Metodo para avisar cuando un empleado entra a la reunion.
     * @param IDEmpleado indica el ID del empleado que entra.
     */
    public void entraReunion(String IDEmpleado){
        for(int i=0;i<Invitados.size();i++){
            Empleado invitado = Invitados.get(i).getEmpleado();
            if(invitado.getID()==IDEmpleado){
                Asistencia asis;
                if(horaInicio!=null) {
                    if(Invitados.get(i).getHora().getEpochSecond()>Instant.now().getEpochSecond()){
                        asis = new Asistencia(invitado);
                    } else {
                        asis = new Retraso(invitado);
                    }
                } else {
                    asis = new Asistencia(invitado);
                }
                Asistentes.add(asis);
            }
        }

    }

    /**
     * es un metodo que permite obtener la duracion estimada ingresada al crear la reunion.
     * @return cuanto debiera haber durado la reunion
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    /**
     * Genera un informe en texto con detalles de la reunion
     * @return el informe en formato StringBuilder, listo para que se agregue mas informacion
     */
    public StringBuilder generarInforme() {
        StringBuilder informe = new StringBuilder();

        // Fecha y hora de la reunión
        informe.append("Fecha y hora de la reunión: ").append(formatoFechaHora.format(horaPrevista)).append("\n");

        // Horas de inicio y fin, y duración total
        informe.append("Hora de inicio: ").append(formatoHora.format(horaInicio)).append("\n");
        informe.append("Hora de fin: ").append(formatoHora.format(horaFin)).append("\n");
        informe.append("Duración total: ").append(this.calcularTiempoReal()).append(" minutos\n");

        informe.append("Organizador: ").append(Organizador.getNombre()).append(" ").append(Organizador.getApellidos()).append("\n");
        informe.append("Lista de participantes:\n");
        List<Empleado> participantes = obtenerAsistencias();
        for (Empleado participante : participantes) {
            informe.append("- ").append(participante.getNombre()).append(" ").append(participante.getApellidos()).append("\n");
        }
        informe.append("Notas: \n");
        for (Nota notaInforme : Notas) {
            informe.append("- ").append(notaInforme.getContenido()).append("\n");
        }

        informe.append("Tipo de reunión: ").append(tipo.getDescripcion()).append("\n");

        return informe;
    }

    /**
     * Exporta el informe a un archivo de texto.
     * @param rutaArchivo La ruta del archivo de texto donde se exportara el informe
     */
    public void exportarInforme(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(this.generarInforme().toString());
            System.out.println("Informe exportado correctamente a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar el informe: " + e.getMessage());
        }
    }
    public String toString(){
        return "Crea la reunion, tanto virtual como presencial, dependendiendo de lo que se pida y tambien poder guardar a que hora sera la reunion,la duracion prevista y quien sera el organizador";
    }
}
