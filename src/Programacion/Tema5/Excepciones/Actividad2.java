package Programacion.Tema5.Excepciones;
/*2. Implementa un programa que pida dos valores int num1 y num2 utilizando un
nextInt( ) (de Scanner), calcule num1/num2 y muestre el resultado por pantalla.
Se deberán tratar de forma independiente las dos posibles excepciones,
InputMismatchException y ArithmeticException, mostrando en cada caso un
mensaje de error diferente en cada caso.*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class Actividad2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        double result = 0;

        System.out.println("Introduce un valores enteros: ");

        //Se gestiona la excepción de InputMisMatchException

        try {
            System.out.println("Introduce el dividendo:");
            num1 = input.nextInt();
            System.out.println("Introduce el divisor: ");
            num2 = input.nextInt();

            result = num1/num2;

            if (num2 != 0){
                System.out.println("El resultado es: "+ result);
            }

        }
        catch (InputMismatchException e){
            System.out.println("El valor introducido es incorrecto.");
        }
        catch (ArithmeticException e){
            result = 0;
            System.out.println("El resultado es: "+ result);
        }

    }
}
