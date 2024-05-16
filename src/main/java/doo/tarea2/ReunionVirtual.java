package doo.tarea2;

import java.util.Date;

/**
 * Clase ReunionVirtual
 * Se crea con un super desde reunion original.
 * @author Santiago Diaz
 * @author Luis Martinez
 * @author Mario Salgado
 */
public class ReunionVirtual extends Reunion {
    /**
     * enlace es privado para que solo sea visible cuando el programa lo estime necesario.
     */
    private String enlace;

    public ReunionVirtual(Empleado org, Date fechaR, int horaPrevistaHH, int horaPrevistaMM, int duraPrev) {
        super(org, fechaR, horaPrevistaHH, horaPrevistaMM, duraPrev);
    }

    /**
     * Permite obtener el contenido del enlace de reunion.
     * @return String con el enlace
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * Modifica el contenido del enlace de la reunion en cuestion.
     * @param enlace es el nuevo enlace
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    /**
     * Genera el informe de la reunion agregando la informacion de reunion virtual y enlace
     * @return el informe terminado en formato StringBuilder para ser usado por generarInforme()
     */
    @Override
    public StringBuilder generarInforme(){
        StringBuilder informe = super.generarInforme();
        informe.append("La reunión fue virtual.\n").append("Enlace: ").append(enlace);
        return informe;
    }
}