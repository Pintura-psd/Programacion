package Tema5;

public class Abonado {

    private String dni;
    private String name;
    private int age;

    //Constructor con parámetros
    public Abonado(String dni, String name, int age) {
        this.name = name;
        this.age = age;

        this.dni = dni;
        if (checkDNI()== true ){
            this.dni = dni;
        }
        else {
            System.out.println("Los valores de "+ this.name + " no válidos se establecerá cómo vacío.");
            this.dni="";
        }
    }

    //Constructor vacío
    public Abonado() {
        this.dni = "";
        this.name = "";
        this.age = 0;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (checkDNI()== true ){
            this.dni = dni;
        }
        else {
            System.out.println("Los valores de "+ this.name + " no válidos se establecerá cómo vacío.");
            this.dni="";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean checkDNI() {
        String letterMayus = " ";

        if (this.dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false) {
            return false;
        }

        letterMayus = (this.dni.substring(8)).toUpperCase();

        if (soloNumeros() && letraDNI().equals(letterMayus)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean soloNumeros() {

        int i, j = 0;
        String num = " ";
        String miDNI = " ";
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (i = 0; i < this.dni.length() - 1; i++) {
            num = this.dni.substring(i, i + 1);

            for (j = 0; j < unoNueve.length; j++) {
                if (num.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }
        if (miDNI.length() == 9) {
            return true;
        } else {
            return false;
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

    @Override
    public String toString() {
        return String.format(this.name+ " " + this.age + " " + this.dni);
        //return " " + this.nombre + ", ";
    }
}
