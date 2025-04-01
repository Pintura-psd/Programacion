package Programacion.Tema5;

public class UsuarioBanco {

    private int edad;
    private String nombre;
    private String dni;

    public UsuarioBanco(int edad, String nombre, String dni) {
        this.edad = 0;
        this.nombre = "";
        this.dni = "";
    }

    @Override
    public String toString() {
        return String.format("Usuario: Nombre: "+ this.nombre + "DNI: "+ this.dni +"Edad"+ this.edad );
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
