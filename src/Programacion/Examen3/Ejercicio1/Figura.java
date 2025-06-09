package Programacion.Examen3.Ejercicio1;

import java.io.Serializable;

public abstract class Figura implements Serializable {

    private String nombre;
    private  int year;
    private double precio;
    private Embalaje estado;

    public Figura(String nombre, int year, double precio, Embalaje estado) {
        this.nombre = nombre;
        this.year = year;
        this.precio = precio;
        this.estado = estado;
    }

    public Figura() {
        this.nombre = "";
        this.year = 0;
        this.precio = 0.0;
        this.estado = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Embalaje getEstado() {
        return estado;
    }

    public void setEstado(Embalaje estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return "Nombre: "+ this.nombre +"Año lanzamiento"+ this.year + "Precio base: "+ this.precio + "Estado caja" + this.estado;
    }

    public void precioReal(){}
}
