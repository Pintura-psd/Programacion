package Programacion.Tema7.EjerciciosB;
/* Implementa un programa que pida al usuario un número de cualquier longitud, como por ejemplo
“1234”, y le diga al usuario si dicho número aparece en el primer millón de decimales del nº pi
(están en el archivo ‘pi-million.txt’). No está permitido utilizar ninguna librería ni clase ni método
que realice la búsqueda. Debes implementar el algoritmo de búsqueda tú*/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioB6 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Path rutaNumPi = Paths.get("Documentos/pi-million.txt");
        List<String> pi_txt = new ArrayList<>();
        String piUnido = "";

        System.out.println("Introduce una sucesión de números.");
        String num = input.nextLine();

        //Debería probarlo a hacer con buffer reader.
       try {
           pi_txt = Files.readAllLines(rutaNumPi);
           //Unir todo en una string.
           piUnido = String.join("",pi_txt);
       }
       catch (IOException e){
           System.out.println("No se ha podido leer el fichero."+ e.getMessage());
       }

        if (piUnido.contains(num)){
         System.out.println("Está dentro");
        }
        else {
         System.out.println("No está dentro.");
        }
    }
}
