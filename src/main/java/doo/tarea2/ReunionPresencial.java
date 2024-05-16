package doo.tarea2;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial() {
        super();
    }
    public String getSala() {
        return sala;
    }
    public void modSala(String sala) {
        this.sala = sala;
    }
}
