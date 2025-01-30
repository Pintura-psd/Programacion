package Programacion.Tema3.Parte4;

import java.util.Scanner;

public class CesaCipher {
    /*2. Crea una clase CaesarCipher para implementar el cifrado de Julio César con
tres funciones: encrypt (cifrar), decrypt (descifrar) y main. Julio César inventó
un cifrado para evitar que los mensajes pudieran ser leídos por cualquier
persona. El cifrado tiene las siguientes normas:
- Todo mensaje debe tener sus letras en mayúsculas.
- Se reemplaza cada letra por la siguiente del abecedario, excepto la Z
que se reemplaza por la A.
- Se reemplaza cada dígito por el siguiente dígito, excepto el 9 que se
reemplaza por 0.
- El resto de caracteres no se reemplazan.*/

    public static void main (String[]args){
        String menu = "menu";
        Scanner input = new Scanner(System.in);

        System.out.println("Para encriptar el mensaje: a");
        System.out.println("Para desencriptar el mensaje: b");
        menu = input.next();
        String cadena = " ";

        switch (menu){
            case "a":


                System.out.println("Introduce la frase que quieres encriptar.");
                input.nextLine();
                cadena = input.nextLine();

                break;
            case "b":



                break;


        }

    }

    public static void encrypt (String cadena){
        int counter = -1;
        String cadenaUpper = cadena.toUpperCase();

        String[] cadenaArray = cadenaUpper.split(" ");

        while (counter < cadenaArray.length){
        

        }


    }

}
