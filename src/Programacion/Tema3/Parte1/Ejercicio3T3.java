package Programacion.Tema3.Parte1;

/*3) Crea un programa que pida al usuario un radio válido por teclado (>0) y
calcule la superficie y perímetro de un círculo. Necesitarás implementar
y utilizar las siguientes funciones:
boolean validRadius(radius)
double calculateCirclePerimeter(radius)
double calculateCircleArea(radius) */


import java.util.Scanner;

public class Ejercicio3T3 {
    public static void main (String[] args){

        double radius=0;
        double area;
        double perimetre;
        boolean validRadius;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el valor del radio.");
        radius = input.nextInt();

        validRadius = Funciones.validRadius(radius);
        if (validRadius == true){
            perimetre = Funciones.calculateCirclePerimeter(radius);
            System.out.println("Tú perímetro es: "+ perimetre);

            area = Funciones.calculateCircleArea(radius);
            System.out.println("Tú área es: "+ area);
        }
    input.close();
    }
}
