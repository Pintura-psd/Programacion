package Programacion.Estudio_examenRecu.EjercicioFunkosTry1;

import java.util.ArrayList;
import java.util.Scanner;
//Tiempo en completar el ejercicio: 2:03,  1º intento.
public class RecuFunkomain {
    public static void main(String[] args) {
        int menuSelect = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Funko> listaFunkos = RecuFunkoFunciones.importarCSV();

        while (menuSelect == 0){
            RecuFunkoFunciones.menu();
            System.out.println("Introduce una opción.");
            menuSelect = input.nextInt();
            input.nextLine();

            switch (menuSelect){
                case 1:
                    System.out.println("Añadir Funko: ");
                    RecuFunkoFunciones.addFunko(listaFunkos,input);
                    menuSelect = 0;
                    break;
                case 2:
                    System.out.println("Borrar Funko: ");
                    RecuFunkoFunciones.eliminarFunko(listaFunkos,input);
                    menuSelect = 0;
                    break;

                case 3:
                    System.out.println("Mostrando Funkos");
                    RecuFunkoFunciones.mostrarFunkos(listaFunkos);
                    menuSelect = 0;
                    break;
                case 4:
                    System.out.println("Media de precios.");
                    RecuFunkoFunciones.media(listaFunkos);
                    menuSelect = 0;
                    break;
                case 5:
                    System.out.println("Mostar funkos por modelo");
                    RecuFunkoFunciones.mostrarPorModelo(listaFunkos, input);
                    menuSelect = 0;
                    break;
                case 6:
                    System.out.println("Mostrando los funkos de 2023: ");
                    RecuFunkoFunciones.mostrarFunkos2023(listaFunkos);
                    menuSelect = 0;
                    break;
                case 7:
                    System.out.println("El funko con el precio mas caro.");
                    RecuFunkoFunciones.mostrarFunkomasCaro(listaFunkos);
                    menuSelect = 0;
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
