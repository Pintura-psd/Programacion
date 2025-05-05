package Programacion.Tema7.Serializacion;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Ejercicio1 {

    /*Ejercicio 1: Crear y Escribir en un Fichero de Texto
     Crea un programa que pida al usuario su nombre y edad y los guarde en un fichero llamado
     usuario.txt, con el siguiente formato:
     Nombre: Ximo
     Edad: 25*/

    public static void main(String[] args) {
        Path rutaFichero = Paths.get("Documentos/usuarios.txt");
        Scanner input = new Scanner(System.in);
        String nom = "";
        int edad;

        while (!nom.equals("stop")) {
            System.out.println("Introduce tu nombre de usuario.");
            nom = input.nextLine();
            System.out.println("Introduce tu edad.");
            edad = input.nextInt();

            // Escribir en el archivo
            try (FileWriter fichero = new FileWriter(rutaFichero.toString(), true)) {
                //El true aquí es lo mismo que StandardOpenOption.APPEND
                fichero.write("Nombre: " + nom + "\n");
                fichero.write("Edad: " + edad + "\n");
                System.out.println("Los datos se han guardado correctamente en: personas.txt");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
            input.nextLine();
            System.out.println("Escribe stop si desas parar, si no pulsa enter.");
            nom = input.nextLine();
        }
        System.out.println("Final de proceso");
    }
}
