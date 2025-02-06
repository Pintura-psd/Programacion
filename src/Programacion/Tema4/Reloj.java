package Programacion.Tema4;

import java.util.Scanner;

public class Reloj {
    //Atributos
    private int hora ;
    private int minuto ;
    private int segundos ;
    //Si es de 24h o 12h
    private boolean its24h ;

    public Reloj (int hora, int minuto, int segundos){
        this.hora = hora;
        this.minuto = minuto;
        this.segundos = segundos;
        this.its24h = true;
        if(hora > 23 || minuto > 59 || segundos >59){
            System.out.println("Hora inválida");
        }
    }
    public Reloj() {
        this.hora = 0;
        this.minuto = 0;
        this.segundos = 0;

    }

    public int getHora() {
        return hora;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
        if(segundos > 59 ){
            System.out.println("Hora inválida");
        }
    }

    public boolean isIts24h() {
        return its24h;
    }

    public void setIts24h(boolean its24h) {
        this.its24h = its24h;
    }

    public void setHora(int hora) {
        this.hora = hora;
        if(hora > 23 ){
            System.out.println("Hora inválida");
        }
    }

    public int getMinuto (){
        return minuto;
    }

    public void setMinuto (int minuto){
        this.minuto = minuto;
        if( minuto > 59 ){
            System.out.println("Hora inválida");
        }
        }
    }




