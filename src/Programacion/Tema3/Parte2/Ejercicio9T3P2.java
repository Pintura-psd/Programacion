package Programacion.Tema3.Parte2;

/*9. Añade una función a MyMath que sume los dígitos de un número entero.*/

import java.util.Scanner;

public class Ejercicio9T3P2 {
    public static void main (String [] args){

        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un número para sumar sus dígitos.");
        num = input.nextInt();

        System.out.println("La suma de sus dígitos es "+ MyMath.DigitPlus(num));
    }
}
