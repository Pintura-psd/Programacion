package Programacion.Tema7.Serializacion.SerializacionPersona;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/*Ejercicio 4: Serializar un Objeto Persona
Crea una clase Persona con nombre y edad. Crea un objeto y guárdalo en un fichero binario
llamado persona.dat mediante serialización.*/
public class Ejercicio4 {
    public static void main(String[] args) {

        Path rutaArchivo = Paths.get("Documentos/persona.dat");
        Persona javier = new Persona( "Javier", 26);
        try {
            ObjectOutputStream serializar_persona = new ObjectOutputStream(new FileOutputStream(rutaArchivo.toString()));
            serializar_persona.writeObject(javier);
            serializar_persona.close();
        } catch (IOException e) {
            System.out.println("No se ha podido serializar el objeto"+ e.getMessage());
        }
        System.out.println("Se ha serializado con éxito.");

    }
}
