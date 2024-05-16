package doo.tarea2;

/**
 *  Clase Nota
 *
 *  Crea una nota tipo String Modificable.
 */
public class Nota {
    private String contenido;

    /**
     * Constructor Nota
     * @param contenido contenido de la nota
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @return contenido ya existente en la nota
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @param contenido recibe el contedido de la nota ya modificada
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public void tostring(){
        System.out.println("Permite crear notas sobre la reunion");
    }
}
