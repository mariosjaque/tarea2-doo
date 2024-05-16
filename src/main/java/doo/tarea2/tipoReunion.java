package doo.tarea2;

/**
 * enum tipoReunion
 *
 * Tiene los tipos de reunion que se usan comunmente y permite clasificarlas.
 * @author Mario Salgado
 * @author Santiago Diaz
 */
public enum tipoReunion {
    TECNICA("Técnica"),
    MARKETING("Marketing"),
    OTRO("Otro");

    private final String descripcion;

    /**
     *
     * @param descripcion pide una descripcion del tipo de reunion o su fin en si.
     */
    tipoReunion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}