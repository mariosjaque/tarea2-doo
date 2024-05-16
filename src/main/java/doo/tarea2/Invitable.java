package doo.tarea2;

import java.lang.ref.Reference;
import java.time.Instant;
import java.util.List;

/**
 * Interface Invitable
 *
 * Se crea la forma de invitar para crear invitaciones genericas.
 * @author Luis Martinez
 * @author Mario Salgado
 */
public interface Invitable {
    void invitar(List<Invitacion> Invitados, Instant hora);
}
