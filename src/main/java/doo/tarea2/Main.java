package doo.tarea2;

import java.time.Instant;
import java.util.*;

/**
 * Clase Main
 *
 * Contiene los test de todo el programa.
 * @author Luis Martinez
 * @author Mario Salgado
 * @author Santiago Diaz
 * @version 1.0
 *
 */
public class Main {

    public static void main(String[] args) {

        Empleado Admin = new Empleado("0", "Jefe", "Empresa", "@gmail");
        Empleado Luis = new Empleado("1", "Luis", "Martinez Neira", "@gmail");
        Empleado Santiago = new Empleado("2", "Santiago", "Diaz Barra", "@outlook");
        Empleado Mario = new Empleado("3", "Mario", "Salgado Jaque", "@hotmail");
        Departamento Ingenieria = new Departamento("Ingenieria");
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);

        ArrayList<Invitacion> invitados = new ArrayList<>();
        ReunionVirtual reunion = new ReunionVirtual(Admin, " 2024-05-16 ", 17, 50, 2, 0,invitados);
        reunion.setEnlace("https://testing.com");

        Ingenieria.invitar(invitados, "2024-05-16", 17, 50);
        reunion.entraReunion("1");
        reunion.entraReunion("2");

        reunion.iniciar();
        /*try {
            //Simulamos la duracion de la reunion
            long numero2 = reunion.getDuracionPrevista().getSeconds();
            Thread.sleep(numero2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }*/
        reunion.finalizar();
        System.out.println(reunion.obtenerTotalAsistencia());
        System.out.println(reunion.obtenerPorcentajeAsistencia());
        reunion.exportarInforme("C:/users/mario/informe.txt");
    }

}
