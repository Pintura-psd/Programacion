/* package Programacion.Estudio_examenRecu.Examen2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1funciones {

    public static void menu (){
        System.out.println("Añadir figura: 1");
        System.out.println("Añadir nuevo accesorio: 2");
        System.out.println("Eliminar Figura: 3");
        System.out.println("Mostar Funkos edicion limitada: 4");
        System.out.println("Mostrar lista: 5" );
        System.out.println("Salir: 6");
    }

    public static ArrayList<Figura> addFigura(ArrayList<Figura> listaFiguras, Scanner in){
        int selectFigura;
        in.nextLine();
        System.out.println("¿Que tipo de figura es?");
        System.out.println("Figura de acción: 1 | Estatua: 2 | Funko Pop: 3");
        selectFigura = in.nextInt();
        in.nextLine();
        switch (selectFigura){
            case 1:
                addFiguraAccion(listaFiguras,in);
                break;
            case 2:
                addEstatua(listaFiguras,in);
                break;
            case 3:
                addFunkoPop(listaFiguras,in);
                break;
        }
        return listaFiguras;
    }

    public static ArrayList<Figura> addFiguraAccion (ArrayList<Figura> listaFiguras, Scanner in){
        in.nextLine();
        int select = 0;

        System.out.println("¿Que nombre tiene?");
        String nombre = in.nextLine();
        System.out.println("¿Año de lanzamiento?");
        int year = in.nextInt();
        in.nextLine();
        Boolean edicionEspecial = false;
        while (select< 1 || select>2) {
            System.out.println("¿Es edicion especial?");
            System.out.println("Sí: 1 | No: 2");
            try {
                select = in.nextInt();
                if (select == 1){
                    edicionEspecial = true;
                }
                else {
                    edicionEspecial = false;
                }
            } catch (Exception e){
                System.out.println("Introduce un numero entero.");

            }
            if (select<1 | select>2){
                System.out.println("Introduce 1 o 2");
            }
        }
        in.nextLine();
        System.out.println("¿Cual es su precio?");
        double precio = 0.0;
        try {
            precio = in.nextDouble();
            in.nextLine();
        } catch (Exception e){
            System.out.println("Introduce un número decimal."+ e.getMessage());
        }
        select = 0;
        while (select<1 || select > 3) {
            System.out.println("¿Cual es su estado?");
            System.out.println("Precintado: 1 | Embalaje original: 2 | Sin embalaje: 3");
           try {
               select = in.nextInt();
           } catch (Exception e){
               System.out.println("Introduce un número entero.");
           }
            in.nextLine();
            if (select<1 || select > 3){
                System.out.println("Introduce una opción del 1 al 3.");
            }
        }
        Embalaje embalaje = null;
        switch (select) {
            case 1:
                embalaje = Embalaje.PRECINTADO;
                break;
            case 2:
               embalaje = Embalaje.EMBALAJE_OG;
                break;
            case 3:
                embalaje = Embalaje.SIN_EMBALAJE;
                break;
        }
        ArrayList<Accesorio> listaAcesorios = new ArrayList<>();
        Figura_accion figuraAccion = new Figura_accion(nombre,year,edicionEspecial,precio,embalaje,listaAcesorios);
        listaFiguras.add(figuraAccion);
        return listaFiguras;
    }

    public static ArrayList<Figura> addEstatua (ArrayList<Figura> listaFiguras, Scanner in){
        in.nextLine();
        int select = 0;

        System.out.println("¿Que nombre tiene?");
        String nombre = in.nextLine();
        System.out.println("¿Año de lanzamiento?");
        int year = in.nextInt();
        in.nextLine();
        Boolean edicionEspecial = false;
        while (select< 1 || select>2) {
            System.out.println("¿Es edicion especial?");
            System.out.println("Sí: 1 | No: 2");
            try {
                select = in.nextInt();
                if (select == 1){
                    edicionEspecial = true;
                }
                else {
                    edicionEspecial = false;
                }
            } catch (Exception e){
                System.out.println("Introduce un numero entero.");

            }
            if (select<1 | select>2){
                System.out.println("Introduce 1 o 2");
            }
        }
        in.nextLine();
        System.out.println("¿A que franquicia pertenece?");
        String fraquicia = in.nextLine();
        System.out.println("¿Cual es su precio?");
        double precio = 0.0;
        try {
            precio = in.nextDouble();
            in.nextLine();
        } catch (Exception e){
            System.out.println("Introduce un número decimal."+ e.getMessage());
        }
        select = 0;
        while (select<1 || select > 3) {
            System.out.println("¿Cual es su estado?");
            System.out.println("Precintado: 1 | Embalaje original: 2 | Sin embalaje: 3");
            try {
                select = in.nextInt();
            } catch (Exception e){
                System.out.println("Introduce un número entero.");
            }
            in.nextLine();
            if (select<1 || select > 3){
                System.out.println("Introduce una opción del 1 al 3.");
            }
        }
        Embalaje embalaje = null;
        switch (select) {
            case 1:
                embalaje = Embalaje.PRECINTADO;
                break;
            case 2:
                embalaje = Embalaje.EMBALAJE_OG;
                break;
            case 3:
                embalaje = Embalaje.SIN_EMBALAJE;
                break;
        }
        Estatua estatua = new Estatua(nombre,year,edicionEspecial,precio,embalaje,fraquicia);
        listaFiguras.add(estatua);
        return listaFiguras;
    }

    public static ArrayList<Figura> addFunkoPop (ArrayList<Figura> listaFiguras, Scanner in){
        in.nextLine();
        int select = 0;

        System.out.println("¿Que nombre tiene?");
        String nombre = in.nextLine();
        System.out.println("¿Año de lanzamiento?");
        int year = in.nextInt();
        in.nextLine();
        Boolean edicionEspecial = false;
        while (select< 1 || select>2) {
            System.out.println("¿Es edicion especial?");
            System.out.println("Sí: 1 | No: 2");
            try {
                select = in.nextInt();
                if (select == 1){
                    edicionEspecial = true;
                }
                else {
                    edicionEspecial = false;
                }
            } catch (Exception e){
                System.out.println("Introduce un numero entero.");

            }
            if (select<1 | select>2){
                System.out.println("Introduce 1 o 2");
            }
        }
        in.nextLine();
        System.out.println("¿Cual es su precio?");
        double precio = 0.0;
        try {
            precio = in.nextDouble();
            in.nextLine();
        } catch (Exception e){
            System.out.println("Introduce un número decimal."+ e.getMessage());
        }
        select = 0;
        while (select<1 || select > 3) {
            System.out.println("¿Cual es su estado?");
            System.out.println("Precintado: 1 | Embalaje original: 2 | Sin embalaje: 3");
            try {
                select = in.nextInt();
            } catch (Exception e){
                System.out.println("Introduce un número entero.");
            }
            in.nextLine();
            if (select<1 || select > 3){
                System.out.println("Introduce una opción del 1 al 3.");
            }
        }
        Embalaje embalaje = null;
        switch (select) {
            case 1:
                embalaje = Embalaje.PRECINTADO;
                break;
            case 2:
                embalaje = Embalaje.EMBALAJE_OG;
                break;
            case 3:
                embalaje = Embalaje.SIN_EMBALAJE;
                break;
        }
        Funko_pop funkoPop = new Funko_pop(nombre,year,edicionEspecial,precio,embalaje);
        listaFiguras.add(funkoPop);
        return listaFiguras;
    }

    public static ArrayList<Figura> eliminarFigura(ArrayList<Figura> listaFiguras, Scanner in){
        String nombre = "";
        boolean econtrado = false;
        int contador= 0;
        int indexnum= 0;

        in.nextLine();
        System.out.println("¿Cual es su nombre?");
        nombre = in.nextLine();

        for (Figura figura : listaFiguras){
            if (figura.getNombre().equalsIgnoreCase(nombre)){
                econtrado = true;
                contador = indexnum;
            }
            contador++;
        }
        if (econtrado){
            listaFiguras.remove(indexnum);
            System.out.println("Se ha eliminado la figura correctamente.");
        }
        else {
            if (econtrado == false){
                System.out.println("No se ha encontrado la figura que buscas dentro de la lista.");
            }
        }
        return listaFiguras;
    }

    public static ArrayList<Figura> addAccesorio(ArrayList<Figura> listaFiguras, Scanner in){
       String nombre = "";
       Boolean econtrado = false;
       int contador = 0;
       int cantidad = 0;
       int indexNum=0;

        System.out.println("¿A que figura le quieres añadir accesorios?");
        nombre = in.nextLine();
        in.nextLine();

        for (Figura figura : listaFiguras){
            if (figura.getNombre().equalsIgnoreCase(nombre)){
                econtrado = true;
                indexNum = contador;
                try {
                    if (figura instanceof Figura_accion){
                        System.out.println("¿Cuantos quieres añadir?");
                        cantidad = in.nextInt();
                        in.nextLine();

                        for (int i = 0;i < cantidad; i++){
                        System.out.println("¿Cual es el nombre del accesorio?");
                        String nomAccesorio = in.nextLine();
                        System.out.println("¿Cual es el material?");
                        String material = in.nextLine();
                        System.out.println("Descripcion");
                        String descripcion = in.nextLine();
                        Accesorio accesorio = new Accesorio(nomAccesorio,material,descripcion);
                        ((Figura_accion) figura).getListaAccesorios().add(accesorio);
                        System.out.println("Se ha añadido correctamente el accesorio.");
                        System.out.println(((Figura_accion) figura).getListaAccesorios());
                        }
                    }
                } catch (Exception e){
                    System.out.println("No es una figura de acción."+ e.getMessage());
                }

            }
            contador++;
        }

        if (econtrado= false){
            System.out.println("No se pudo encontrar tu figura.");
        }
        return listaFiguras;
    }

    public static void mostrarLimitada(ArrayList<Figura> listaFiguras){
       ArrayList<Figura> fukoslimitados = new ArrayList<>();
        for (Figura figura : listaFiguras){
            if (figura instanceof Funko_pop){
                if (figura.isEdicion_esp()==true){
                    fukoslimitados.add(figura);
                }
            }
        }
        mostrarLista(fukoslimitados);
    }

    public static void mostrarLista (ArrayList<Figura> listaFiguras){
       for (Figura figura : listaFiguras){
           System.out.println(figura);
       }
    }
}
*/