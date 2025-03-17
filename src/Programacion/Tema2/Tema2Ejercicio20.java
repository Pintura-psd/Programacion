package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio20 {
    public static void main (String []args){

        /*20. Realiza un programa que lee por consola dos números enteros (A y B).
Si B es mayor que A, muestra todos los números impares entre ellos.*/

        int num1;
        int num2;
        int aux;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce dos números enteros y te mostraré los números impares entre ellos si el segundo número es mayor que el primero.");
        num1=input.nextInt();
        num2=input.nextInt();

        if (num2>num1){
            System.out.println("Los números impares entre "+ num1 + " y " + num2 + " son: ");
            aux=num1+1;
            while (aux<num2){;
               if (aux%2 !=0){
                   System.out.println(aux);
               }
                aux++;
            }

        }else {
            System.out.println("El segundo número no es mayor que el primero.");
        };

    }
}
