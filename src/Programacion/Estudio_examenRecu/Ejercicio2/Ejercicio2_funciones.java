package Programacion.Estudio_examenRecu.Ejercicio2;

import Programacion.Estudio_examenRecu.Ejercicio1.Figura;
import Programacion.Estudio_examenRecu.Ejercicio1.Funko_Pop;
import Programacion.Tema7.Funkos.Funko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                       Boolean precintado = Boolean.getBoolean(funkosLista.get(i).get(3));
                       Boolean embalajeOg = Boolean.getBoolean(funkosLista.get(i).get(4));
                       Boolean edicionEspecial = Boolean.getBoolean(funkosLista.get(i).get(5));
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
        System.out.println(" ");
        System.out.println("Se ha añadido el Funko-Pop: "+ funko.getNombre());
        return funkosLista;
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

}
