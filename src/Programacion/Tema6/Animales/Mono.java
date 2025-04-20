package Programacion.Tema6.Animales;

public class Mono extends Animal{

    @Override
    public void comer() {
        System.out.println("Se come un platanito");
    }

    @Override
    public void dormir() {
        System.out.println("Chill en su ramita,zzz");

    }

    @Override
    public void hacerRuido() {
        System.out.println("Sonido de heterbasico promedio.");

    }

    public void lanzarCaca() {
        System.out.println("Te lanza excrementos. Al final es un mono que esperabas");
    }
}
