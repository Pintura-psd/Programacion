package Programacion.Estudio_examenRecu.Examen1.Ejercicio2;

import Programacion.Estudio_examenRecu.Examen1.Ejercicio1.Figura;
import Programacion.Estudio_examenRecu.Examen1.Ejercicio1.Funko_Pop;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio2_funciones {

    public static void menu (){
        System.out.println("Añadir Funko: 1");
        System.out.println("Eliminar Funko: 2");
        System.out.println("Mostrar el número total de Funko-Pops: 3");
        System.out.println("Mostrar el año del Funko-Pop más nuevo: 4");
        System.out.println("Mostrar el año del Funko-Pop más antiguo: 5");
        System.out.println("Media del precio de tu colección: 6");
        System.out.println("Salir: 7");
    }

    public static ArrayList<Funko_Pop> importarListaTxt(){
        Path rutaArchivo = Paths.get("Documentos/Documentos_examen/FunkosListadoExamen.txt");
        ArrayList<Funko_Pop> listaImportada = new ArrayList<>();
            try {
                Stream<String> txtContenido = Files.lines(Paths.get(rutaArchivo.toString()));{
                    List<List<String>> funkosLista = txtContenido.map(l -> Arrays.asList(l.split("#"))).toList();
                    for (int i = 1; i < funkosLista.size();i++){
                       String nombre = funkosLista.get(i).get(0);
                       int year = Integer.parseInt(funkosLista.get(i).get(1));
                       Double precio = Double.parseDouble(funkosLista.get(i).get(2));
                       Boolean precintado = Boolean.parseBoolean(funkosLista.get(i).get(3));
                       Boolean embalajeOg = Boolean.parseBoolean(funkosLista.get(i).get(4));
                       Boolean edicionEspecial = Boolean.parseBoolean(funkosLista.get(i).get(5));
                       int actualYear = LocalDate.now().getYear();

                        Funko_Pop funkoTem = new Funko_Pop(nombre,year,precio,precintado,embalajeOg,edicionEspecial,actualYear);
                        listaImportada.add(funkoTem);
                    }
                }
            } catch (IOException e) {
                System.out.println("No se ha podido leer la lista." + e.getMessage());
            }
            return listaImportada;
    }

    public static ArrayList<Funko_Pop> addFunko(Scanner input,ArrayList<Funko_Pop> funkosLista){
        int select = 0;
        String nombre = "";
        int releaseYear;
        boolean limitada;
        boolean precintada = false;
        boolean embalajeOG = false;
        double precioBase;
        int fechaAdqusicion = LocalDate.now().getYear();
        String lineaTxt = "";


        System.out.println("Añadiendo Funko-Pop: ");
        System.out.println(" ");
        System.out.println("¿Cual es el nombre?");
        nombre = input.nextLine();
        System.out.println("¿Es edición limitada?");
        System.out.println("Sí: 1 | No: 2");
        select = input.nextInt();
        if (select == 1){
            limitada = true;
        }
        else if (select==2){
            limitada = false;
        }
        else {
            System.out.println("Valor erroneo, edición limitada será FALSE.");
            limitada = false;
        }
        System.out.println("¿Cual es el año de lanzamiento?");
        releaseYear = input.nextInt();
        System.out.println("¿Cual es su precio base?");
        precioBase = input.nextDouble();
        System.out.println("¿Está precintada?");
        System.out.println(" ");
        System.out.println("Sí: 1 | No: 2");
        select = 0;
        select = input.nextInt();
        if (select == 1){
            precintada = true;
            embalajeOG = true;
        }
        else if (select == 2){
            precintada = false;
            System.out.println("¿Mantiene el embalaje original?");
            System.out.println(" ");
            System.out.println("Sí: 1 | No: 2");
            select = input.nextInt();
            if (select == 1){
                embalajeOG =  true;
            }
            else if (select == 2){
                embalajeOG = false;
            }
            else {
                System.out.println("Valor erróneo, se pondrá FALSE por defecto.");
                embalajeOG = false;
            }
        }
        else{
            System.out.println("Valor erróneo, se pondrá FALSE por defecto.");
        }

        Funko_Pop funko = new Funko_Pop(nombre,releaseYear,precioBase,precintada,embalajeOG,limitada,fechaAdqusicion);
        funkosLista.add(funko);
        lineaTxt = nombre +"#"+releaseYear +"#"+precioBase +"#"+precintada +"#"+embalajeOG +"#"+limitada+"\n";
        escribirTxt(lineaTxt);
        System.out.println(" ");
        System.out.println("Se ha añadido el Funko-Pop: "+ funko.getNombre());
        return funkosLista;
    }

    public static void escribirTxt (String lineaTxt){
        Path rutaArchivo = Paths.get("Documentos/Documentos_examen/FunkosListadoExamen.txt");
       try {
           Files.writeString(rutaArchivo, lineaTxt, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
       }
       catch (Exception e){
           System.out.println("No se pudo escribir la línea de texto"+ e.getMessage());
       }
        System.out.println("Se ha escrito una línea de texto al documento .txt");
    }

    public static ArrayList<Funko_Pop> eliminarFunkos (ArrayList<Funko_Pop> listaFunkos, Scanner input){
        String nombre = " ";

        System.out.println("Introduce el nombre del Funko-Pop que desees eliminar: ");
        nombre = input.nextLine();
        int contador = 0;
        int funkoPosicion = 0;
        boolean encontrado = false;

        for (Figura fg : listaFunkos){
            if (nombre.equalsIgnoreCase(fg.getNombre())){
                funkoPosicion = contador;
                encontrado = true;
            }
            contador++;
        }
        if (encontrado){
            listaFunkos.remove(funkoPosicion);
            System.out.println("Se ha eliminado con éxito.");
        }
        else {
            System.out.println("La figura no está en la lista.");
        }

        rescribirTxt(listaFunkos);
        encontrado = false;
        return listaFunkos;
    }

    public static void rescribirTxt (ArrayList<Funko_Pop> listaFunkos){
        Path rutaArchivo = Paths.get("Documentos/Documentos_examen/FunkosListadoExamen.txt");
        String cabezera = "NOMBRE#AÑO#PRECIO BASE#PRECINTADO#EMBALAJE ORIGINAL#EDICIÓN ESPECIAL";

        try {
            Files.writeString(rutaArchivo, cabezera+"\n");
            for (Funko_Pop figura : listaFunkos){
                try {
                    Files.writeString(rutaArchivo,figura.getNombre()+"#"+figura.getReleaseYear()+"#"+figura.getPrecioBase()+"#"+figura.isPrecintada()+"#"+figura.isEmbalajeOG()+ figura.isEdicionLimitada()+"#"+"\n", StandardOpenOption.APPEND);
                }
                catch (Exception e){
                    System.out.println("No se pudo realizar bien la reescritura"+ e.getMessage());
                }
            }
        }
        catch (Exception e){
            System.out.println("No se ha podido reescribir el archivo."+ e.getMessage());
        }
        System.out.println("Se he actualizado la lista con éxito.");
    }

    public static void contarFunkos(ArrayList<Funko_Pop> listaFunkos){
        System.out.println("El número total de funkos es: " + listaFunkos.size());
    }

    public static void masNuevo(ArrayList<Funko_Pop> listaFunkos){
        Funko_Pop funkoPopMasNuevo = new Funko_Pop(" ",0 ,0.0,false,false,false,0);
        for (Figura figura : listaFunkos){
            if (figura.getReleaseYear() > funkoPopMasNuevo.getReleaseYear()){
                funkoPopMasNuevo = (Funko_Pop) figura;
            }
        }
        System.out.println("El funko más nuevo es : "+ funkoPopMasNuevo);
    }

    public static void masAntiguo(ArrayList<Funko_Pop> listaFunkos){
        Funko_Pop funkoPopMasAntiguo = new Funko_Pop(" ",0 ,0.0,false,false,false,0);
        for (Figura figura : listaFunkos){
            if (figura.getReleaseYear() < funkoPopMasAntiguo.getReleaseYear()){
                funkoPopMasAntiguo = (Funko_Pop) figura;
            }
        }
        System.out.println("El funko más nuevo es : "+ funkoPopMasAntiguo);
    }

    public static void average(ArrayList<Funko_Pop> listaFunkos){
        double average = 0;

        for (Figura fg : listaFunkos){
            average = average + fg.getPrecioBase();
        }

        average = average / listaFunkos.size();

        System.out.println("La media de precio es: "+ average);
    }

    public static void serlializarLista (ArrayList<Funko_Pop> listaFunkos){

        Path rutaArchivo = Paths.get("Documentos/Documentos_examen/ListaSerializadaFunkoPops.txt");
        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo no existe, se va a crear uno.");
            File listaSerializadaFunkoPops = new File("Documentos/Documentos_examen/ListaSerializadaFunkoPops.txt");
            try {
                System.out.println("Serializando...");
                listaSerializadaFunkoPops.createNewFile();
            }catch (Exception e){
                System.out.println("No se ha podido crear el archivo.");
            }
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(rutaArchivo));
            oos.writeObject(listaFunkos);
            System.out.println("Se ha serializado con éxito");
            oos.close();
        } catch (IOException e) {
            System.out.println("No se pudo serializar"+ e.getMessage());
        }
        System.out.println("Se ha serializado con éxito.");
    }

}
