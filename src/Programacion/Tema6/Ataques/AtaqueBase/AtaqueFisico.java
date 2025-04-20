package Programacion.Tema6.Ataques.AtaqueBase;

public class AtaqueFisico implements IAtaque {
    private int damge;
    private int cost;

    public AtaqueFisico(int damge, int cost) {
        this.damge = damge;
        this.cost = cost;
    }

    @Override
    public void lanzar() {
        System.out.println("Se ha realizado un ataque físico.");

    }

    @Override
    public int coste() {
        return cost;
    }

    @Override
    public int daño() {
        return damge;
    }
}
