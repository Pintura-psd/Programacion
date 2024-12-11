package Programacion.Tema3.Parte2;

/*4. Añade a MyMath una función que devuelve el número de dígitos pares de
un número entero.*/

import java.util.Scanner;

public class Ejercicio4T3P2 {
    public static void main (String [] args){
        int num;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el número del cual quieras cuantos dígitos nuemros impares tiene.");
        num=input.nextInt();

        System.out.println(num+ " Tiene "+ MyMath.pairPosition(num) +" en posición par." );

    }
}
