package Programacion.Tema5.Excepciones;

import java.util.Objects;
import java.util.Scanner;
/*5. Implementa un programa con tres funciones:
• void imprimePositivo(int p): Imprime el valor p. Lanza una ‘Exception’ si
p < 0
• void imprimeNegativo(int n): Imprime el valor n. Lanza una ‘Exception’ si
p >= 0
La función main para realizar pruebas. Puedes llamar a ambas funciones varias
veces con distintos valores, hacer un bucle para pedir valores por teclado y
pasarlos a las funciones, etc. Maneja las posibles excepciones.*/
public class Actividad5 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String stringNum = " ";

        //Recuerda que las cadenas ha de gesionarse con oject.equals.
        while (!Objects.equals(stringNum, "fin")) {
            try {
                //Encapsulo con un try-catch anidado para que el bucle contnue.
                System.out.println("Introduce un valor entero: ");
                stringNum = input.nextLine();
                int num = Integer.parseInt(stringNum);
                 try {
                     imprimePositive(num);
                     imprimeNegative(num);
                 }
                 catch (Exception e){
                     //e(nombre de la excepción).getMessage coge la string del constructor de la excepción.
                     System.out.println("El número es: "+ num +" "+ e.getMessage());
                 }
            }
            catch (NumberFormatException e){
                if (!Objects.equals(stringNum,"fin")){
                    System.out.println("No es un formato válido, tiene que ser un número entero.");
                    input.nextLine();
                }
            }
        }

        System.out.println("Fin el proceso.");
        input.close();
    }

    public static void imprimePositive (int num) throws Exception {
        if (num < 0){
            throw new Exception ("El número es positivo.");
        }
    }

    public static void imprimeNegative (int num) throws Exception {
        if (num >= 0){
            throw new Exception ("El número es negativo.");
        }
    }
}