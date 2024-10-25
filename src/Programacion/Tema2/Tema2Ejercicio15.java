package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio15 {
    public static void main (String [] arg){
        /* Realiza un programa que lee el número de un mes y el año e indica por
consola el número de días del mes (piensa en que el año puede ser
bisiesto)*/

    int year;
    int month;
    int day;
    Scanner input=new Scanner(System.in);

    System.out.println("Indica a que mes estamos.");
    month=input.nextInt();
    while (month>12 || month<1){
        System.out.println("Escribe el mes bien porfa.");
        month=input.nextInt();
    }

    System.out.println("además a que año estemos.");
    year=input.nextInt();

    if ( month==1||month==3||month==5||month==7||month==8||month==10||month==12 ){
        System.out.println("Es un mes de 31 días");
    }else if ( month==4||month==6||month==9||month==11) {
        System.out.println("Es un mes de 30 días.");
    }else {
        System.out.println("Este mes tiene 28 días");
    }

    if ((year%4==0) && !(year%100==0) || (year%400==0)&&(year%100==0)){
        System.out.println("Este año es bisiesto.");
    }else {
        System.out.println("Este año NO es bisiesto");
    }

input.close();
    }
}
