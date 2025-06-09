package Programacion.Estudio_examenRecu.Examen1.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1_main {
    public static void main(String[] args) {
        int eleccion =  0;
        Scanner input = new Scanner(System.in);
        ArrayList<Figura> listaFiguras = new ArrayList<>();

        while (eleccion == 0){
            Ejercicio1_metodos.menuTexto();
            eleccion = input.nextInt();
            switch (eleccion){
                case 1:
                    System.out.println("Añadir Figura: ");
                    Ejercicio1_metodos.añadirFigura(input,listaFiguras);
                    eleccion = 0;
                    break;
                case 2:
                    System.out.println("Añadir accesorios a una figura de acción: ");
                    Ejercicio1_metodos.addAccesorio(input, listaFiguras);
                    eleccion = 0;
                    break;

                case 3:
                    System.out.println("Mostrando lista de figuras.");
                    Ejercicio1_metodos.mostrarLista(listaFiguras);
                    eleccion = 0;
                    break;
                case 4:
                    System.out.println("Mostrando lista de Funkos edición limitada.");
                    Ejercicio1_metodos.mostrarFunkosLimitados(listaFiguras);
                    eleccion = 0;
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

            if (eleccion > 6 || eleccion < 1){
                System.out.println("Elige un valor adecuado");
                eleccion = 0;
            }
        }
    }
}
