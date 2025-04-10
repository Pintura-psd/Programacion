package Programacion.Tema5.Excepciones;

import java.util.Scanner;
/* 1. Implementa un programa que pida al usuario un valor entero num utilizando
un nextInt( ) (de Scanner) y luego muestre por pantalla el mensaje “Valor
introducido: ...”. Se deberá tratar la excepción InputMismatchException que
lanza nextInt( ) cuando no se introduce un entero válido. En tal caso se mostrará
el mensaje “Valor introducido incorrecto” */
public class Actividad1 {
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        int num = 0;

        System.out.println("Introduce un valor entero");

        //Se gestiona la excepción de InputMisMatchException
        try {
            num = input.nextInt();

        }
        catch (Exception e){
            System.out.println("El valor introducido es incorrecto.");
        }

        System.out.println("El número sumado por si mismo es: " + num + num);
    }
}
