package Programacion.Estudio_examenRecu.Examen2;

import java.io.Serializable;
import java.time.LocalDate;

public class Funko_pop extends Figura implements Serializable {
    private Boolean edicion_esp;

    public Funko_pop(String nombre, int anyo, double precio, Embalaje embalaje, Boolean edicion_esp) {
        super(nombre, anyo, precio, embalaje);
        this.edicion_esp = edicion_esp;
    }

    public Funko_pop(Boolean edicion_esp) {
        this.edicion_esp = edicion_esp;
    }

    public Funko_pop() {
        this.edicion_esp = false;
    }

    @Override
    public String toString(){
        return "Nombre: "+ getNombre() + " año lanzamiento"+ getAnyo() + "Edicion especial: "+ this.edicion_esp +"Estado embalaje: "+ getEmbalaje();
    }

    @Override
    public void precioReal(){
        Double precioReal = 0.0;
        LocalDate actualyear = null;
        precioReal = getPrecio() +((actualyear.getYear()-getAnyo())* 10);
    }
}
