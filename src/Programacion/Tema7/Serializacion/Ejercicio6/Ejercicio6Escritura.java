package Programacion.Tema7.Serializacion.Ejercicio6;

import Programacion.Tema7.Serializacion.SerializacionPersona.Persona;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/*Ejercicio 6: Guardar y Leer un ArrayList de Personas
Crea un programa que permita guardar varios objetos Persona en un ArrayList. Serializa la
lista completa en un fichero personas.dat. Luego, haz otro programa que lea el fichero y
muestre los datos de todas las personas.*/
public class Ejercicio6Escritura {
    public static void main(String[] args) {
        Persona[] personas = new Persona[3];
        Path rutaArchivo = Paths.get("Documentos/array_personas.dat");
        Persona javier = new Persona("Javier",26);
        Persona manuel = new Persona("Manuel", 26);
        Persona eduardo = new Persona("Eduardo", 26);

        personas[0] = javier;
        personas[1] = manuel;
        personas[2] = eduardo;

        try {
            ObjectOutputStream serializar_arrayPersonas = new ObjectOutputStream(new FileOutputStream(rutaArchivo.toString()));
            //Llamar bien al objeto en concreto, nuestra Array aún ser objetos persona. Queremos escribir la array concreta.
            //En este caso personas.
            serializar_arrayPersonas.writeObject(personas);
            System.out.println("Se ha serializado correctamente.");
            //cerrar de manera correcta los stream segundo aviso.
            serializar_arrayPersonas.close();
        } catch (IOException e) {
            System.out.println("No se ha podido serializar"+ e.getMessage());
        }
    }
}
