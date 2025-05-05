package Programacion.Tema7.Serializacion;

/*Lee el contenido del fichero usuario.txt (del ejercicio anterior) y muestra las líneas en
consola.*/

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        Path rutaUsuarios = Paths.get("Documentos/usuarios.txt");
        List<String> lineasUsaurio = new ArrayList<>();

        try {
            System.out.println("Mostrar contenido de usuarios: ");
            lineasUsaurio = Files.readAllLines(rutaUsuarios);
            for (String linea : lineasUsaurio){
                System.out.println(linea);
            }
        }
        catch (IOException e){
            System.out.println("No se han podido leer el archivo" + e.getMessage());
        }
    }
}
