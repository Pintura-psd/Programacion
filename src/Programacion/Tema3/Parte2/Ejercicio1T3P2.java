package Programacion.Tema3.Parte2;

/*1. Crea una clase MyMath que tendrá funciones para calcular el perímetro y
el área de un círculo, cuadrado y rectángulo. Los nombres de las
funciones serán:
squarePerimeter
squareArea
rectanglePerimeter
rectangleArea
circlePerimeter
circleArea*/

import Programacion.Tema3.Parte1.Funciones;

import java.util.Scanner;

public class Ejercicio1T3P2 {
    public static void main (String [] args){
        /*Un switch para elegir lo que queremos.*/

        String menu = " ";
        double squareSide = 0;
        double baseRectangle = 0;
        double hightRectangle = 0;
        double radius = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Escribe que quieres hacer: ");
        System.out.println("Square perimetre");
        System.out.println("Square area");
        System.out.println("Rectangle perimetre");
        System.out.println("Rectangle area");
        System.out.println("Circle perimetre");
        System.out.println("Circle area");
        System.out.println(" ");

        menu = input.nextLine();

        switch (menu){
            case "Square perimetre":

                System.out.println("Introduce el valor de tú lado.");
                squareSide = input.nextDouble();

                System.out.println("Tú perímetro es: "+ MyMath.squarePerimetre(squareSide));
                
                break;

            case "Square area":

                System.out.println("Inroduce el valor de tú lado. ");
                squareSide = input.nextDouble();

                System.out.println("Tú area es: "+ MyMath.squareArea(squareSide));

                break;

            case "Rectangle perimetre":

                System.out.println("Introduce el valor de tú base.");
                baseRectangle = input.nextDouble();
                System.out.println("Introduce el valor de tú altura.");
                hightRectangle = input.nextDouble();

                System.out.println("Tú perímetro es: "+ MyMath.rectaglePerimetre(baseRectangle, hightRectangle));

            case "Rectangle area":

                System.out.println("Introduce el valor de tú base.");
                baseRectangle = input.nextDouble();
                System.out.println("Introduce el valor de tú altura.");
                hightRectangle = input.nextDouble();

                System.out.println("Tú área es: "+ MyMath.areaRectangle(baseRectangle, hightRectangle));

            case "Circle perimetre":

                System.out.println("Introduce tú radio.");
                radius = input.nextDouble();

                System.out.println("Tú perímetro es: "+ MyMath.circlePerimetre(radius));

            case "Circle area":

                System.out.println("Introduce tú radio.");
                radius = input.nextDouble();

                System.out.println("Tú area es: "+ MyMath.circleArea(radius));
        }
    }
}
