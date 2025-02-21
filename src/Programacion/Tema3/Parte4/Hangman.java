package Programacion.Tema3.Parte4;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        String word = " ";
        char letterUSU = ' ';
        boolean solve = false;
        boolean letraCorrecta = false;
        int tries = 0;

        System.out.println("Juego del ahorcado.");
        System.out.println("Tienes 6 intentos");
        System.out.println("Introduce la palabra para comenzar el juego.");
        word = input.nextLine();
        char [] letters = word.toCharArray();
        char [] barraBaja = new char[letters.length];

        for (int i = 0; i < letters.length; i++){
            barraBaja[i ]= '_';
        }
        System.out.println(barraBaja);

        //No entiendo bien cuando usar el || o el &&.
        while (tries < 6 && solve == false){

            letraCorrecta = false;
                System.out.println("Introduce una leta de la A a la Z");
                //input.nextLine();
                letterUSU = input.next().charAt(0);

            for (int i = 0; i < letters.length; i++){
                if (letters[i] == letterUSU ){
                    barraBaja[i] = letterUSU;
                    System.out.println("Bien hecho!");
                    System.out.println(barraBaja);
                }
            }
            //Esto es para que no sume si es correcto.
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == letterUSU) {
                    barraBaja[i] = letterUSU;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                monigote(tries);
                tries++;
            }

            if (Arrays.equals(barraBaja,letters)){
                //Importante el .equals para comprar arrays
                solve=true;
                System.out.println("Has ganado!");
             }
        }
    }

    public static void monigote (int tries){
        switch (tries){
            case 0 :
                System.out.println("Oh, no...!");
                System.out.println("Intentos: "+ (5 - tries));
                System.out.println(" O ");
                break;
            case 1:
                System.out.println("Oh, no...!");
                System.out.println("Intentos: "+ (5 - tries));
                System.out.println("  O ");
                System.out.println("/ ");
                break;
            case 2:
                System.out.println("Oh, no...!");
                System.out.println("Intentos: "+ (5 - tries));
                System.out.println("  O ");
                System.out.println("/ |");
                break;
            case 3:
                System.out.println("Oh, no...!");
                System.out.println("Intentos: "+(5 - tries));
                System.out.println("  O ");
                System.out.println("/ | \\ ");
                break;
            case 4:
                System.out.println("Oh, no...!");
                System.out.println("Intentos: "+(5 - tries));
                System.out.println("  O ");
                System.out.println("/ | \\ ");
                System.out.println("/   ");
                break;
            case 5:
                System.out.println("Déjalo, ya no respira... X_X");
                System.out.println("Intentos: "+(5 - tries));
                System.out.println("  O ");
                System.out.println("/ | \\ ");
                System.out.println("/   \\ ");
                break;
        }
    }
}
