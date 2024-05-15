package doo.tarea2;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reunion reunion = new Reunion();
        Scanner entrada = new Scanner(System.in);

        int numero = -1;
        String palabra;
        //Se supondra que conocemos todas las personas y Departamentos invitables
        Empleado Luis = new Empleado("1", "Luis", "Martinez Neira", "@gmail");
        Empleado Santiago = new Empleado("2", "Santiago", "Diaz Barra", "@utlook");
        Empleado Mario = new Empleado("3", "Mario", "Salgado Jaque", "@hotmail");
        Departamento Ingenieria = new Departamento("Ingenieria");
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);




        while (true) {
            System.out.println("Escriba 1 si desea invitar a un empleado en concreto, 2 para un Departamento y 3 si desea continuar");
            numero = entrada.nextInt();
            if (numero == 3) {
                break;
            } else if (numero == 2) {
                Scanner entrada2 = new Scanner(System.in);
                System.out.println("Indique el nombre del departamento");
                palabra = entrada2.nextLine();
                if (Objects.equals(palabra, Ingenieria.getNombre())) {
                    Ingenieria.invitar();
                }


            } else if(numero == 1){
                Scanner entrada2 = new Scanner(System.in);
                System.out.println("Indique el correo del empleado: ");
                palabra = entrada2.nextLine();
                if (Objects.equals(palabra, Luis.getCorreo())) {
                    Luis.invitar();
                } else if (Objects.equals(palabra, Mario.getCorreo())) {
                    Mario.invitar();
                } else if (Objects.equals(palabra, Santiago.getCorreo())) {
                    Santiago.invitar();
                }
            }


        }
        reunion.iniciar();
        try {
            //Simulamos la duracion de la reunion
            long numero2 = reunion.getDuracionPrevista().getSeconds();
            Thread.sleep(numero2*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        reunion.finalizar();
    }

}
