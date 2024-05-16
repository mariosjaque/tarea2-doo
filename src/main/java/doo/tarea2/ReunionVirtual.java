package doo.tarea2;

/**
 * Clase ReunionVirtual
 * Se crea con un super desde reunion original.
 * @author Santiago Diaz
 * @author Luis Martinez
 */
public class ReunionVirtual extends Reunion {
    /**
     * enlace es privado para que solo sea visible cuando el programa lo estime necesario.
     */
    private String enlace;

    public ReunionVirtual() {
        super();
    }

    /**
     * getEnlace()
     * Permite obtener el contenido del enlace de reunion.
     * @return String con el enlace
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * setEnlace()
     * Modifica el contenido del enlace de la reunion en cuestion.
     * @param enlace es el nuevo enlace
     */

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}