package Programacion.Tema3.Parte2;

/*8. Añade una función a MyMath que recibirá 3 coeficientes de una ecuación
de segundo grado y devolverá cuántas soluciones tiene la ecuación (2, 1
o 0). */

import java.util.Scanner;

public class Ejercicio8T3P2 {
    public static void main (String [] args){

        int a = 0, b = 0, c = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce los valores de los coeficientes de tu ecuación de segundo grado.");
        System.out.println("Introduce el valor de a");
        a = input.nextInt();
        System.out.println("Introduce el valor de b");
        b = input.nextInt();
        System.out.println("Introduce el valor de c");
        c = input.nextInt();

        System.out.println("Tú encuación tiene "+ MyMath.discriminant(a,b,c) +" soluciones posibles.");
    }
}
