package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio8 {
    public static void main(String[] args) {
        int num1;
        int num2;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce dos números enteros para ver cual es más grande.");
        num1=input.nextInt();
        num2=input.nextInt();

        if (num1>num2) {
            System.out.println("El número "+ num1 +" es más grande que "+ num2);


        }
        else if (num1<num2) {
            System.out.println("El número "+ num2 +" es más grande que "+ num1);


        }
        else if (num1==num2);
        System.out.println(num1 +" y "+ num2 +" son iguales.");
    }

}



