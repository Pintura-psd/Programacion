package Programacion.Estudio_examenRecu.Examen3.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecicio1main {
    public static void main(String[] args) {
        int menuSelect = 0;
        ArrayList<Figura> listaFiguras =  new ArrayList<>();
        Scanner input = new Scanner(System.in);

         while (menuSelect == 0){
             Ejecicio1Funciones.menu();
             System.out.println("¿Qué opción deseas?");

             try {
                 menuSelect = input.nextInt();
             } catch (Exception e){
                 System.out.println("Introduce un número entero.");
                 menuSelect = 0;
             }
             if (menuSelect < 1 || menuSelect > 5){
                 System.out.println("Introduce un valor entre 1 y 5");
                 menuSelect = 0;
             }

             switch (menuSelect){
                 case 1:
                     System.out.println("Añadir figura");
                     Ejecicio1Funciones.addFigura(listaFiguras,input);
                     menuSelect = 0;
                     break;
                 case 2:
                     System.out.println("Añadir accesorio");
                     Ejecicio1Funciones.addAccesorio(listaFiguras,input);
                     menuSelect = 0;
                     break;
                 case 3:
                     System.out.println("Mostar listado");
                     Ejecicio1Funciones.mostrarLista(listaFiguras);
                     menuSelect = 0;
                     break;
                 case 4:
                     System.out.println("Mostrar Funkos edición limitada");
                     Ejecicio1Funciones.funkosEdLimitada(listaFiguras);
                     menuSelect = 0;
                     break;
                 case 5:
                     System.out.println("Saliendo...");
                    break;
             }
         }
    }
}
