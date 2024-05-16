package doo.tarea2;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Departamento
 *
 * Crea Departamentos a los que asignar empleados e implementa la funcion para ser invitable a traves
 * de una lista modificable por cada departamento.
 */
public class Departamento implements Invitable{
    /**
     * String nombre del empleado que participa
     */
    private String nombre;

    private ArrayList<Empleado> Lista;

    /**
     * Constructor Genera un departamento nuevo con la posibilidad de asignarle un nombre.
     * @param NOMBRE el nombre asignado al departamento
     */
    public Departamento(String NOMBRE){
        Lista = new ArrayList<>();
        nombre = NOMBRE;
    }

    /**
     * Devuelve el numero de empleados en el departamento a ser invitados.
     * @param Empleados empleados que pertenecen al departamento
     * @return int que representa el numero
     */
    public int obtenerCantidadEmpleados(List Empleados){
        return Empleados.size();
    }

    /**
     * AñadirEmpleado añade empleados a la lista de un departamento
     * @param e id de empleado
     */
    public void AñadirEmpleado(Empleado e){
        Lista.add(e);
    }

    /**
     * Genera invitaciones para todos los empleados que pertenecen al departamento.
     * Usa como parametro para el bucle for el tamaño de la lista de empleados.
     */
    @Override
    public void invitar(){
        for(int i=0;i<Lista.size();i++)
            System.out.println("Se invito al empleado: "+Lista.get(i).getNombre()+" "+Lista.get(i).getApellidos());
    }

    /**
     * @return nombre Devuelve el nombre solicitado.
     */
    public String getNombre(){
        return nombre;
    }
    public void tostring(){
        System.out.println("Crea una empesa, inicializando su nombre");
    }

}