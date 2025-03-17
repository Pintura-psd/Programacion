package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio4 {
    public static void main(String [] args){
//Realiza un programa que lea 3 números por consola y devuelva el
//mayor de ellos.

        double num1;
        double num2;
        double num3;
        double bignum;
        Scanner input= new Scanner(System.in);

        System.out.println( "Introduce los tres números de los cuales quieras saber cual es el mayor.");

        num1=input.nextDouble();
        num2=input.nextDouble();
        num3=input.nextDouble();

        if (num1>num2 && num1>num3) {
            bignum=num1;
        } else if (num2>num1 && num2>num3) {
            bignum=num2;
        }else {
            bignum=num3;
        }
        System.out.println("Tú número más grande es "+bignum);

        input.close();
    }
}
