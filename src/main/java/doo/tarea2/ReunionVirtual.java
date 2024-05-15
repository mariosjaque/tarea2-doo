package doo.tarea2;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(String enlace) {
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
}