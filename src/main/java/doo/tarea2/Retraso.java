package doo.tarea2;

import java.time.Instant;

/**
 * Class Retraso
 *
 * Extendida de Asistencia
 * @author Mario Salgado
 * @author Luis Martinez
 */
public class Retraso extends Asistencia{
    private Instant hora;
    /**
     * Constructor, registra el retraso del Empleado
     * @param e Empleado que incurre en retraso
     */
    public Retraso(Empleado e){
        super(e);
        hora = Instant.now();
    }

    /**
     * getHora()
     * @return retorna hora del ingreso del empleado
     */
    public Instant getHora(){
        return hora;
    }

}