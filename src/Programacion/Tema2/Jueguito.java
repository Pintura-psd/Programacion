package Programacion.Tema2;

import java.util.Random;
import java.util.Scanner;

public class Jueguito {
    public static void main(String[] arg) {

        int turn = 1;
        int slowest = 0;
        String player;

        String player1 = " ";
        int action1 = 0;
        int maxhealth1 = 1;
        int healthpoints1 = 1;
        int damage1 = 1;
        int defense1 = 1;
        int parry1 = 1;
        int speed1 = 1;
        int hit1 = 0;
        int heal1 = 0;
        int totalPoints1 = healthpoints1 + damage1 + defense1 + speed1;

        String player2 = " ";
        int action2 = 0;
        int maxhealth2 = 1;
        int healthpoints2 = 1;
        int damage2 = 1;
        int defense2 = 1;
        int parry2 = 1;
        int speed2 = 1;
        int hit2 = 0;
        int heal2 = 0;
        int totalPoints2 = healthpoints2 + damage2 + defense2 + speed2;

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduce los atributos del Player1 tienes 500 puntos a repartir.");
        System.out.println("Tus atributos no pueden pasar los 200 puntos.");

        while (totalPoints1 != 500 || maxhealth1 > 200 || damage1 > 200 || defense1 > 200 || speed1 > 200) {
            System.out.println("Introduce tú vida Player1");
            maxhealth1 = input.nextInt();
            System.out.println("Introduce tú daño Player1");
            damage1 = input.nextInt();
            System.out.println("Introduce tú defensa Player1");
            defense1 = input.nextInt();
            System.out.println("Introduce tú velocidad Player1");
            speed1 = input.nextInt();

            //Aquí uso healpoints y maxhealth para que al curarte no desbordes la vida máxima.
            healthpoints1 = maxhealth1;
            totalPoints1 = healthpoints1 + damage1 + defense1 + speed1;

            //Aquí dividiendo el else del if, creo que estoy haciendo un malgasto de recursos. Tendría que mirarlos mas adelante.
            if (totalPoints1 > 500) {
                System.out.println("Tus puntos suman más que 500, redistribuyelos.");
                System.out.println("Vida: " + healthpoints1 + " Ataque: " + damage1 + " Defensa: " + defense1 + " Velocidad: " + speed1);
            } else {
                if (healthpoints1 > 200 || damage1 > 200 || defense1 > 200 || speed1 > 200) {
                    System.out.println("Tus valores tiene que ser menores de 200.");
                } else {
                    if (totalPoints1 < 500) {
                        System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
                        System.out.println("Vida: " + healthpoints1 + " Ataque: " + damage1 + " Defensa: " + defense1 + " Velocidad: " + speed1);
                    } else if (totalPoints1 == 500) {
                        System.out.println("Los puntos del Player1 están repartidos!");

                        if ((damage1 / defense1) > 1 && (damage1 / healthpoints1) > 1) {
                            System.out.println("Eres un Asesino");
                            player1 = "Asesino";
                        } else if ((damage1 / defense1) > 1) {
                            System.out.println("Eres un Guerrero");
                            player1 = "Guerrero";
                        } else if ((damage1 / defense1) <= 1 && (defense1 / speed1) > 1) {
                            System.out.println("Eres un paladin");
                            player1 = "Paladin";
                        } else {
                            System.out.println("Eres un NPC venido a más.");
                            player1 = "NPC";
                        }
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

            //Aquí uso healpoints y maxhealth para que al curarte no desbordes la vida máxima.
            healthpoints2 = maxhealth2;
            totalPoints2 = healthpoints2 + damage2 + defense2 + speed2;

            if (totalPoints2 > 500) {
                System.out.println("Tus puntos suman más que 500, redistribuyelos.");
                System.out.println("Vida: " + healthpoints2 + " Ataque: " + damage2 + " Defensa: " + defense2 + " Velocidad: " + speed2);
            } else {
                if (healthpoints2 > 200 || damage2 > 200 || defense2 > 200 || speed2 > 200) {
                    System.out.println("Tus valores tiene que ser menores de 200.");
                } else if (totalPoints2 < 500) {
                    System.out.println("No tienes todos los puntos repartidos. Tus puntos son: ");
                    System.out.println("Vida: " + healthpoints2 + " Ataque: " + damage2 + " Defensa: " + defense2 + " Velocidad: " + speed2);
                } else if (totalPoints2 == 500) {
                    System.out.println("Los puntos del Player2 están repatidos!");

                    if ((damage2 / defense2) > 1 && (damage2 / healthpoints2) > 1) {
                        System.out.println("Eres un Asesino");
                        player2 = "Asesino";
                    } else if ((damage2 / defense2) > 1) {
                        System.out.println("Eres un Guerrero");
                        player2 = "Guerrero";
                    } else if ((damage2 / defense2) <= 1 && (defense2 / speed2) > 1) {
                        System.out.println("Eres un paladin");
                        player2 = "Paladin";
                    } else {
                        System.out.println("Eres un NPC venido a más.");
                        player2 = "NPC";
                    }
                }
            }
        }

        System.out.println("  ");
        System.out.println("                       __          __     ");
        System.out.println("  _________  ____ ___  / /_  ____ _/ /____ ");
        System.out.println(" / ___/ __ \\/ __ `__ \\/ __ \\/ __ `/ __/ _ \\ ");
        System.out.println("/ /__/ /_/ / / / / / / /_/ / /_/ / /_/  __/");
        System.out.println("\\___/\\____/_/ /_/ /_/_.___/\\__,_/\\__/\\___/ ");

//Tengo que printear mejor las acciones.

        if (speed1 - speed2 > 0) {
            slowest = 0;
        } else {
            slowest = 1;
        }

        while (healthpoints1 >= 0 || healthpoints2 >= 0) {

            System.out.println("¿Qué  quieres hacer player1?");

            System.out.println("Turno: " + turn);
            System.out.println(" ");
            System.out.println("1: Atacar");
            System.out.println("2: Bloquear");
            System.out.println("3: Cura");
            System.out.println(" ");
            System.out.println("Realiza tú acción.");
            action1 = input.nextInt();

            System.out.println("¿Qué quieres hacer player2?");

            System.out.println("Turno: " + turn);
            System.out.println(" ");
            System.out.println("1: Atacar");
            System.out.println("2: Bloquear");
            System.out.println("3: Cura");
            System.out.println(" ");
            System.out.println("Realiza tú acción.");
            action2 = input.nextInt();

            if (!(slowest == 1 && action1 == 3)) {
                System.out.println("player2 ha defendido al player1");

            } else if (player2 == "Gerrero") {
                parry2 = (damage1 * (damage2 / 2) / 100);
                healthpoints1 = healthpoints1 - parry2;
                System.out.println("player 2 ha reflejado!");

            } else if (speed1 > speed2) {
                switch (action1) {
                    case 1:
                        hit1 = (int) (damage1 * (1 - 0.5 * defense2 / 200));
                        if (hit1 < 0) {
                            healthpoints2 = healthpoints2 - hit1;
                        }
                        hit1 = (int) (damage1 * (1 - 0.5 * defense2 / 200));
                        //Entre 200 porque es el máximo de armadura que podemos tener. Es una regla de tres.
                        //El 1 es una reduccicón.
                        healthpoints2 = healthpoints2 - hit1;
                        //El random necesario de la práctica.
                        if (player1 == "Asesino") {
                            int randomInt = random.nextInt(1);
                            int randomIntBoost = random.nextInt(3);
                            if ((speed1 > 100 || speed1 < 150) && randomInt == 1) {
                                hit1 = (int) (hit1 * 1.75);
                                healthpoints2 = healthpoints2 - hit1;
                                System.out.println("Golpe crítico!");

                            } else if (speed1 > 175 && randomIntBoost > 0) {
                                hit1 = (int) (hit1 * 1.75);
                                healthpoints2 = healthpoints2 - hit1;
                                System.out.println("Golpe crítico!");
                            }
                        }
                        break;
                    case 2:
                        if (player1 == "Guerrero" && action2 == 1) {
                            parry1 = (damage2 * (damage1 / 2) / 100);
                            healthpoints2 = healthpoints2 - parry1;
                            System.out.println("player 1 ha reflejado!");
                        }
                        // Mitigar daño enemigo.
                        defense1 = defense1 * 1000;
                        break;

                    case 3:
                        if (player1 == "Pladin") {
                            heal1 = (maxhealth1 % 5);
                            healthpoints1 = healthpoints1 + heal1;
                        } else {
                            heal1 = (maxhealth1 % 10);
                            healthpoints1 = healthpoints1 + heal1;
                        }

                        if (healthpoints1 > maxhealth1) {
                            healthpoints1 = maxhealth1;
                        }
                        break;
                }
            }
            else if (speed2 > speed1) ;
            {
                switch (action1) {
                    case 1:
                        hit2 = (int) (damage2 * (1 - 0.5 * defense1 / 200));
                        if (hit2 < 0) {
                            healthpoints1 = healthpoints1 - hit2;
                        }
                        hit2 = (int) (damage2 * (1 - 0.5 * defense1 / 200));
                        //Entre 200 porque es el máximo de armadura que podemos tener. Es una regla de tres.
                        //El 1 es una reduccicón.
                        healthpoints1 = healthpoints1 - hit2;
                        //El random necesario de la práctica.
                        if (player2 == "Asesino") {
                            int randomInt = random.nextInt(1);
                            int randomIntBoost = random.nextInt(3);
                            if ((speed2 > 100 || speed2 < 150) && randomInt == 1) {
                                hit2 = (int) (hit2 * 1.75);
                                healthpoints1 = healthpoints1 - hit2;
                                System.out.println("Golpe crítico!");

                            } else if (speed1 > 175 && randomIntBoost > 0) {
                                hit1 = (int) (hit1 * 1.75);
                                healthpoints2 = healthpoints2 - hit1;
                                System.out.println("Golpe crítico!");
                            }
                        }
                        break;
                    case 2:
                        //Aquí no relleno porque el bloqueo se desarrola antes porque tiene prioridad.
                        break;

                    case 3:
                        if (player2 == "Pladin") {
                            heal2 = (maxhealth2 % 5);
                            healthpoints2 = healthpoints2 + heal2;
                        } else {
                            heal2 = (maxhealth2 % 10);
                            healthpoints2 = healthpoints2 + heal2;
                        }

                        if (healthpoints2 > maxhealth2) {
                            healthpoints2 = maxhealth2;
                        }
                        break;
                }
            }
            System.out.println("Player1: "+ healthpoints1);
            System.out.println("Player2: "+ healthpoints2);
            turn++;
        }
        if (healthpoints1<=0 || healthpoints2<=0){
            System.out.println("Se acabó el combate!");
        }
        else if (healthpoints1>healthpoints2) {
            System.out.println("Ha ganado player1!");
        }
        else {
            System.out.println("Ha ganado player2!");
        }
    }
}

