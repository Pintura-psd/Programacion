package Programacion.Tema7.Funkos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunkosSerializacion {
    public static void main(String[] args) {
        Path rutaEscritura = Paths.get("Documentos/funkosbinario.dat");
        ArrayList<Funko> listaImportada = FunkoMetodos.importCSV();
        FunkoMetodos.mostrarFunkos(listaImportada);
        try {
            ObjectOutputStream serializarLista = new ObjectOutputStream(new FileOutputStream(rutaEscritura.toString()));
            serializarLista.writeObject(listaImportada);
            System.out.println("Se ha serializado correctamente.");
            serializarLista.close();
        } catch (IOException e) {
            System.out.println("No se ha podido serializar "+ e.getMessage());
        }
    }
}
