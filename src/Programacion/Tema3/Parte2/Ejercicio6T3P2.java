package Programacion.Tema3.Parte2;

/*6. Añade a MyMath una función que nos calcule el factorial de un número.*/

import java.util.Scanner;

public class Ejercicio6T3P2 {
    public static void main (String[]args){

        int num;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el número del cual quieras saner su factorial.");
        num = input.nextInt();

        System.out.println("El factorias es "+ MyMath.factorial(num));
    }
}

/*No tengo ni idea de que está funcioando. Solo he entendido que con un factorial se usa un for
* ya que sabemos el número de veces que vamos a repetir algo, el número que se multiplica pues n veces.
*  La matemática interna ni idea.*/