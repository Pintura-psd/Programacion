package Programacion.Tema3;

/*7) Escribe un programa que pida números enteros positivos hasta que se
introduzca el 0, para cada número nos dirá si es primo o no.*/

import java.util.Scanner;

public class Ejercicio7T3 {
    public static void main (String [] args){

        int num=1;
        boolean prime;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce un numero positivo y te diré si es primo o no.");

        while (num>0) {
            num = input.nextInt();
            prime = Funciones.primeNumber(num);

            if (prime == true) {
                System.out.println("Es un número primo.");
            } else {
                System.out.println("No es un número primo.");
            }
        }

        System.out.println("Hasta la siguiente sesión.");
    }
}
