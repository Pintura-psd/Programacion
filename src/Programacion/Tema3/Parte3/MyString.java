package Programacion.Tema3.Parte3;

import java.util.Scanner;

public class MyString {
    public static void main (String [] args){

        String menu = "menu";
        String cadena = " ";
        String cadena2 = " ";
        Scanner input = new Scanner(System.in);

        System.out.println("a: Invertir una palabra.");
        System.out.println("b: Contar vocales.");
        System.out.println("c: Devolver la palabra más larga de una string.");

        menu = input.nextLine();

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
            case "c":
                /*c) Una función que reciba una cadena y devuelva la palabra de
                mayor longitud*/

                System.out.println("Introduce una frase.");
                cadena = input.nextLine();

                System.out.println("La palabra mas larga es: "+ longWord(cadena));
                break;

            case "d":
                /*d) Una función que reciba dos cadenas y devuelva el número de
                veces que la segunda cadena está incluida en la primera.*/

                System.out.println("Introduce la primera cadena.");
                cadena = input.nextLine();
                System.out.println("Introduce la segunda cadena");
                cadena2 = input.nextLine();

                break;
        }

    }

public static String reverseString(String cadena) {
    String invertida ="";

    for (int i = cadena.length() - 1; i >= 0; i--) {
        invertida += cadena.charAt(i);
    }
        return invertida.toUpperCase();
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

public static String longWord (String cadena){

        int length = 0;
        String cadena2 = cadena.toLowerCase();

        String[] empty;
        String vuelta = " ";
        empty = cadena2.split(" ");

        for (int i=0; i < empty.length; i++){
            if (empty[i].length()>length){
                length = empty[i].length();
                vuelta = empty[i];
            }
        }
        return vuelta;
}

public static String repeticionCadena (String cadena1, String cadena2){



        return cadena1;
}

}