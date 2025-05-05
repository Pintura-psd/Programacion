package Programacion.Tema7.Funkos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static Programacion.Tema7.Funkos.FunkosMain.input;
import static java.util.stream.Collectors.toList;

public class FunkoMetodos {

    //Menú
    public static void menu() {
        System.out.println("MENU:");
        System.out.println("Selecciona una opción:");
        System.out.println("Añadir funkos: 1");
        System.out.println("Borrar funkos: 2");
        System.out.println("Mostrar todos los funkos: 3");
        System.out.println("Mostrar la media del precio de los funkos: 4");
        System.out.println("Mostrar grupos de Funkos: 5");
        System.out.println("Mostrar funkos lanzados en 2023: 6");
    }

    //Seleccionar menu
    public static int seleccion(Scanner input) {

        int seleccion = 0;

        try {
            seleccion = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Introduce un numero entero." + e.getMessage());
        } finally {

            if (seleccion < 0 || seleccion > 8) {

                System.out.println("Debes introducir una opción válida.");
                seleccion = 0;
            }

            input.nextLine();

        }
        return seleccion;
    }

    //Importar CSV
    public static ArrayList<Funko> importCSV() {
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        ArrayList<Funko> listaFunkosImportada = new ArrayList<>();

        if (!Files.exists(rutaArchivo)) {
            System.err.println("El archivo no existe.");
        } else {

            try {
                Stream<String> contenidoFichero = Files.lines(Paths.get(rutaArchivo.toString()));
                System.out.println("Leyendo fichero...");
                //Preguntar bien cómo funciona esto.
                List<List<String>> listaFunkos = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();

                for (int i = 1; i < listaFunkos.size(); i++) {
                    double funkoPrecio = Double.parseDouble(listaFunkos.get(i).get(3));
                    Funko fukopopo = new Funko(listaFunkos.get(i).get(0), listaFunkos.get(i).get(1), listaFunkos.get(i).get(2), funkoPrecio, listaFunkos.get(i).get(4));
                    listaFunkosImportada.add(fukopopo);
                }

            } catch (IOException e) {
                System.out.println("No se ha podido leer la lista." + e.getMessage());
            }
        }
        return listaFunkosImportada;
    }

    //Guardar Funkos nuevos

}
