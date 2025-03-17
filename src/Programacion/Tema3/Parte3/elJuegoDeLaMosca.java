package Programacion.Tema3.Parte3;
/*Realiza el juego “Atrapa a la mosca”. Hay un array de 15 elementos (no
visible por el jugador). El jugador selecciona una posición (entre 1 y 15) si la
mosca se encuentra en dicha posición, el jugador ha ganado. Si la mosca se
encuentra en una posición adyacente, aleatoriamente cambia de posición. Si
la mosca no se encuentra en una posición adyacente, no se mueve. */

import java.util.Scanner;

public class elJuegoDeLaMosca {
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        int[] array = new int[15];
        int flyPosition = 0;
        boolean winCondition = false;
        int playerPoint ;

        flyPosition = (int) (Math.random() * 15)+1;

        array[flyPosition] = 1;

        System.out.println("!Introduce un número del 1 al 15 para enconctar a la mosca!");

        while (!winCondition){
            MyArray.printArray(array);
            playerPoint = input.nextInt()-1;
            if (playerPoint > 15 || playerPoint < 0) {
                System.out.println("No es  una posición válida");
                System.out.println("Introduce otra posición.");
            }
            else if (playerPoint == flyPosition+1 || playerPoint == flyPosition-1){
                System.out.println("La mosca se ha movido! X_X' ");
                flyPosition = (int) (Math.random() * 15);
                array[flyPosition] = 1;
            }
            else if (playerPoint == flyPosition) {
                System.out.println("Has atrapado a la mosca! Ò.Ó");
                winCondition = true;
            }
            else {
                System.out.println("Ahí no está! @_@");
            }
        }
    }
}
