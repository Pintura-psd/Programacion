package Programacion.Tema6.Animales;

public class Mantis extends Animal{

    @Override
    public void comer() {
        System.out.println("Se come la cabeza de su pareja");
    }

    @Override
    public void dormir() {
        System.out.println("Ta mu' quieta y se duerme");

    }

    @Override
    public void hacerRuido() {
        System.out.println("No suena, no se que esperabas de una mantis.");
    }

    public void camuflaje() {
        System.out.println("Se queda muy quieta y no la distingues de las hojas.");
    }
}
