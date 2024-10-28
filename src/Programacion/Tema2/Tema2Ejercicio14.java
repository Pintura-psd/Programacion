package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio14 {
    public static void main (String [] arg){

        /* Realiza un programa que calcule el precio de la estancia en un camping.
Leerá por consola el número de personas y días. La tarifa estándar es
de 15 €/noche, pero si son más de 5 personas y se quedan al menos una
semana el precio se reduce un 25%. */

        double price;
        int person;
        int nights;
        Scanner input= new Scanner(System.in);

        price=0;

        System.out.println("Introduce el número de personas.");
        person= input.nextInt();

        System.out.println("Introduce el número de noches");
        nights=input.nextInt();

        price=(nights*15)*person;

        if (person>=5 && nights>7){
            price=person*(nights*15)*0.75;
        }

        System.out.println("Tu precio es "+ price +"€ con el descuento de más de 5 personas.");
    }
}
