package Programacion.Tema4;

public class Goblin {
    private boolean alive;
    private String name = "goblin";
    private int level;
    private int attack;
    private int defense;
    private int maxHealth;
    private int currentHealth;
    private int exp;

    //constantes
    private static final int levelMax = 120;


    public Goblin (String name, int level, int attack, int defense, int maxHealth){


        //atributos
        this.name = name;
        this.maxHealth = level * 10;
        this.currentHealth = maxHealth;
        //No quiero que suban de nivel durante el combate.
        this.exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.alive = true;
    }

        //constructor vacío
    public Goblin(){
        this.name = "";
        this.level = 1;
        this.maxHealth = 1;
        this.currentHealth = this.maxHealth;
        this.exp = 0;
        this.attack = 0;
        this.defense = 0;
    }
    //constructor con parámetros
    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = currentHealth;
        }
    }

    public void damage(Hero hero) {
        int damage = this.attack - hero.getDefense();
        if (damage <= 0) {
            damage = 1;
        }
        hero.setCurrentHealth(hero.getCurrentHealth() - damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
       if(this.level < 0){
           this.level = 1;
       }
       else {
           this.level = level;
       }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return String.format("Goblin {name='%s', level=%d, maxHealth=%d, exp=%d, attack=%d, defense=%d}",
                this.name, this.level, this.maxHealth, this.exp, this.attack, this.defense);
    }
}
