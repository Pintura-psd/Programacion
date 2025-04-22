package Programacion.Tema7.EjerciciosB;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.Files.exists;


/**Ejercicio B3 - Ordenando archivos
 Implementa un programa que pida al usuario un nombre de archivo A para lectura y otro nombre
 de archivo B para escritura. Leerá el contenido del archivo A (por ejemplo ‘usa_personas.txt’) y lo
 escribirá ordenado alfabéticamente en B (por ejemplo ‘usa_personas_sorted.txt’).*/

public class EjercicioB3 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean existe = false;
        Path archivoEntrada = null;
        Path archivoEscritura = null;
        List<String> lineasTexto = new ArrayList<>();
        /*Creo una ruta, en read.nextline*/
        while (!existe) {
           System.out.println(" ");
           System.out.println("Introduce el archivo que vas a leer");
           String entradaFileName = read.nextLine().toLowerCase();
        //Obtener el objeto path del fichero que me han pasado
           archivoEntrada = Paths.get(entradaFileName);
           if (exists(archivoEntrada)) {
               System.out.println("El archivo existe.");
               existe = true;
           }
           else {
               System.out.println("El archivo no existe.");
           }
       }

        System.out.println(" ");
        System.out.println("Introduce el archivo que vas a escribir.");
        String salidaFileName = read.nextLine().toLowerCase();
       //Obtengo la ruta para crear el fichero
        archivoEscritura = Paths.get(archivoEntrada.getParent().toString() + "/"+ salidaFileName);

        System.out.println(" ");
        System.out.println("Texto sin ordenar");
        System.out.println(" ");

        try{
            //Aqui guardo todas las lineas en mi array con Files.readAllLines
            lineasTexto = Files.readAllLines(archivoEntrada);
            for (String linea : lineasTexto){
                System.out.println(linea);
            }
        }
        catch (IOException e){
            System.out.println("Error al leer el archivo." + e.getMessage());
        }

        Collections.sort(lineasTexto);
        System.out.println(" ");
        System.out.println("Texto ordenado");
        System.out.println(" ");
        for (String linea : lineasTexto){
            System.out.println(linea);
        }

        try {
            //Recorro todas las lineas de mi array
            for (String linea : lineasTexto){
               //Escribo en el nuevo fichero una línea y lo creo. Si no existe. APPEN escribe al final del texto sin borrarlo.
                Files.writeString(archivoEscritura, linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
               //Escribe un salto de linea al final de cada línea.
                Files.writeString(archivoEscritura, "\r\n", StandardOpenOption.APPEND);
            }
        }
        catch(Exception e){
            System.out.println("Ha habido un error de escritura.");
        }

        System.out.println("Se ha generado tu archivo");
    }
}
