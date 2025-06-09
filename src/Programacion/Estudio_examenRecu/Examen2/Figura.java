package Programacion.Estudio_examenRecu.Examen2;

public abstract class Figura {

    private String nombre;
    private int anyo;
    double precio;
    Embalaje embalaje;

    public Figura(String nombre, int anyo, double precio, Embalaje embalaje) {
        this.nombre = nombre;
        this.anyo = anyo;
        this.precio = precio;
        this.embalaje = embalaje;
    }

    public Figura() {
        this.nombre = "";
        this.anyo = 0;
        this.precio = 0.0;
        this.embalaje = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Embalaje getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(Embalaje embalaje) {
        this.embalaje = embalaje;
    }

    @Override
    public String toString(){
        return "Nombre: "+ this.nombre + " año lanzamiento"+ this.anyo +"Estado embalaje: "+ this.embalaje;
    }

    public void precioReal(){};
}
