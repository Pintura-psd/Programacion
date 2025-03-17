package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio22 {
    public static void main (String[]arg){
        /*22. Realiza un programa que lea por consola un número entero e indique
cuántas cifras tiene. Pista: usa varias divisiones entre 10.*/

        int num;
        int contador;
        Scanner input=new Scanner(System.in);

        contador=0;

        System.out.println("Introduce el número entero. Yo te diré cuantas cifras tiene.");
        num= input.nextInt();

        while (num>0){
            num=num/10;
            contador++;
        }

        System.out.println("Tú número tiene: "+ contador +" cifras." );
    }
}
