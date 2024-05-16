package doo.tarea2;

/**
 * Clase ReunionPresencial
 *
 * Se extiende de reunion y permite crear una reunion presencial y modificar sus datos.
 * @author Santiago Diaz
 * @author Luis Martinez
 */
public class ReunionPresencial extends Reunion {
    /**
     * sala es privado para que solo sea visible cuando el programa lo estime necesario.
     */
    private String sala;
    public ReunionPresencial() {
        super();
    }

    /**
     * getSala()
     * Permite obtener la sala de la reunion.
     * @return String con la sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * modSala()
     * Modifica la sala indicada para la reunion en cuestion.
     * @param sala es la nueva sala
     */
    public void modSala(String sala) {
        this.sala = sala;
    }
}
