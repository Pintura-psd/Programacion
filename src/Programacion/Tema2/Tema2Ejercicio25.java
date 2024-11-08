package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio25 {
    public static void main (String[]arg){
    /*25. Haz un programa que pide un número entero por consola y calcula el
factorial. Por ejemplo el factorial de 5 es:
5! = 5 * 4 * 3 * 2 * 1*/

        int num;
        int result;
        Scanner input=new Scanner(System.in);

        result=1;

        System.out.println("Introduce un número y te diré su factorial.");
        num= input.nextInt();

        for (int i=1; i<=num; i++){
        result *=i;

        }

        System.out.println(result);
input.close();
    }
}
