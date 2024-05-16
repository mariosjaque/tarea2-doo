package doo.tarea2;

import java.util.Date;
import java.util.List;

/**
 * Clase ReunionPresencial
 * Se extiende de reunion y permite crear una reunion presencial y modificar sus datos.
 * @author Santiago Diaz
 * @author Luis Martinez
 * @author Mario Salgado
 */
public class ReunionPresencial extends Reunion {
    /**
     * sala es privado para que solo sea visible cuando el programa lo estime necesario.
     */
    private String sala;
    public ReunionPresencial(Empleado org, Date fechaR, int horaPrevistaHH, int horaPrevistaMM, int duraPrev, int tipo, List<Invitacion> ListaInv) {
        super(org, fechaR, horaPrevistaHH, horaPrevistaMM, duraPrev, tipo, ListaInv);
    }

    /**
     * Permite obtener la sala de la reunion.
     * @return String con la sala
     */
    public String getSala() {
        return sala;
    }

    /**
     * Modifica la sala indicada para la reunion en cuestion.
     * @param sala es la nueva sala
     */
    public void modSala(String sala) {
        this.sala = sala;
    }

    /**
     * Genera el informe de la reunion agregando la informacion de reunion presencial y sala
     * @return el informe terminado en formato StringBuilder para ser usado por generarInforme()
     */
    @Override
    public StringBuilder generarInforme(){
        StringBuilder informe = super.generarInforme();
        informe.append("La reunión fue presencial.\n").append("Sala: ").append(sala);
        return informe;
    }
}
