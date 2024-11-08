package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio24 {
    public static void main (String[] arg){
        /*24. Realiza un programa que permite a un profesor introducir la nota de un
número indefinido de alumnos y le indica cuántos suspendidos o
aprobados hay*/

    int alumnos;
    int pass;
    int dont;
    double mark;
    Scanner input= new Scanner(System.in);

    pass=0;
    dont=0;
    alumnos=0;

    System.out.println("Inroduce la nota de tus alumnos para saber si estás suspendidos. Si quieres para introduce cualquier valor negativo");
    mark=input.nextDouble();

        //quitar system.out duplicados
    while (mark>=0){
        if (mark>4 && mark<11){
            System.out.println("Ha aprobado");
            pass++;
            alumnos++;
            System.out.println("Introduce la siguiente nota.");
            mark=input.nextDouble();
        }
        else if (mark<5 && mark>=0) {
            System.out.println("Ha suspendido");
            dont++;
            alumnos++;
            System.out.println("Introduce la siguiente nota.");
            mark=input.nextDouble();
        }else if (mark>=11) {
            System.out.println("Esta nota no es válida. Introduce la siguiente nota.");
            mark=input.nextDouble();
        }

    }
    System.out.println("De tus: "+ alumnos +" Han aprobado: "+ pass +" Han suspendido: "+ dont);
input.close();
    }
}
