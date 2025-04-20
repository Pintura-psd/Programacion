package Programacion.Tema6.Ataques.AtaqueAvanzado;

public class AtaqueAvanzadoMain {

    public static void main(String[] args) {

        //La idea es que valores que no hacen los ataque nos se puedan modoficar y se mantengan en 0.
        BolaFuego fireBall = new BolaFuego(50,10);
        Espadazo swingSword = new Espadazo(30,5);
        EspadazoRunico RunicSwingSword = new EspadazoRunico(10,10,30,30);

        System.out.println(" ");

        System.out.println("Daño: " + fireBall.daño());
        System.out.println("Coste: "+ fireBall.coste());
        fireBall.lanzar();

        System.out.println(" ");

        System.out.println("Daño: " + swingSword.daño());
        System.out.println("Coste:" + swingSword.coste());
        swingSword.lanzar();

        System.out.println(" ");

        System.out.println("Daño: " + RunicSwingSword.magicalDamage());
        System.out.println("Coste: " + RunicSwingSword.coste());
        RunicSwingSword.lanzar();
    }
}