package Programacion.Estudio_examenRecu.PilotoDB;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class OperacionesPiloto {

    public static String[] cargarCredenciales(){
        Properties properties = new Properties();
        String[] credenciales = new String[3];
        Path rutaCredenciales = Paths.get("/Users/fernandoaguilera/Desktop/FP informatica/Programación/Pilotos db/credencialesPilotos.txt");

        try (InputStream entrada = Files.newInputStream(rutaCredenciales)){
            properties.load(entrada);

            String url = properties.getProperty("db.url");
            String usuario =  properties.getProperty("db.user");
            String password =  properties.getProperty("db.password");

            credenciales[0] = url;
            credenciales[1] = usuario;
            credenciales[2] = password;

        } catch (Exception e){
            System.out.println("Error al cargar credenciales. "+ e.getMessage());
        }
        return credenciales;
    }

    public static void menu(){
        System.out.println("1. Crear y añadir Piloto a la base de datos");
        System.out.println("2. Buscar Piloto en la base de datos (por entero)");
        System.out.println("3. Devolver listado de todos los Pilotos de la base de datos");
        System.out.println("4. Seleccionar y actualizar un Piloto en la base de datos");
        System.out.println("5. Seleccionar y eliminar un Piloto de la base de datos");
        System.out.println("6. Mostrar la clasificación mundial de Pilotos, por puntos");
        System.out.println("7. Mostrar clasificación mundial de Equipos, por puntos");
        System.out.println("8. Salir");
        System.out.println(" ");
        System.out.print("Selección: ");
    }

    //Importar pilotos

    public static void importarPilotos(ArrayList<Piloto> listaPilotos){

        String[] credenciales = cargarCredenciales();

        String url = credenciales[0];
        String usuario =  credenciales[1];
        String password =  credenciales[2];

        String sentenciaSQL = "SELECT * FROM drivers";

        try (Connection conexion = DriverManager.getConnection(url,usuario,password);
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)){

            ResultSet resultados = sentencia.executeQuery();
            while (resultados.next()){
                int conductorID = resultados.getInt("driverid");
                String code = resultados.getString("code");
                String nombre = resultados.getString("forename");
                String apellido = resultados.getString("surname");
                String dob =  resultados.getString("dob");
                String nacionalidad = resultados.getString("nacionality");
                String urlPiloto = resultados.getString("url");

                Piloto conductor = new Piloto(conductorID,code,nombre,apellido,dob,nacionalidad,url);
                listaPilotos.add(conductor);
            }
        }
        catch (SQLException e){
            System.out.println("Ha ocurrido un error al identificar la base de datos");
        }
    }

    public static void createPilot (ArrayList<Piloto> listaPilotos, Scanner input){
        String[]credenciales = cargarCredenciales();
        String sentenciaSQL = "INSERT into drivers (driverid, code, forename, surname, dob, nationality, url) VALUES (?, ?, ?, ?, ? , ?, ?)";
        boolean seguroAdd = true;

        int driverId = 0;
        String code = "";
        String forename = "";
        String surname = "";
        String dob = "";
        String nationality = "";
        String url = "";

        try {
            System.out.println(" ");
            System.out.println("Introduce la Id del piloto: ");
            driverId = input.nextInt();
            input.nextLine();

            System.out.println("Introduce el código del piloto");
            code = input.nextLine();

            System.out.println("Introduce el nombre del piloto:");
            forename = input.nextLine();

            System.out.println("Introduce la fecha de nacimiento AAAA-MM-DD");
            dob =  input.nextLine();

            System.out.println("Introduce la nacionalidad del piloto: ");
            nationality = input.nextLine();

            System.out.println("Introduce la página web del piloto");
            url = input.nextLine();
        } catch (Exception e){
            seguroAdd = false;
            System.out.println("Ha habido un error a la hora de definir el pilo a la lista."+ e.getMessage());

            input.nextLine();
        }finally {
            if (seguroAdd){
                Piloto piloto = new Piloto(driverId, code, forename, surname, dob,nationality,url);
                listaPilotos.add(piloto);

                try (Connection conexion = DriverManager.getConnection(credenciales[0],credenciales[1],credenciales[2]);
                     PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL)){

                    sentencia.setInt(1,driverId);
                    sentencia.setString(2,code);
                    sentencia.setString(3,forename);
                    sentencia.setString(4,surname);
                    sentencia.setDate(5, Date.valueOf(dob));
                    sentencia.setString(6, nationality);
                    sentencia.setString(7, url);

                    int rowsAffected = sentencia.executeUpdate();

                    System.out.println(" ");
                    System.out.println(rowsAffected + " fila(s) insertada(s) correctamente.");

                } catch (Exception e){
                    System.out.println("Ha ocurrido un error al añadir el piloto a la base  de datos."+ e.getMessage());
                }
            }
        }
    }
}
