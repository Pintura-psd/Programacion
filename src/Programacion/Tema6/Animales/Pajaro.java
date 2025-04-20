package Programacion.Tema6.Animales;

public class Pajaro extends Animal{

    @Override
    public void comer() {
        System.out.println("Come un poquito de alpiste");
    }

    @Override
    public void dormir() {
        System.out.println("Ahueca las plumas y se duerme.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("Pio, pio");
    }

    public void volar () {
        System.out.println("Bate las alas y se va por los cielos.");
    }
}
