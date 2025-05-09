package Programacion.Tema7.RankingVidejuegos;

import java.io.Serializable;

public abstract class Videojuego implements Serializable {
    private String titulo;
    private String plataforma;
    private int nota;

    //Constructor
    public Videojuego(String titulo, String plataforma, int nota) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.nota = nota;
    }

    //Constructor vacío
    public Videojuego(){
        this.titulo = "";
        this.plataforma = "";
        this.nota = 0;
    }

    //Gueters & setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    //Metodo
    public abstract String getTipo();

    //toString
    @Override
    public String toString(){
        return "Titulo: " + this.titulo + "\n" + "Plataforma: " + this.plataforma + "\n" + "Nota: " + this.nota;
    }

}
