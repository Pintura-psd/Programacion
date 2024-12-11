package Programacion.Tema3.Parte2;

import java.util.Scanner;

/*5. Añade a MyMath una función que devuelve el número de dígitos impares
de un número entero.*/
public class Ejercicio5T3P2 {
    public static void main (String [] args ){

        int num;


        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el número del cual quieras cuantos dígitos nuemros impares tiene.");
        num=input.nextInt();

        System.out.println(num +" Tiene "+ MyMath.oddPosition(num)+ " en posición inpar.");
    }
}
