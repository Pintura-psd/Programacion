package Programacion.Estudio_examenRecu.Examen1.Ejercicio1;

public abstract class Figura {

        private String nombre;
        private int releaseYear;
        private double precioBase;
        private boolean precintada;
        private boolean embalajeOG;

    public Figura(String nombre, int releaseYear, double precioBase, boolean precintada, boolean embalajeOG) {
        this.nombre = nombre;
        this.releaseYear = releaseYear;
        this.precioBase = precioBase;
        this.precintada = precintada;
        this.embalajeOG = embalajeOG;
    }

    //Guetters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isPrecintada() {
        return precintada;
    }

    public void setPrecintada(boolean precintada) {
        this.precintada = precintada;
    }

    public boolean isEmbalajeOG() {
        return embalajeOG;
    }

    public void setEmbalajeOG(boolean embalajeOG) {
        this.embalajeOG = embalajeOG;
    }

    @Override
    public abstract String toString();

    //Funcion abstracta
    public abstract double calcularPrecio();
}


