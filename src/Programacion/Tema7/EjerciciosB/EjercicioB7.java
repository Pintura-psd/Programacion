package Programacion.Tema7.EjerciciosB;
/*Implementa un programa que lea un documento de texto y muestre por pantalla algunos datos
estadísticos: nº de líneas, nº de palabras, nº de caracteres y cuáles son las 10 palabras más
comunes (y cuántas veces aparecen). Prueba el programa con los archivos de la carpeta ‘Libros*/

/*NOTA: Para llevar la cuenta de cuántas veces aparece cada palabra puedes utilizar una
HashTable. Una tabla hash es una estructura de datos tipo colección (como el ArrayList), que
permite almacenar pares clave-valor. Por ejemplo {“elefante”, 5} o {“casa”, 10} son pares
<String,Integer> que asocian una palabra (clave) con un nº entero (valor).*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EjercicioB7 {

    public static void main(String[] args) {
        Path rutaLibros = Paths.get("Documentos/Libros");
        Scanner input = new Scanner(System.in);
        File Libros = rutaLibros.toFile();
        System.out.println("Introduce el nombre del libro del cual quieres saber las estadísticas.");
        String nombreLibro = input.nextLine() + ".txt";

            if (Libros.exists()) {
                if (!new File(rutaLibros + "/" + nombreLibro).exists()){
                    System.out.println("El libro que buscas no existe.");
                }
                else {
                    contadorDePalabras(nombreLibro);
                    contadorDeLineas(nombreLibro);
                    topPalabras(nombreLibro);
                }
            } else {
                System.out.println("La carpeta libros no existe.");
            }
        }

    public static void contadorDePalabras (String nombreLibro){
        List<String> lineas = new ArrayList<>();
        Path rutaLibros = Paths.get("Documentos/Libros/" + nombreLibro);
        String cadenaLineas;

        try {
            lineas = Files.readAllLines(rutaLibros);
        }
        catch (IOException e){
            System.out.println("Problemas al reconocer el libro." + e.getMessage());
        }
        //Espacio como delimitador para evitar entradas vacías. trim(); nos juntará tabulaciones y demás espacios "raros".
        cadenaLineas = String.join(" ", lineas).trim();
        //Separar por cualquier cantidad de espacios en blanco \\s+
        String[] numPalabras = cadenaLineas.split("\\s+");
        System.out.println("El número de palabras son: " + numPalabras.length);
    }

    public static void contadorDeLineas (String nombreLibro){
        List<String> lineas = new ArrayList<>();
        Path rutaLibros = Paths.get("Documentos/Libros/" + nombreLibro);

        try {
            lineas = Files.readAllLines(rutaLibros);
            System.out.println("El numero de líneas es: "+ lineas.size());
        }
        catch (IOException e){
            System.out.println("Problemas al reconocer el libro." + e.getMessage());
        }
    }

    public static void topPalabras (String nombreLibro) {
        List<String> lineas = new ArrayList<>();
        String cadenaLineas;
        String[] palabras = null;

        //Preguntar por los integer, aún no me quedan del todo claros.
        Hashtable<String, Integer> contador = new Hashtable<>();
        Path rutaLibros = Paths.get("Documentos/Libros/" + nombreLibro);


        try {
            lineas = Files.readAllLines(rutaLibros);
            cadenaLineas = String.join(" ", lineas).trim();
            palabras = cadenaLineas.split("\\s+");
        } catch (IOException e) {
            System.out.println("Problemas al reconocer el libro." + e.getMessage());
        }

        for (String palabra : palabras) {
            //Cuenta las palabras. Pero no entiendo del todo el método.
            contador.put(palabra, contador.getOrDefault(palabra, 0) + 1);
        }

        List<Map.Entry<String,Integer>> listaPalabras = new ArrayList<>(contador.entrySet());

       //Esto yo de sacar los valores invertidos de cabeza no sé hacerlo.
        listaPalabras.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry1.getValue());
                }
            });
        System.out.println("10 palabras más repetidas: ");
        for (int i = 0; i < 9; i++) {
            System.out.println(listaPalabras.get(i));
        }
    }
}
