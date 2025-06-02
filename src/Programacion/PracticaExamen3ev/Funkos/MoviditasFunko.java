package Programacion.PracticaExamen3ev.Funkos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class MoviditasFunko {

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

    public static int menuSeleccion (Scanner input){
        int seleccion = 0;
        System.out.println("Introduce un numero entero. ");
        try {
            seleccion = input.nextInt();
        }
        catch (Exception e){
            System.out.println("No es un dato válido");
        }
        finally {
            if (seleccion < 0 || seleccion > 7){
                System.out.println("Selecciona una opción dentro del rango 1-7");
            }
        }
        return seleccion;
    }

    public static ArrayList<Funko2> importarListaCSV (){
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        ArrayList<Funko2> listaFunkosImportada = new ArrayList<>();

        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo no exite.");
        }
        else {
            try {
                Stream<String> contenidoCSV = Files.lines(Paths.get(rutaArchivo.toString()));
                List<List<String>> listaFunkos = contenidoCSV.map(l-> Arrays.asList(l.split(","))).toList();
                    for (int i = 1; i < listaFunkos.size(); i++){
                        double funkoPrecio = Double.parseDouble(listaFunkos.get(i).get(3));
                        Funko2 funko = new Funko2 (listaFunkos.get(i).get(0),listaFunkos.get(i).get(1),listaFunkos.get(i).get(2),funkoPrecio,listaFunkos.get(i).get(4));
                        listaFunkosImportada.add(funko);
                    }
                System.out.println("Lista importada con éxito!");
            }
            catch (Exception e){
                System.out.println("No se ha podido leer el archivo csv");
            }
        }
        return listaFunkosImportada;
    }
    //Mostrar Funkos

    public static void mostrarFunko (ArrayList<Funko2> funkosLista){
        for (Funko2 fk : funkosLista){
            System.out.println(fk);
        }
    }

    //Añadir funkos
    public static void añadirFunkos(Scanner input, ArrayList<Funko2> listaFunkos){
        int contador;

        System.out.println("Cuantos Funkos quieres añadir?");
        contador = input.nextInt();
        input.nextLine();

        try {
        for (int i = 0; i < contador; i++){
            System.out.println("¿Cual es el código?");
            String cod = input.nextLine();

            System.out.println("¿Cual es el nombre?");
            String nom = input.nextLine();

            System.out.println("¿De que linea de modelos es?");
            String model = input.nextLine();

            System.out.println("¿Qué precio tiene?");
            Double precio = input.nextDouble();
            input.nextLine();

            System.out.println("¿Qué fecha fue su lanzamiento?");
            String fecha = input.nextLine();

            Funko2 funko = new Funko2(cod,nom,model,precio,fecha);
            listaFunkos.add(funko);
            System.out.println("Funko"+ contador + "añadido.");

            String lineaCSV = cod +","+nom +","+ model + "," + precio.toString() + "," + fecha +"\n";
            escribirCSV(lineaCSV);
        }
        }
        catch (Exception e){
            System.out.println("Problema en añadir Funko nuevo");
        }
    }

    //Escribir CSV
    public static void escribirCSV (String linea){
        try {
        Path rutaAarchivo = Paths.get("Documentos/funkos.csv");
        Files.writeString(rutaAarchivo,linea, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            System.out.println("Se ha escrito el CSV correctamente.");
        }
        catch (Exception e) {
            System.out.println("No se ha podido escribir la línea.");
        }
    }

    //Eliminar Funko
    public static void eliminarFunko(ArrayList<Funko2> listaFunkos, Scanner input){
        input.nextLine();
        int contador = 0;
        int funkoPosicion = 0;
        boolean sePuedeBorrar = false;
        String nombreFunko = "";

        try {
            System.out.println("Introduce el nombre del Funko que deseas borrar: ");
             nombreFunko = input.nextLine();
        }
        catch (Exception e ){
            System.out.println("Introduce un nombre válido");
        }
        try {

            for (Funko2 fk : listaFunkos) {
                if (fk.getNombre().equals(nombreFunko)) {
                    funkoPosicion = contador;
                    sePuedeBorrar = true;
                }
                contador++;
            }
            if (sePuedeBorrar){
                listaFunkos.remove(funkoPosicion);
                System.out.println("Se ha eliminado el funko de nombre: "+ nombreFunko + " con éxito.");
                rescrituraCSV(listaFunkos);
            }
            else {
                System.out.println("No se ha encontrado el funko dentro de la lista");
            }
        }
        catch (Exception e){
            System.out.println("No se ha encontrado el funko"+ e.getMessage());
        }
    }
    //reescribirCsv
    public static void rescrituraCSV (ArrayList<Funko2> listaFunkos){
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        String primeraLinea = "COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO"+ "\n";
        try {
            Path rutaAarchivo = Paths.get("Documentos/funkos.csv");
            Files.writeString(rutaAarchivo,primeraLinea);
            System.out.println("Se ha escrito el CSV correctamente.");
        }
        catch (Exception e) {
            System.out.println("No se ha podido escribir la línea.");
        }

        try {
            for (Funko2 fk : listaFunkos){
                try {
                Files.writeString(rutaArchivo, fk.getCodigo()+","+fk.getNombre()+","+fk.getModelo()+","+fk.getPrecio()+","+fk.getFecha() + "\n", StandardOpenOption.APPEND);

                }
                catch (Exception e){
                    System.out.println("No se ha podido escribir la linea"+ e.getMessage());
                }
             }
        }
        catch (Exception e){
            System.out.println("Error en la reescritura."+ e.getMessage());
        }
    }

    //funkos media
    public static double media (ArrayList<Funko2> listaFukos){
        double media = 0;
        for (Funko2 fk : listaFukos){
            media = media + fk.getPrecio();
        }
        return media / listaFukos.size();
    }

    //Por modelo:
    public static void porModelo (Scanner input,ArrayList<Funko2> listaFunkos){
        ArrayList<Funko2> listaModelos = new ArrayList<>();
        input.nextLine();
        String modelo = "";

        try {
            System.out.println("Que modelo deseas?");
            modelo = input.nextLine().toUpperCase();
        }
        catch (Exception e){
            System.out.println("Problema en la lectura de modelo."+ e.getMessage());
        }
        try {
            for (Funko2 fk : listaFunkos){
                if (modelo.equals(fk.getModelo())){
                    listaModelos.add(fk);
                }
            }
            System.out.println(" ");
            System.out.println("Lista por modelos: ");
            mostrarFunko(listaModelos);
        }
        catch (Exception e){
            System.out.println("Problema al leer modelos.");
        }
    }

    //Por fecha
    public static void porFecha(ArrayList<Funko2> listaImportadaFunkos){
        String fecha = "2023";
        ArrayList<Funko2> listaPorFecha = new ArrayList<>();
        /*System.out.println("Introduce la fecha por la que deseas buscar.");
        fecha = input.nextLine();*/

        for (Funko2 funkoTemp : listaImportadaFunkos) {
            if (funkoTemp.getFecha().contains(fecha)) {
                listaPorFecha.add(funkoTemp);
            }
            /*else if (!funkoTemp.getFecha().contains(fecha)) {
                System.out.println("No hay registro de esa fecha.");
                System.out.println("Saliendo...");
                System.exit(0);*/
        }
        System.out.println("Lista por fecha: ");
        mostrarFunko(listaPorFecha);
    }

    public static void seralizacion (){
        System.out.println("Serializando...");
        Path rutaArchivo = Paths.get("Documentos/funkos_serializados2.dat");
        ArrayList<Funko2> lista = importarListaCSV();
        try {
            ObjectOutputStream serliazar = new ObjectOutputStream(new FileOutputStream(rutaArchivo.toString()));
            serliazar.writeObject(lista);
            System.out.println("Serialización con éxito");
            serliazar.close();
        }
        catch (IOException e){
            System.out.println("Problema al serialziar");
        }
    }

    //Deserializar
    public static void deserializar (){
        System.out.println("Des-serializando...");
        Path rutaArchivo = Paths.get("Documentos/funkos_serializados2.dat");
        ArrayList<Funko2> listaDeserializada = new ArrayList<>();
        try {
            ObjectInputStream deserialziar = new ObjectInputStream(new FileInputStream(rutaArchivo.toString()));
            listaDeserializada = (ArrayList<Funko2>) deserialziar.readObject();
            System.out.println("Lista deserializada con éxito");
        }
        catch (Exception e){
            System.out.println("Problema al deserialziar "+ e.getMessage());
        }
        mostrarFunko(listaDeserializada);
    }
}

