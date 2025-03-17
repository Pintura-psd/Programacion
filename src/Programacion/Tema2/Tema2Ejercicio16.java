package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio16 {
    static public void main (String [] arg){
        /* Realiza un programa que si lee por consola ‘D’ convierte euros a dolares
la cantidad introducida y si lee por consola ‘E’ convierte dolares a
euros. */

    double cuantity;
    double result;
    char letra;
    Scanner input=new Scanner(System.in);
    System.out.println("Introduce una E si quieres transformar a euros, si quieres pasar a dolares introduce una D");
    letra= input.next().charAt(0);

   while ((letra !='D') && (letra !='E')){
       System.out.println("Introduce bien el dato.");

       System.out.println("Introduce una E si quieres transformar a euros, si quieres pasar a dolares introduce una D");
       letra= input.next().charAt(0);
        }

   System.out.println("Introduce la cantidad que deseas transformar.");
   cuantity=input.nextDouble();

   if (letra=='D'){
       result=cuantity*0.93;
       System.out.println("Tienes "+ result +" $");
   } else if (letra=='E') {
       result=cuantity*1.0825;
       System.out.println("Tienes "+ result +" €");
   }

input.close();
    }
}
