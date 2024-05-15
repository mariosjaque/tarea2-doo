package doo.tarea2;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    public Empleado(String ID, String NOMBRE,String APELLIDOS,String CORREO){
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getCorreo(){return correo;}
    @Override
    public void invitar(){
        System.out.println("Se invito al empleado: "+nombre+" "+apellidos);
    }

}