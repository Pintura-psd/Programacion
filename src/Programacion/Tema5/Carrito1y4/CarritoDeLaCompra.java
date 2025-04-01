package Programacion.Tema5.Carrito1y4;
/*1. Haz una aplicación que permita crear una lista de la compra. Leerá por
consola varios productos y los guardará todos en un set. Si intentas guardar
dos veces el mismo producto te avisará que ya existe el producto.*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CarritoDeLaCompra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> productos = new  HashSet();
        String producto = "";

        System.out.println("Introduce los productos que tú quiereas añadir a tú lista de la compra.");
        System.out.println("Intoduce fin cuando quieras finalizar tú lista.");
        while (!producto.equals("fin")){
            System.out.println("Introduce tú producto: ");
            producto = input.nextLine().toLowerCase();
            /*Si pongo producto.toLowerCase(); separado, no entiende que fin está
            introducido y no acaba el bucle*/

            if (!producto.equals("fin")){
                if (productos.contains(producto)){
                    System.out.println("Ese producto ya está en la lista.");
                }
                else {
                    productos.add(producto);
                }
            }
        }
        System.out.println("Has cerrado la tú carrito de la compra");
        System.out.println("Tú carrito es: " + productos);
    }
}
