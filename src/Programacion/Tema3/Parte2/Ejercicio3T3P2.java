package Programacion.Tema3.Parte2;

/*3. Añade a MyMath una función que nos indique el número de dígitos de un
número entero.*/

import java.util.Scanner;

public class Ejercicio3T3P2 {
    public static void main (String [] args){

        int num;
        Scanner input = new Scanner (System.in);

        System.out.println("Introduce el número del que quieras saber la longitud.");
        num = input.nextInt();

        System.out.println(num+ " Tienen: "+ MyMath.lengthNum(num) + " dígitos.");
    }
}
