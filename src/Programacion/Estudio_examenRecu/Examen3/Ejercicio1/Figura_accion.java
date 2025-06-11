package Programacion.Estudio_examenRecu.Examen3.Ejercicio1;

import java.util.ArrayList;

public class Figura_accion extends Figura{

    private ArrayList<Accesorio> listaAccesorios;

    public Figura_accion(String nombre, int year, double precio, Embalaje estado, ArrayList<Accesorio> listaAccesorios) {
        super(nombre, year, precio, estado);
        this.listaAccesorios = listaAccesorios;
    }

    public Figura_accion(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    public Figura_accion() {
        this.listaAccesorios = null;
    }

    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    @Override
    public String toString(){
       return " Nombre: "+ getNombre() +" Año lanzamiento"+ getYear() + " Precio base: "+ getPrecio() + " Estado caja: " + getEstado() + " Lista de accesorios: "+ this.listaAccesorios;
    }

    @Override
    public void precioReal(){
        double precioReal = 0.0;
        if (getEstado().equals("PRECINTADO")){
            precioReal = getPrecio() * 2;
        } else if (getEstado().equals("PACK_OG")) {
            precioReal = getPrecio();
        } else {
            precioReal = getPrecio()/2;
        }
    }
}
