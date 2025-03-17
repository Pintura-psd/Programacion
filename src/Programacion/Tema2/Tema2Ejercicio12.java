package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio12 {
        public static void main(String [] args) {

            // Realiza un programa que lea 3 números por consola y los muestre
            //ordenados de mayor a menor.

            double num1;
            double num2;
            double num3;
            double big = 0;
            double medium = 0;
            double small = 0;
            Scanner input = new Scanner(System.in);

            System.out.println("Dime los tres números de los cuales quieras saber el mayor.");
            num1 = input.nextDouble();
            num2 = input.nextDouble();
            num3 = input.nextDouble();

            if (num1 > num2 && num1 > num3) {
                big = num1;
                if (num2 > num3) {
                    medium = num2;
                    small = num3;
                } else {
                    medium = num3;
                    small = num2;
                }
            } else if (num2>num1 && num2>num3) {
                big=num2;
                if (num1>num3) {
                    medium = num1;
                    small = num3;
                } else {
                    medium= num3;
                    small= num1;
                    }
                if (num3>num2 && num3>num1) {
                    big=num3;
                    if (num1>num2) {
                        medium = num1;
                        small = num2;
                    } else {
                        medium = num2;
                        small = num1;
                    }

                    }
                }


                System.out.println("Tú número mayor es " + (big) + " mediano " + (medium) + " y pequeño " + (small));
            input.close();
        }
}
