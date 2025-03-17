package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio1 {
    public static void main(String [] args) {
        //Realiza un programa que lea por consola el lado de un cuadrado y
        //mostrará por consola la superficie y el perímetro.

        double lado;
        Scanner input= new Scanner(System.in);

        System.out.println("Escribe el tamaño del lado de tu cuadrado.");

       lado=input.nextDouble();

        System.out.println("Tú área es de "+ (lado*lado) + " y tú perímetro es de "+(lado*4));

        input.close();
    }
}
