package Programacion.Tema4;

public class Persona {
    //Atributos de persona
    private String dni ;
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
            System.out.println("El DNI no es válido");
        } else if (!Character.isDigit(character)) {
            System.out.println("El DNI no es válido.");
        }
    }

    public void ageDifference (int age ){
        System.out.println("Introduce el la edad de ");

    }



}
