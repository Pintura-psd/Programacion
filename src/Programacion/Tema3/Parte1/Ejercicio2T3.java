package Programacion.Tema3.Parte1;
/*2) Utiliza la función anterior y una función nueva que crearás llamada
isAdult para hacer un programa que reciba una edad e indica si se es
mayor de edad o no.
boolean isAdult(age) */

import java.util.Scanner;

public class Ejercicio2T3 {
    public static void main (String [] args){

        Scanner input= new Scanner(System.in);
        int num=0;
        int result=0;
        int age=0;
        boolean mas18;

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

       //Segunda parte
        System.out.println("Ahora introdúceme una edad y te diré si es mayor de edad o no");
        age = input.nextInt();

        mas18 = Funciones.isAdult(age);

        if (mas18 == true){
            System.out.println("Es mayor de edad.");
        }
        else {
            System.out.println( "No es mayor de edad.");
        }

        input.close();
    }
}
