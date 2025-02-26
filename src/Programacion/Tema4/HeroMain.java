package Programacion.Tema4;

import java.util.Scanner;

public class HeroMain {
    //Para que no haya errores tengo que cambiar el método del daño. Está ahora mismo puesto para la pelea de ordas.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //heroes
        Hero manuel = new Hero("Manuel",1,0,10,10);
        Hero javier = new Hero("Javier", 1,0,10,10);

        System.out.println(manuel);
        System.out.println(javier);

        while (manuel.getCurrentHealth() != 5 && javier.getCurrentHealth() != 5){
           // manuel.damage(javier);
            System.out.println("Vida de Javier "+ javier.getCurrentHealth());
          //  javier.damage(manuel);
            System.out.println("Vida de Manuel "+ manuel.getCurrentHealth());
        }

        if (manuel.getCurrentHealth() == 5 && manuel.getCurrentHealth() != 0){
            manuel.drinkPotion();
            System.out.println("Vida de Manuel después de la poción: "+ manuel.getCurrentHealth());
        }

        if (javier.getCurrentHealth() == 5 && javier.getCurrentHealth() != 0)
            javier.restingMethod();
        System.out.println("Vida de Javier después de un descansinto: "+ javier.getCurrentHealth());

        while (manuel.getCurrentHealth() != 0 && javier.getCurrentHealth() != 0){
          //  manuel.damage(javier);
            System.out.println("Vida de Javier "+ javier.getCurrentHealth());
          //  javier.damage(manuel);
            System.out.println("Vida de Manuel "+ manuel.getCurrentHealth());
        }

        System.out.println(manuel);
        System.out.println(javier);

        System.out.println("¡Se acabó el combate!");
    }
}