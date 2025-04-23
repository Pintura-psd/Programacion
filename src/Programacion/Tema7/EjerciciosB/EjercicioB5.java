package Programacion.Tema7.EjerciciosB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjercicioB5 {
    /*Implementa un programa que cree la carpeta ‘Diccionario’ con tantos archivos como letras del
abecedario (A.txt, B.txt… Z.txt). Introducirá en cada archivo las palabras de ‘diccionario.txt’ que
comiencen por dicha letra.*/

    public static void main(String[] args) {

        String rutaCarpeta = "Documentos/Diccionario";
        Path rutaDiccionario = Paths.get("Documentos/Diccionario.txt");
        File Diccionario = new File(rutaCarpeta);
        Map<Character, FileWriter> ficheros = new HashMap<>();

        if(!Diccionario.exists()){
        Diccionario.mkdir();
        System.out.println("Se ha creado la carpeta Diccionario.");
        }
        else {
        System.out.println("No se ha podido crear la carpeta Diccionario.");
        }

        try {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                String rutaTemp = rutaCarpeta + "/" + letra + ".txt";
                FileWriter ficheroTemporal = new FileWriter(rutaTemp);
                ficheros.put(letra,ficheroTemporal);
            }
            try {
                List<String> lineasDiccionario_txt = new ArrayList<>();
                lineasDiccionario_txt = Files.readAllLines(rutaDiccionario);
                for (String linea : lineasDiccionario_txt){
                    for (char letra = 'a'; letra <= 'z' ; letra ++) {
                        Path archivoLetra = Paths.get(rutaCarpeta + "/" + letra + ".txt");
                        if (letra == linea.charAt(0)){
                           Files.writeString(archivoLetra, linea + "\r\n", StandardOpenOption.APPEND);
                        }
                    }
                }
            }
            catch (IOException e){
                System.out.println("Error en la escritura." + e.getMessage());
            }
        }
        catch (IOException e){
            System.out.println("Problemas al crear el fichero."+ e.getMessage());
        }
        finally {
            {
                for (FileWriter ficherosLetra : ficheros.values()){
                    try {
                            ficherosLetra.close();
                    }
                    catch (IOException e){
                        System.out.println("No se han cerrado correctamente. "+ e.getMessage());
                    }
                }
            }
        }
        System.out.println("Se han creado los respectivos ficheros en su carpeta.");
    }
}