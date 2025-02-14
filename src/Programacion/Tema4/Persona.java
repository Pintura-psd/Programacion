package Programacion.Tema4;

public class Persona {
    //Atributos de persona
    private final String dni ;
    private String nombre;
    private  String apellidos;
    private  int edad;

    //Constructor vacío.
    public Persona() {
        this.dni = " ";
        this.nombre = " ";
        this.apellidos = " ";
        this.edad = 0;
    }

    public Persona (String dni, String nombre,String apellidos, int edad){
        boolean itsAdult = false;
        boolean itsRetired = false;
        char[] dniArray = dni.toCharArray();

        if (this.edad > 18){
            itsAdult = true;
        }
        else {
            itsAdult = false;
        }

        if (this.edad > 65){
            itsRetired = true;
        }
        else {
            itsRetired = false;
        }

        char character;
        character = dniArray[9];

        if (dniArray.length > 9){
            System.out.println("El DNI no es válido.");
        } else if (!Character.isLetter(character)) {
            System.out.println("El DNI no es válido.");
        }

        this.dni = dniArray.toString();
    }

    public void ageDifference (int age1, int age2 ){
        if (age1<age2){
            System.out.println("La diferencia de edad es: "+ (age2-age1));
        }
        else {
            System.out.println("La diferencia de edad es: "+ (age1-age2));
        }
    }
}
