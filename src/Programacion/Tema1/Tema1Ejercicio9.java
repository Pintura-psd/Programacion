package Programacion.Tema1;

import java.util.Scanner;

public class Tema1Ejercicio9 { public static void main(String[] args) {
    int num1;
    int num2;
    Scanner input= new Scanner(System.in);

    System.out.println("Introduceme los dos números que con los que quieras operar.");

    num1=input.nextInt();
    num2=input.nextInt();

    System.out.println("Suma "+ (num1+num2) +" Resta "+ (num1-num2) +" Producto " + (num1*num2) + " Resto "+ (num1 % num2));

    input.close();
}

}