package Programacion.Tema4;

public class PersonaMain {
    public static void main (String [] args){

        Persona person1 = new Persona("12345678Q","Antonio","Garcia",58);
        Persona person2 = new Persona("12345678H","MariCarmen","Marsahll",36);

        //Debería monstrar error.
        System.out.println(person2);

    }

}
