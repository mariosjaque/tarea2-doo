package doo.tarea2;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(String sala) {
        this.sala = sala;
    }
    public String getSala() {
        return sala;
    }
    public void modSala(String sala) {
        this.sala = sala;
    }
}
