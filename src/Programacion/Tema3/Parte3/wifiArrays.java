package Programacion.Tema3.Parte3;
/*4. Vamos a hacer un programa que permita hacer simulaciones de cobertura
wifi para hoteles. Le pediremos al usuario que seleccione un número de
habitación (1-20) donde instalar el router y una potencia de transmisión del
router (1-6). La señal se pierde en cada paso de habitación y vamos a
representarlo en el array. Si ponemos un router de potencia 4 en la habitación
10 el resultado sería el siguiente array:*/

import java.util.Arrays;
import java.util.Scanner;

public class wifiArrays {
    public static void main (String [] args){

        int[] habitaciones = new int[20];
        Scanner input = new Scanner(System.in);
        int habitacion = 0;
        int potenciaRuter = 0;

        System.out.println("Introduce un número del 1 al 20.");
        habitacion = input.nextInt();
        while (habitacion < 1 || habitacion > 20){
            System.out.println("No es un número válido. Introduce entre 1 al 20.");
            habitacion = input.nextInt();
        }
        System.out.println("Habitación selecionada: "+ habitacion);

        System.out.println("Para la potencia del ruter introduce un número del 1 al 6.");
        potenciaRuter = input.nextInt();
        while (potenciaRuter < 1 || potenciaRuter > 6){
            System.out.println("No es un número valido. Introduce un número del 1 al 6.");
            potenciaRuter = input.nextInt();
        }

        /*Ubicar la potencia en la habitación*/
        System.out.println("Potencia del router: "+ potenciaRuter);

        /*Propagar la señal a la izquierda*/
        habitaciones[habitacion - 1] = potenciaRuter;
        for (int i = habitacion - 2, potencia = potenciaRuter - 1; i >= 0 && potencia > 0; i--, potencia--) {
            habitaciones[i] = potencia;
        }

        /*Propagar la señal hacia la derecha*/
        for (int i = habitacion, potencia = potenciaRuter - 1; i < habitaciones.length && potencia > 0; i++, potencia--) {
            habitaciones[i] = potencia;
        }

        System.out.println("Distribución de la señal: ");
        System.out.println(Arrays.toString(habitaciones));

        input.close();
    }
}
