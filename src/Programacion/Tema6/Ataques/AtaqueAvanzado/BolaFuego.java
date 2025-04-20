package Programacion.Tema6.Ataques.AtaqueAvanzado;

public class BolaFuego implements IAtaqueavanzado{
    final int physicalDamage = 0 ;
    private int magicalDamage ;
    final int stamina = 0;
    private int mana;


    public BolaFuego(int magicalDamage, int mana) {
        //Daño fisico final en 0
        this.magicalDamage = magicalDamage;
        this.mana = mana;
    }

    @Override
    public int physicalDamage() {
        return physicalDamage;
    }

    @Override
    public int magicalDamage() {
        return magicalDamage;
    }

    @Override
    public int stamina() {
        return stamina;
    }

    @Override
    public int mana() {
        return mana;
    }

    @Override
    public void lanzar() {
        System.out.println("Se ha canalizado una bola de fuego.");
    }

    @Override
    public int coste() {
        return stamina + mana;
    }

    @Override
    public int daño() {
        return physicalDamage + magicalDamage;
    }
}
