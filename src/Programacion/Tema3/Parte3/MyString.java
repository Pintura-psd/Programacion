package Programacion.Tema3.Parte3;

import java.util.Scanner;

public class MyString {
    public static void main (String [] args){

        String menu = "menu";
        String cadena = " ";
        Scanner input = new Scanner(System.in);

        System.out.println("a: Invertir una palabra.");
        System.out.println("b: Contar vocales");

        menu = input.next();

        switch (menu){
            case "a":

                /* Una función que reciba una cadena y devuelva esta cadena
                invertida y en mayúsculas. */
                System.out.println("Introduce una palabra para invertirla.");
                cadena = input.next();

                System.out.println(reverseString(cadena));
            break;
            case "b":
                /*Una función que reciba una cadena y devuelva el número de
                vocales. */

                System.out.println("Introduce una cadena para saber la cantidad de vocales que tiene.");
                cadena = input.next();

                System.out.println(vowelsCount(cadena));


                break;
        }

    }

public static String reverseString(String cadena) {
    String invertida =" ";

    for (int i = cadena.length() - 1; i >= 0; i--) {
        invertida += cadena.charAt(i);
    }
        return invertida;
}

public static int vowelsCount(String cadena){

        String cadena2 = cadena.toLowerCase();
        int count = 0;

        for (int i = cadena2.length() -1; i >= 0; i--){
            if (cadena2.charAt(i) == 'a'|| cadena2.charAt(i) == 'e' || cadena2.charAt(i) == 'i' || cadena2.charAt(i) == 'o' || cadena2.charAt(i) == 'u'){
                count ++;
            }
        }
        return count;
}
}