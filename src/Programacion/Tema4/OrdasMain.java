package Programacion.Tema4;

import java.util.Scanner;

public class OrdasMain {
    public static void main(String[] args) {;
        Scanner scanner = new Scanner(System.in);

        // Creamos al héroe
        Hero hero = new Hero("Jugador", 15, 0, 25, 15);
        int hordasSobrevividas = 0;
        int hordaActual = hordasSobrevividas + 1;
        int turno = 0;

        // Bucle del juego
        while (hero.getCurrentHealth() > 0) {
            int numGoblins=0;
            System.out.println("️ Horda " + (hordasSobrevividas + 1) + " entrante...");
            Goblin[] goblins = Peleita.goblinsGeneration(hero);

            for (Goblin goblin : goblins ) {
                if (goblin != null) {

                    while (goblin != null && goblin.getCurrentHealth() > 0) {
                        // Lucha contra los Goblins
                        System.out.println( hordaActual );
                        Peleita.fight(hero, goblins);

                        hordasSobrevividas++;

                        // 10% de probabilidad de encontrar una poción
                        if (Math.random() < 0.1) {
                            System.out.println("Has encontrado una poción y recuperas vida!");
                            hero.drinkPotion();
                        }

                        // 0.1% de probabilidad de descansar
                        if (Math.random() < 0.001) {
                            System.out.println("Has encontrado un lugar seguro y descansas.");
                            hero.restingMethod();
                        }
                    }
                }
            }
                turno = 0;
                System.out.println("Fin de la primera orda. Vida actual: " + hero.getCurrentHealth());
                System.out.print("Presiona ENTER para continuar...");
                scanner.nextLine();

        }
        System.out.println("Has muerto después de sobrevivir a " + hordasSobrevividas + " hordas.");
    }
}
