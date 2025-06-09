package Programacion.Tema8.RepasoSQL;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class RepasoSQL_Operaciones {

    //Cargar credenciales en nuestra base de datos.
    public static String[] cargarCredenciales(){
        Properties properties = new Properties();
        String[] crendenciales = new String[3];
        //Aquí el path es la ruta a dónde tenemos cargados los credenciales.
        try (InputStream entrada = Files.newInputStream(Path.of("C:/Users/ACER/Desktop/FP/Programacion/Tema8/credencialesFer.txt"))){
           properties.load(entrada);

           //Aquí lo que va dentro del parentesis es el nombre del credencial.
           String url = properties.getProperty("db.url");
           String usuario = properties.getProperty("db.user");
           String password = properties.getProperty("db.password");

                crendenciales[0] = url;
                crendenciales[1] = usuario;
                crendenciales[2] = password;

        } catch (IOException e){
            System.out.println("Fallo en cargar los credenciales."+ e.getMessage());
        }
        return crendenciales;
    }

    //1. Consulta básica con SELECT
    public static void nombresyapellidosProfesores(String[] credenciales){
        //Guardamos las sentencias en una String
        String consulta = "SELECT nombre, apellido FROM profesor";

        try (
                Connection conexion = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                PreparedStatement statement = conexion.prepareStatement(consulta)) {
            ResultSet resultados = statement.executeQuery();
            System.out.println(" ");
            System.out.println("Nombres y apellidos profesores.");
            while (resultados.next()) {
                //Hay que estar atento de qué tipo de dato queremos sacar.
                //En este caso es una String. Pero podría ser otra cosa
                //Dentro de los paréntesis pondremos el nombre que corresponde a la columna.
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");

                //Con el sout tendremos la respuesta.
                System.out.println("Nombre: " + nombre + " Apellido: " + apellido);
            }
        } catch (Exception e) {
            System.out.println("No se pudo realizar conexion" + e.getMessage());
        }
    }


    //Filtrado de datos con WHERE
    public static void nacidosDespues1980(String[] credenciales){
        String consulta = "SELECT nombre, apellido, fecha_nacimiento FROM estudiante WHERE fecha_nacimiento > '1980-01-01' ";

        try {
            Connection conexion = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultados = statement.executeQuery();
            System.out.println(" ");
            System.out.println("Nacidos después de 1980");
            while (resultados.next()){
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");

                System.out.println("Alumno: "+ nombre +" "+ apellido +" Nacido en: "+ fecha_nacimiento);
            }

        }   catch (Exception e){
            System.out.println("Error en nacidos depués de 1980"+ e.getMessage());
        }
    }

    public static void nombresyapellidosAscend (String[] credenciales){
        String consulta = "SELECT nombre, apellido, fecha_nacimiento FROM estudiante ORDER BY fecha_nacimiento ASC";

        try {
            Connection conexion = DriverManager.getConnection(credenciales[0],credenciales[1],credenciales[2]);
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultados = statement.executeQuery();
            System.out.println(" ");
            System.out.println("Ordenar por fecha ASC");
            while (resultados.next()){
                String nombre = resultados.getString("nombre");
                String apellidos = resultados.getString("apellido");
                Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");

                System.out.println("Nombre: "+ nombre +" Apellido: "+ apellidos + " Fecha de naciemiento: "+ fecha_nacimiento);
            }

        } catch (Exception e){
            System.out.println("Fallo en ordenar apellidos y nombres por fecha ASC"+ e.getMessage());
        }
    }

    public static void DistinguirPorAnyo1982(String[] credenciales){
        String sentencia = "SELECT nombre, apellido, fecha_nacimiento FROM estudiante WHERE EXTRACT(YEAR FROM fecha_nacimiento) = 1982";

        try {
            Connection conexion = DriverManager.getConnection(credenciales[0],credenciales[1],credenciales[2]);
            PreparedStatement statement = conexion.prepareStatement(sentencia);
            ResultSet resultados = statement.executeQuery();
            while (resultados.next()){
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                Date fecha = resultados.getDate("fecha_nacimiento");

                System.out.println("Nombre: "+ nombre +" Apellido: "+ apellido +" Fecha: "+ fecha);
            }
        } catch (Exception e){
            System.out.println("Fallo en discriminar por año de naciemiento. "+ e.getMessage());
        }
    }

    //Nombres que empiecesn por la letra F
    public static void startsF (String[] credenciales){
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
}
