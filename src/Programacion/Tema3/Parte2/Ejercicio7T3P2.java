package Programacion.Tema3.Parte2;

/*7. Añade a MyMath una función que nos calcule el factorial de un número
(de manera recursiva).*/

import java.util.Scanner;

public class Ejercicio7T3P2 {
    public static void main (String [] args){

        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un número del cual quieras saber su factorial");
        num = input.nextInt();

        System.out.println("El factorial de "+ num + " es "+ MyMath.recursiveFactorial(num));

    }
}
