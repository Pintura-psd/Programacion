package Programacion.Tema7.RankingVidejuegos;

import Programacion.Tema7.Funkos.Funko;
import Programacion.Tema7.Funkos.FunkoMetodos;
import Programacion.Tema7.RankingVidejuegos.Exceptions.JuegoNoEncontrado;
import Programacion.Tema7.RankingVidejuegos.Exceptions.NotaFueraDeRangoException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class MetodosVidejuegos {

    public static void menu() {
        System.out.println(" ");
        System.out.println("MENU");
        System.out.println("Añadir videjuego: 1");
        System.out.println("Mostrar Ranking: 2");
        System.out.println("Eliminar Juego por nombre: 3");
        System.out.println("Guardar ranking: 4");
        System.out.println("Cargar ranking : 5");
        System.out.println("Exportar ranking a fichero: 6");
        System.out.println("Odenar por nota: 7");
        System.out.println("Salir: 8");
    }

    public static int seleccionMenu(Scanner input) {
        int seleccion = 0;
        try {
            seleccion = input.nextInt();
        } catch (Exception e) {
            System.out.println("Problema de lectura, introduce un número entero." + e.getMessage());
            input.nextLine();
        } finally {
            if (seleccion < 0 || seleccion > 8) {
                System.out.println("Introduce un valor váido");
                seleccion = 0;
            }
        }
        return seleccion;
    }

    //crear fichero
    public static void crearFichero (){
       // File ficheroTxt = new File("Documentos/ranking.txt");
        File ficheroDat = new File("Documentos/ranking.dat");
        File ficheroExportadoTxt = new File("Documentos/ranking_exportado.txt");

       /* try {
            if (ficheroTxt.createNewFile()){
                System.out.println("Se ha creado el fichero txt.");
            }
            else {
                System.out.println("Se ha localizado el fichero txt.");
            }
        }
        catch (IOException e){
            System.out.println(" ");
            System.out.println("No se ha podido generar el fichero txt");
        }

        */

        try {
            if (ficheroDat.createNewFile()){
                System.out.println("Se ha creado el fichero dat.");
            }
            else {
                System.out.println("Se ha localizado el fichero dat.");
            }
        }
        catch (IOException e){
            System.out.println(" ");
            System.out.println("No se ha podido generar el fichero dat" + e.getMessage());
        }

        try {
            if (ficheroExportadoTxt.createNewFile()){
                System.out.println("Se ha creado el fichero dónde exportar el txt.");
            }
            else {
                System.out.println("Se ha localizado el fichero donde exportar txt.");
            }
        }
        catch (IOException e){
            System.out.println(" ");
            System.out.println("No se ha podido generar el fichero txt");
        }
    }

    /*Con la funcionalidad cargar y exportar no hace falta este metodo.
    //Escritura fichero txt
    public static void escrituraFicheros (String videojuegoCadena ){
        Path rutaListaTxt = Paths.get("Documentos/ranking.txt");

        try {
            Files.writeString(rutaListaTxt,videojuegoCadena, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
        }
        catch (Exception e){
            System.out.println("No se ha podido escribir el archivo txt"+ e.getMessage());
        }
    }
    */

    //Serializar
    public static void serializarDat(ArrayList<Videojuego> vj) {
        Path rutaEscritura = Paths.get("Documentos/ranking.dat");
        try {
            ObjectOutputStream serializarLista = new ObjectOutputStream(new FileOutputStream(rutaEscritura.toString()));
            serializarLista.writeObject(vj);
            System.out.println("Se ha serializado correctamente.");
            serializarLista.close();
        } catch (IOException e) {
            System.out.println("No se ha podido serializar "+ e.getMessage());
        }
    }

    // deserializar listaVidejuegos
    public static ArrayList<Videojuego> importarLista(){
        ArrayList<Videojuego> listaImportadaVidejuegos = new ArrayList<>();
        try {
            ObjectInputStream importarLista = new ObjectInputStream(Files.newInputStream(Paths.get("Documentos/ranking.dat")));
            listaImportadaVidejuegos = (ArrayList<Videojuego>) importarLista.readObject();
            importarLista.close();
        }
        catch (Exception e){
            System.out.println("No se ha podido deserializar el fichero" + e.getMessage());
        }
        System.out.println("Se ha cargado la lista.");
        return listaImportadaVidejuegos;
    }

    //Añadir videojuego.
    public static void addJuego(Scanner input, ArrayList<Videojuego> listaVidejuegos){
        int seleccion = 0;

        while (seleccion == 0){
            System.out.println(" ");
            System.out.println("¿Es digital o fisico?");
            System.out.println("1.Digital | 2.Físico");


            try {
                seleccion = input.nextInt();
            }
            catch (Exception e){
                System.out.println(" ");
                System.out.println("Introduce 1 o 2" + e.getMessage());
                input.nextLine();
            }
            finally {
                if (seleccion < 1 || seleccion > 2){
                    seleccion = 0;
                }
            }

            switch (seleccion){
                case 1:
                    addJuegoDigital(input,listaVidejuegos);
                    break;
                case 2:
                    addJuegoFisico(input,listaVidejuegos);
                    break;
            }

        }

    }

    public static void addJuegoFisico (Scanner input, ArrayList<Videojuego> listaVideojuegos) {
        String titulo = "";
        String plataforma = "";
        int nota = 0;
        String tiendaCompra = "";
        String estado = "";
        int seleccion = 0;
        String videjuegoCadena;

        //Limpiar buffer
        input.nextLine();

        System.out.println("¿Cual es su título?");
        titulo = input.nextLine();

        System.out.println("¿Cual es su plataforma?");
        plataforma =  input.nextLine();

        while (seleccion == 0){
            System.out.println("¿Qué nota le pones?");

            try {
                nota = input.nextInt();
                seleccion = 1;

            }
            catch (Exception e){

                System.out.println(" ");
                System.out.println("Introduce una nota valida");
            }
            finally {
                if (nota < 0 || nota > 10){
                    seleccion = 0;
                }
            }
        }

        seleccion = 0;
        //Limpiar Buffer.
        input.nextLine();

        while (seleccion == 0) {
            System.out.println("¿Está usado?");
            System.out.println("1. Usado | 2. Nuevo");

            try {
                seleccion = input.nextInt();

            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Introduce 1 o 2" + e.getMessage());
            } finally {
                if (seleccion < 1 || seleccion > 2) {
                    seleccion = 0;
                }
            }
        }
            switch (seleccion){
                case 1:
                    estado = "Usado";
                    break;
                case 2:
                    estado = "Nuevo";
                    break;
            }

        seleccion = 0;

        while (seleccion == 0) {
            System.out.println("¿Lo compraste en tienda?");
            System.out.println("1. Si | 2. No");

            try {
                seleccion = input.nextInt();
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Introduce 1 o 2" + e.getMessage());
            } finally {
                if (seleccion < 1 || seleccion > 2) {
                    seleccion = 0;
                }
            }
        }
            switch (seleccion){
                case 1:
                    tiendaCompra = "Comprado en tienda";
                    break;
                case 2:
                    tiendaCompra = "NO comprado en tienda";
                    break;
            }
        videjuegoCadena = titulo + "," + plataforma  + "," + nota  + "," + tiendaCompra  + "," + estado + "\n";
        VideojuegoFisico VidejuegoFisico = new VideojuegoFisico(titulo,plataforma,nota,tiendaCompra,estado);
        listaVideojuegos.add(VidejuegoFisico);
        //escrituraFicheros(videjuegoCadena);
    }

    public static void addJuegoDigital(Scanner input, ArrayList<Videojuego> listaVideojuegos){
        String titulo = "";
        String plataforma = "";
        int nota = 0;
        String tiendaOnline = "";
        Double gigabites = 0.0;
        int seleccion = 0;
        String videjuegoCadena;

        //Limpiar buffer
        input.nextLine();

        System.out.println("¿Cual es su título?");
        titulo = input.nextLine();
        System.out.println("¿Cual es su plataforma?");
        plataforma = input.nextLine();

        while (seleccion==0){
            System.out.println("¿Que nota le pones?");

            try {
                nota = input.nextInt();
                seleccion = 1;
            }
            catch (Exception e){
                System.out.println("");
                System.out.println("Nota no válida"+ e.getMessage());
                System.out.println("La nota tiene que ser del 0 al 10");
            }
            finally {
                if (nota < 0 || nota > 10){
                    seleccion = 0;
                }
            }
        }

        seleccion = 0;

        //Limpiar buffer
        input.nextLine();

        while (seleccion == 0 ){
            System.out.println("¿Cuanto pesa en Gigabytes?");

            try {
                gigabites = input.nextDouble();
                seleccion = 1;
                if (gigabites < 0){
                    System.out.println("No puedes poner un valor negativo");
                    gigabites = 0.0;
                    seleccion = 0;
                }
            }
            catch (Exception e){
                System.out.println("");
                System.out.println("Introduce un valor correcto"+ e.getMessage());
                seleccion = 0;
            }
        }

        seleccion = 0;

        //Limpiar buffer
        input.nextLine();

        while (seleccion == 0) {
            System.out.println("¿Lo compraste en tienda Online?");
            System.out.println("1. Si | 2. No");

            try {
                seleccion = input.nextInt();
                seleccion = 1;
            } catch (Exception e) {
                System.out.println(" ");
                System.out.println("Introduce 1 o 2");
            } finally {
                if (seleccion < 1 || seleccion > 2) {
                    seleccion = 0;
                }
            }
        }

            switch (seleccion){
                case 1:
                    tiendaOnline = "Comprado en Online";
                    break;
                case 2:
                    tiendaOnline = "NO comprado en Online";
                    break;
            }


        videjuegoCadena = titulo + "," + plataforma  + "," + nota  + "," + tiendaOnline  + "," + gigabites + "\n";
        VideojuegoDigital videojuegoDigital = new VideojuegoDigital(titulo,plataforma,nota,tiendaOnline,gigabites);
        listaVideojuegos.add(videojuegoDigital);
        //escrituraFicheros(videjuegoCadena);
    }

    //Eliminar por nombre
    public static void eliminarJuego(Scanner input, ArrayList<Videojuego> vjList){
        String nombre = " ";
        int contador = 0;
        int juegoPosicion = 0;
        boolean sePuedeBorrar = false;
        //Limpiar buffer
        input.nextLine();

        System.out.println("Introduce el nombre: ");
        try {
            nombre = input.nextLine();
        }
        catch (Exception e){
            System.out.println("No es un nombre valido");
        }

        try {
            for (Videojuego vj : vjList){

                if (nombre.equals(vj.getTitulo())){
                    juegoPosicion = contador;
                    sePuedeBorrar = true;
                }
                contador++;
            }
            if (sePuedeBorrar){
                vjList.remove(juegoPosicion);
                System.out.println("");
                System.out.println("Se ha eliminado el juego correctamente:");
                System.out.println("Recuerda guardar los cambios.");
            }
            else {
                throw new JuegoNoEncontrado("No se ha encontrado el juego dentro de la lista;");
            }

        }
        catch (Exception e){
            System.out.println("No se ha encontrado el juego"+ e.getMessage());
        }

    }

    //Mostrar ranking
    public static void mostrarRanking(ArrayList<Videojuego> ranking){
        System.out.println("Ranking: ");
        if (ranking.isEmpty()){
            System.out.println("No se ha importado bien o está vacío.");
            System.out.println("Si está vacío asegurate de cargar el ranking primero.");
        }
        else {
            int contador = 1;
            for (Videojuego vj : ranking){
                //comprobar el tipo con instanceOf
                //se ejecutará el toSTring de la clase coresondiente
                System.out.println("■ " + contador + ": "+ "\n" + vj);
                contador++;
            }
        }
    }

    //Exportar texto
    public static void exportarTexto (ArrayList<Videojuego> vj){
        Path rutaLista = Paths.get("Documentos/ranking_exportado.txt");

        System.out.println("Exportando a texto...");

        if (!Files.exists(rutaLista)){
            System.out.println("El archivo no existe.");
        }
        else if (vj.isEmpty()){
            System.out.println("Carga primero una lista.");
        }
        else {
            int contador = 1;
            for (Videojuego videojuego : vj ){
                String lineaEscritura = "■ "+ contador + ": " +videojuego.getTitulo() + "," +
                        videojuego.getPlataforma() +","+
                        videojuego.getNota() +","+
                        videojuego.getTipo() + "\n";
              try {
                  Files.writeString(rutaLista,lineaEscritura, StandardOpenOption.APPEND );
              }
              catch (Exception e){
                  System.out.println("No se ha podido escribir el texto");
              }
              contador++;
            }
        }
    }

    //Ordenar por nota
    public static void mostrarPorNota (ArrayList<Videojuego> vjLista){
        System.out.println(" ");
        System.out.println("Mostrando por nota");

        if (vjLista.isEmpty()){
            System.out.println("El archivo está vacío");
        }
        else {

            vjLista.sort(new Comparator<Videojuego>() {
                @Override
                public int compare(Videojuego o1, Videojuego o2) {
                    return Integer.compare(o2.getNota(), o1.getNota());
                }
            });
            mostrarRanking(vjLista);
            System.out.println("Ranking ordenado del 10 al 1");
            System.out.println("Recuerda guardar si quieres manterlo ordenado por nota.");
        }
    }


}