package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio30 {
    public static void main (String [] arg){
        /*30. Haz una calculadora. La calculadora permitirá hacer varias operaciones.
Pedirá un número real, pedirá una operación (+, -, *, / o %), pedirá otro
número real y mostrará el resultado por consola. A continuación pedirá
los datos para una nueva operación. Piensa en un modo para que se
pueda salir de la calculadora en cualquier momento.*/

    double num1=0;
    double num2=0;
    char suma='+';
    char multiplicación='*';
    char resta='-';
    char division='/';
    char resto='%';
    Scanner input= new Scanner(System.in);

    System.out.println("Esta calculadora no admite números negativos");
    System.out.println("Si quieres cerrar la calculadora introduce un valor negativo");


    while(num1>0 || num2>0){
        System.out.println("Introduce el primer número con el que quieres operar.");
        num1=input.nextInt();
        System.out.println("Introduce el segundo número con el que quieres operar");
        num2=input.nextInt();
        //Ahora habría que meter un switch para elegir la operación, pero no me acuerdo.



    }



    }
}
