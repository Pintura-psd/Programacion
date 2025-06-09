package Programacion.Examen3.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecicio1Funciones {

    public static void menu (){
        System.out.println("Añadir figura: 1");
        System.out.println("Añadir accesorio: 2");
        System.out.println("Mostrar listado: 3");
        System.out.println("Mostrar edición especial de Funko-pops: 4");
        System.out.println("Salir: 5");
    }

    public static ArrayList<Figura> addFigura (ArrayList<Figura> lsitaFiguras, Scanner input){
        int select = 0;
        while (select == 0) {

            System.out.println("¿Qué tipo de figura quieres añadir?");
            System.out.println("1: Figura accion");
            System.out.println("2: Estatua");
            System.out.println("3: Funko-pop");

            try {
                select = input.nextInt();
            } catch (Exception e){
                System.out.println("Introduce un valor entero.");
            }
            if (select < 1 || select > 3 ){
                System.out.println("Introduce un valor del 1 al 3");
            }
        }


        switch (select){
            case 1:
                addFigura_accion(lsitaFiguras,input);
                break;
            case 2:
                addEstatua(lsitaFiguras,input);
                break;
            case 3:
                addFunko(lsitaFiguras,input);
                break;
        }

        return lsitaFiguras;
    }

    public static ArrayList<Figura> addFigura_accion (ArrayList<Figura> lsitaFiguras, Scanner input){
        int select = 0;
        Embalaje estado = null;
        ArrayList<Accesorio> listaAccesorios = new ArrayList<>();

        input.nextLine();
        System.out.println("¿Cual es el nombre de la Figura de acción?");
        String nombre = input.nextLine();
        System.out.println("¿Cuando fue el año de su lanzamiento?");
        int year = input.nextInt();
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

        Figura_accion figuraAccion = new Figura_accion(nombre,year,precio,estado,listaAccesorios);
        lsitaFiguras.add(figuraAccion);
        System.out.println("Se ha añadido la figura.");
        return lsitaFiguras;
    }

    public static ArrayList<Figura> addFunko (ArrayList<Figura> lsitaFiguras, Scanner input){
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
        return lsitaFiguras;
    }

    public static ArrayList<Figura> addEstatua (ArrayList<Figura> listaFiguras, Scanner input){
        int select = 0;
        Embalaje estado = null;

        input.nextLine();
        System.out.println("¿Cual es el nombre de la Estatua?");
        String nombre = input.nextLine();
        System.out.println("¿Cuando fue el año de su lanzamiento?");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("¿Cual es su franquicia?");
        String franquicia = input.nextLine();
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

        Estatua estatua = new Estatua(nombre,year,precio,estado,franquicia);
        listaFiguras.add(estatua);
        System.out.println("Se ha añadido la figura.");
        return listaFiguras;
    }

    public static void mostrarLista(ArrayList<Figura> listaFiguras){
        System.out.println("Lista de figuras: ");
        for (Figura figura: listaFiguras){
            System.out.println(figura);
            System.out.println("________________________");
        }
    }

    public static ArrayList<Figura> addAccesorio (ArrayList<Figura> listaFiguras, Scanner input){
        String nombre =  "";
        Boolean econtrado = false;

        input.nextLine();
        System.out.println("¿Cual es el nombre de la figura?");
        nombre = input.nextLine();
        for (Figura figura: listaFiguras){
            if (figura.getNombre().equalsIgnoreCase(nombre)){
                econtrado = true;
                if (figura instanceof Figura_accion){
                    System.out.println("¿Cual es el nombre del accesorio?");
                    String nombreAccesorio = input.nextLine();
                    System.out.println("¿Cual es el material?");
                    String material = input.nextLine();
                    System.out.println("¿Cual es su descripción?");
                    String descripcion = input.nextLine();

                    Accesorio accesorio = new Accesorio(nombreAccesorio,material,descripcion);
                    ((Figura_accion) figura).getListaAccesorios().add(accesorio);
                }
                else {
                    System.out.println("No es una figura de acción");
                }
            }
        }
        if (econtrado = false){
            System.out.println("No se ha encontrado tu figura en el listado.");
        }
        return listaFiguras;
    }

    public static void funkosEdLimitada(ArrayList<Figura> listaFiguras){
        ArrayList<Figura> listaFigurasLimitadas = new ArrayList<>();

        for (Figura figura : listaFiguras){
            if (figura instanceof Funko_pop){
                if (((Funko_pop) figura).isEd_limitada() == true){
                    listaFigurasLimitadas.add(figura);
                }
            }
        }
        mostrarLista(listaFigurasLimitadas);
    }
}
