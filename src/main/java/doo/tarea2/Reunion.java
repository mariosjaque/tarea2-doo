package doo.tarea2;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.Instant;

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
    private tipoReunion tipo;
    private List<Invitacion> Invitados;
    private List<Nota> Notas;
    private List<Asistencia> Asistentes;
    DateTimeFormatter fechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /**
     * Genera una reunion
     * @param org Empleado que organiza la reunion
     * @param fechaR la fecha de la reunion a organizar
     * @param horaPrevistaHH la hora (hora del dia) de la reunion
     * @param horaPrevistaMM minutos de la hora del dia de la reunion
     * @param duraPrev Duracion en minutos prevista para la reunion
     * @param tipo Describe el tipo de la reunion
-     */
    public Reunion(Empleado org, Date fechaR, int horaPrevistaHH, int horaPrevistaMM, int duraPrev, tipoReunion tipo){
        fecha = fechaR;
        horaPrevista = fecha.toInstant();
        horaPrevista = horaPrevista.plus(horaPrevistaHH, HOURS);
        horaPrevista = horaPrevista.plus(horaPrevistaMM, MINUTES);
        Organizador = org;
        duracionPrevista = Duration.ofMinutes(duraPrev);
        this.tipo = tipo;
    }

    /**
     * @return Devuelve la lista de asistencia.
     */
    public List obtenerAsistencias(){
        List<Empleado> empAsistente = null;
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
        List<Empleado> ausente = null;
        for(int i=0;i<Invitados.size();i++){
            boolean asistio=false;
            Empleado invitado = Invitados.get(i).getEmpleado();
            for(int j=0;j<Asistentes.size();j++){
                Empleado asistente = Asistentes.get(i).getEmpleado();
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
        List<Empleado> retrasos = null;
        for(int i=0;i<Asistentes.size();i++){
            Asistencia asistente = Asistentes.get(i);
            if(asistente instanceof Retraso){
                retrasos.add(asistente.getEmpleado());
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
        float tiemporeal = horaFin.getEpochSecond()-horaInicio.getEpochSecond();
        return tiemporeal/60;
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
        StringBuilder todasNotas = null;
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
        Scanner Entrada = new Scanner(System.in);
        for(int i=0;i<Invitados.size();i++){
            Empleado e = Invitados.get(i).getEmpleado();
            System.out.println("¿Está presente el empleado "+e.getNombre()+" "+e.getApellidos()+"? (Si/No): ");
            String Frase = Entrada.nextLine();
            while(Frase!="Si" && Frase!="No"){
                System.out.println("Por favor responder validamente (Si/No): ");
                Frase = Entrada.nextLine();
            }
            if(Frase=="Si") {
                Asistencia asistente = new Asistencia(e);
                Asistentes.add(asistente);
            }
        }
        System.out.println("La reunion empezo a las "+fechaHora.format(horaInicio));
    }

    /**
     * Finaliza la reunion e imprime un mensaje al respecto.
     */
    public void finalizar(){
        horaFin = Instant.now();
        System.out.println("La reunion finalizo a las "+fechaHora.format(horaFin));
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
        informe.append("Fecha y hora de la reunión: ").append(fechaHora.format(horaPrevista)).append("\n");

        // Horas de inicio y fin, y duración total
        informe.append("Hora de inicio: ").append(fechaHora.format(horaInicio)).append("\n");
        informe.append("Hora de fin: ").append(fechaHora.format(horaFin)).append("\n");
        informe.append("Duración total: ").append(this.calcularTiempoReal()).append(" minutos\n");

        informe.append("Organizador: ").append(Organizador.getNombre()).append("\n");
        informe.append("Lista de participantes:\n");
        List<Empleado> participantes = obtenerAsistencias();
        for (Empleado participante : participantes) {
            informe.append("- ").append(participante.getNombre()).append("").append(participante.getApellidos()).append("\n");
        }
        informe.append("Notas:\n");
        for (Nota notaInforme : Notas) {
            informe.append("- ").append(notaInforme.getContenido()).append("\n");
        }

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
    public void tostring(){
        System.out.println("Crea la reunion, tanto virtual como presencial, dependendiendo de lo que se pida y tambien poder guardar a que hora sera la reunion,la duracion prevista y quien sera el organizador");
    }
}
