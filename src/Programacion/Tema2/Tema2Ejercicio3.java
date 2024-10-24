package Programacion.Tema2;

//Realiza un programa que lea por consola la base y la altura de un
//triángulo y mostrará por consola la superficie.

import java.util.Scanner;

public class Tema2Ejercicio3 {
    public static void main (String [] args){

        double base;
        double hight;
        Scanner input= new Scanner(System.in);

        System.out.println("Escribe la base de tú triángulo.");
        base=input.nextDouble();

        System.out.println("Escribe la altura de tú triángulo.");
        hight=input.nextDouble();

        System.out.println("El área de tu triángulo es "+ ((base*hight)/2));

        input.close();

    }
}
