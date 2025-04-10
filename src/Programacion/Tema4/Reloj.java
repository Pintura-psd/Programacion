package Programacion.Tema4;

import java.util.Scanner;

public class Reloj {
    //Atributos
    private int hora ;
    private int minuto ;
    private int segundos ;
    //Si es de 24h o 12h
    private boolean its24h ;

    public Reloj (int hora, int minuto, int segundos, boolean its24h){
        if (hora >= 0 && hora <= 23 && minuto >= 0 && minuto <= 59 && segundos >= 0 && segundos <= 59) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundos = segundos;
        } else {
            System.out.println("Si la hora no es válida se establecerá en 00:00:00 por defecto.");
            this.hora = 0;
            this.minuto = 0;
            this.segundos = 0;
        }
        this.its24h = its24h;
    }
    /*Constructor vacío para que en caso de haber errores a la hora de definir parámetros no de errores inesperados*/
    public Reloj() {
        this.hora = 0;
        this.minuto = 0;
        this.segundos = 0;
        this.its24h = true;
    }

    public int getHora() {

        return hora;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
        if(segundos >= 0 && segundos<= 59 ){
            this.segundos = segundos;
        }
        else {
            System.out.println("Si la hora no es valida no se asignará.");
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
        if(hora >= 0 && hora <= 23 ){
            this.hora = hora;
        }
        else {
            System.out.println("Si la hora no es valida no se asignará.");
        }
    }

    public int getMinuto (){
        return minuto;
    }

    public void setMinuto (int minuto){
        this.minuto = minuto;
            if( minuto >= 0 && minuto <= 59 ){
                this.minuto = minuto;
            }
            else {
                System.out.println("Si la hora no es valida no se asignará.");
            }
        }

    @Override
    public String toString() {
        String formato;
        int horaMostrar = this.hora;

        if (!its24h){
            //Determina si es AM o PM
           if (horaMostrar < 12){
               formato = "AM";
           }
           else {
               formato = "PM";
           }
           //Forma a 12 horas
           if (horaMostrar == 0){
               horaMostrar = 12;
           } else if (horaMostrar > 12) {
               horaMostrar = horaMostrar -12;
           }
        }
        else {
            //Si no necesitas formato 24h sale por aquí.
            formato = "24H";
        }

        /*%02d significa:
        d: Número entero.
        02: Se rellena con ceros si tiene menos de dos dígitos.
        */
        return String.format("Reloj: %02d:%02d:%02d %s", horaMostrar, minuto, segundos, formato);
    }
}