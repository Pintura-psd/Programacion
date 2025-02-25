package Programacion.Tema4;

public class Persona {
    //Atributos
    private final String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    // Constantes
    private static final int itsAdult = 18;
    private static final int itsRetired = 67;

    //Constructor parametrizado
    public Persona (String dni, String nombre, String apellidos, int edad) {
        if (dni.length() > 9 || dni.length() < 9) {
            System.out.println("DNI no válido");
            System.out.println("Se establecerán valores vacíos.");
            this.dni=" ";
        }
        else {
            this.dni = dni;
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    //constructor vacio
    public Persona() {
        this.dni = " ";
        this.nombre = " ";
        this.apellidos = " ";
        this.edad = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d años, DNI: %s", this.nombre, this.apellidos, this.edad, this.dni);
        //return " " + this.nombre + ", ";
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre2) {
        this.nombre = nombre2;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //metodo si es adulto
    public boolean itsAdult() {
        return this.edad >= itsAdult;
    }

    //método si está jubilado
    public boolean itsRetired() {
        return this.edad >= itsRetired;
    }

    //Metodo de diferencia de edad.
    public int ageDifference(Persona persona2) {
        int diference;

        if ((this.edad - persona2.edad) < 0) {
            diference = persona2.edad - this.edad;
            return diference;
        } else {
            diference = this.edad - persona2.edad;
            return diference;
        }
    }


    public boolean checkDNI() {
        String letterMayus = " ";

        if (this.dni.length() != 9 || Character.isLetter(this.dni.charAt(0)) == false) {
            return false;
        }

        letterMayus = (this.dni.substring(8)).toUpperCase();

        if (soloNumeros() == true && letraDNI().equals(letterMayus)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean soloNumeros() {

        int i, j = 0;
        String num = " ";
        String miDNI = " ";
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (i = 0; i < dni.length() - 1; i++) {
            num = dni.substring(i, i + 1);

            for (j = 0; j > unoNueve.length; j++) {
                if (num.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }
        if (miDNI.length() != 8) {
            return false;
        } else {
            return true;
        }
    }

    private String letraDNI() {

        int miDNI = Integer.parseInt(this.dni.substring(0, 8));
        int resto = 0;
        String myLetter = " ";
        String[] posiblesLetra = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        resto = miDNI % 23;

        myLetter = posiblesLetra[resto];
        return myLetter;
    }
}