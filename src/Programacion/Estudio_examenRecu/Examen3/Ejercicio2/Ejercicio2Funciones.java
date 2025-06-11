package Programacion.Estudio_examenRecu.Examen3.Ejercicio2;

import Programacion.Estudio_examenRecu.Examen3.Ejercicio1.Embalaje;
import Programacion.Estudio_examenRecu.Examen3.Ejercicio1.Funko_pop;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio2Funciones {
   public static  void menu(){
       System.out.println("Añadir Funko-pop: 1");
       System.out.println("Borrar Funko-pop: 2");
       System.out.println("Mostrar el total de Funko pops: 3");
       System.out.println("Mostrar Funko pop más antiguo y más nuevo : 4");
       System.out.println("Mostrar la media de los precios: 5");
       System.out.println("Salir: 6");
   }

   public static ArrayList<Funko_pop> importarFunkosTxt(){
       ArrayList<Funko_pop> listaImportada = new ArrayList<>();
       Path rutaArchivo = Paths.get("C:/Users/ACER/IdeaProjects/Programacion2/src/Programacion/Examen3/Ejercicio2/listaFunkos.txt");
       if (!Files.exists(rutaArchivo)){
           System.out.println("El archivo no existe, se procede a crear uno");
           try {
               File ficherotxt = new File(rutaArchivo.toString());
               System.out.println("Éxito al crear el archivo.");
              try {
                  String cabecera = "NOMBRE#AÑO#EDICIONESPECIAL#PRECIO#ESTADO"+"\n";
                  String funkoModulo = "Nombre#0#false#0#SIN_CAJA"+"\n";
                  Files.writeString(rutaArchivo, cabecera);
                  Files.writeString(rutaArchivo,funkoModulo, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
              } catch (Exception e){
                  System.out.println("Fallo al escribir primeras líneas."+ e.getMessage());
              }
               System.out.println("Se ha escrito el encabezado.");
           } catch (Exception e){
               System.out.println("Error al crear el achivo.");
           }
       } else {
           System.out.println("El archivo txt existe");
       }
       //Nombre#Año lanzamiento#Edición limitada#Precio base#Estado caja
       try (Stream<String> txtContent = Files.lines(Paths.get(rutaArchivo.toString()))){
           List<List<String>> fukosLista = txtContent.map(l-> Arrays.asList(l.split("#"))).toList();
            for (int i = 1; i < fukosLista.size(); i++){
                String nombre = fukosLista.get(i).get(0);
                int year = Integer.parseInt(fukosLista.get(i).get(1));
                Boolean ed_esp = Boolean.parseBoolean(fukosLista.get(i).get(2));
                Double precio = Double.parseDouble(fukosLista.get(i).get(3));
                Embalaje estado = Embalaje.valueOf(fukosLista.get(i).get(4).toString());

                Funko_pop funkoPop = new Funko_pop(nombre,year,precio,estado,ed_esp);
                listaImportada.add(funkoPop);
            }

           return listaImportada;
       } catch (Exception e){
           System.out.println("Error al leer el archivo."+ e.getMessage());
       }
       return listaImportada;
   }

   public static ArrayList<Funko_pop> borrarFunko(ArrayList<Funko_pop> listaFunkos, Scanner input){
       String nombre = "";
       int contador = 0;
       int indexNum = 0;
       boolean econtrado = false;
       Path rutaArchivo = Paths.get("C:/Users/ACER/IdeaProjects/Programacion2/src/Programacion/Examen3/Ejercicio2/listaFunkos.txt");

       input.nextLine();
       System.out.println("¿Cual es el nombre del Funko que quieres Borrar?");
       nombre = input.nextLine();
       for (Funko_pop funkoPop: listaFunkos){
           if (funkoPop.getNombre().equalsIgnoreCase(nombre)){
               econtrado = true;
               indexNum = contador;
           }
           contador++;
       }

       if (econtrado == false){
           System.out.println("No se ha encontrado el funko dentro de la lista.");
       } else {
           listaFunkos.remove(indexNum);
       }

       try {

           String cabecera = "NOMBRE#AÑO#EDICIONESPECIAL#PRECIO#ESTADO"+"\n";
           Files.writeString(rutaArchivo, cabecera);
           for (Funko_pop fk : listaFunkos){
               String lineaFunko = fk.getNombre()+"#"+fk.getYear()+"#"+fk.isEd_limitada()+"#"+fk.getPrecio()+"#"+fk.getEstado()+"\n";
               try {
                   Files.writeString(rutaArchivo, lineaFunko, StandardOpenOption.WRITE, StandardOpenOption.APPEND );
                   System.out.println("Se ha eliminado el funko corectamente.");
               } catch (Exception e){
                   System.out.println("Error al escribir la lina funko en el archivo txt"+ e.getMessage());
               }
           }
       } catch (Exception e){
           System.out.println("Fallo al escribir la cabecera."+ e.getMessage());
       }
       System.out.println("Se ha escrito el encabezado.");

       return listaFunkos;
   }

    public static ArrayList<Funko_pop> addFunko (ArrayList<Funko_pop> lsitaFiguras, Scanner input){
        int select = 0;
        Embalaje estado = null;
        boolean ed_limitada = false;

        input.nextLine();
        System.out.println("¿Cual es el nombre del Funko-pop?");
        String nombre = input.nextLine();
        System.out.println("¿Cuando fue el año de su lanzamiento?");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("¿Es edición limitada?");
        System.out.println("1: Sí | 2: No");
        select = input.nextInt();
        if (select == 1){
            ed_limitada = true;
        }
        else {
            ed_limitada =  false;
        }
        input.nextLine();
        System.out.println("¿Cual es su precio?");
        double precio = input.nextDouble();
        input.nextLine();
        System.out.println("¿Cual es el estado del embalaje?");
        System.out.println("1: Precintado | 2: Embalaje orginal | 3: Sin embalaje");
        select = input.nextInt();
        switch (select){
            case 1:
                estado = Embalaje.PRECINTADO;
                break;
            case 2:
                estado = Embalaje.PACK_OG;
                break;
            case 3:
                estado = Embalaje.SIN_CAJA;
                break;
        }
        input.nextLine();

        Funko_pop funkoPop = new Funko_pop(nombre,year,precio,estado,ed_limitada);
        lsitaFiguras.add(funkoPop);
        System.out.println("Se ha añadido la figura.");

        String lineaFunko = nombre+"#"+year+"#"+ed_limitada+"#"+precio+"#"+estado+"\n";
        Path rutaArchivo = Paths.get("C:/Users/ACER/IdeaProjects/Programacion2/src/Programacion/Examen3/Ejercicio2/listaFunkos.txt");
        try {
            Files.writeString(rutaArchivo, lineaFunko,StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (Exception e){
            System.out.println("Error al ecribir la línea del nuevo Funko en el archivo txt"+ e.getMessage());
        }

        return lsitaFiguras;
    }

    public static void mostrarLista(ArrayList<Funko_pop> listaFunkos){
        System.out.println("LISTA FUNKOS");
        for (Funko_pop fk : listaFunkos){
            System.out.println(fk);
        }
        System.out.println("Número total de funkos: "+ listaFunkos.size());
    }

    public static void masAntMasNeo(ArrayList<Funko_pop> listaFunkos){
       int masAnt = 0;
       String masAntNom = "";
       int masNuevo = 100000;
       String masNewNom = "";

       for (Funko_pop fk : listaFunkos){
           if (fk.getYear()>masAnt){
               masAnt = fk.getYear();
               masAntNom = fk.getNombre();
           }
           else if (fk.getYear()< masNuevo){
               masNuevo = fk.getYear();
               masNewNom = fk.getNombre();
           }
       }

        System.out.println("El funko mas nuevo es: "+ masNewNom + " Fecha: "+ masNuevo);
        System.out.println("El funko mas antiguo es: "+ masAntNom + " Fecha: "+ masAnt);
    }

    public static void average (ArrayList<Funko_pop> listaFunkos){
       double media;
       double total = 0;

       for (Funko_pop fk : listaFunkos){
           total = fk.getPrecio() + total;
       }

       media = total / listaFunkos.size();

        System.out.println("La media de precios es: "+ media);
    }
}
