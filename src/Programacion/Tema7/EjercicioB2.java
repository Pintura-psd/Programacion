package Programacion.Tema7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EjercicioB2 {

    public static void main(String[] args) {
        //Poner un try catch para que no explote si el documento no existe.

        List<String> lineas = null;
        List<Alumno> alumnos = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("Documentos/alumnos_notas.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String nombre;
        String apellido;
        int average = 0;
        int counter = 0;

        try {
            for (String linea : lineas) {
                String [] valores = linea.split(" ");
                nombre = valores [0];
                apellido = valores[1];
                for (int i = 2; i < valores.length; i++) {
                     average = (average + Integer.valueOf(valores[i]));
                     counter++;
                }
                average = average / counter;

                alumnos.add(new Alumno(nombre, apellido, average));
                counter = 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        alumnos.sort(Comparator.comparing(Alumno::getAverage));
        for (int i = alumnos.size()-1; i >= 0; i--) {
            System.out.println(alumnos.get(i));
        }
    }
}
