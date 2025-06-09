package Programacion.PracticaExamen3ev.Funkos;

import Programacion.Tema7.Funkos.MoviditasFunko;

import java.util.ArrayList;
import java.util.Scanner;

public class Funko2Main {

    public static void main(String[] args) {
        //Importar Lista
        ArrayList<Funko2> listaFuko = MoviditasFunko.importarListaCSV();


        int menuSeleccion = 0;
        Scanner input = new Scanner(System.in);

        while (menuSeleccion == 0){
            MoviditasFunko.menu();
            menuSeleccion = MoviditasFunko.menuSeleccion(input);

            switch (menuSeleccion){
                case 1:
                    System.out.println("Añadir funko: ");
                    MoviditasFunko.añadirFunkos(input,listaFuko);
                    menuSeleccion = 0;
                    break;
                case 2:
                    System.out.println("Borrar Funko");
                    MoviditasFunko.eliminarFunko(listaFuko,input);
                    menuSeleccion = 0;
                    break;
                case 3:
                    System.out.println("Mostrar Funkos");
                    MoviditasFunko.mostrarFunko(listaFuko);
                    menuSeleccion = 0;
                    break;
                case 4:
                    System.out.println("Media de los precios");
                    System.out.println(" ");
                    System.out.println("La media es: "+ MoviditasFunko.media(listaFuko));
                    menuSeleccion = 0;
                    break;
                case 5:
                    System.out.println("Obtener los funkos de ese modelo.");
                   MoviditasFunko.porModelo(input,listaFuko);
                    menuSeleccion = 0;
                    break;
                case 6:
                    System.out.println("Mostrar por fecha: ");
                    MoviditasFunko.porFecha(listaFuko);
                    menuSeleccion = 0;
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    //Serializar lista.
                    MoviditasFunko.seralizacion();
                    MoviditasFunko.deserializar();
                    System.out.println("");
                    System.out.println("y nos fuimos...");
                    menuSeleccion = 1;
                    break;
            }


        }
    }
}
