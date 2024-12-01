package Programacion.Tema3;


/*8) Escribe un programa que lea por consola un día (1-31), un mes (1-12) y
un año y nos indique si la fecha es correcta o no.*/

import java.util.Scanner;

import static Programacion.Tema3.Funciones.correctDate;

public class Ejercicio8T3 {
    public static void main (String [] args){
            int month;
            int day;
            int year;
            Scanner input = new Scanner(System.in);

            System.out.println("Introduce el mes con números.");
            month = input.nextInt();
            System.out.println("Introduce el día en números");
            day = input.nextInt();
            System.out.println("Introduce el año en números");
            year = input.nextInt();

            Funciones.correctDate(month, day, year);
    }
}