package Programacion.PracticaExamen3ev.BasesDeDatos;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MetodosDB { public static String[] cargarCredenciales(){
    //No sé qué es el objeto properties.
    //Tampoco sé cómo he llegado hasta aquí y no sé hacer consultas. Esto es una mierda.
    Properties propiedades = new Properties();
    String[] credenciales = new String[3];

    try (InputStream input = Files.newInputStream(Path.of("C:/Users/ACER/Desktop/FP/Programacion/Tema8/credencialesFer.txt"))){
        propiedades.load(input);

        String url = propiedades.getProperty("db.url");
        String nom = propiedades.getProperty("db.user");
        String password = propiedades.getProperty("db.password");

        credenciales[0] = url;
        credenciales[1] = nom;
        credenciales[2] = password;

    }
    catch (Exception e){
        System.out.println("Error al cargar el archivo."+ e.getMessage());
    }
    return credenciales;
}

    public static void fantasma (String[] credenciales) {
        String consulta = "Select * FROM casa";

        try (
                Connection conex = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                PreparedStatement statement = conex.prepareStatement(consulta)) {
            //Aquí opero con el resultado de la consulta.

            ResultSet resultados = statement.executeQuery();
            System.out.println("Prueba: Fantamas de las casas: ");
            System.out.println(" ");
            while (resultados.next()) {
                //Hay que estar atento de qué tipo de dato queremos sacar.
                //En este caso es una String. Pero podría ser otra cosa.
                String fantasma = resultados.getString("fantasma");
                System.out.println(fantasma);
            }
        } catch (Exception e) {
            System.out.println("No se pudo realizar conexion." + e.getMessage());
        }
    }
}
