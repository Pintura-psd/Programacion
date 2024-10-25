package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio9 {
    public static void main (String [] args){

        /*Realiza un conversor de dólares a euros.*/

        double dolares;
        Scanner input= new Scanner(System.in);


        System.out.println("Introduce la cnatidad de dolares que quieras pasar a euros.");

        dolares=input.nextDouble();

        System.out.println("Tienes un total de "+ (dolares*0.92)+" euros.");

        input.close();
    }
}