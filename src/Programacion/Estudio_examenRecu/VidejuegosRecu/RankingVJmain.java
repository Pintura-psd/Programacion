package Programacion.Estudio_examenRecu.VidejuegosRecu;

import java.util.ArrayList;
import java.util.Scanner;

public class RankingVJmain {
    public static void main(String[] args) {
        int menuSelect  = 0;
        Scanner in = new Scanner(System.in);
        ArrayList<VJ> listaVJ = RankingVJFunciones.deserializar();

        while (menuSelect == 0){
            RankingVJFunciones.menu();
            menuSelect = in.nextInt();

            switch (menuSelect){
                case 1:
                    System.out.println("Añadir videojuego: ");
                    RankingVJFunciones.addVJ(listaVJ,in);
                    menuSelect = 0;
                    break;
                case 2:
                    RankingVJFunciones.mostrarRanking(listaVJ);
                    menuSelect = 0;
                    break;
                case 3:
                    System.out.println("Eliminar video juego por titulo: ");
                    RankingVJFunciones.eliminarVJ(listaVJ,in);
                    menuSelect = 0;
                    break;
                case 4:
                    System.out.println("Guardar raking en binario: ");
                    RankingVJFunciones.serialziar(listaVJ);
                    menuSelect = 0;
                    break;
                case 5:
                    System.out.println("Ordenar por nota.");
                    RankingVJFunciones.ordenarPorNota(listaVJ);
                    menuSelect = 0;
                    break;
                case 6:
                    System.out.println("Exportando a fichero.txt");
                    RankingVJFunciones.exportarATexto(listaVJ);
                    menuSelect = 0;
                    break;
                case 7:
                    System.out.println("Demo jugalbe");
                    RankingVJFunciones.jugable(listaVJ,in);
                    menuSelect = 0;
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;

            }
        }
    }
}
