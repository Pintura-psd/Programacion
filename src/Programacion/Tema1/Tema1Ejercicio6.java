package Programacion.Tema1;

import java.util.Scanner;

public class Tema1Ejercicio6 {public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    Double Radius;
    Double Area;

    System.out.println ("Introduce el valor del radio.");
    Radius=input.nextDouble();

    Area= 3.14*Radius*Radius;

    System.out.println("Tu area es:"+ Area);

    input.close();
}

}