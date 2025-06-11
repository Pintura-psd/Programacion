package Programacion.Estudio_examenRecu.Examen3;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Operaciones {

    public static String[] cargarCredenciales(){
        Properties properties = new Properties();
        String[] credenciales = new String[3];
        Path rutaCrecendiales = Paths.get("C:/Users/ACER/Desktop/FP/Programacion/Tema8/credencialesFer.txt");

        try (InputStream entrada = Files.newInputStream(Path.of(rutaCrecendiales.toString()))){
            properties.load(entrada);

            String url = properties.getProperty("db.url");
            String usuario = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            credenciales[0] = url;
            credenciales[1] = usuario;
            credenciales[2] = password;

        }catch (Exception e){
            System.out.println("Error al cargar los credenciales."+ e.getMessage());
        }
        return credenciales;
    }

    public static void alumnosQueTienenMascota (String[] credenciales){
        String consulta = " SELECT e.nombre, e.apellido, m.nombre AS nombre_mascota, m.especie FROM estudiante e JOIN mascota m on e.id_estudiante = m.id_estudiante";

        try {
            Connection conexion = DriverManager.getConnection(credenciales[0],credenciales[1],credenciales[2]);
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultados = statement.executeQuery();
            while (resultados.next()){
                String nombre_alu = resultados.getString("nombre");
                String apellido_alu = resultados.getString("apellido");
                String nombre_m = resultados.getString("nombre_mascota");

                System.out.println("Alumno: "+ nombre_alu+" "+apellido_alu+ " Mascota: "+ nombre_m);
            }
        }catch (Exception e){
            System.out.println("Fallo en estudiantes y mascotas. "+ e.getMessage());
        }
    }

    public static void startsA (String[] credenciales){
        String consulta = "SELECT nombre, apellido FROM estudiante WHERE nombre LIKE 'A%'";

        try {
            Connection conexion = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultados = statement.executeQuery();
            while (resultados.next()){
                String nombres = resultados.getString("nombre");
                String apellidos = resultados.getString("apellido");

                System.out.println("Nombre: "+ nombres +" "+ apellidos);
            }
        }catch (Exception e){
            System.out.println("Problema al distiguir nombres que empiecen por la letra A. "+ e.getMessage());
        }
    }

    public static void ejercicio1 (String[] credenciales){
        String consulta = "SELECT e.nombre, e.apellido FROM Estudiante e JOIN Casa c ON e.id_casa = c.id_casa WHERE c.nombre = 'Gryffindor' ";

        try (
                Connection conex = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                PreparedStatement statement = conex.prepareStatement(consulta)) {
            ResultSet resultados = statement.executeQuery();
            System.out.println("Ejercicio 1: ");
            System.out.println(" ");

            while (resultados.next()){
                //Cuidado, resultados corresponde a lo que estamos haciendo el select.
                String nombres = resultados.getString("nombre");
                String apellidos = resultados.getString("apellido");
                System.out.println(nombres +" "+ apellidos);
            }
        }
        catch (Exception e){
            System.out.println("No se pudo realizar la consultar" + e.getMessage());
        }
    }
}
