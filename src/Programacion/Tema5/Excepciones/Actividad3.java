package Programacion.Tema5.Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;
     /*3. Implementa un programa que cree un vector tipo double de tamaño 5 y
luego, utilizando un bucle, pida cinco valores por teclado y los introduzca en el
vector. Tendrás que manejar la/las posibles excepciones y seguir pidiendo
valores hasta rellenar completamente el vector.*/

public class Actividad3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] vector = new double[5];

        System.out.println("Introduce los valores de tú grupo de 5.");

        for (int i = 0; i < 6;i++) {
            try {
                System.out.println("Introduce tú valor: ");
                vector[i] = input.nextDouble();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("El valor no es correcto");
                System.out.println("El valor de "+ (i+1) +" establecerá a 0.");
                vector[i] = 0.0;
                input.nextLine();

            } catch (ArrayIndexOutOfBoundsException e) {
                //Se que aquí no llega pero, bueno doble seguridad.
                System.out.println("Tu lista ha superado los límites.");
            }
        }

        System.out.println(" ");
        for (int i = 0; i < vector.length; i++){
            System.out.println("El valor de la posición "+ (i + 1) +" es "+ vector[i]);
        }
    }
}
