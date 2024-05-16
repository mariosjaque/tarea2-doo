package doo.tarea2;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Entrada = new Scanner(System.in);

        Reunion reunionV = null;
        while (true){
            System.out.println("Para reunion en linea escriba *Linea* para presencial *Presencial*");
            String Frase = Entrada.nextLine();
            Entrada.reset();
            if(Objects.equals(Frase,"Linea")){
                ReunionVirtual reunion = new ReunionVirtual();
                System.out.println("Escriba a continuacion el link de su reunion: ");
                Frase = Entrada.nextLine();
                reunion.setEnlace(Frase);
                System.out.println("Muy bien su link entonces sera: "+Frase);
                reunionV = reunion;
                break;
            }
            else if(Objects.equals(Frase,"Presencial")){
                ReunionPresencial reunion = new ReunionPresencial();
                System.out.println("Escriba a continuacion el link de su reunion: ");
                reunion.modSala(Frase);
                System.out.println("Muy bien su sala entonces sera: "+Frase);
                reunionV = reunion;
                break;
            }
        }

        int numero = -1;
        String palabra;
        //Se supondra que conocemos todas las personas y Departamentos invitables
        Empleado Luis = new Empleado("1", "Luis", "Martinez Neira", "@gmail");
        Empleado Santiago = new Empleado("2", "Santiago", "Diaz Barra", "@outlook");
        Empleado Mario = new Empleado("3", "Mario", "Salgado Jaque", "@hotmail");
        Departamento Ingenieria = new Departamento("Ingenieria");
        Ingenieria.AñadirEmpleado(Luis);
        Ingenieria.AñadirEmpleado(Santiago);
        Ingenieria.AñadirEmpleado(Mario);




        while (true) {
            Scanner Entrada3 = new Scanner(System.in);
            System.out.println("Escriba 1 si desea invitar a un empleado en concreto, 2 para un Departamento y 3 si desea continuar");
            numero = Entrada3.nextInt();
            if (numero == 3) {
                break;
            } else if (numero == 2) {
                Scanner Entrada2 = new Scanner(System.in);
                System.out.println("Indique el nombre del departamento");
                palabra = Entrada2.nextLine();
                if (Objects.equals(palabra, Ingenieria.getNombre())) {
                    Ingenieria.invitar();
                }


            } else if(numero == 1){
                Scanner Entrada2 = new Scanner(System.in);
                System.out.println("Indique el correo del empleado: ");
                palabra = Entrada2.nextLine();
                if (Objects.equals(palabra, Luis.getCorreo())) {
                    Luis.invitar();
                } else if (Objects.equals(palabra, Mario.getCorreo())) {
                    Mario.invitar();
                } else if (Objects.equals(palabra, Santiago.getCorreo())) {
                    Santiago.invitar();
                }
            }


        }
        reunionV.iniciar();
        try {
            //Simulamos la duracion de la reunion
            long numero2 = reunionV.getDuracionPrevista().getSeconds();
            Thread.sleep(numero2*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        reunionV.finalizar();
    }

}
