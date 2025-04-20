package Programacion.Tema6.Ataques.AtaqueAvanzado;

public class EspadazoRunico implements IAtaqueavanzado{

    private int mana;
    private int stamina;
    private int physicalDamage;
    private int magicalDamage;

    public EspadazoRunico(int mana, int stamina, int physicalDamage, int magicalDamage) {
        this.mana = mana;
        this.stamina = stamina;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
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
        System.out.println("Se ha asentado un golpe espadazo rúnico.");
    }

    @Override
    public int coste() {
        return mana + stamina;
    }

    @Override
    public int daño() {
        return magicalDamage + physicalDamage;
    }
}
