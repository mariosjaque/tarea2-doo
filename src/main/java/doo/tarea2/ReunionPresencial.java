package doo.tarea2;

/**
 * Clase ReunionPresencial
 *
 * Se extiende de reunion y permite crear una reunion presencial y modificar sus datos.
 *
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial() {
        super();
    }
    public String getSala() {
        return sala;
    }

    /**
     *
     * @param sala es privada oara que solo el empelado con acceso pueda verla.
     */
    public void modSala(String sala) {
        this.sala = sala;
    }
}
