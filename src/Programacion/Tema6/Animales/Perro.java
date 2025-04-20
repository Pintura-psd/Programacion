package Programacion.Tema6.Animales;

public class Perro  extends Animal{


    @Override
    public void comer() {
        System.out.println("El perro come pienso. No le gusta");

    }

    @Override
    public void dormir() {
        System.out.println("*snork, snork*");
    }

    @Override
    public void hacerRuido() {
        System.out.println("Bark, bark");
    }

     public void pedir() {
        System.out.println("No le das nada? Mira que carita pone.");
    }

    public void alerta (){
        System.out.println("Levata las orejas, parece que ha escuchado algo.");
    }
}
