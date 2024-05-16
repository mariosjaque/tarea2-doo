package doo.tarea2;

/**
 * Clase ReunionVirtual
 *
 * Se crea con un super desde reunion original.
 */
public class ReunionVirtual extends Reunion {
    /**
     * @param enlace es privado para que solo el empelado con acceso pueda verla.
     */
    private String enlace;

    public ReunionVirtual() {
        super();
    }

    public String getEnlace() {
        return enlace;
    }

    /**
     * setEnlace Modifica el contenido del enlace identificado con esa id.
     * @param enlace es modificable
     */

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}