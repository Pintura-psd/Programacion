package Programacion.Tema2;


public class Tema2Ejercicio19 {
    public static void main (String[]arg){
        /*19. Escribe un programa que muestra por consola todos los números pares
entre 1 y 1000.*/

        int number;

        number=1;

    while (number<=1000){
        if ( number%2==0){
            System.out.println(number);
        }
        number++;
    }



    }
}
