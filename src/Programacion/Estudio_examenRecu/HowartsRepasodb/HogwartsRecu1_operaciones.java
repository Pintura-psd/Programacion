package Programacion.Estudio_examenRecu.HowartsRepasodb;

import Programacion.Tema8.Hogwarts.Operaciones;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class HogwartsRecu1_operaciones {

    public static String[] cargarCredenciales() {

        Properties propiedades = new Properties();
        String[] credenciales = new String[3];

        try (InputStream insertar = Files.newInputStream(Path.of("C:\\Users\\ACER\\Desktop\\FP\\Programacion\\Tema8\\credencialesFer"))) {
            propiedades.load(insertar);

            String url = propiedades.getProperty("db.url");
            String pasword = propiedades.getProperty("db.pasword");
            String user = propiedades.getProperty("db.user");

            credenciales[0] = url;
            credenciales[1] = pasword;
            credenciales[2] = user;
        } catch (IOException ex) {
            System.out.println("Fallo en la carga de credenciales" + ex.getMessage());
        }
        return credenciales;
    }

    //Consulta asignaturas
    public static void listadoAsignaturas (){

        String[] credenciales = Operaciones.cargarCredenciales();
        String sentenciaSQL = "SLECT * FROM asignatura";

        try(Connection con = DriverManager.getConnection(credenciales[0], credenciales[1], credenciales[2]);
            PreparedStatement sentencia = con.prepareStatement(sentenciaSQL)){

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()){

                String id = resultados.getString("id_asignatura");
                String nombre = resultados.getString("nombre");
                String aula = resultados.getString("aula");
                boolean obligatoria = resultados.getBoolean("obligatoria");

                String obligatoriaString = "No";

                if (obligatoria) obligatoriaString = "Sí";
                System.out.println(id +"-"+ nombre + ", Aula: "+ aula + " , Obligatoria: "+ obligatoriaString);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}