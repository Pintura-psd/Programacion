package Programacion.Tema7.EjerciciosB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*Implementa un programa que genere aleatoriamente nombres de persona (combinando nombres
y apellidos de ‘usa_nombres.txt’ y ‘usa_apellidos.txt’). Se le pedirá al usuario cuántos nombres de
persona desea generar y a qué archivo añadirlos (por ejemplo ‘usa_personas.txt’).*/
public class EjercicioB4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> nombresGenerados = new ArrayList<>();
        Random random = new Random();
        Path rutaNombres = Paths.get("Documentos/usa_nombres.txt");
        Path rutaApellidos = Paths.get("Documentos/usa_apellidos.txt");
        Path rutaNombresGenerados = Paths.get("Documentos/nombres_generados.txt");
        int contador = input.nextInt();

        try {
            nombres = Files.readAllLines(rutaNombres);
            apellidos = Files.readAllLines(rutaApellidos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Generador de nombres");
        System.out.println(" ");
        System.out.println("Indica cuantos nombres quieres generar");

        for (int i = 0; i < contador ; i++) {
            nombresGenerados.add(nombres.get(random.nextInt(nombres.size())));
            nombresGenerados.add(apellidos.get(random.nextInt(apellidos.size())));
        }

        try {
            for (int i = 0; i < nombresGenerados.size(); i+=2) {
               //Unifico las posiciones y fuerzo a dividir en la escritura.
                String linea = nombresGenerados.get(i) + " " + nombresGenerados.get(i+1);
                Files.writeString(rutaNombresGenerados, linea + "\r\n",StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }
        catch(IOException e){
            System.out.println("Ha habido un error de escritura.");
        }
        System.out.println("Se ha generado tu archivo.");
    }
}
