package Programacion.Tema7.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EjercicioB1 {
    public static void main(String[] args) throws IOException {
        Path numeros = Paths.get("Documentos/numeros.txt");
        List<String> listaNumeros = Files.readAllLines(numeros);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int tempNum;
        //Path camino = Paths.get("C:/Users/ACER/Desktop/numeros.txt");
        //String[] arraydeStrings = Files.readAllLines(Paths.get("Documentos/usa_personas.txt")).toArray(new String[0]);

        for (String num : listaNumeros) {
            tempNum = Integer.valueOf(num);

            if (tempNum > max) {
                max = tempNum;
            } else if (tempNum < min) {
                min = tempNum;
            }
        }

        System.out.println("El número minimo es: "+ min);
        System.out.println("El número máximo es: "+ max);
    }
}
