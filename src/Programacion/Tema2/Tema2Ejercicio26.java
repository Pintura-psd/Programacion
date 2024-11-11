package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio26 {
    public static void main (String [] arg){
        /*26. Haz un programa que pida un número entero por consola e indica si es
primo o no. Un número primo sólo es divisible por él mismo y por la
unidad.*/

        int num;
        boolean primo=true;
        Scanner input=new Scanner(System.in);




        System.out.println("Introduce un número entero:");
        num=input.nextInt();


        //Esto es lo que me verifica si es primo.
        if (num<=1){
            primo=false;
        }

        for (int i= 2;i < num; i++){
            if (num%i==0) {
                primo=false;
            }
        }

        if (primo==true) {
            System.out.println("Este número "+ num +" es primo.");
        } else {
            System.out.println("Este número "+ num +" no es primo.");
        }
input.close();
    }
}
