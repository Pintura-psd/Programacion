package Programacion.Tema7;

import Programacion.Tema7.RankingVidejuegos.Videojuego;

import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {
    public static void menu(){

        System.out.println(" ");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("--- Ranking de Videojuegos ---");
        System.out.println(" ");
        System.out.println("1. Añadir videojuego");
        System.out.println("2. Mostrar ranking");
        System.out.println("3. Guardar ranking");
        System.out.println("4. Cargar ranking");
        System.out.println("5. Eliminar videojuego");
        System.out.println("6. Exportar a texto");
        System.out.println("7. Ordenar ranking por nota");
        System.out.println("8. Salir");
        System.out.println(" ");
    }

    public static int menuChoice(Scanner read){

        int menuChoice = 0;

        try {

            menuChoice = read.nextInt();

        } catch (Exception e){

            System.out.println(" ");
            System.out.println("Introduce un entero.");
            read.nextLine();

        } finally {

            if (menuChoice < 0 || menuChoice > 8){

                System.out.println(" ");
                System.out.println("Selecciona una opción válida.");
                menuChoice = 0;

            }

        }

        return menuChoice;

    }

}
