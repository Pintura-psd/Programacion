package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio2 {
    public static void main(String [] args){

// Realiza un programa que lea por consola la base y la altura de un
//rectángulo y mostrará por consola la superficie y el perímetro

        double lado1;
        double lado2;
        Scanner input= new Scanner(System.in);

        System.out.println("Escribe el tamaño de los lados de tu rectángulo.");

        lado1=input.nextDouble();
        lado2=input.nextDouble();

        System.out.println("Tú área es de "+ (lado1*lado2) + " y tú perímetro es de "+(lado1*2+lado2*2));

        input.close();
    }
}
