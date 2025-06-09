package Programacion.Estudio_examenRecu.VidejuegosRecu;

import java.util.ArrayList;

public class VJDigital extends VJ {

    private String tiendaOnline;
    private Double pesoGB;

    //Constructor heredado
    public VJDigital(String nombre, String plataforma, int nota) {
        super(nombre, plataforma, nota);
    }

    //Consturctor
    public VJDigital(String nombre, String plataforma, int nota, String tiendaOnline, Double pesoGB) {
        super(nombre, plataforma, nota);
        this.tiendaOnline = tiendaOnline;
        this.pesoGB = pesoGB;
    }

    //Constructor vacio
    public VJDigital() {
        super();
        this.tiendaOnline = null;
        this.pesoGB = 0.0;
    }

    public String getTiendaOnline() {
        return tiendaOnline;
    }

    public void setTiendaOnline(String tiendaOnline) {
        this.tiendaOnline = tiendaOnline;
    }

    public Double getPesoGB() {
        return pesoGB;
    }

    public void setPesoGB(Double pesoGB) {
        this.pesoGB = pesoGB;
    }



    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String toString(){
        return "Nombre: "+ this.getNombre() +"\n"+"Plataforma: "+ this.getPlataforma()+"\n"+"Nota: "+ this.getNota()+"\n"+"Peso: "+ this.getPesoGB()+"\n"+"TiendaOnline: "+this.getTiendaOnline()+"\n"+"Peso GB: "+getPesoGB();
    }


    @Override
    public void JugarDemo() {
        System.out.println("Este juego tiene demo disponible en la tienda Online.");
    }
}
