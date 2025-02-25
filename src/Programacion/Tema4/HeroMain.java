package Programacion.Tema4;

import java.util.Scanner;

public class HeroMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //heroes
        Hero manuel = new Hero("Manuel",1,0,10,10);
        Hero javier = new Hero("Javier", 1,0,10,10);

        System.out.println(manuel);
        System.out.println(javier);

        while (manuel.getCurrentHealth() != 0 || javier.getCurrentHealth() != 0){
            manuel.damage(javier);
            System.out.println("Vida de Javier "+ javier.getCurrentHealth());
            javier.damage(manuel);
            System.out.println("Vida de Manuel "+ manuel.getCurrentHealth());

            if (manuel.getMaxHealth() == manuel.getCurrentHealth()/2 && manuel.getCurrentHealth() != 0){
                manuel.drinkPotion();
                System.out.println("Vida de Manuel después de la poción: "+ manuel.getCurrentHealth());
            }
            else if (javier.getMaxHealth() == javier.getCurrentHealth()/2 && javier.getCurrentHealth() != 0)
                javier.restingMethod();
            System.out.println("Vida de Javier después de un descansinto: "+ javier.getCurrentHealth());
        }
    }
}