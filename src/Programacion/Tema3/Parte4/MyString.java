package Programacion.Tema3.Parte4;

import java.util.Scanner;

public class MyString {
    public static void main (String [] args){

        String menu = "menu";
        String cadena = " ";
        Scanner input = new Scanner(System.in);

        System.out.println("a: Invertir una palabra.");
        System.out.println("b: Contar vocales.");
        System.out.println("c: La palabra más larga.");
        System.out.println("d: Cuantas veces de repite una cadena.");
        System.out.println("f: Una función que reciba que convierta un número a formato ideal.");
        System.out.println("g: Histograma de vocales.");

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

            case "c":
                    /*Una función que reciba una cadena y devuelva la palabra de
                    mayor longitud.*/
                System.out.println("Vamos a encontrar la palabra más larga de una frase.");
                System.out.println(" ");
                System.out.println("Introduce tu frase:");
                input.nextLine();
                cadena = input.nextLine();


                System.out.println(longestWord(cadena));
                break;

            case "d":
                /*Una función que reciba dos cadenas y devuelva el número de
                veces que la segunda cadena está incluida en la primera.*/

                String cadenaContenedora = " ";

                System.out.println("Introduce la cadena que quieres comprobar que se repite");
                input.nextLine();
                cadena = input.nextLine();
                System.out.println("Introduce la cadena  en la que quieres comprobar la repetición");
                cadenaContenedora = input.nextLine();

                System.out.println("La cadena: "+ cadena + " se repite: "+repeatString(cadena, cadenaContenedora));

                break;

            case "f":
                /* Una función que reciba un número de teléfono, por ejemplo
                “34555332211” y lo convierta al formato (+34)-555-332211.*/

                String cadenaNum = " ";

                System.out.println("Introduce un número a la cual quieras añadir el formato de número de teléfono.");
                System.out.println("Recuerda añadir los dos dígitos correspondientes de tu país");
                input.nextLine();
                cadenaNum = input.nextLine();

                System.out.println("El número con formato en formato es: "+ numberFormat(cadenaNum));
                break;

            case "g":
                /*Un procedimiento que reciba una cadena y muestre por pantalla
                el histograma de frecuencias de las vocales (las veces que se
                repiten). Por ejemplo:*/

                System.out.println("Introduce la frase la cual quieras saber la cantidad de vocales que contiene.");
                input.nextLine();
                cadena = input.nextLine();

                graphicVowels(cadena);
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

    public static String longestWord (String cadena){
            int length=0;
            String[] cadenaArray = cadena.split(" ");
            String longWord = " ";

            /*Tengo que tener cuidado con exceder el índice de una array*/
             for (int i = 0; i < cadenaArray.length; i++) {
                if (length < cadenaArray[i].length()){
                    length = cadenaArray[i].length();
                    longWord = cadenaArray[i];
                }
             }

            return longWord;

    }

    public static int repeatString (String cadena, String cadenaContendora){

        int contador = 0;

        String[] cadenaArray = cadenaContendora.split(" ");

        for (int i=0; i < cadenaArray.length; i++){
            if (cadena.equals(cadenaArray[i])){
                contador++;
            }
        }

        return  contador;
    }

    public static String numberFormat (String cadena){

            if (cadena.matches("\\d+") && cadena.length()==11){
                /*cadena = "Es un valor valido";*/

                String pack1 =" ", pack2 =" ", pack3 =" ", pack4 = " ", pack5 = " ";

                pack1 = cadena.substring(0,2);
                pack2 = cadena.substring(2,5);
                pack3 = cadena.substring(5,7);
                pack4 = cadena.substring(7,9);
                pack5 = cadena.substring(9,cadena.length());
                cadena = "(+"+pack1+")"+pack2+"-"+pack3+"-"+pack4+"-"+pack5;

                return cadena;
            }
            else {
               cadena ="No es un valor válido";
               return cadena;
            }
    }

    public static void graphicVowels (String cadena){

            String cadena1 = " ";
            cadena1 = cadena.toLowerCase();

            int countA = 0;
            int countE = 0;
            int countI = 0;
            int countO = 0;
            int countU = 0;

        for (int i = cadena1.length() -1; i >= 0; i--){
            if (cadena1.charAt(i) == 'a'){
                countA ++;
            }

            if (cadena1.charAt(i) == 'e'){
                countE++;
            }

            if (cadena1.charAt(i) == 'i'){
                countI++;
            }

            if (cadena1.charAt(i) == 'o'){
                countO++;
            }

            if (cadena1.charAt(i) == 'u'){
                countU++;
            }
        }

        System.out.println(cadena);
        System.out.print("a: "+ countA+" ");
        for (int i = 0 ; i <= countA; i++){
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("e: "+ countE+" ");
        for (int i = -1 ; i <= countE; i++){
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("i: "+ countI+" ");
        for (int i = -1 ; i <= countI; i++){
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("o: "+ countO+" ");
        for (int i = -1 ; i <= countO; i++){
            System.out.print("*");
        }
        System.out.println(" ");

        System.out.print("u: "+ countU+" ");
        for (int i = -1 ; i <= countU; i++){
            System.out.print("*");
        }
    }
}