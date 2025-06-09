package Programacion.Estudio_examenRecu.EjercicioFunkosTry1;

//COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO
public class Funko {

    private String cod;
    private String nombre;
    private String modelo;
    private double precio;
    private String fecha_lanzamiento;

    //Constructor

    public Funko(String cod, String nombre, String modelo, double precio, String fecha_lanzamiento) {
        this.cod = cod;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    //Constructor vacío
    public Funko() {
        this.cod = " ";
        this.nombre = " ";
        this.modelo = " ";
        this.precio = 0.0;
        this.fecha_lanzamiento = null;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    @Override
    public String toString (){

        return "Código: "+ this.cod +" Nombre: "+ this.nombre +" Modelo: "+ this.modelo +" Precio: "+ this.precio + " Fecha de lanzamiento: "+ this.fecha_lanzamiento;
    }
}
