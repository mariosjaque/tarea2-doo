package doo.tarea2;
import java.util.ArrayList;
import java.util.List;
public class Departamento implements Invitable{
    private String nombre;

    private ArrayList<Empleado> Lista;
    public Departamento(String NOMBRE){
        Lista = new ArrayList<>();
        nombre = NOMBRE;
    }
    public int obtenerCantidadEmpleados(List Empleados){
        return Empleados.size();
    }
    public void AñadirEmpleado(Empleado e){
        Lista.add(e);
    }
    @Override
    public void invitar(){
        for(int i=0;i<Lista.size();i++)
            System.out.println("Se invito al empleado: "+Lista.get(i).getNombre()+" "+Lista.get(i).getApellidos());
    }
    public String getNombre(){
        return nombre;
    }

}