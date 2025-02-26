package Programacion.Tema4;

import java.util.Random;
//Para que copile tengo que ajustar la clase hero.
    public class Peleita {
      public static  final Random random = new Random();

      public static Goblin[] goblinsGeneration(Hero hero){
              int numbOfGoblins = random.nextInt(3)+1;
              Goblin[] goblins = new Goblin[3];

          for (int i = 0; i < numbOfGoblins; i++) {
              int goblinLevel = hero.getLevel()/2;
              int goblinAttack = hero.getDefense()/3;
              int goblinDefense = hero.getAttack()/3;
              int goblinHealth = (hero.getLevel()/2) * 3;


              goblins[i] = new Goblin("Goblin " + (i + 1), goblinLevel, goblinAttack, goblinDefense, goblinHealth);
          }
          return goblins;
      }

      public static boolean fight (Hero hero, Goblin[] goblins){
          System.out.println("Los goblins se acercan!");
          System.out.println(" ");


          while (hero.getCurrentHealth() > 0 && hero.getLevel() < 100){
              boolean goblinsAlive = false;
              //no entiendo exactamente los :
              for (Goblin goblin : goblins) {
                  if (goblin != null && goblin.getCurrentHealth() > 0) {
                      goblinsAlive = true;

                      //hero.damage(goblin);
                      System.out.println(hero.getName() + " ha atacado a " + goblin.getName());

                      if (goblin.getCurrentHealth() > 0) {
                          goblin.damage(hero);
                          //huida de goblins
                          if (goblin != null && random.nextDouble() < 0.1) {
                              System.out.println("El goblin ha huido!");
                              goblin.setCurrentHealth(0);
                              continue;
                          }

                          //goblins ataque
                          System.out.println(goblin.getName() + " ataca a " + hero.getName());
                          goblin.damage(hero);
                      } else {
                          System.out.println(goblin.getName() + " ha muerto");
                      }
                  }
              }

              if (!goblinsAlive){
                  return false;
              }
          }
        return false;
      }

    }
