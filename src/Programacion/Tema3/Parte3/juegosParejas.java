package Programacion.Tema3.Parte3;

import java.util.Random;
import java.util.Scanner;

public class juegosParejas {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] animales = {"oso","ornitorinco","lobo","pulpo","mono","cabra","perro","gato","rata","capira"};
        String[] tablero = new String[20];
        int paresEncontrados = 0;
        int pos1 = 0;
        int pos2 = 0;
        boolean[] visible = new boolean[20];

        //Esto crea los pares
        for (int i = 0; i < 10; i++){
            tablero[i * 2] = animales[i];
            tablero[i * 2 + 1] = animales[i];
        }

        //Mezclar el tablero
        for (int i = 0; i < tablero.length; i++) {
            int j = random.nextInt(tablero.length);
            String temp = tablero[i];
            tablero[i] = tablero [j];
            tablero[j] = temp;
        }
        System.out.println("Tablero mezclado: "+ String.join(" ", tablero));

        while (paresEncontrados < 10){
            //Mostrar tablero:
                System.out.println("Tablero: ");
                for (int i = 0;i < tablero.length; i++){
                    if (visible[i]){
                        System.out.print(tablero[i] + " "); //No se porque no me funciona imprimir array directamente
                    }
                    else  {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            //Verifica que la posición este en el rango del índice y esté visible.
            System.out.println("Selecciona la PRIMERA posición del 1 al 20");
            pos1 = input.nextInt() -1;
            while (pos1 < 0 || pos1 > 20 || visible[pos1]){
                System.out.println("La posición no es válida o ya es visible.");
                pos1 = input.nextInt() -1; //Ajusta el indice.
            }


            System.out.println("Selecciona la SEGUNDA posición del 1 al 20");
            pos2 = input.nextInt() -1;
            while (pos2 < 0 || pos2 >= 20 || visible[pos2]){
                System.out.println("La posición no es válida o ya es visible");
                pos2 = input.nextInt()-1;
            }


            if (tablero[pos1].equals(tablero[pos2])) {
                System.out.println("Has encontrado una pareja!");
                visible[pos1] = true;
                visible[pos2] = true;
                paresEncontrados++;}
            else {
                System.out.println("No es su pareja, intentalo de nuevo.");
            }

            try {
                //Esto de aquí no se exactamente qué es, parece que es para pausar.
                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
