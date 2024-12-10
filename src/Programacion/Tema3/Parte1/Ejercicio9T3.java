package Programacion.Tema3.Parte1;

/*9) Escribe un procedimiento que muestre por pantalla un triángulo como el
que hay a continuación. Recibirá 2 parámetros: el carácter y el número
de líneas del triángulo.

     a
    aaa
   aaaaa
  aaaaaaa
 */

import java.util.Scanner;

public class Ejercicio9T3 {
    public static void main (String [] args){

        char symbol;
        int hightLines;
        Scanner input = new Scanner(System.in);

        System.out.println("Vamos a construir un triángulo.");
        System.out.println(" ");
        System.out.println("Introduce el carácter con el con el cual contruiremos el triángulo: ");
        symbol = input.next().charAt(0);

        System.out.println("Ahora dime cuantas líneas quieres que formen el triángulo.");
        hightLines = input.nextInt();

        //Aqui entra función.
        Funciones.chactPiramid(hightLines, symbol);
    }
}
