package Programacion.Tema8.Hogwarts;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Operaciones {

    public static String[] cargarCredenciales(){
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

    public static void fantasma(String[] credenciales) {
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

    public static void ejercicio2 (String[] credenciales){
        String consulta = "SELECT m.nombre AS mascota, m.especie FROM Mascota m JOIN Estudiante e ON m.id_estudiante = e.id_estudiante WHERE e.nombre = 'Hermione' AND e.apellido = 'Granger' ";

        try (
                Connection conex = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                PreparedStatement statement = conex.prepareStatement(consulta)) {
                ResultSet resultados = statement.executeQuery();
                System.out.println("Ejercicio 2: ");
                System.out.println(" ");

            while (resultados.next()){
                String mascota = resultados.getString("mascota");
                System.out.println(mascota);
            }
        }
        catch (Exception e){
            System.out.println("No se pudo realizar la consultar" + e.getMessage());
        }
    }

    public static void ejercicio3 (String[] credenciales){
        String consulta = " SELECT c.nombre AS casa, COUNT(e.id_estudiante) AS numero_estudiantes FROM Casa c LEFT JOIN Estudiante e ON c.id_casa = e.id_casa GROUP BY c.nombre ORDER BY numero_estudiantes DESC ";

        try (
                Connection conex = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                PreparedStatement statement = conex.prepareStatement(consulta)) {
                ResultSet resultados = statement.executeQuery();
                System.out.println("Ejercicio 3: ");
                System.out.println(" ");

            while (resultados.next()){
                String casa = resultados.getString("casa");
                String numEstudiante = resultados.getString("numero_estudiantes");
                System.out.println(casa + " "+ numEstudiante);
            }
        }
        catch (Exception e){
            System.out.println("No se pudo realizar la consultar" + e.getMessage());
        }
    }

    public static void insertarTabla(Scanner input) {

        String[] credenciales = Operaciones.cargarCredenciales();

        String sentenciaSQL = "INSERT into ASIGNATURA (nombre, aula, obligatoria) VALUES (?, ?, ?)";
        String nombre = "";
        String aula = "";
        boolean obligatoria = false;

        try {

            System.out.println(" ");
            System.out.print("Introduce el nombre de la asignatura: ");

            nombre = input.nextLine();

            System.out.print("Introduce el nombre del aula correspondiente: ");

            aula = input.nextLine();

            System.out.print("¿Es la clase obligatoria? (Sí / No): ");

            String booleanCheck = input.nextLine();

            if (booleanCheck.equalsIgnoreCase("si") || booleanCheck.equalsIgnoreCase("sí")) {

                obligatoria = true;

            }

        } catch (Exception e) {
            System.out.println("Datos mal introducidos." + e.getMessage());
        } finally {
            try (Connection con = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
                 PreparedStatement sentencia = con.prepareStatement(sentenciaSQL)) {

                sentencia.setString(1, nombre);
                sentencia.setString(2, aula);
                sentencia.setBoolean(3, obligatoria);

                //Si no exite esto, la función no hace nada.
                int filasAfectadas = sentencia.executeUpdate();

                System.out.println(" ");
                System.out.println(filasAfectadas + " fila(s) insertada(s) correctamente.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void modificarAsignatura (Scanner input) {

        String[] credentials = Operaciones.cargarCredenciales();

        String sentenciaSQL = "UPDATE Asignatura SET aula = ? WHERE id_asignatura = ?";

        String aula = "";
        int id_asignatura = 0;

        try {
            System.out.println(" ");
            System.out.print("Introduce el ID de la asignatura a modificar: ");

            id_asignatura = input.nextInt();
            input.nextLine();

            System.out.print("Introduce el nombre de la nueva aula: ");

            aula = input.nextLine();

        } catch (Exception e) {
            System.out.println("Datos mal introducidos." + e.getMessage());
        } finally {
            try (Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
                 PreparedStatement sentencia = con.prepareStatement(sentenciaSQL)) {

                sentencia.setString(1, aula);
                sentencia.setInt(2, id_asignatura);

                int rowsAffected = sentencia.executeUpdate();

                System.out.println(" ");
                System.out.println(rowsAffected + " fila(s) insertada(s) correctamente.");

            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }
    }

    public static void eliminarAsignatura(Scanner input) {
        String[] credentials = Operaciones.cargarCredenciales();

        String sentenciaSQL = "DELETE FROM Asignatura WHERE id_asignatura = ?";

        int id_asignatura = 0;

        try {
            System.out.println(" ");
            System.out.print("Introduce el ID de la asignatura a eliminar: ");

            id_asignatura = input.nextInt();
            input.nextLine();

        }
        catch (Exception e){
            System.out.println("No se ha leído bien la sentencia");
        }
        finally {
            try(Connection con = DriverManager.getConnection(credentials[0], credentials[1], credentials[2]);
                PreparedStatement sentencia = con.prepareStatement(sentenciaSQL)){

                sentencia.setInt(1, id_asignatura);

                int rowsAffected = sentencia.executeUpdate();

                System.out.println(" ");
                System.out.println(rowsAffected + " fila(s) eliminada(s) correctamente.");

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }
        }
    }
}