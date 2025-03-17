package Programacion.Tema4;

import java.util.Random;
import java.util.Scanner;

public class JuegoRol {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Hero heroe = new Hero("Arthas",1,0,10,10);
        Random random = new Random();
        int hordas = 1;

        while (heroe.getCurrentHealth() > 0 && hordas <= 10) {
            System.out.println("Es la horda: " + hordas);


            Hero[] enemies = new Hero[random.nextInt(1,4)];
            for (int i = 0; i < enemies.length; i++){
                enemies[i] = new Hero("Enemy" + (i + 1),1,0,5,5);
            }

            while (!muertos(enemies)) {
                for (Hero enemy : enemies) {
                    System.out.println(enemy);
                    //El valor de la huida. Decimos que es un valor aleatorio y este es menor a 0.90 ataca. Si no huye.
                    if (random.nextFloat() < 0.90) {
                        System.out.println(heroe.getName() + " ataca a el enemigo.");
                        heroe.damage(enemy);
                        if (enemy.getCurrentHealth() > 0) {
                            System.out.println(" El enemigo le devuelve el golpe!");
                            enemy.damage(heroe);
                        }
                    }
                    else {
                        System.out.println("El enemigo ha muerto.");
                    }

                    if (random.nextFloat() < 0.1) {
                        heroe.drinkPotion();
                        System.out.println(heroe.getName()+ " ha encontrado una poción.");
                        System.out.println(heroe.getName()+ " vida actual: "+ heroe.getCurrentHealth());
                    }

                    if (random.nextFloat() < 0.001){
                        System.out.println(heroe.getName() + " ha encontrado un rincón para una hogera y descansar.");
                        System.out.println(heroe.getName() + " vida actual: "+ heroe.getCurrentHealth());
                    }
                }
            }
            System.out.println(" ");
            System.out.println("Tdodos los enemigos han muerto.");

            hordas++;
        }

        if (hordas == 11) {
            System.out.println(" ");
            System.out.println("Se han superado todas las hordas.");
            System.out.println(heroe.getName() + " ha ganado");
        }
        else if (heroe.getCurrentHealth() < 0) {
            System.out.println( heroe.getName() + " ha muerto.");
        }
    }

    public static boolean muertos (Hero[] enemies){
        for (Hero hero : enemies ) {
            if (hero.getCurrentHealth() > 0) {
                return false;
            }
        }
        return true;
    }
}
