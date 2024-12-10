package Programacion.Tema3.Parte2;

/*2. Añade una función a MyMath que nos diga si un número es primo. Añade
otra función que nos diga si un número NO es primo (reutiliza código).*/

import java.util.Scanner;

public class Ejercicio2T3P2 {
    public static void main (String [] args){

        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce un numero y te diré si es primo.");
        System.out.println("Recuenda que un número primo ha de ser entreo y positivo.");
         num = input.nextInt();

         if (num>0){
             if (MyMath.primeNumber(num))
                 System.out.println(num +" Es un número primo");
             else if (MyMath.primeNumber(num)==false) {
                 System.out.println(num +" No es un número primo");
             }
         }
         else {
             System.out.println("No es un número valido");
         }

    }
}
