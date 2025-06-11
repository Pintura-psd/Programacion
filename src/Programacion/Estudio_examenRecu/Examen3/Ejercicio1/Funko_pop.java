package Programacion.Estudio_examenRecu.Examen3.Ejercicio1;

import java.time.LocalDate;

public class Funko_pop extends  Figura{
    private boolean ed_limitada;

    public Funko_pop(String nombre, int year, double precio, Embalaje estado, boolean ed_limitada) {
        super(nombre, year, precio, estado);
        this.ed_limitada = ed_limitada;
    }

    public Funko_pop(boolean ed_limitada) {
        this.ed_limitada = ed_limitada;
    }

    public Funko_pop() {
        this.ed_limitada = false;
    }

    public boolean isEd_limitada() {
        return ed_limitada;
    }

    public void setEd_limitada(boolean ed_limitada) {
        this.ed_limitada = ed_limitada;
    }

    @Override
    public String toString(){
        return "Nombre: "+ getNombre() +" Año lanzamiento"+ getYear() + " Edición limitada: "+ this.ed_limitada + " Precio base: "+ getPrecio() + " Estado caja: " + getEstado();
    }

    @Override
    public void precioReal(){
        double precioReal = 0.0;
        LocalDate actualDate = null;

        precioReal = getPrecio() +((actualDate.getYear()-getYear())* 10);
    }
}
