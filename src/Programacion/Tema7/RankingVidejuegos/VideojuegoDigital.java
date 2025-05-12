package Programacion.Tema7.RankingVidejuegos;

import java.util.ArrayList;

public class VideojuegoDigital extends Videojuego{
    private String tiendaOnline;
    private double gigabites;

    public VideojuegoDigital(String titulo, String plataforma, int nota, String tiendaOnline, double gigabites) {
        super(titulo, plataforma, nota);
        this.tiendaOnline = tiendaOnline;
        this.gigabites = gigabites;
    }

    public VideojuegoDigital(String tiendaOnline, double gigabites) {
        this.tiendaOnline = tiendaOnline;
        this.gigabites = gigabites;
    }

    public VideojuegoDigital() {
        this.tiendaOnline = "";
        this.gigabites = 0;
    }

    public String getTiendaOnline() {
        return tiendaOnline;
    }

    public void setTiendaOnline(String tiendaOnline) {
        this.tiendaOnline = tiendaOnline;
    }

    public double getGigabites() {
        return gigabites;
    }

    public void setGigabites(double gigabites) {
        this.gigabites = gigabites;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String toString(){
        return "Tienda Online: " + this.tiendaOnline + "\n" + "Gigabites: " + this.gigabites;
    }


}
