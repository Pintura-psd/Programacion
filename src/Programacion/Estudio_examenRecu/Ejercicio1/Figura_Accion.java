package Programacion.Estudio_examenRecu.Ejercicio1;

import java.util.ArrayList;

public class Figura_Accion extends Figura{
    public ArrayList<Accesorio> listaAccesorios = new ArrayList<>();

    public Figura_Accion(String nombre, int releaseYear, double precioBase, boolean precintada, boolean embalajeOG) {
        super(nombre, releaseYear, precioBase, precintada, embalajeOG);
    }

    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    @Override
    public double calcularPrecio() {
        double precioReal = 0.0;

        if (isPrecintada()){
            precioReal = getPrecioBase() * 2;

        } else if (!isPrecintada()){
            if (isEmbalajeOG()){
                precioReal = getPrecioBase();
            }
            else {
                precioReal = getPrecioBase() / 2;
            }
        }
        return precioReal;
    }


    @Override
    public String toString() {
        return "Nombre: "+ this.getNombre() + " Año de lanzamiento: "+ getReleaseYear() +" Precintada: "+ isPrecintada() +" Embalaje original: "+ isEmbalajeOG() +" Precio Base: "+ getPrecioBase()+ " Precio Final: "+ calcularPrecio() + " Accesorios: " + this.listaAccesorios;
    }
}
