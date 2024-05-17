package doo.tarea2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ReunionVirtualTest {

    private Empleado Admin = new Empleado("0", "Jefe", "Empresa", "@gmail");
    private Empleado Luis = new Empleado("1", "Luis", "Martinez Neira", "@gmail");
    private Empleado Santiago = new Empleado("2", "Santiago", "Diaz Barra", "@outlook");
    private Empleado Mario = new Empleado("3", "Mario", "Salgado Jaque", "@hotmail");
    private Empleado Farsante = new Empleado("4", "Fulanito", "Riquelme", "@hotmail");
    private Departamento Ingenieria = new Departamento("Ingenieria");
    private ReunionVirtual reunion;
    private ArrayList<Invitacion> invitados = new ArrayList<>();
    private String currentDateTime;
    private int hh;
    private int mm;
    private Date currentDate = new Date();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @BeforeEach
    void setUp() {
        currentDateTime = dateFormat.format(currentDate);
        hh = LocalDateTime.now().getHour();
        mm = LocalDateTime.now().getMinute();
        if (mm == 59) {
            hh += 1;
            mm = 0;
        }

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test uno temprano, dos tarde depto")
    public void testUnoTempranoDosTarde() throws InterruptedException {
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);


        reunion = new ReunionVirtual(Admin, currentDateTime, hh, mm + 1, 5, 0, invitados);
        Ingenieria.invitar(invitados, currentDateTime, hh, mm);
        reunion.entraReunion("1");
        reunion.iniciar();
        long numero2 = reunion.getDuracionPrevista().getSeconds();
        Thread.sleep(2000);
        reunion.entraReunion("2");
        reunion.entraReunion("3");
        reunion.finalizar();
        assertEquals(2, reunion.obtenerRetrasos().size());
        Retraso ret = (Retraso) reunion.obtenerRetrasos().get(0);
        assertNotNull(ret.getHora());
        assertEquals(0, reunion.obtenerAusencias().size());
        assertEquals(3, reunion.obtenerTotalAsistencia());
        assertEquals(100.0, reunion.obtenerPorcentajeAsistencia());
        reunion.exportarInforme("informe.txt");
        assertNull(reunion.obtenerNotas());
        assertNotNull(reunion.obtenerRetrasos().get(0));

    }

    @Test
    @DisplayName("Test Un Ausente depto")
    public void testUnAusente() throws InterruptedException {
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);
        Ingenieria.AñadirEmpleado(Farsante);


        reunion = new ReunionVirtual(Admin, currentDateTime, hh, mm + 1, 5, 0, invitados);
        Ingenieria.invitar(invitados, currentDateTime, hh, mm + 1);
        reunion.entraReunion("1");
        reunion.entraReunion("2");
        reunion.entraReunion("3");
        reunion.iniciar();
        long numero2 = reunion.getDuracionPrevista().getSeconds();
        Thread.sleep( 1000);
        reunion.finalizar();
        assertEquals(0, reunion.obtenerRetrasos().size());
        reunion.exportarInforme("informe2.txt");
        assertEquals(1, reunion.obtenerAusencias().size());
        assertNull(reunion.obtenerNotas());
        assertNotEquals(4, reunion.obtenerTotalAsistencia());
        assertFalse(reunion.obtenerPorcentajeAsistencia()>75);


    }

    @Test
    @DisplayName("Test notas + invitacion tardia")
    public void testNotasInvTardia() throws InterruptedException {
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Mario.invitar(invitados, currentDateTime,hh+1, mm);


        reunion = new ReunionVirtual(Admin, currentDateTime, hh, mm + 1, 60, 0, invitados);
        Ingenieria.invitar(invitados, currentDateTime, hh, mm + 1);
        reunion.entraReunion("1");
        reunion.entraReunion("2");
        reunion.iniciar();
        Thread.sleep(1000);
        reunion.agregarNota("Esto es una nota de prueba");
        reunion.entraReunion("3");
        reunion.finalizar();
        assertEquals(0, reunion.obtenerAusencias().size());
        assertEquals(3, reunion.obtenerTotalAsistencia());
        assertEquals(100.0, reunion.obtenerPorcentajeAsistencia());
        reunion.exportarInforme("informe3.txt");
        assertEquals(0, reunion.obtenerRetrasos().size());
        assertNotNull(reunion.obtenerNotas());
    }

    @Test
    @DisplayName("No vino nadie")
    public void testNoVinoNadie() throws InterruptedException {
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);


        reunion = new ReunionVirtual(Admin, currentDateTime, hh, mm + 1, 5, 0, invitados);
        Ingenieria.invitar(invitados, currentDateTime, hh, mm);
        reunion.iniciar();
        long numero2 = reunion.getDuracionPrevista().getSeconds();
        Thread.sleep(2000);
        reunion.finalizar();
        assertEquals(0, reunion.obtenerRetrasos().size());
        assertEquals(3, reunion.obtenerAusencias().size());
        assertEquals(0, reunion.obtenerTotalAsistencia());
        assertEquals(0, reunion.obtenerPorcentajeAsistencia());
        reunion.exportarInforme("informe4.txt");
        assertNull(reunion.obtenerNotas());

    }
}