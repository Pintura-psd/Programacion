package Programacion.Tema7;

import java.io.IOException;
import java.util.Scanner;

public class PruebasMain {
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);
        int menuChoice = 0;

        while (menuChoice == 0) {

            Funciones.menu();
            menuChoice = Funciones.menuChoice(read);

            switch (menuChoice) {

                case 1 -> {
                    System.out.println("Hola mundo");
                    menuChoice = 0;
                }
            }
        }
    }
}