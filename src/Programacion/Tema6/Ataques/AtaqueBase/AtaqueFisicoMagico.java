package Programacion.Tema6.Ataques.AtaqueBase;

public class AtaqueFisicoMagico implements IAtaque {
    int PhysicalDamage;
    int MagicalDamage;
    int cost;

    public AtaqueFisicoMagico(int PhysicalDamage, int MagicalDamage, int cost) {
        this.PhysicalDamage = PhysicalDamage;
        this.MagicalDamage = MagicalDamage;
        this.cost = cost;
    }

    @Override
    public void lanzar() {

    }

    @Override
    public int coste() {
        return cost;
    }

    @Override
    public int daño() {
        return PhysicalDamage + MagicalDamage;
    }
}
