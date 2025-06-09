package Programacion.Estudio_examenRecu.Examen2;

import java.util.ArrayList;

public class Figura_accion extends Figura{

    private ArrayList <Accesorio> listaAccesorios;

    public Figura_accion(String nombre, int anyo, boolean edicion_esp, double precio, Embalaje embalaje, ArrayList<Accesorio> listaAccesorios) {
        super(nombre, anyo, precio, embalaje);
        this.listaAccesorios = listaAccesorios;
    }

    public Figura_accion(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    public ArrayList<Accesorio> getListaAccesorios() {
        return listaAccesorios;
    }

    public void setListaAccesorios(ArrayList<Accesorio> listaAccesorios) {
        this.listaAccesorios = listaAccesorios;
    }

    @Override
    public String toString(){
        return  "Nombre: "+ getNombre() + " Año lanzamiento"+ getAnyo() +"Estado embalaje: "+ getEmbalaje() + " Lista accesorios: "+ this.listaAccesorios;
    }

    @Override
    public void precioReal(){
        double precioReal;
        if (getEmbalaje().equals("PRECINTADO")){
            precioReal = getPrecio() * 2;
        }else if (getEmbalaje().equals("EMBALAJE_OG")){
            precioReal = getPrecio();
        } else {
            precioReal = getPrecio()/2;
        }
    }
}
