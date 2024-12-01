package Programacion.Tema3;

import java.util.Scanner;

public class PruebasEjercicio8 {
    public static void main (String [] args){
        int month;
        int day;
        int year;
        Scanner input = new Scanner(System.in);

        System.out.println("Introduce el mes con números.");
        month = input.nextInt();
        System.out.println("Introduce el día en números");
        day = input.nextInt();
        System.out.println("Introduce el año en números");
        year = input.nextInt();


        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day<=31 && day>0){

                    System.out.println("Es "+ day +" mes "+ month +" año "+ year);
                }
                else {
                    System.out.println("No es un día válido");
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day<=30 && day>0){

                    System.out.println("Es "+ day +" mes "+ month +" año "+ year);
                }
                else {
                    System.out.println("No es un día válido");
                }
                break;
            case 2:
                if (year%4==0 && (year%100 !=0 || year%400==0 )){
                    if (day<=29 && day>0){

                        System.out.println("Es "+ day +" mes "+ month +" año "+ year);
                    }
                    else {
                        System.out.println("No es un día válido");
                    }
                }
                else if (day<28 && day>0){

                    System.out.println("Es "+ day +" mes "+ month +" año "+ year);
                }
                else {
                    System.out.println("No es un día válido");
                }
                break;

                default:
                System.out.println("No es una fecha válida.");
        }
        input.close();
    }
}
