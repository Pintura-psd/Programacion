package Programacion.Tema2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tema2Ejercicio5 {
    public static void main (String [] args){
//Realiza un programa que lea 3 números por consola y calcule la media
//con decimales y sin decimales.

        double num1;
        double num2;
        double num3;
        double medi;
        Scanner input= new Scanner(System.in);

        System.out.println("Introduce los 3 números de los cuales quieras saber su media.");

        num1=input.nextDouble();
        num2=input.nextDouble();
        num3=input.nextDouble();

        medi = (num1 + num2 + num3) / 3;
        System.out.println("Con decimales tu resultado es: "+ medi);
        DecimalFormat df= new DecimalFormat ("#");
        System.out.println("Sin decimales es: "+ (df.format(medi)));

        input.close();
    }
}
