package Entornos;

import java.util.Scanner;

public class Calculadora {
    static void main (String [] args){

        int num1 = 0;
        int num2 = 0;
        int menu ;
        Scanner input = new Scanner(System.in);

        System.out.println("1 Para sumar");
        System.out.println("2 Para restar");
        System.out.println("3 Para multiplicar");
        System.out.println("4 Para dividir");
        System.out.println("5 Para salir");
        menu = input.nextInt();

        if (menu>0 && menu<4) {
            switch (menu) {
                case 1:
                    System.out.println("La suma es: "+ suma(num1,num2));
                    break;
                case 2:
                    System.out.println("La resta es: "+ resta(num1,num2));
                    break;
                case 3:
                    System.out.println("La multiplicación es"+ multi(num1, num2));
                    break;
                case 4:
                    System.out.println("La division es"+ div(num1,num2));
                    break;
            }
        }
        else {
            System.out.println("Has salido de la calculadora.");
        }
    }

    public static int suma (int num1, int num2){
        int sum;
        sum = num1 + num2;
        return sum;
    }

    public static int resta (int num1, int num2){
        int rest;
        rest = num1 - num2;
        return rest;
    }

    public static int multi (int num1, int num2){
        int multi;
        multi = num1 * num2;
        return multi;
    }

    public static int div (int num1, int num2){
        int div;
        div = num1 / num2;
        return div;
    }
}


