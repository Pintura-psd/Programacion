package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio8 {
    public static void main (String [] args){

        /*Realiza un conversor de euros a dólares.*/

        double euros;
        Scanner input= new Scanner(System.in);


        System.out.println("Introduce la cnatidad de euros que quieras pasar a dólares.");

        euros=input.nextDouble();

        System.out.println("Tienes un total de "+ (euros*1.0825)+"dólares.");

        input.close();
    }
}
