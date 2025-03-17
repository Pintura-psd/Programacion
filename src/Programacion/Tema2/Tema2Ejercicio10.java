package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio10 {
    public static void main (String [] args){
        /* Realiza un programa que indique si los 3 números que pedimos por
teclado están ordenados de menor a mayor o no.*/

        double num1;
        double num2;
        double num3;
        Scanner input=new Scanner(System.in);

        System.out.println("Introduce tres números y te diré si están ordenados.");

        num1=input.nextDouble();
        num2=input.nextDouble();
        num3=input.nextDouble();

        if (num1<num2 || num1<num3){
            System.out.println("Están ordenados.");
        }else if (num2<num3 || num2>num1){
            System.out.println("Están ordenados.");
        } else if (num3>num1 || num3>num2) {
            System.out.println("Están ordenados.");
        }else {
            System.out.println("No están ordenados");
        }

        input.close();
    }
}
