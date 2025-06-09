package Programacion.Estudio_examenRecu.EjercicioFunkosTry2;

import java.io.File;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FunkosFunciones {

    public static void menu (){
        System.out.println("Añadir Funko: 1");
        System.out.println("Eliminar Funko: 2");
        System.out.println("Mostrar todos los Funkos: 3");
        System.out.println("Mostrar Funko más caro: 4");
        System.out.println("Motrar la media de precios de todos los Funkos: 5");
        System.out.println("Mostrar Funkos agrupados por modelos: 6");
        System.out.println("Mostrar todos los funkos de 2023: 7");
        System.out.println("Salir: 8");
    }

    public static ArrayList<Funko> leerCSV(){
        ArrayList<Funko> listaFunkosImportada = new ArrayList<>();
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");

        try (Stream<String> csvContent = Files.lines(rutaArchivo)){
            List<List<String>> listaFunkos = csvContent.map(l-> Arrays.asList(l.split(","))).toList();
            for (int i = 1; i < listaFunkos.size(); i++){
                String cod = listaFunkos.get(i).get(1);
                String nom = listaFunkos.get(i).get(0);
                String modelo = listaFunkos.get(i).get(2);
                Double precio = Double.parseDouble(listaFunkos.get(i).get(3));
                String fecha_lanzamiento = listaFunkos.get(i).get(4);

                Funko funkotempo = new Funko(nom,cod,modelo,precio,fecha_lanzamiento);

                listaFunkosImportada.add(funkotempo);
            }

        } catch (Exception e){
            System.out.println("Error al leer CSV"+ e.getMessage());
        }
        System.out.println("Se ha leído el CSV correctamente.");
        return listaFunkosImportada;
    }

    public static ArrayList<Funko> addFunko (ArrayList<Funko> listaFunkos, Scanner input){
        String lineaCSV = "";

        input.nextLine();
        System.out.println("¿Cuales el nombre del Funko que quieres añadir?");
        String nomre = input.nextLine();
        System.out.println("¿Cual es su código?");
        String cod = input.nextLine();
        System.out.println("¿Cual es su modelo?");
        String modelo = input.nextLine();
        System.out.println("¿Cual es su precio?");
        Double precio = input.nextDouble();
        //limpiarBuffer
        input.nextLine();
        System.out.println("¿Cuando fue su lanzamiento?");
        String fecha_lanzamiento = input.nextLine();

        Funko funko = new Funko(cod,nomre,modelo,precio,fecha_lanzamiento);
        listaFunkos.add(funko);

        lineaCSV = cod+","+nomre+","+modelo+","+precio+","+fecha_lanzamiento+"\n";
        escribirCSV(lineaCSV);
        return listaFunkos;
    }

    public static void escribirCSV (String lineaCSV){
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");

        if (Files.exists(rutaArchivo)){
            try {
                Files.writeString(rutaArchivo, lineaCSV, StandardOpenOption.WRITE,StandardOpenOption.APPEND);
                System.out.println("Se ha escrito la línea en el CSV correctamente.");
            } catch (Exception e){
                System.out.println("Problemas al escribir el CSV"+ e.getMessage());
            }
        }
        else {
            System.out.println("El archivo no existe.");
        }
    }

    public static ArrayList<Funko> eliminarFunko(ArrayList<Funko> listaFunkos, Scanner input){
        int contador = 0;
        int numIndex = 0;
        Boolean encontrado = false;

        System.out.println("Cual es el nombre del Funko que deseas eliminar");
        String nombre = input.nextLine();

        for (Funko fk : listaFunkos){
            if (fk.getNombre().equals(nombre)){
                encontrado = true;
                numIndex = contador;
            }
            contador++;
        }

        if (encontrado){
            listaFunkos.remove(numIndex);
        } else {
            System.out.println("No se ha podido encontrar el Funko deseado.");
        }

        rescribirCSV(listaFunkos);
        return listaFunkos;
    }

    public static void rescribirCSV (ArrayList<Funko> listaFunkos){
        String cabecera = "COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO"+"\n";
        String linea;
        Path rutaArchivo = Paths.get("Documentos/funkos.csv");

        if (Files.exists(rutaArchivo)){
         try {
             try {
                 Files.writeString(rutaArchivo,cabecera);
             } catch (Exception e){
                 System.out.println("Error al rescribir la cabecera."+ e.getMessage());
             }
             for (Funko fk : listaFunkos){
                 linea = fk.getCod() +","+ fk.getNombre() +","+ fk.getModelo() +","+ fk.getPrecio() +","+ fk.getFecha_lanzamiento();
                 try {
                     Files.writeString(rutaArchivo,linea+"\n",StandardOpenOption.WRITE, StandardOpenOption.APPEND);
                 }
                 catch (Exception e){
                     System.out.println("Error en la resctritura del CSV.");
                 }
             }
         }catch (Exception e){
             System.out.println("Error en la reescritura del CSV"+ e.getMessage());
         }
        }
        else {
            System.out.println("El archivo no existe.");
        }
    }

    public static void mostrarFunkos (ArrayList<Funko> listaFunkos){
        for (Funko fk : listaFunkos){
            System.out.println(fk);
        }
    }

    public static void masCaro (ArrayList<Funko> listaFunkos){
        double precio = 0;
        String nombre = "";
        for (Funko fk : listaFunkos){
            if (fk.getPrecio()>precio){
                precio = fk.getPrecio();
                nombre = fk.getNombre();;
            }
        }

        System.out.println("El funko mas caro es: "+ nombre + " su precio es de: "+ precio);
    }

    public static void averageFunkos (ArrayList<Funko> listaFunkos){
        double media;
        double precioTotal = 0;

        for (Funko fk : listaFunkos){
            precioTotal = precioTotal + fk.getPrecio();
        }

        media = precioTotal/listaFunkos.size();

        System.out.println("El precio de los funkos tiene de media: "+ media);
    }

    public static void mostrarPorModelo(ArrayList<Funko> listaFunkos, Scanner input){
        int menuSelec = 0;
        String modelo = "";
        ArrayList<Funko> listaModelos = new ArrayList<>();

        System.out.println("¿Que modelos quieres ver?");
        System.out.println("Marvel: 1");
        System.out.println("Disney: 2");
        System.out.println("Anime: 3");
        System.out.println("Otros: 4");
        input.nextLine();
        menuSelec= input.nextInt();;
        switch (menuSelec){
            case 1:
                modelo = "marvel";
                break;
            case 2:
                modelo = "disney";
                break;
            case 3:
                modelo = "anime";
                break;
            case 4:
                modelo = "otros";
                break;
        }

        for (Funko funko:listaFunkos){
            if (funko.getModelo().equalsIgnoreCase(modelo)){
                listaModelos.add(funko);
            }
        }
        mostrarFunkos(listaModelos);
    }

    public static void mostrar2023 (ArrayList<Funko> listaFunkos){
        ArrayList<Funko> listaYear = new ArrayList<>();

        for (Funko funko : listaFunkos){
            if (funko.getFecha_lanzamiento().contains("2023")){
                listaYear.add(funko);
            }
        }
        mostrarFunkos(listaYear);
    }

    public static void serializacion (ArrayList<Funko> listaFunkos){
        Path rutaArchivo = Paths.get("Documentos/funkos_serializados3.dat");
         if (!Files.exists(rutaArchivo)) {
            System.out.println("El arcivo no existía, creando archivo");
            crearArchivo();
        }

        try (ObjectOutputStream oos= new ObjectOutputStream(Files.newOutputStream(Paths.get(rutaArchivo.toString())))){
            oos.writeObject(listaFunkos);
            oos.close();
            System.out.println("Serilizado con éxito.");
        } catch (Exception e){
            System.out.println("Problemas en la serializacición."+e.getMessage());
        }

    }

    public static void crearArchivo(){
        File fileDat = new File("Documentos/funkos_serializados3.dat");
       try {
           if (fileDat.createNewFile()){
               System.out.println("Sea ha creado el archivo.");
           }
       } catch (Exception e){
           System.out.println("Error al crear el archivo"+ e.getMessage());
       }
    }
}
