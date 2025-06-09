package Programacion.Estudio_examenRecu.EjercicioFunkosTry1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class RecuFunkoFunciones {

    public static void menu (){
        System.out.println("Añadir funko: 1");
        System.out.println("Borrar funko: 2");
        System.out.println("Mostrar todos los funkos: 3");
        System.out.println("Mortrar la media de precio: 4");
        System.out.println("Mostrar los funkos por modelos: 5");
        System.out.println("Mostrar los funkos de 2023: 6");
        System.out.println("Mostrar el funko más caro: 7");
        System.out.println("Salir: 8");
    }

    public static ArrayList<Funko> importarCSV (){
        ArrayList<Funko> listaFunkosImportada = new ArrayList<>();
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        String cod;
        String nom;
        String modelo;
        double precio;
        String fecha_lanzamiento;

        try (Stream<String> csvContent = Files.lines(rutaArchivo)){
            List<List<String>> listaFunkos = csvContent.map(l-> Arrays.asList(l.split(","))).toList();
            for (int i = 1; i < listaFunkos.size() ; i++) {
                nom = listaFunkos.get(i).get(0);
                cod = listaFunkos.get(i).get(1);
                modelo = listaFunkos.get(i).get(2);
                precio = Double.parseDouble(listaFunkos.get(i).get(3));
                fecha_lanzamiento = listaFunkos.get(i).get(4);

                Funko funkoTemp = new Funko(cod,nom,modelo,precio,fecha_lanzamiento);
                listaFunkosImportada.add(funkoTemp);
            }
        }catch (Exception e){
            System.out.println("Error al importar la lista."+ e.getMessage());
        }
        return listaFunkosImportada;
    }

    public static ArrayList<Funko> addFunko(ArrayList<Funko> listaFunkos, Scanner input){
        String cod;
        String nom;
        String model;
        Double price;
        String releaseDate;

        System.out.println("Introduce el nombre del Funko: ");
        nom = input.nextLine();
        System.out.println(" ");
        System.out.println("Introduce el código del Funko: ");
        cod = input.nextLine();
        System.out.println("Introduce el modelo: ");
        model = input.nextLine();
        System.out.println("Introduce el precio: ");
        price = input.nextDouble();
        //limpiar Buffer
        input.nextLine();
        System.out.println("Introduce la fecha de lanzamiento: ");
        releaseDate = input.nextLine();

        Funko funkopopo = new Funko(cod,nom,model,price,releaseDate);
        listaFunkos.add(funkopopo);

        String lineaCSV = cod+","+nom+","+model+","+price+","+releaseDate+"\n";
        escribirCSV(lineaCSV);
        return listaFunkos;
    }

    public static void escribirCSV(String lineaCSV){
        Path  rutaArchivo = Paths.get("Documentos/funkos.csv");
        if (Files.exists(rutaArchivo)){
            try {
                Files.writeString(rutaArchivo, lineaCSV,StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                System.out.println("Se ha añadido el funko al CSV.");
            }catch (Exception e){
                System.out.println("Error al escribir en el archivo CSV"+ e.getMessage());
            }
        } else {
            System.out.println("No se ha podido encontrar el archivo.");
        }
    }

    public static ArrayList<Funko> eliminarFunko (ArrayList<Funko> listaFunkos, Scanner input){
        System.out.println("Introduce el nombre del funko que quieres borrar.");
        String nombre = input.nextLine();
        Boolean encontrado;
        int contador = 0;
        int numeroIndice = 0;
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");

        for (Funko fk : listaFunkos){
            if (fk.getNombre().equals(nombre)) {
                encontrado = true;
                numeroIndice = contador;
            }
            contador++;
        }
        listaFunkos.remove(numeroIndice);
        rescrituraCSV(listaFunkos);

        return listaFunkos;
    }

    public static void rescrituraCSV(ArrayList<Funko> listaFunkos){
        System.out.println("Rescribiendo CSV...");
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");
        String cabeceraCSV = "COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO"+"\n";
        String lineaCSV = "";

        if (Files.exists(rutaArchivo)){
            try {
                Files.writeString(rutaArchivo, cabeceraCSV);
                for (Funko funko : listaFunkos){
                    try {
                        lineaCSV = funko.getCod()+","+funko.getNombre()+","+funko.getModelo()+","+funko.getPrecio()+","+funko.getFecha_lanzamiento()+"\n";
                        Files.writeString(rutaArchivo,lineaCSV ,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
                    } catch (Exception e){
                        System.out.println("Error en la reescritura del CSV (interior del for)"+ e.getMessage());
                    }
                }

            }catch (Exception e){
                System.out.println("Error en la reescritura del CSV. "+ e.getMessage());
            }

        }
        else {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }

    public static void mostrarFunkos(ArrayList<Funko> listaFunkos){
        for (Funko fk : listaFunkos){
            System.out.println(fk.getCod()+","+fk.getNombre()+","+ fk.getModelo()+","+fk.getPrecio()+","+ fk.getFecha_lanzamiento()+"\n");
        }
    }

    public static void  mostrarFunkomasCaro(ArrayList<Funko> listaFunkos){
        double precio = 0;
        String nom = "";

        for (Funko fk : listaFunkos){
            if (precio < fk.getPrecio()){
                precio = fk.getPrecio();
                nom = fk.getCod();
            }
        }
        System.out.println("El funko más caro es, "+ nom +", con un precio de: "+ precio );
    }

    public static void media(ArrayList<Funko> listaFunkos){
        double sumaPrecios = 0;
        double average = 0;

        for (Funko fk : listaFunkos){
            sumaPrecios = fk.getPrecio()+sumaPrecios;
        }

        average = sumaPrecios / listaFunkos.size();

        System.out.println("La media de precio es: "+ average);
    }

    public static void mostrarPorModelo (ArrayList<Funko> listaFunkos,Scanner input){
        int select = 0;
        String modelo = "";
        ArrayList<Funko> listaPorModelo = new ArrayList<>();

        System.out.println("¿Porqué modelo quieres agrupar?");
        System.out.println("1: Marvel , 2: Disney, 3: Anime, 4: Otros");
        select = input.nextInt();
        switch (select){
            case 1:
                modelo = "Marvel";
                break;
            case 2:
                modelo = "Disney";
                break;
            case 3:
                modelo = "Anime";
                break;
            case 4:
                modelo = "Otros";
                break;
        }

        for (Funko fk : listaFunkos){
            if (fk.getModelo().equalsIgnoreCase(modelo)){
                listaPorModelo.add(fk);
            }
        }

        System.out.println("Funko por modelo: ");
        mostrarFunkos(listaPorModelo);
    }

    public static void mostrarFunkos2023 (ArrayList<Funko> listaFunkos){
        ArrayList<Funko> lista2023 = new ArrayList<>();

        for (Funko fk : listaFunkos){
            if (fk.getFecha_lanzamiento().contains("2023")){
                lista2023.add(fk);
            }
        }

        System.out.println("Los funkos 2023 son: ");
        mostrarFunkos(lista2023);
    }
}

