package Programacion.Estudio_examenRecu.VidejuegosRecu;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RankingVJFunciones {

    public static void menu (){
        System.out.println("Añadir videjuego: 1");
        System.out.println("Mostrar Ranking: 2");
        System.out.println("Eliminar videjuego por título: 3");
        System.out.println("Serializar ranking: 4");
        System.out.println("Ordenar por nota: 5");
        System.out.println("Exportar ranking a texto: 6");
        System.out.println("Interfaz Jugable: 7");
        System.out.println("Salir: 8");
    }


    public static ArrayList<VJ> deserializar (){
        Path rutaArchivo = Paths.get("Documentos/ranking2.dat");
        ArrayList<VJ> listaVJ = new ArrayList<>();

        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo no existe. Se procederá a crear uno.");
            try {
                Files.createFile(rutaArchivo);
            }catch (Exception e){
                System.out.println("Error al crear el archivo."+ e.getMessage());
            }
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(rutaArchivo))){
            listaVJ = (ArrayList<VJ>) ois.readObject();

            ois.close();
        }catch (Exception e){
            System.out.println("Error al deseerializar. "+ e.getMessage());
            if (listaVJ.isEmpty()){
                System.out.println("La lista está vacía");
                System.out.println("Crea algún videojuego para llenar la lista.");
            }
        }
        System.out.println("Se ha podido deserializar la lista.");
                return listaVJ;
    }



    public static void serialziar (ArrayList<VJ> listaJuegos){
        Path rutaArchivo = Paths.get("Documentos/ranking2.dat");

        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo no existe. Se procederá a crear uno.");
            try {
                Files.createFile(rutaArchivo);
            }catch (Exception e){
                System.out.println("Error al crear el archivo."+ e.getMessage());
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(rutaArchivo))){
            oos.writeObject(listaJuegos);
            oos.close();
        }catch (Exception e){
            System.out.println("Error al serializar."+ e.getMessage());
        }
    }


    public static ArrayList<VJ> addVJ (ArrayList<VJ> listaVJ, Scanner in){
        int slect = 0;
        while (slect == 0){
            System.out.println("¿Es físico o digital?");
            System.out.println("1: Físico | 2: Digital");
            try {
                slect = in.nextInt();
            } catch (Exception e){
                System.out.println("Introduce un valor adecuado.");
            }
        }

        switch (slect){
            case 1:
               VJ_Fisico vjFisico = addFisico(in);
               listaVJ.add(vjFisico);
                break;
            case 2:
                VJDigital vjDigital = addVJDigital(in);
                listaVJ.add(vjDigital);
                break;
        }
        slect = 0;
        return listaVJ;
    }

    public static VJDigital addVJDigital(Scanner in){
        int nota = 0;
        boolean valida =  false;
        double gb = 0;

        in.nextLine();
        System.out.println("¿Cual es el título?");
        String titulo = in.nextLine();
        System.out.println("¿Cual es la plataforma?");
        String plataforma = in.nextLine();
        while ( !valida) {
            System.out.println("¿Que nota le pones, del 1 al 10?");
            try {
                nota = in.nextInt();
                in.nextLine();

                if (nota>0 && nota<11){
                    valida = true;

                }
                else {
                    System.out.println("La nota tiene que estar del 1 al 10");
                }

            } catch (Exception e) {
                System.out.println("La nota tiene que ser un valor entero." + e.getMessage());
            }
        }
        String tiendaOnline = "Tienda Online";
        System.out.println("¿Cual es su peso en GB?");
        valida = false;
        while (!valida) {
            try {
                gb = in.nextDouble();
                in.nextLine();

                if (gb > 0 || gb < 999.9){
                    valida = true;
                }
            } catch (Exception e) {
                System.out.println("Error al introducir el valor" + e.getMessage());
            }
        }
        VJDigital vjDigital = new VJDigital(titulo,plataforma,nota,tiendaOnline,gb);
        return vjDigital;
    }

    public static VJ_Fisico addFisico (Scanner in){
        int nota = 0;
        int select = 0;
        boolean valida = false;
        EstadoVJ estadoVJ = null;

        in.nextLine();
        System.out.println("¿Cual es el título?");
        String titulo = in.nextLine();
        System.out.println("¿Cual es la plataforma?");
        String plataforma = in.nextLine();
        while ( !valida) {
            System.out.println("¿Que nota le pones, del 1 al 10?");
            try {
                nota = in.nextInt();
                in.nextLine();

                if (nota>0 && nota<11){
                    valida = true;

                }
                else {
                    System.out.println("La nota tiene que estar del 1 al 10");
                }

            } catch (Exception e) {
                System.out.println("La nota tiene que ser un valor entero." + e.getMessage());
            }
        }
        String tiendaFisica = "Tienda Fisica";

        while (select == 0) {
            System.out.println("¿Cual es su estado?");
            System.out.println("1: Nuevo | 2: Usado");
            try {
                select = in.nextInt();
                in.nextLine();
            } catch (Exception e){
                System.out.println("Introduce 1 o 2"+ e.getMessage());
                select = 0;
            }
            if (select == 1){
                estadoVJ = EstadoVJ.NUEVO;
            }
            else if (select == 2){
                estadoVJ = EstadoVJ.USADO;
            }
            else {
                System.out.println("Los valores tienen que estar entre 1 o 2.");
            }
        }

        VJ_Fisico vjFisico = new VJ_Fisico(titulo,plataforma,nota,tiendaFisica,estadoVJ);

        return vjFisico;
    }

    public static ArrayList<VJ> eliminarVJ (ArrayList<VJ> listaJuegos, Scanner in){
        String nom = "";
        Boolean encontrado = false;
        int contador = 0;
        int indexNum;

        System.out.println("Introduce el nombre del videojuego que desas borrar: ");

        nom = in.nextLine();

        for (VJ vj : listaJuegos){
            if (vj.getNombre().equalsIgnoreCase(nom)){
                encontrado = true;
                if (encontrado = true){
                    indexNum = contador;
                    listaJuegos.remove(indexNum);
                    System.out.println("Se ha eliminado el juego correctamente.");
                }
            }
            contador++;
        }
        if (encontrado == false){
            System.out.println("No se ha encontrado el juego en la lista.");
        }else {
            if (encontrado == true){
                encontrado = false;
            }
        }
        return listaJuegos;
    }

    public static void mostrarRanking(ArrayList<VJ> listaJuegos){
        System.out.println("------Juegos------");
        for (VJ vj : listaJuegos){
            System.out.println(vj);
            System.out.println(" ");
        }
    }

    public static void exportarATexto(ArrayList<VJ> listaVJ){
        Path rutaArchivo = Paths.get("Documentos/rankingVj.txt");

        if (!Files.exists(rutaArchivo)){
            System.out.println("El archivo no existe. Se procederá a crear uno.");
            try {
                Files.createFile(rutaArchivo);
            }catch (Exception e){
                System.out.println("Error al crear el archivo."+ e.getMessage());
            }
        }

        try {
            Files.writeString(rutaArchivo, "Ranking videojuegos"+ "\n");
        }catch (Exception e){
            System.out.println("Error en la escritura del txt.");
        }

        for (VJ vj : listaVJ){
            try {
                Files.writeString(rutaArchivo, vj.toString(), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            }catch (Exception e){
                System.out.println("Error en la escritura del txt.");
            }
        }
        System.out.println("Éxito en la escritura txt.");
    }

    public static void ordenarPorNota (ArrayList<VJ> listaVJ) {
        System.out.println("Lista por nota: ");
        System.out.println(" ");
        listaVJ.sort(new Comparator<VJ>() {
            @Override
            public int compare(VJ o1, VJ o2) {
                return Integer.compare(o2.getNota(), o1.getNota());
            }

        });
        mostrarRanking(listaVJ);
    }

    public static void jugable(ArrayList<VJ> lsitaJuegos, Scanner in) {
        String nom = "";
        Boolean encontrado = false;
        int contador = 0;
        int indexNum = 0;
        in.nextLine();
        System.out.println("Introduce el nombre del juego que quieras saber si es jugable");
        nom = in.nextLine();
        for (VJ vjTempo : lsitaJuegos) {
            if (vjTempo.getNombre().equalsIgnoreCase(nom)) {
                encontrado = true;
                indexNum = contador;
            }
            contador++;
        }

        if (encontrado) {
            VJ vj = lsitaJuegos.get(indexNum);
            vj.JugarDemo();
        } else {
            System.out.println("No se ha encontrado el juego que deseas.");
        }
    }
}




