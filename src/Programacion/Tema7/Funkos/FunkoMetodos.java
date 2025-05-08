package Programacion.Tema7.Funkos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


import static java.util.stream.Collectors.toList;

public class FunkoMetodos {

    //Menú
    public static void menu() {
        System.out.println("MENU:");
        System.out.println("Selecciona una opción:");
        System.out.println("Añadir funkos: 1");
        System.out.println("Borrar funkos: 2");
        System.out.println("Mostrar todos los funkos: 3");
        System.out.println("Mostrar la media del precio de los funkos: 4");
        System.out.println("Mostrar grupos de Funkos: 5");
        System.out.println("Mostrar funkos lanzados en 2023: 6");
        System.out.println("Salir: 7");
    }

    //Seleccionar menu
    public static int seleccion(Scanner input) {

        int seleccion = 0;

        try {
            seleccion = input.nextInt();
        } catch (Exception e) {
            System.out.println("Introduce un numero entero." + e.getMessage());
        } finally {

            if (seleccion < 0 || seleccion > 8) {

                System.out.println("Debes introducir una opción válida.");
                seleccion = 0;
            }
        }
        return seleccion;
    }

    //Importar CSV
    public static ArrayList<Funko> importCSV() {
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        ArrayList<Funko> listaFunkosImportada = new ArrayList<>();

        if (!Files.exists(rutaArchivo)) {
            System.err.println("El archivo no existe.");
        } else {

            try {
                Stream<String> contenidoFichero = Files.lines(Paths.get(rutaArchivo.toString()));
                System.out.println("Leyendo fichero...");
                //Preguntar bien cómo funciona esto.
                List<List<String>> listaFunkos = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();

                for (int i = 1; i < listaFunkos.size(); i++) {
                    double funkoPrecio = Double.parseDouble(listaFunkos.get(i).get(3));
                    Funko fukopopo = new Funko(listaFunkos.get(i).get(0), listaFunkos.get(i).get(1), listaFunkos.get(i).get(2), funkoPrecio, listaFunkos.get(i).get(4));
                    listaFunkosImportada.add(fukopopo);
                }

            } catch (IOException e) {
                System.out.println("No se ha podido leer la lista." + e.getMessage());
            }
        }
        return listaFunkosImportada;
    }

    //Guardar Funkos nuevos

    public static void addFunkos (Scanner input,ArrayList listaImportadaFunkos ){
        int contador;

        input.nextLine();
        System.out.println("¿Cuantos funkos deseas ingresar?");
        contador = input.nextInt();
        input.nextLine();

        for (int i = 0; i < contador; i++) {
            System.out.println("Introduce el código: ");
            String codigo = input.nextLine();
            if (listaImportadaFunkos.contains(codigo)) {
                while (!listaImportadaFunkos.contains(codigo))
                    System.out.println("Ese codigo ya existe");
                System.out.println("Introduce de nuevo el código:");
                input.nextLine();
            } else {

                System.out.println("Introduce el nombre: ");
                String nombre = input.nextLine();
                System.out.println("Introduce el modelo;");
                String modelo = input.nextLine();
                System.out.println("Introduce la fecha: ");
                String fecha = input.nextLine();
                //El double lo pongo al final que si no limpiar el buffer es un coñazo.
                System.out.println("Introduce el precio: ");
                Double precio = input.nextDouble();
                //Limpiar buffer
                //System.out.println("Pulsa enter: ");
                input.nextLine();


                Funko funkoTemp = new Funko(codigo, nombre, modelo, precio, fecha);
                listaImportadaFunkos.add(funkoTemp);
                String lineaCSV;
                lineaCSV = funkoTemp.getCodigo() + ","
                        + funkoTemp.getNombre() + ","
                        + funkoTemp.getModelo()+ ","
                        + funkoTemp.getPrecio()+ ","
                        + funkoTemp.getFecha()+ "\n";
                //Escribir en la listaCSV
                escribirFunkosCSV(lineaCSV);
            }
        }
      mostrarFunkos(listaImportadaFunkos);
    }

