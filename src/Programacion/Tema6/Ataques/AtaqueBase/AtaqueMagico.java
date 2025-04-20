package Programacion.Tema6.Ataques.AtaqueBase;

public class AtaqueMagico implements IAtaque {
    private int damage;
    private int cost;

    public AtaqueMagico(int damage, int cost) {
        this.damage = damage;
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
        return damage;
    }

}
