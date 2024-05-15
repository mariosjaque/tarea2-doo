package doo.tarea2;

public class Invitacion {

    private Hora horaInicio;

    public Invitacion(int horas, int minutos) {
        this.horaInicio = new Hora(horas, minutos);
    }
}
class Hora {
    private int horas;
    private int minutos;

    public Hora(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }
}