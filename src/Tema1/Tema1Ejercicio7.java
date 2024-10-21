package Tema1;

import java.util.Scanner;

public class Tema1Ejercicio7 {
    public static void main(String[] args) {
        int dice;
        int ndice;
        Scanner input= new Scanner(System.in);

        System.out.println("Escribe la cara del dado que quieres. (D6)");
        dice=input.nextInt();
        if (dice<1||dice>6) {
            System.out.println("Esto no es un dado D6.");

        }
        else {
            ndice=7-dice;
            System.out.println("Has introducido "+ dice +" y tú cara opuesta es:"+ ndice);



        }

    }

}