package Programacion.Tema2;

import java.util.Random;
import java.util.Scanner;

public class Tema2Ejercicio29 {
    public static void main(String[] arg){

        /* “El número secreto”. Programa un juego en el que se calcula
aleatoriamente un número de 1 a 100. El usuario debe adivinarlo. Cada
vez que el usuario pone un número el programa le indicará si lo ha
acertado, si el número secreto es mayor o si es menor. Termina cuando
el usuario acierta el número.*/

        int userNum;
        Scanner input= new Scanner(System.in);
        Random random=new Random();
        int secret = random.nextInt(100);
        System.out.println(secret);

        System.out.println("¿En qué número crees que estoy pensando, del 1 al 100.");
        userNum= input.nextInt();

        while (userNum!=secret){
            if (userNum>secret){
                System.out.println("No! Ese no es mi número, más bajo.");


            }
            else if (userNum<secret) {
                System.out.println("No! Ese no es mi número, más alto");
            }
            else {
                System.out.println("Has acertado mí número era: "+secret);
            }
            System.out.println("¿En qué número estoy pensado?");
            userNum=input.nextInt();
        }

        if (userNum==secret){
            System.out.println("Madre mía a la primera! Qué potra.");
        }

        /*Está rara la respuesta de victoria, pero me hace mucha gracia. Tengo que mirar cómo
        * cambiar a la respuesta buena btw*/
        input.close();
    }
}
