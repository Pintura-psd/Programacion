package Programacion.Tema3.Parte2;

/*4. Añade a MyMath una función que devuelve el número de dígitos pares de
un número entero.*/

import java.util.Scanner;

public class Ejercicio4T3P2 {
    public static void main (String [] args){

        int num;
        int cuantity = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el número del cual quieras cuantos dígitos nuemros pares tiene.");
        num=input.nextInt();

         cuantity = MyMath.lengthNum(num);

         if (cuantity%2==0){
             System.out.println("Tienes "+ (cuantity/2) + " números pares");
         }
         else if(cuantity%2 != 0){
             System.out.println("Tienes "+ ((cuantity/2)) +" números pares");
         }
    }
}
