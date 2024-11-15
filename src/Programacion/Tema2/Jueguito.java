package Programacion.Tema2;

import java.util.Scanner;

public class Jueguito {
    public static void main (String []arg) {

        int turn=1;
        int elecction = 0;

        int player1;
        int maxhealth=1;
        int healthpoints = 1;
        int damage = 1;
        int defense = 1;
        int speed = 1;
        int hit;
        int heal=0;
        int totalPoints1 = healthpoints + damage + defense + speed;

        int player2;
        int maxhealth2=1;
        int healthpoints2 = 1;
        int damage2 = 1;
        int defense2 = 1;
        int speed2 = 1;
        int hit2;
        int heal2=0;
        int totalPoints2 = healthpoints2 + damage2 + defense2 + speed2;

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce los atributos del Player1 tienes 500 puntos a repartir.");
        System.out.println("Tus atributos no pueden pasar los 200 puntos.");

        while (totalPoints1 != 500 || maxhealth > 200 || damage > 200 || defense > 200 || speed > 200) {
            System.out.println("Introduce tú vida Player1");
            maxhealth = input.nextInt();
            System.out.println("Introduce tú daño Player1");
            damage = input.nextInt();
            System.out.println("Introduce tú defensa Player1");
            defense = input.nextInt();
            System.out.println("Introduce tú velocidad Player1");
            speed = input.nextInt();

            healthpoints = maxhealth;
            totalPoints1 = healthpoints + damage + defense + speed;


            if (totalPoints1 > 500) {
                System.out.println("Tus puntos suman más que 500, redistribuyelos.");
                System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
            } else {
                if (healthpoints > 200 || damage > 200 || defense > 200 || speed > 200) {
                    System.out.println("Tus valores tiene que ser menores de 200.");
                } else {
                    if (totalPoints1 < 500) {
                        System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
                        System.out.println("Vida: " + healthpoints2 + " Ataque: " + damage2 + " Defensa: " + defense2 + " Velocidad: " + speed2);
                    } else if (totalPoints1 == 500) {
                        System.out.println("Los puntos del Player1 están repartidos!");
                    }
                }
            }
        }


        while (totalPoints2 != 500 || maxhealth2 > 200 || damage2 > 200 || defense2 > 200 || speed2 > 200) {
            System.out.println("Introduce tú vida Player2 ");
            maxhealth2 = input.nextInt();
            System.out.println("Introduce tú daño Player2");
            damage2 = input.nextInt();
            System.out.println("Introduce tú defensa Player2");
            defense2 = input.nextInt();
            System.out.println("Introduce tú velocidad Player2");
            speed2 = input.nextInt();

            healthpoints2 = maxhealth2;
            totalPoints2 = healthpoints2 + damage2 + defense2 + speed2;

            if (totalPoints2 > 500) {
                System.out.println("Tus puntos suman más que 500, redistribuyelos.");
                System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
            } else {
                if (healthpoints2 > 200 || damage2 > 200 || defense2 > 200 || speed2 > 200) {
                    System.out.println("Tus valores tiene que ser menores de 200.");
                } else if (totalPoints2 < 500) {
                    System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
                    System.out.println("Vida: " + healthpoints + " Ataque: " + damage + " Defensa: " + defense + " Velocidad: " + speed);
                } else if (totalPoints2 == 500) {
                    System.out.println("Los puntos del Player2 están repatidos!");
                }
            }

            System.out.println("Es hora de combatir!");

            if (totalPoints1==500 && totalPoints2==500) {
                while (healthpoints >= 0 || healthpoints2 >= 0) {
                    System.out.println("Turno: " + turn);
                    System.out.println("1: Atacar");
                    System.out.println("2: Bloquear");
                    System.out.println("3: Cura");
                    System.out.println("Realiza tú acción.");
                    elecction = input.nextInt();

                    if (speed > speed2 || speed == speed2) {
                        switch (elecction) {
                            case 1:
                                hit = damage - (defense2 / damage);
                                healthpoints2 = healthpoints2 - hit;
                                break;
                            case 2:
                                defense = defense * 10;
                                break;
                            case 3:
                                heal = (maxhealth % 10);
                                healthpoints = healthpoints + heal;

                                if (healthpoints > maxhealth) {
                                    healthpoints = maxhealth;
                                }
                                break;
                        }
                    }
                    if (speed2 > speed) {
                        switch (elecction) {
                            case 1:
                                hit2 = damage2 - (defense / damage2);
                                healthpoints = healthpoints - hit2;
                                break;
                            case 2:
                                defense2 = defense2 * 10;
                                break;
                            case 3:
                                heal2 = healthpoints2 + (maxhealth2 % 10);
                                if (healthpoints2 > maxhealth2) {
                                    healthpoints2 = maxhealth2;
                                }
                                break;
                        }
                    }
                    System.out.println("Player 1: "+ healthpoints);
                    System.out.println("player 2 "+ healthpoints2);
                    turn++;
                }if (healthpoints <= 0){
                    System.out.println("Jugador 2 ha ganado!");
                }
                else {
                    System.out.println("Jugador 1 ha ganado!");
                }
            }


        }
    }
}