    //Escribir en el CSV
    public static void escribirFunkosCSV (String lineaCSV){
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        try {
            Files.writeString(rutaArchivo, lineaCSV, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
        }
        catch (Exception e){
            System.out.println("No se ha podido escribir la linea."+ e.getMessage());
        }
    }

    //Eliminar Funko
    public static void borrarFunko (Scanner input, ArrayList<Funko> listaImportadaFunkos){
        String nombre;
        //System.out.println("Limpiando buffer...");
        input.nextLine();
        System.out.println("Introduce el nombre del funko que quieres borrar.");
        nombre = input.nextLine();
        ArrayList<Funko> nuevaLista = new ArrayList<>();

        //Si uso un .remove la lista altera los indices y peta durante el for.
        //Ahora, hago locontrario. Que escriba todo, menos cuado coincide el nombre.
        for (Funko funko : listaImportadaFunkos){
            if (!funko.getNombre().equals(nombre)){
                nuevaLista.add(funko);
            }
        }
        eliminarFunkoCSV(nuevaLista);
        mostrarFunkos(nuevaLista);
    }

    //Eliminar del CSV
    public static void eliminarFunkoCSV (ArrayList<Funko> nuevaLista){
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
            try{
                Files.writeString(rutaArchivo, "COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO"+ "\n");
            }
            catch (Exception e){
                System.out.println("No se ha podido escribir el archivo." + e.getMessage());
            }
            for (Funko funkoTemp : nuevaLista){
                try {
                    Files.writeString(rutaArchivo , funkoTemp.getCodigo() +","+
                            funkoTemp.getNombre()+","+
                            funkoTemp.getModelo()+","+
                            funkoTemp.getPrecio()+","+
                            funkoTemp.getFecha()+ "\n"
                            , StandardOpenOption.APPEND);
                }
                catch (Exception e){
                    System.out.println("No se ha podido escribir bien el archivo." + e.getMessage());
                }
            }
        System.out.println("Se ha rescrito el CSV con éxito.");
    }

    //Enseñar funcos
    public static void mostrarFunkos (ArrayList<Funko> listaImportadaFunkos){
        System.out.println("Lista de Funkos: ");
        for(Object funko : listaImportadaFunkos){
            System.out.println(funko);
        }
    }

    //Media de precio de los funkopopos
    public static double mediaFunkos(ArrayList<Funko> listaImportadaFunkos){
        double contador = 0;
        double media;

        for (Funko funkoTemp : listaImportadaFunkos ){
           contador =contador + funkoTemp.getPrecio();
        }
        media = contador / listaImportadaFunkos.size();
        return media;
    }

    //Mostrar grupo de funkos
    public static void funkosPorGrupos (Scanner input, ArrayList<Funko> listaImportadaFunkos){
        String nombreModelo;
        ArrayList<Funko> listaPorModelo = new ArrayList<>();
        input.nextLine();
        System.out.println("Introduce el nombre del modelo que buscas.");
        nombreModelo = input.nextLine().toUpperCase();


            for (Funko funkoTemp : listaImportadaFunkos) {
                if (funkoTemp.getModelo().equals(nombreModelo)) {
//                    System.out.println(funkoTemp);
                   listaPorModelo.add(funkoTemp);
                }

               /* else{
                    System.out.println("El modelo no existe.");
                    System.out.println("Saliendo...");
                    System.exit(0);
                }*/

            }

        System.out.println("Lista por modelos: ");
        mostrarFunkos(listaPorModelo);
    }

    //Mostrar funkos por año
    public static void funkosPorFecha(Scanner input, ArrayList<Funko> listaImportadaFunkos){
        String fecha = "2023";
        ArrayList<Funko> listaPorFecha = new ArrayList<>();
        input.nextLine();
        /*System.out.println("Introduce la fecha por la que deseas buscar.");
        fecha = input.nextLine();*/

        for (Funko funkoTemp : listaImportadaFunkos) {
            if (funkoTemp.getFecha().contains(fecha)) {
                listaPorFecha.add(funkoTemp);
            }
            /*else if (!funkoTemp.getFecha().contains(fecha)) {
                System.out.println("No hay registro de esa fecha.");
                System.out.println("Saliendo...");
                System.exit(0);*/
        }

        System.out.println("Lista por fecha: ");
        mostrarFunkos(listaPorFecha);
    }
}
