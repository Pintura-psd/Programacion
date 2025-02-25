package Programacion.Tema4;

public class Goblin {
    private String name = "goblin";
    private int level;
    private int attack;
    private int defense;
    private int maxHealth;
    private int currentHealth;
    private int exp;

    //constantes
    private static final int levelMax = 100;
    private static final int healthPotion = 10;
    private static final int resting = 50;
    private static final int lowestHealth = 0;
    private static final int expByAtack = 10;
    private static final int levelUpExp = 50;

    public Goblin (String name, int level, int attack, int defense, int maxHealth, int currentHealth, int exp){
        if (this.level > 100){
            this.level = 100;
        }
        else {this.level = level;
        }

        //atributos
        this.maxHealth = level * 10;
        this.currentHealth = maxHealth;
        this.exp = exp;
        this.attack = attack;
        this.defense = defense;
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

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = currentHealth;
        }
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
        this.level = level;
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

    public void getCurrentHealth() {
        if (currentHealth < 0) {
            this.currentHealth = 0;
        } else if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        } else {
            this.currentHealth = currentHealth;
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return String.format("Hero{name='%s', level=%d, maxHealth=%d, exp=%d, attack=%d, defense=%d}",
                this.name, this.level, this.maxHealth, this.exp, this.attack, this.defense);
    }
}
