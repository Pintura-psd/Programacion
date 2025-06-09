package Programacion.Estudio_examenRecu.VidejuegosRecu;

import java.util.ArrayList;

public class VJ_Fisico extends VJ{
    private String tiendaCompra;
    private EstadoVJ estado;

    //Constructor heredado
    public VJ_Fisico(String nombre, String plataforma, int nota, String tiendaCompra, EstadoVJ estado) {
        super(nombre, plataforma, nota);
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

    //Constructor
    public VJ_Fisico(String tiendaCompra, EstadoVJ estado) {
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

    //Constructo vacío
    public VJ_Fisico() {
        this.tiendaCompra = "";
        this.estado = null;
    }

    //Getters and setters


    public String getTiendaCompra() {
        return tiendaCompra;
    }

    public void setTiendaCompra(String tiendaCompra) {
        this.tiendaCompra = tiendaCompra;
    }

    public EstadoVJ getEstado() {
        return estado;
    }

    public void setEstado(EstadoVJ estado) {
        this.estado = estado;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }

    @Override
    public String toString (){
        return "Nombre: "+ this.getNombre() +"\n"+"Plataforma: "+ this.getPlataforma()+"\n"+"Nota: "+ this.getNota()+"\n"+"Estado: "+  this.getEstado()+"\n"+"Tienda: "+this.getTiendaCompra();
    }


    @Override
    public void JugarDemo() {
        if (this.estado.equals("NUEVO")){
            System.out.println("Este juego tiene demo disponible.");
        }
        else {
            System.out.println("Este juego no tiene demo disonible.");
        }
    }
}
