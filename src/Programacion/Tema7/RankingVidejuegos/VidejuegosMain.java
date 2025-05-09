package Programacion.Tema7.RankingVidejuegos;

import java.util.ArrayList;
import java.util.Scanner;

public class VidejuegosMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int seleccion = 0;

        //Como me pide el ejercicio caargar la lista, hay problmeas de sobrescritura.
        //Se arreglaría simplemente cargando la lista al iniciar el programa:
        //listaVideojuegos = MetodosVidejuegos.importarLista();
        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        MetodosVidejuegos.crearFichero();

        while (seleccion == 0){
            MetodosVidejuegos.menu();
            seleccion = MetodosVidejuegos.seleccionMenu(input);

            switch (seleccion){
                case 1:
                    System.out.println(" ");
                    System.out.println("Añadir videjuego:1");
                        MetodosVidejuegos.addJuego(input,listaVideojuegos);
                    seleccion = 0;
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Mostrando Ranking: ");
                    MetodosVidejuegos.mostrarRanking(listaVideojuegos);
                    seleccion = 0;
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Eliminar juego por nombre.");
                    MetodosVidejuegos.eliminarJuego(input,listaVideojuegos);
                    seleccion = 0;
                    break;
                case 4:
                    System.out.println(" ");
                    System.out.println("Guardando ranking...");
                    MetodosVidejuegos.serializarDat(listaVideojuegos);
                    seleccion = 0;
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("Cargando ranking...");
                    listaVideojuegos = MetodosVidejuegos.importarLista();
                    seleccion = 0;
                    break;
                case 6:
                    System.out.println(" ");
                    System.out.println("Escribiendo ranking...");
                    System.out.println(" ");
                    MetodosVidejuegos.exportarTexto(listaVideojuegos);
                    seleccion = 0;
                    break;
                case 7:
                    System.out.println(" ");
                    System.out.println("Ordenando por nota...");
                    MetodosVidejuegos.mostrarPorNota(listaVideojuegos);
                    seleccion = 0;
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
            }

        }

    }
}
