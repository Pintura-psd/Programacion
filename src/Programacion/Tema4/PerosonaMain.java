package Programacion.Tema4;

public class PerosonaMain {
    public static void main (String [] args){

        Persona fer = new Persona("72905464H","Fernando","Rodriguez",25);
        Persona aida = new Persona("53787229G","Aida","Leon",29);
        Persona error = new Persona("123h","error","204",300);

        System.out.println("Persona1: ");
        System.out.println(" ");
        System.out.println(fer);
        System.out.println(fer.itsAdult());
        System.out.println(fer.itsRetired());
        System.out.println(fer.checkDNI());
        System.out.println("");

        System.out.println("Persona2: ");
        System.out.println(" ");
        System.out.println(aida);
        System.out.println(aida.ageDifference(fer));
        System.out.println(aida.checkDNI());
        System.out.println("");

        System.out.println("Persona3: comprobando errores");
        System.out.println(error);
        System.out.println(error.ageDifference(fer));
        System.out.println(error.checkDNI());
    }
}
