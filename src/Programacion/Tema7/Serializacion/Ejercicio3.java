package Programacion.Tema7.Serializacion;
/*Ejercicio 3: Leer un Fichero Línea a Línea y Contar Palabras
Lee un fichero de texto llamado texto.txt y cuenta cuántas palabras hay en total. Muestra el
número de palabras al final.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {

        Path rutaTexto = Paths.get("Documentos/texto.txt");
        List<String> lienasTexto = new ArrayList<>();
        String cadenaTexto;

        if (!Files.exists(rutaTexto)){
            System.out.println("No existe el archivo.");
            System.out.println("Cerrando programa.");
            System.exit(0);}
        else {
            try {
                lienasTexto = Files.readAllLines(rutaTexto);
            } catch (IOException e) {
                System.out.println("No se ha podido leer el texto correctamente." + e.getMessage());
            }

            cadenaTexto = lienasTexto.toString();

            String[] palabras = cadenaTexto.split(" ");
            System.out.println("El tamaño del texto es: " + palabras.length);
        }
    }
}
