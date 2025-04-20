package Programacion.Tema6.Animales;

public class Pez extends Animal{

    @Override
    public void comer() {
        System.out.println("Sube a la superfice a comer");
    }

    @Override
    public void dormir() {
        System.out.println("No sé como duerme un pez.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("Glup, glup");
    }

    public void burbujas() {
        System.out.println("Waw, que de burbujas");
    }

    }

