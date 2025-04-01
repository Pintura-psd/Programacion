package Programacion.Tema5.Carrito1y4;
/*1. Haz una aplicación que permita crear una lista de la compra. Leerá por
consola varios productos y los guardará todos en un set. Si intentas guardar
dos veces el mismo producto te avisará que ya existe el producto.*/

/* */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class CarritoAmpliado {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> productsList = new  HashSet();
        Set<String> productsNest = new HashSet();
        int menu = 0;

        while (menu != 6){
            menu = readOptions(input);
            switch (menu){
                case 1:
                    productsAdd(input,productsList);
                    break;
                case 2:
                    productsAdd(input,productsNest);
                    break;
                case 3:
                    show(productsList);
                    break;
                case 4:
                    show(productsNest);
                    break;
                case 5:
                    missProducts(productsList,productsNest);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }

    private static int readOptions(Scanner input){
        System.out.println("Opciones: ");
        System.out.println("1. Añadir un producto a la lista.");
        System.out.println("2. Añadir un producto al carro");
        System.out.println("3. Mostrar productos de la lista.");
        System.out.println("4. Mostrar productos del carro.");
        System.out.println("5. Productos que faltan por añadir");
        System.out.println("6. Salir.");
        int menu = input.nextInt();
        return menu;
    }

    public static void productsAdd(Scanner input, Set<String> productos){
        String producto = "";

        System.out.println("Introduce los productos que tú quiereas añadir.");
        System.out.println("Intoduce fin cuando quieras finalizar.");
        while (!producto.equals("fin")){
            System.out.println("Introduce tú producto: ");
            producto = input.nextLine().toLowerCase();
            /*Si pongo producto.toLowerCase(); separado, no entiende que fin está
            introducido y no acaba el bucle*/

            if (!producto.equals("fin")){
                if (productos.contains(producto)){
                    System.out.println("Ese producto ya está añadido.");
                }
                else {
                    productos.add(producto);
                }
            }
        }
        System.out.println("Has terminado de añadir productos.");
    }

    public static void show (Set<String> productos){
        System.out.println("Tú lista es: " + productos);
    }

    public static void missProducts(Set<String> productsList, Set<String> productsNest){
       //Preguntar por HashSet
        Set<String> leftProducsts = new HashSet<>(productsList);
        productsList.remove(productsNest);
        System.out.println("Productos que faltan por comprar.");
        System.out.println(leftProducsts);
    }
}
