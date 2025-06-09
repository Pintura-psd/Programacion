package Programacion.Estudio_examenRecu.Examen1.Ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1_metodos {
    public static void menuTexto (){
        System.out.println("Añadir figura: 1");
        System.out.println("Añadir accesorio: 2");
        System.out.println("Mostrar listado: 3");
        System.out.println("Mostrar Funkos Pops edición especial: 4");
        System.out.println("Salir: 5");
    }

    public static ArrayList añadirFigura (Scanner input, ArrayList<Figura> listaFiguras){
        String nombre;
        int releaseYear;
        double precioBase;
        boolean precintada = false;
        boolean embalajeOG = false;
        int fechaAdqusicion = LocalDate.now().getYear();
        ArrayList<Accesorio> listaAccesorios = new ArrayList<>();
        boolean limitada;
        String fraquicia;

        int seleccionMenu = 0;
        int select = 0;

        System.out.println("¿Qué tipo de figura quieres añadir?");
        System.out.println("Figura de acción: 1");
        System.out.println("Estatua: 2");
        System.out.println("Funko-pop: 3");
        seleccionMenu = input.nextInt();
        System.out.println(" ");
        if (seleccionMenu > 3 || seleccionMenu <0){
            System.out.println("Selecciona un número del 1 al 3");
            seleccionMenu = 0;
        }
        input.nextLine();
        switch (seleccionMenu){
            case 1:
                System.out.println("Añadiendo Figura de acción: ");
                System.out.println(" ");
                System.out.println("¿Cual es el nombre?");
                nombre = input.nextLine();
                System.out.println("¿Cual es el año de lanzamiento?");
                releaseYear = input.nextInt();
                System.out.println("¿Cual es su precio base?");
                precioBase = input.nextDouble();
                System.out.println("¿Está precintada?");
                System.out.println(" ");
                System.out.println("Sí: 1 | No: 2");
                select = input.nextInt();
                input.nextLine();
                if (select == 1){
                    precintada = true;
                    embalajeOG = true;
                }
                else if (select == 2){
                    precintada = false;
                    select = 0;
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

                Figura_Accion figuraAccion = new Figura_Accion(nombre,releaseYear,precioBase,precintada,embalajeOG);
                listaFiguras.add(figuraAccion);
                System.out.println(" ");
                System.out.println("Se ha añadido la figura de acción: "+ figuraAccion.getNombre());
                break;

            case 2:
                System.out.println("Añadiendo Estatua: ");
                System.out.println(" ");
                System.out.println("¿Cual es el nombre?");
                nombre = input.nextLine();
                System.out.println("¿Cual es su franquicia?");
                fraquicia = input.nextLine();
                System.out.println("¿Cual es el año de lanzamiento?");
                releaseYear = input.nextInt();
                System.out.println("¿Cual es su precio base?");
                precioBase = input.nextDouble();
                System.out.println("¿Está precintada?");
                System.out.println(" ");
                System.out.println("Sí: 1 | No: 2");
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
                    select = 0;
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

                Estatua estatua = new Estatua(nombre,releaseYear,precioBase,precintada,embalajeOG,fraquicia);
                listaFiguras.add(estatua);
                System.out.println(" ");
                System.out.println("Se ha añadido la estatua: "+ estatua.getNombre());
                break;

            case 3:
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
                listaFiguras.add(funko);
                System.out.println(" ");
                System.out.println("Se ha añadido el Funko-Pop: "+ funko.getNombre());
                break;
        }

        return listaFiguras;
    }

    public static void addAccesorio(Scanner input, ArrayList<Figura> listaFiguras){
        String nombreFigura = "";
        String nombre = "";
        String material = "";
        String deccripcion = "";
        int contador = 0;
        boolean encontrado = false;


        System.out.println("Introduce el nombre de tu Figura de acción");
        input.nextLine();
        nombreFigura = input.nextLine();

        for (Figura Figura : listaFiguras){
            if (Figura.getNombre().equals(nombreFigura)){
                encontrado = true;
            }
            else {
                encontrado = false;
            }
        }

        if (encontrado){
            System.out.println("La figura "+ nombreFigura +" está en la lista");
            System.out.println(" ");
            System.out.println("¿Cuantos accesorios quieres añadir?");
            contador = input.nextInt();

            for (int i = 0; i < contador; i++) {

                System.out.println("¿Cual es el nombre el accesorio "+ (i+1) +"?");
                input.nextLine();
                nombre = input.nextLine();
                System.out.println("¿De que material está hecho?");
                material = input.nextLine();
                System.out.println("Introduce una breve desccripción.");
                deccripcion = input.nextLine();

                Accesorio accesorio = new Accesorio(nombre,material,deccripcion);

                for (Figura figura : listaFiguras ){
                  if (figura instanceof Figura_Accion && figura.getNombre().equalsIgnoreCase(nombreFigura)){
                      ((Figura_Accion) figura).getListaAccesorios().add(accesorio);
                      System.out.println("Se ha añadido el accesorio: "+ accesorio.getNombre());
                      System.out.println(" ");
                      System.out.println("Especificaciones de la figura"+ figura);
                  }
                }
            }
        }
        else {
            System.out.println("La figura "+ nombre +"no está en la lista");
        }
   }

   public static void mostrarFunkosLimitados(ArrayList<Figura> listaFiguras){
        ArrayList<Figura> Funko_pops = new ArrayList<>();
        for (Figura figura : listaFiguras){
            if (figura instanceof Funko_Pop && ((Funko_Pop) figura).isEdicionLimitada() == true)
            Funko_pops.add(figura);
        }

       mostrarLista(Funko_pops);
   }

   public static void mostrarLista(ArrayList<Figura> listaFiguras){
        for (Figura figura : listaFiguras){
            System.out.println("Nombre: " + figura.getNombre() +" Precio base: "+ figura.getPrecioBase()+" Precio final: "+ figura.calcularPrecio() + "\n");
        }
   }
}
