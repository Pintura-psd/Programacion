package Programacion.Tema4;

import java.util.Scanner;

public class OrdasMain {
    public static void main(String[] args) {;
        Scanner scanner = new Scanner(System.in);

        // Creamos al héroe
        Hero hero = new Hero("Jugador", 15, 0, 10, 15);
        int hordasSobrevividas = 0;

        // Bucle del juego
        while (hero.getCurrentHealth() > 0) {
            System.out.println("\n🛡️ Horda " + (hordasSobrevividas + 1) + " entrante...");

            Goblin[] goblins = Peleita.goblinsGeneration(hero);
            for (Goblin goblin : goblins) {
                if (goblin != null) System.out.println("👹 Aparece " + goblin);
            }

            // Lucha contra los Goblins
            boolean sobrevivio = Peleita.fight(hero, goblins);
            if (!sobrevivio) break;

            hordasSobrevividas++;

            // 10% de probabilidad de encontrar una poción
            if (Math.random() < 0.1) {
                System.out.println("\n🍷 Has encontrado una poción y recuperas vida!");
                hero.drinkPotion();
            }

            // 0.1% de probabilidad de descansar
            if (Math.random() < 0.001) {
                System.out.println("\n💤 Has encontrado un lugar seguro y descansas.");
                hero.restingMethod();
            }

            System.out.println("\n⚡ Fin del turno. Vida actual: " + hero.getCurrentHealth());
            System.out.print("Presiona ENTER para continuar...");
            scanner.nextLine();
        }
        System.out.println("\n💀 Has muerto después de sobrevivir a " + hordasSobrevividas + " hordas.");
    }
}
