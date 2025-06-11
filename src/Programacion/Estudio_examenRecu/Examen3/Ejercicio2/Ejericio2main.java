package Programacion.Estudio_examenRecu.Examen3.Ejercicio2;

import Programacion.Estudio_examenRecu.Examen3.Ejercicio1.Funko_pop;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejericio2main {
    public static void main(String[] args) {
        int menuSelect = 0;
        ArrayList<Funko_pop> lsitaFunkos = Ejercicio2Funciones.importarFunkosTxt();
        Scanner input = new Scanner(System.in);

        while (menuSelect == 0){

            System.out.println("¿Que opción deseas?");
            Ejercicio2Funciones.menu();
            menuSelect = input.nextInt();

            switch (menuSelect){
                case 1:
                    System.out.println("Añadir funko");
                    Ejercicio2Funciones.addFunko(lsitaFunkos,input);
                    menuSelect = 0;
                    break;
                case 2:
                    System.out.println("Borrar Funko");
                    Ejercicio2Funciones.borrarFunko(lsitaFunkos,input);
                    menuSelect = 0;
                    break;
                case 3:
                    System.out.println("Mostrar el total de Funko-pops");
                    Ejercicio2Funciones.mostrarLista(lsitaFunkos);
                    menuSelect = 0;
                    break;
                case 4:
                    System.out.println(" Mostrar el más antiguo y el más nuevo.");
                    Ejercicio2Funciones.masAntMasNeo(lsitaFunkos);
                    menuSelect = 0;
                    break;
                case 5:
                    System.out.println(" Media de precios");
                    Ejercicio2Funciones.average(lsitaFunkos);
                    menuSelect = 0;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
