package doo.tarea2;

/**
 * Clase Empleado implementa Invitable
 *
 * Crea un id unico para cada empleado y permite ordenar empleados e implementa la funcion
 * para ser invitable a traves de un conjunto de datos identificadores.
 */
public class Empleado implements Invitable{

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor Empleado
     * Solicita datos para crear el empleado nuevo en el sistema.
     * @param ID id del empleado
     * @param NOMBRE nombre del empleado
     * @param APELLIDOS apellido del empleado
     * @param CORREO correo del empleado
     */

    public Empleado(String ID, String NOMBRE,String APELLIDOS,String CORREO){
        id = ID;
        apellidos = APELLIDOS;
        nombre = NOMBRE;
        correo = CORREO;
    }
    /**
     * getNombre()
     * @return nombre retorna el nombre ingresado.
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * getApellido()
     * @return apellidos retorna el apellido ingresado.
     */
    public String getApellidos(){
        return apellidos;
    }
    /**
     * getCorreo()
     * @return Correo retorna el correo ingresado.
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Invitar
     *
     * Usando el nombre y apellido de un empleado se le asigna una invitacion mediante la clase Invitacion
     */
    @Override
    public void invitar(){
        System.out.println("Se invito al empleado: "+nombre+" "+apellidos);
    }

}