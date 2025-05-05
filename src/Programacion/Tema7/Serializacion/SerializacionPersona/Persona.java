package Programacion.Tema7.Serializacion.SerializacionPersona;

import java.io.Serializable;

public class Persona implements Serializable {
    // No sé qué es exactamente esta línea de código, pero si no la escribo se me modifican los objetos.
    // IMPORTANTE:  Poner bien los this. Si no, va a dar problemas a leer objetos.
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString (){
        return this.nombre + "," + this.edad;
    }
}
