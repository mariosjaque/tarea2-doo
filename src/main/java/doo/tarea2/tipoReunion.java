package doo.tarea2;

public enum tipoReunion {
    TECNICA("Técnica"),
    MARKETING("Marketing"),
    OTRO("Otro");

    private final String descripcion;

    tipoReunion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}