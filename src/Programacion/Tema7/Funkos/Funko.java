package Programacion.Tema7.Funkos;

import java.io.Serializable;

//Datos: COD,NOMBRE,MODELO,PRECIO,FECHA_LANZAMIENTO
public class Funko implements Serializable {
    private String codigo;
    private String nombre;
    private String modelo;
    private double precio;
    private String fecha;

    public Funko(String codigo, String nombre, String modelo, double precio, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return "Codigo: " + this.codigo + " Nombre: " + this.nombre + " Modelo: " + this.modelo + " Precio: " + this.precio + " Fecha: " + this.fecha;
    }
}
