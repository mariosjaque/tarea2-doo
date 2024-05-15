package doo.tarea2;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    @Override
    public void invitar(Empleado e){
        System.out.println("Se invito al empleado"+e.getNombre()+e.getApellidos());
    }

}