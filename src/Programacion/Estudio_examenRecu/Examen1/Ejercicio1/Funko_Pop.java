package Programacion.Estudio_examenRecu.Examen1.Ejercicio1;

import java.io.Serializable;
import java.time.LocalDate;

public class Funko_Pop extends Figura implements Serializable {

    private boolean edicionLimitada;
    private int actualYear = LocalDate.now().getYear();

    public Funko_Pop(String nombre, int releaseYear, double precioBase, boolean precintada, boolean embalajeOG, boolean edicionLimitada, int actualYear) {
        super(nombre, releaseYear, precioBase, precintada, embalajeOG);
        this.edicionLimitada = edicionLimitada;
        this.actualYear = actualYear;
    }

    public boolean isEdicionLimitada() {
        return edicionLimitada;
    }

    public void setEdicionLimitada(boolean edicionLimitada) {
        this.edicionLimitada = edicionLimitada;
    }

    @Override
    public String toString() {
        return "Nombre: "+ this.getNombre() + " Año de lanzamiento: "+ getReleaseYear() +" Edicion limitada: "+ isEdicionLimitada() +" Precintada: "+ isPrecintada() +" Embalaje original: "+ isEmbalajeOG() +" Precio Base: "+ getPrecioBase()+ " Precio Final: "+ calcularPrecio();
    }

    @Override
    public double calcularPrecio() {
        Double precioReal = 0.0;

        precioReal = getPrecioBase() + ((actualYear - getReleaseYear())*10);
        return 0;
    }
}
