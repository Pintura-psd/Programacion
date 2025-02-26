package Programacion.Tema4;

public class Hero {

    //atributos
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int exp;
    private int attack;
    private int defense;

    //constantes
    private static final int levelMax = 100;
    private static final int healthPotion = 20;
    private static final int resting = 50;
    private static final int expByAtack = 10;
    private static final int levelUpExp = 50;

    //constructor parametrizado
    public Hero (String name, int level, int exp, int attack, int defense){

        if (this.level > levelMax){
            this.level = levelMax;
        }
        else {this.level = level;
        }

        this.name = name;
        this.maxHealth = level * 10;
        this.currentHealth = maxHealth;
        this.exp = exp;
        this.attack = attack;
        this.defense = defense;
    }

    //constructor vacío
    public Hero (){
        this.name = "";
        this.level = 1;
        this.maxHealth = 100;
        this.currentHealth = this.maxHealth;
        this.exp = 0;
        this.attack = 0;
        this.defense = 0;
    }

    //Getters and Setters
    public int getCurrentHealth() {
        return currentHealth;
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    //toString
    @Override
    public String toString() {
        return String.format("Hero{name='%s', level=%d, maxHealth=%d, exp=%d, attack=%d, defense=%d}",
                this.name, this.level, this.maxHealth, this.exp, this.attack, this.defense);
    }

    //beber poción
    public void drinkPotion (){
        setCurrentHealth(currentHealth + healthPotion);

        if(this.currentHealth > this.maxHealth){
           this.currentHealth = this.maxHealth;
        }
    }

    //Descanso
    public void restingMethod () {
        setCurrentHealth(currentHealth + resting);

        if(this.currentHealth > this.maxHealth){
            this.currentHealth = this.maxHealth;
        }
    }

    //ataque
    /*public void damage (Hero heroe2 ){
        int damage;
        damage = this.attack - heroe2.defense;
        if (damage <= 0){
            damage = 1;
        }
        heroe2.currentHealth = (heroe2.getCurrentHealth() - damage);
        this.exp += expByAtack;
        while (this.exp >= levelUpExp ) {
            levelUP();
        }
    }*/

    public void damage (Goblin goblin ){
        int damage;
        damage = this.attack - goblin.getDefense();
        if (damage <= 0){
            damage = 1;
        }
        goblin.setCurrentHealth((goblin.getCurrentHealth() - damage));
        this.exp += expByAtack;
        while (this.exp >= levelUpExp ) {
            levelUP();
        }
    }

    //subir nivel
    public void levelUP (){
        if (exp >= levelUpExp) {
            System.out.println(this.name + " Ha subido de nivel!");
            setLevel(level +1);
            setMaxHealth(getMaxHealth() + 5);
            setAttack(getAttack()+ 1);
            setDefense(getDefense()+ 1);
            setExp(0);
        }
    }

}
