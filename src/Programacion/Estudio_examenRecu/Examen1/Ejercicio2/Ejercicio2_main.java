package Programacion.Estudio_examenRecu.Examen1.Ejercicio2;

import Programacion.Estudio_examenRecu.Examen1.Ejercicio1.Funko_Pop;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2_main {
    public static void main(String[] args) {
        int seleccion = 0;
        Scanner input = new Scanner(System.in);

        ArrayList<Funko_Pop> listaFunkos = Ejercicio2_funciones.importarListaTxt();
        System.out.println("Lista importada con éxito.");

        while (seleccion == 0){
            Ejercicio2_funciones.menu();
            System.out.println("¿Qué opción buscas?");
            seleccion = input.nextInt();
            input.nextLine();
            Ejercicio2_funciones.menu();
            switch (seleccion){
                case 1:
                    System.out.println("Añadir Funko");
                    Ejercicio2_funciones.addFunko(input,listaFunkos);
                    seleccion= 0;
                    break;
                case 2:
                    System.out.println("Eliminando funko");
                    Ejercicio2_funciones.eliminarFunkos(listaFunkos,input);
                    seleccion = 0;
                    break;
                case 3:
                    System.out.println("Mostrando número total de funkos");
                    Ejercicio2_funciones.contarFunkos(listaFunkos);
                    seleccion = 0;
                    break;
                case 4:
                    System.out.println("El año del Funko-pop más nuevo.");
                    Ejercicio2_funciones.masNuevo(listaFunkos);
                    seleccion = 0;
                    break;
                case 5:
                    System.out.println("El año del Funko-pop más antiguo.");
                    Ejercicio2_funciones.masAntiguo(listaFunkos);
                    seleccion = 0;
                    break;
                case 6:
                    System.out.println("Media del precio entre todos los funkos");
                    Ejercicio2_funciones.average(listaFunkos);
                    seleccion = 0;
                    break;
                case 7:
                    System.out.println("Un momento, serializando lista...");
                    Ejercicio2_funciones.serlializarLista(listaFunkos);
                    System.out.println("Saliendo...");
                    seleccion = 1;
                    break;
            }

        }
    }
}
