package Programacion.Tema7.Serializacion.SerializacionPersona;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/*Lee el objeto Persona del fichero persona.dat y muestra sus datos en consola.*/
public class Ejercicio5 {

    public static void main(String[] args) {
        Path rutaArchivo = Paths.get("Documentos/persona.dat");
        Persona persona_recuperada;
        try {
            ObjectInputStream recuperar_persona = new ObjectInputStream(new FileInputStream(rutaArchivo.toString()));
            persona_recuperada = (Persona)recuperar_persona.readObject();
            recuperar_persona.close();
            System.out.println("Persona recuperada: ");
            System.out.println("Nombre: "+ persona_recuperada.getNombre());
            System.out.println("Edad: "+ persona_recuperada.getEdad());
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("No se ha podido leer el objeto persona"+ e.getMessage());
        }
    }
}
