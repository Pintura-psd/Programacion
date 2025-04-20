package Programacion.Tema6.Ataques.AtaqueAvanzado;

public class Espadazo implements IAtaqueavanzado {
    private int physicalDamage ;
    final int magicalDamage = 0 ;
    private int stamina;
    final int mana = 0;


    public Espadazo(int physicalDamage, int stamina) {
        this.physicalDamage = physicalDamage;
        this.stamina = stamina;
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
        System.out.println("Se ha realizado una estocada.");
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
