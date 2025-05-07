package Programacion.Tema7.Funkos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunkosMain {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Iimportar CSV
        ArrayList<Funko> listaImportadaFunkos = FunkoMetodos.importCSV();
        //Menu

        int menuSeleccion = 0;


        while (menuSeleccion == 0) {
            FunkoMetodos.menu();
            menuSeleccion = FunkoMetodos.seleccion(input);
            switch (menuSeleccion) {
                case 1:
                    System.out.println("Añadir funko");
                    FunkoMetodos.addFunkos(input,listaImportadaFunkos);
                    break;
                case 2:
                    System.out.println("Borrar funko");
                    FunkoMetodos.borrarFunko(input,listaImportadaFunkos);
                    break;
                case 3:
                    System.out.println("Mostrar todos los fukos");
                    FunkoMetodos.mostrarFunkos(FunkoMetodos.importCSV());
                    break;
                case 4:
                    System.out.println("Media del precio funkos");
                    System.out.println("La media del precio es: "+ FunkoMetodos.mediaFunkos(listaImportadaFunkos));
                    break;
                case 5:
                    System.out.println("Mostrar grupos por modelo de funko");
                    FunkoMetodos.funkosPorGrupos(input, listaImportadaFunkos);
                    break;
                case 6:
                    System.out.println("Mostrar funkos 2023");
                    FunkoMetodos.funkosPorFecha(input,listaImportadaFunkos);
                    break;
                case 7:
                    System.out.println("Cerrando");
                    break;
            }
        }
    }
}
