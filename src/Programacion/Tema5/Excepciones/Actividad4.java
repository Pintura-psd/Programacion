package Programacion.Tema5.Excepciones;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Actividad4 {
    /*4. Implementa un programa que cree un vector de enteros de tamaño N
(número aleatorio entre 1 y 100) con valores aleatorios entre 1 y 10. Luego se le
preguntará al usuario qué posición del vector quiere mostrar por pantalla,
repitiéndose una y otra vez hasta que se introduzca un valor negativo. Maneja
todas las posibles excepciones.*/


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random numbersRandom = new Random();
        int intRandomArray = numbersRandom.nextInt(100);
        int intRandomValue = numbersRandom.nextInt(10);
        int[] vector = new int[intRandomArray];
        int vista = 0;


        try {
            System.out.println("Introduce la posición que quieres de nuestra lista: ");
            for (int i = 0; i < vector.length;i++){
                vector[i] = intRandomValue;
            }
            vista = input.nextInt();

            System.out.println("La posición "+ vista + " es: "+ vector[vista]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            if (vista > intRandomArray){
                System.out.println("No hay lista más allá, se te mostrará la posición máxima: ");
                System.out.println("Última posición es: "+ intRandomArray +" y su valor es: "+ vector[(intRandomArray -1)]);
                //El -1 es porque la array cuenta su posición máxima ya fuera de su extensión.
            }
            else if (vista < 0){
                System.out.println("No ha lista mas acá, se te mostrará el primer valor:");
                System.out.println("Primera posición es: 1 y su valor es: "+ vector[(intRandomArray -1)]);
            }
        }
        catch (InputMismatchException e){
          //  while (vista >= 0 && vista <= 99999){
               System.out.println("Valor no válido, ha de ser un número entero.");
          /*     input.next(); //Limpiamos el buffer
                vista = input.nextInt();*/
          // }
        }

    }
}