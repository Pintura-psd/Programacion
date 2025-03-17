package Programacion.Tema4;

public class RelojMain {
    public static void main (String [] args){

        Reloj clock1 = new Reloj(23,59,59, true);
        Reloj clock2 = new Reloj(13,45,30, false);
        Reloj clock3 = new Reloj();

        /*Debería mostrar error*/
        clock2.setHora(25);
        /*Debería funcionar bien*/
        clock2.setHora(10);
        clock2.setMinuto(30);
        clock2.setSegundos(15);
        clock2.setIts24h(false);

        System.out.println("Reloj 3: ");
        System.out.println(clock3);
        System.out.println(" ");
        System.out.println("Reloj 1: ");
        System.out.println(clock1);
        System.out.println(" ");
        System.out.println("Reloj 2: ");
        System.out.println(clock2);
    }
}
