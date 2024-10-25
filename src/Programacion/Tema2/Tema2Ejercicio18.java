package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio18 {
    public static void main( String [] arg){

        /* Realiza un programa que calcula la raíz cuadrada de un número. Si el
número es negativo debe mostrar un mensaje de error*/

    double root;
    double num;
    Scanner input=new Scanner(System.in);

    System.out.println("Introduce el numero del que quieras saber su raíz cuadrada.");
    num=input.nextDouble();

    if (num>=0){
        root= Math.sqrt(num);
        System.out.println("Tú resultado es "+ root);
    }else {
        System.out.println("ERROR: NUM IT'S NEGATIVE");
    }
    input.close();

    }
}
