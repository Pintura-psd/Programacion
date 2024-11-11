package Programacion.Tema2;

import java.util.Scanner;

public class Jueguito {
public static void main (String []arg){

    int player1;
    int healthpoints=1;
    int damage=1;
    int defense=1;
    int speed=1;
    int totalPoints1= healthpoints + damage + defense + speed;

    int player2;
    int healthpoints2=1;
    int damage2=1;
    int defense2=1;
    int speed2=1;
    int totalPoints2= healthpoints2 + damage2 + defense2 + speed2;

    Scanner input= new Scanner(System.in);

    System.out.println("Introduce los atributos del Player1 tienes 500 puntos a repartir.");

    while (totalPoints1<500) {
        System.out.println("Introduce tú vida");
        healthpoints = input.nextInt();
        System.out.println("Introduce tú daño");
        damage = input.nextInt();
        System.out.println("Introduce tú defensa");
        defense = input.nextInt();
        System.out.println("Introduce tú velocidad");
        speed = input.nextInt();

        if (totalPoints1 > 500) {
            System.out.println("Tus puntos suman más que 500, redistribuyelos.");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
        else if (totalPoints1 < 500) {
            System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
       if (totalPoints1==500) {
            System.out.println("Los puntos del Player1 están repartidos!");
        }
    }

    if (totalPoints1==500) {
        System.out.println("Introduce los atributos del Player2 tienes 500 puntos a repartir.");
    }

    while (totalPoints2<=500) {
        System.out.println("Introduce tú vida");
        healthpoints2 = input.nextInt();
        System.out.println("Introduce tú daño");
        damage2 = input.nextInt();
        System.out.println("Introduce tú defensa");
        defense2 = input.nextInt();
        System.out.println("Introduce tú velocidad");
        speed2 = input.nextInt();

        if (totalPoints2> 500) {
            System.out.println("Tus puntos suman más que 500, redistribuyelos.");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
        else if (totalPoints2<500) {
            System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
        if (totalPoints2==500) {
            System.out.println("Los puntos del Player2 están repatidos!");
        }
    }
}
}
