package Programacion.Tema3;

import java.util.Scanner;

public class Pruebaexamen {
    public static void main (String [] args){
        Pruebaexamen.menu();

    }


    public static void menu (){
        String menu = " ";
        Scanner input = new Scanner(System.in);


        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        System.out.println("d");
        menu = input.nextLine();

        switch (menu){
            case "a":
                int cuantity = 0;
                System.out.println("Introduce el número de personas que hay en el grupo");
                cuantity = input.nextInt();

                System.out.println("Hay "+ Pruebaexamen.over18(cuantity));


                break;
        }
    }

    //Ejericio 1
    public static int over18 (int cuantity){
        Scanner input =  new Scanner(System.in);
        int year;
        int over18 = 0;

        for (int i = 0; i < cuantity; i++){

            System.out.println("Introduce el año de nacimiento: ");
            year = input.nextInt();

            if ((2024 - year)>=18){

                over18++;
            }

        }
        return over18;
    }
}

