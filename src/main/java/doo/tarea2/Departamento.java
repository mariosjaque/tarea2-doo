package doo.tarea2;
import java.util.ArrayList;
import java.util.List;
public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> Lista;
    public int obtenerCantidadEmpleados(List Empleados){
        return Empleados.size();
    }
    public void AñadirEmpleado(Empleado e){
        Lista.add(e);
    }
    public void invitar(Empleado e){
        System.out.println("Se invito al empleado"+e.getNombre()+e.getApellidos());
    }

}