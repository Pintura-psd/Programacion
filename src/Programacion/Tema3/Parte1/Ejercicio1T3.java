package Programacion.Tema3.Parte1;
/*1) Crea un programa que pida un número por consola y nos indique si es
positivo, negativo o 0. Para ello implementa la función numberSign que
devuelve 0, 1 o -1 dependiendo de si el número que recibe como
parámetro es 0, positivo o negativo.*/


import java.util.Scanner;

public class Ejercicio1T3 {
    public static void main (String [] args){

        Scanner input= new Scanner (System.in);
        int num=0;
        int result=0;

        //Pido los parámetros al usuario.
        System.out.println("Introduce un número, si es positivo te devolveré un 1, encaso de negativo -1 y 0 si es neutro.");
        num= input.nextInt();

        //Importante el orden de cuando llamo a la función.
        result = Funciones.numberSing(num);

        //Devuelvo el valor.
        if (result == 1) {
           System.out.println("El número es positivo.");
        }
        else if (result == -1) {
           System.out.println("El número es negativo.");
        }
        else {
           System.out.println("El número es 0.");
       }

        input.close();
    }
}
