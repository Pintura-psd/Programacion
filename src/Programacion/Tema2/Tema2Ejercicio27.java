package Programacion.Tema2;


public class Tema2Ejercicio27 {
    public static void main (String [] arg){
        /*27. Haz un programa que encuentre e imprima por consola los 20 primeros
números primos.*/

        int contador;
        int num;
        boolean primo=true;


        contador=0;
        num=1;

        while (contador<20) {
            primo = true;

            if (num <= 1) {
                primo = false;
            }

            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println(num);
                contador++;
            }
            num++;
        }

        System.out.println("Los 20 primero números primos son: "+ (num));
    }
}
