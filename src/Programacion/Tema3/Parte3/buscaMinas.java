package Programacion.Tema3.Parte3;

import java.util.Random;
import java.util.Scanner;

public class buscaMinas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        char[] tablero = new char[20];
        boolean[] visible = new boolean[20];
        int minas = 6;

        // Tablero
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = '0';
        }

        // Colocar minas aleatoriamente
        int colocadas = 0;
        while (colocadas < minas) {
            int posicion = random.nextInt(tablero.length);
            if (tablero[posicion] != '*') {
                tablero[posicion] = '*';
                colocadas++;
            }
        }

        //Proximidad
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == '*') continue;

            int prox = 0;
            if (i > 0 && tablero[i - 1] == '*') prox++; // Izquierda
            if (i < tablero.length - 1 && tablero[i + 1] == '*') prox++; // Derecha

            tablero[i] = (char) ('0' + prox); // Convertir el número a carácter
        }

        // Juego
        int descubiertas = 0;
        boolean perdido = false;

        while (!perdido && descubiertas < (tablero.length - minas)) {
            // Mostrar tablero al jugador
            System.out.println("Tablero:");
            for (int i = 0; i < tablero.length; i++) {
                if (visible[i]) {
                    System.out.print(tablero[i] + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();


            System.out.println("Selecciona una posición del 1 al 20:");
            int pos = input.nextInt() - 1;


            if (pos < 0 || pos >= tablero.length || visible[pos]) {
                System.out.println("Posición no válida. Inténtalo de nuevo.");
                continue;
            }


            visible[pos] = true;
            if (tablero[pos] == '*') {
                perdido = true;
                System.out.println("¡BOOM! X_X Has perdido. Había una mina!");
            } else {
                descubiertas++;
                if (descubiertas == (tablero.length - minas)) {
                    System.out.println("¡Felicidades! Has descubierto todas las casillas sin minas.");
                }
            }
        }


        System.out.println("Tablero final:");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(tablero[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
