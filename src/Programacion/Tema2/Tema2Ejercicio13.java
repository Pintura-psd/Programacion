package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio13 {
    public static void main (String [] arg){
        /*13. Realiza un programa que lea por consola una hora (horas, minutos,
segundos), y muestra por consola la hora con un segundo más.*/

        int hours;
        int seconds;
        int mins;
        Scanner input=new Scanner (System.in);

        System.out.println("Dime las horas, minutos y segundos.");

        hours=input.nextInt();
        mins= input.nextInt();
        seconds=input.nextInt();

        seconds++;

        if (seconds==60) {
            seconds=0;
            mins++;
        }if (mins==60) {
            mins=0;
            hours++;
        }if (hours==24){
            hours=0;
        }

        System.out.println("Son las "+ hours+":"+mins+":"+seconds);

        input.close();
    }
}
