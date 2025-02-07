package Programacion.Tema3.Parte4;
/* Realiza el juego del Lingo en una clase llamada Lingo. El jugador tiene que
adivinar una palabra de 5 letras con un máximo de 5 intentos. En cada intento
el jugador indica una palabra de 5 letras y el ordenador le indica que letras
están en la posición correcta y qué letras están contenidas en la palabra pero
no en la posición correcta. */

import java.util.Arrays;
import java.util.Scanner;

public class Lingo {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        String word = " ";
        int tries = 0;
        String wordUsu = " ";
        boolean solve = false;
        String [] words = {"artes","feo","heroe"};
        int randomPos = (int)Math.floor(Math.random() * ((words.length)));
        word = words[randomPos];
        char [] letters = word.toCharArray();
        char [] barraBaja = new char[letters.length];

        for (int i = 0; i < letters.length; i++){
            barraBaja[i ]= '_';
        }
        System.out.println(barraBaja);

        System.out.println("Adivina la palabra.");
        System.out.println("Tienes 5 intentos");

        while (tries < 5 && solve == false){
            System.out.println(barraBaja);
            System.out.println("Introduce una palabra.");
            wordUsu = input.nextLine();
            char [] tempWord = wordUsu.toCharArray();

            for (int i = 0; i < letters.length;i++){
               //Importante ajustar los indices. Preguntar a Ana sobre los limites de las arrays
                if (i < tempWord.length && letters[i] == tempWord[i]){
                    barraBaja[i] = tempWord[i];
                }
                //Repasar los metodos de arrays.
                else if (i < tempWord.length && word.contains(String.valueOf(tempWord[i])) && letters[i] != tempWord[i]){
                    barraBaja[i] = '*';
                }
            }
            if (Arrays.equals(barraBaja,letters)) {
                System.out.println("Has ganado!");
                solve = true;
            }

            System.out.println(barraBaja);
            System.out.println("Intentos restantes: "+ (5-tries));
            tries++;
        }
        if (!solve){
            System.out.println("La palabra era: "+ word );
        }
    }
}
