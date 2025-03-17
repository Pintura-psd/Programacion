package Programacion.Tema3.Parte1;

/* 6) Escribe un programa que muestre las tablas de multiplicar del 1 al 10 */
public class Ejercicio6T3 {
    public static void main (String [] args){

        int num=1;
        System.out.println("Las tablas de multiplicar del 1 al 10 son : ");
        System.out.println(" ");
        for (int i=1; i<=10; i++) {
            System.out.println("Tabla del: "+ num);
            Funciones.multiplyTable(num);
            System.out.println("  ");

         num++;
        }
    }
}