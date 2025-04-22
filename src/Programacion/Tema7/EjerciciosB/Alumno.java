package Programacion.Tema7.EjerciciosB;

public class Alumno {
    private String nombre;
    private String apellido;
    private int average;

    public Alumno(String nombre, String apellido, int average) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.average = average;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", average=" + average +
                 "\n"
                +'}';
    }
}
