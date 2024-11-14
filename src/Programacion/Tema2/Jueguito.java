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
    System.out.println("Tus atributos no pueden pasar los 200 puntos.");

    while (totalPoints1 !=500 || healthpoints>200 || damage>200 || defense>200 || speed>200) {
        System.out.println("Introduce tú vida Player1");
        healthpoints = input.nextInt();
        System.out.println("Introduce tú daño Player1");
        damage = input.nextInt();
        System.out.println("Introduce tú defensa Player1");
        defense = input.nextInt();
        System.out.println("Introduce tú velocidad Player1");
        speed = input.nextInt();

        totalPoints1= healthpoints + damage + defense + speed;


        if (totalPoints1 > 500) {
            System.out.println("Tus puntos suman más que 500, redistribuyelos.");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }

        else {
            if (healthpoints > 200 || damage > 200 || defense > 200 || speed > 200) {
                System.out.println("Tus valores tiene que ser menores de 200.");
            } else {
                if (totalPoints1 < 500) {
                    System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
                    System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
                } else if (totalPoints1 == 500) {
                    System.out.println("Los puntos del Player1 están repartidos!");
                }
            }
        }
    }



    while (totalPoints2 != 500) {
        System.out.println("Introduce tú vida Player2 ");
        healthpoints2 = input.nextInt();
        System.out.println("Introduce tú daño Player2");
        damage2 = input.nextInt();
        System.out.println("Introduce tú defensa Player2");
        defense2 = input.nextInt();
        System.out.println("Introduce tú velocidad Player2");
        speed2 = input.nextInt();

        totalPoints2= healthpoints + damage + defense + speed;

        if (totalPoints2> 500) {
            System.out.println("Tus puntos suman más que 500, redistribuyelos.");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
        else if (totalPoints2<500) {
            System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
            System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
        }
        else if (healthpoints>200 || damage>200 || defense>200 || speed>200){
            System.out.println("No puedes tener mas de 200 en un valor.");
        }
        else if (totalPoints2==500) {
            System.out.println("Los puntos del Player2 están repatidos!");
        }
    }

}
}
