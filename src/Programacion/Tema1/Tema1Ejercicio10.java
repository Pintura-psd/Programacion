package Programacion.Tema1;
//. Implementa en Java una clase llamada Tema1Ejercicio10 que pida por
//teclado 2 números reales y muestre por pantalla el resultado de su
//suma, producto, resto y división.

import java.util.Scanner;

public class Tema1Ejercicio10 {
    public static void main(String [] args) {

        int num1;
        int num2;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce los dos números enteros con los que quieras operar.");

        num1=input.nextInt();
        num2=input.nextInt();

        System.out.println ("Suma "+ (num1+num2) +" Resta "+ (num1-num2) +" División "+ (num1/num2) +" Resto "+ (num1%num2) +" Producto "+ (num1*num2));

    }

}
