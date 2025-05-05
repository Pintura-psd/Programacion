package Programacion.Tema7.Funkos;

import java.util.List;
import java.util.Scanner;

public class FunkosMain {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int menu = 0;
        String seleccionString = "";

        while (menu == 0)
        FunkoMetodos.menu();
        menu = FunkoMetodos.seleccion(input);

        while (menu == 0) {
            switch (menu) {
                case 1:
                    System.out.println("Añadir funko");
                    break;
                case 2:
                    System.out.println("Borrar funko");
                    break;
                case 3:
                    System.out.println("Mostrar todos los fukos");
                    break;
                case 4:
                    System.out.println("Media del precio funkos");
                    break;
                case 5:
                    System.out.println("Mostrar grupos de funkos");
                    break;
                case 6:
                    System.out.println("Mostrar funkos 2023");
                    break;
                case 7:
                    System.out.println("Cerrando");
                    break;
            }
        }
    }
}
