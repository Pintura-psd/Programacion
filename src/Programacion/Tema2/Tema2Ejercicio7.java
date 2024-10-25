package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio7 {
    public static void main (String [] args){
        /*Realiza un programa que lea 2 números por consola y al más grande le
reste el más pequeño.*/

        double num1;
        double num2;
        double result;
        Scanner input=new Scanner(System.in);

        System.out.println("Introduce los dos números que quieras restar. Ten en cuenta que al mayor se le va a restar el pequeño.");

        num1=input.nextDouble();
        num2= input.nextDouble();

        if ( num1>num2){
            result=num1-num2;
        } else {
            result=num2-num1;
        }

        System.out.println("El resultado es "+ result);

        input.close();
    }
}
