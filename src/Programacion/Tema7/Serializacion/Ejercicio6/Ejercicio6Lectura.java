package Programacion.Tema7.Serializacion.Ejercicio6;

import Programacion.Tema7.Serializacion.SerializacionPersona.Persona;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio6Lectura {
    public static void main(String[] args) {
        Path rutaArchivo = Paths.get("Documentos/array_personas.dat");

        if (!Files.exists(rutaArchivo)) {
            System.err.println("El archivo no existe.");
            return;
        }

        try {
            ObjectInputStream arrayRecuperada = new ObjectInputStream(new FileInputStream(rutaArchivo.toString()));
            //Guardar bien el fichero que se lee en su tipo de dato.
            Persona[] personasRecuperadas = (Persona[]) arrayRecuperada.readObject();

            System.out.println("Personas recuperadas.");
            for (int i = 0; i < 3; i++) {
                System.out.println("Persona: "+ (i+1) + " " + personasRecuperadas[i]);
            }
            //Ordenar bien el .close
            arrayRecuperada.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha podido leer bien el archivo."+ e.getMessage());
        }
    }
}
