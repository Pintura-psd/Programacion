package Programacion.Tema3;

/*4) Escribe un programa que permita pasar de euros a dólares y de dólares
a euros. Necesitarás implementar el procedimiento showMenu() y las
funciones euro2dollar y dollar2euro.*/

import java.util.Scanner;

public class Ejercicio4T3 {
    public static void main (String [] args){
//Importante: Los procedimientos no devuelven valores. Se usan para realizar acciones por ejemplo.

        String converter = " ";
        double euros=0;
        double dollars=0;
        double dollarsConversion=0;
        double eurosConversion=0;
        Scanner input= new Scanner(System.in);

        Funciones.showMenu();

        converter = input.next();

        switch (converter){
            case "Dólares":
                System.out.println("Introduce la cantidad de Dólares que quieres pasar a Euros.");
                dollars = input.nextDouble();
                dollarsConversion = Funciones.dollar2euro(dollars);
                System.out.println("Tienes "+ dollarsConversion +" €");
                break;
            case "Euros":
                System.out.println("Introduce la cantidad de Euros que quieres pasar a Dólares");
                euros = input.nextDouble();
                eurosConversion = Funciones.euro2dollar(euros);
                System.out.println("Tienes "+ eurosConversion +" $");
                break;
        }
        //Recuerda que tienes que usar la variable donde guardas la acción de la función.
        input.close();
    }
}
