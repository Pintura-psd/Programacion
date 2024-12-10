package Programacion.Tema3.Parte1;

/*5) Escribe un programa que pida un número entero por consola de 1 a 10 y
te muestre su tabla de multiplicar.*/

import java.util.Scanner;

public class Ejercicio5T3 {
    public static void main (String [] args){

        int num=0;
        Scanner input=new Scanner(System.in);

        System.out.println("Introduce un múmero del 1 al 10 y te muestro su tabla de multiplicar.");
        num= input.nextInt();

        System.out.println("Esta es tu tabla de multiplicar.");
        System.out.println(" ");

        Funciones.multiplyTable(num);
    }
}