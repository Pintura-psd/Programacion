package Programacion.Tema4;

import java.util.Random;

public class Peleita {
  public static  final Random random = new Random();

  public static Goblin[] goblinsGeneration(Hero hero){
          int numbOfGoblins = random.nextInt(3)+1;
          Goblin[] goblins = new Goblin[3];

      for (int i = 0; i < numbOfGoblins; i++) {
          //Que aquí están muy fuertes los goblins
          /*int goblinLevel = Math.max(1, hero.getLevel() - random.nextInt(2));
          int goblinAttack = Math.max(1, hero.getAttack() - random.nextInt(4));
          int goblinDefense = Math.max(0, hero.getAttack() - random.nextInt(4));
          int goblinHealth = Math.max(10, goblinLevel * 6);*/
          int goblinLevel = Math.max(1, hero.getLevel() - 5);
          int goblinAttack = Math.max(1, hero.getAttack() / 2);
          int goblinDefense = Math.max(0, hero.getDefense() / 2);
          int goblinHealth = Math.max(10, hero.getMaxHealth() / 3);


          goblins[i] = new Goblin("Goblin " + (i + 1), goblinLevel, goblinAttack, goblinDefense, goblinHealth);
      }
      return goblins;
  }

  public static boolean fight (Hero hero, Goblin[] goblins){
      System.out.println("Comienzan a venir ordas!");
      boolean goblinsAlive = false;

      while (hero.getCurrentHealth() > 0 && hero.getLevel() < 100 && goblinsAlive){

          //no entiendo exactamente los :
          for (Goblin goblin : goblins){
              if (goblin != null && goblin.getCurrentHealth() > 0) {
                  goblinsAlive = true;
              }
                //10% de que huyan
              else if (goblin != null && random.nextDouble() < 0.1){
                  System.out.println("El goblin ha huido!");
                  goblin.setCurrentHealth(0);
                  continue;
              }
              hero.damage(goblin);
              System.out.println(hero.getName() + "Ha atacado a "+ goblin.getName());

              if (goblin.getCurrentHealth() > 0){
                  goblin.damage(hero);
              }
          }
          if (!goblinsAlive){
              return true;
          }
      }
    return false;
  }

}
