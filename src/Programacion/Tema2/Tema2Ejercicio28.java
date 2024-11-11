package Programacion.Tema2;

import java.util.Random;
import java.util.Scanner;

public class Tema2Ejercicio28 {
    public static void main (String [] arg){

        /*28. Haz un programa que calcule un número aleatorio de la lotería de
Navidad (de 0 a 99.999) y después pida al usuario por consola hasta 5
números indicando cada vez si ha ganado la lotería o no.*/

       boolean winner=false;
       int trys=0 ;
       int userNum;
       Scanner input=new Scanner(System.in);
       Random random = new Random();
        int lotery= random.nextInt (100000);
        System.out.println(lotery);

        System.out.println("Feliz Navidad! Vamos a ver si toca este año.");

        while (trys<5 && !winner) {
            System.out.println("Introduce tú número de boleto porfavor. Intento: " + (trys + 1) + " de 5");
            userNum=input.nextInt();


            if (userNum == lotery) {
                System.out.println("Enhorabuena, has ganado la lotería.");
            } else {
                System.out.println("Lo siento pero no has ganado, intentalo otra vez.");

            }
            trys++;
        }

        if (!winner){
            System.out.println("No te quedan más intentos lo siento. El número ganador era: "+ lotery);
        }

    }
}
