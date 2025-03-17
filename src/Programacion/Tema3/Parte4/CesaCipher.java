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
        String cadena = " ";

        System.out.println("Para encriptar el mensaje: a");
        System.out.println("Para desencriptar el mensaje: b");
        menu = input.next();

        switch (menu){
            case "a":


                System.out.println("Introduce la frase que quieres encriptar.");
                input.nextLine();
                cadena = input.nextLine();

                System.out.println("Mensaje encryptado: "+ encrypt(cadena));
                break;
            case "b":

                System.out.println("Introduce la frase que quieres desencriptar.");
                input.nextLine();
                cadena = input.nextLine();

                System.out.println("Mensaje desencryptado: "+ unEncrypt(cadena));
                break;
        }

    }

    public static String encrypt (String cadena){
        int desplazamiento = 1;
        String encrypt = " ";
        String cadenaUpper = cadena.toUpperCase();
        for (int i = 0; i < cadenaUpper.length(); i++){
            //crean un índice con los caracteres de la string.
            char indiceCarateres = cadenaUpper.charAt(i);
            //Selecciona solo caracteres
            if (Character.isLetter(indiceCarateres)){
                indiceCarateres= (char) ((indiceCarateres - 'A' + desplazamiento + 26) % 26 + 'A');
                //coge el valor en ASCII de una caracter.
        }
            else if (Character.isDigit(indiceCarateres)) {
                indiceCarateres= (char) ((indiceCarateres - '0' + desplazamiento + 10) % 10 + '0');
                //creo que me devuelve el valor, pero tomando los dígitos
            }
            //No se que es el += pero es con lo único que he conseguido devolver la array en string.
            encrypt += indiceCarateres;
        }
        return encrypt;
    }

    public static String unEncrypt (String cadena){
        int desplazamiento = -1;
        String unEncrypt = " ";
        String cadenaUpper = cadena.toUpperCase();
        for (int i = 0; i < cadenaUpper.length(); i++){
            char indiceCarateres = cadenaUpper.charAt(i);
            if (Character.isLetter(indiceCarateres)){
                indiceCarateres= (char) ((indiceCarateres - 'A' + desplazamiento + 26) % 26 + 'A');
            }
            else if (Character.isDigit(indiceCarateres)) {
                indiceCarateres= (char) ((indiceCarateres - '0' + desplazamiento + 10) % 10 + '0');
            }
            unEncrypt += indiceCarateres;
        }
        return unEncrypt;
    }
}
