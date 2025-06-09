package Programacion.Estudio_examenRecu.VidejuegosRecu;

import java.io.Serializable;

public abstract class VJ implements Serializable, Jugable{
    private String nombre;
    private String plataforma;
    private int nota;

    public VJ(String nombre, String plataforma, int nota) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.nota = nota;
    }

    public VJ() {
        this.nombre = "";
        this.plataforma = "";
        this.nota = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    //Metodo abstracto
    public abstract String getTipo();
}
