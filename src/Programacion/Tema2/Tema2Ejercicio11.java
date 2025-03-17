package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio11 {
    public static void main (String [] args){

        /*Realiza un programa que indique si los 3 números enteros que pedimos
por consola son consecutivos o no. */

        double num1;
        double num2;
        double num3;
        Scanner input=new Scanner(System.in);

        System.out.println("Introduce 3 números y te diré si son consecutivos.");

        num1=input.nextDouble();
        num2=input.nextDouble();
        num3=input.nextDouble();

        if (num1==num2+1 && num1==num3+2){
            System.out.println("Son consecutivos.");
        } else if (num1==num3-2 && num1==num2-1) {
            System.out.println("Son consecutivos.");
        } else {
            System.out.println("No son consecutivos.");
        }

        input.close();
    }
}
