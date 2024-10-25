package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio6 {
    public static void main(String [] args){

        /*Realiza un programa que determina si el número leído por consola es
positivo, negativo o zero.*/

        double num1;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce elúmero y te diré si es positivo, negrativo o neutro.");
        num1=input.nextDouble();

        if (num1>0){
            System.out.println(num1+ " es positivo.");
        }else if (num1<0){
            System.out.println(num1+" es negativo.");
        }else{
            System.out.println(num1 +" es neutro");}

    input.close();
    }
}
