package Programacion.Tema3;

import java.util.Scanner;

public class GrupoEdad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir la cantidad de personas en el grupo
        System.out.print("Ingrese la cantidad de personas en el grupo: ");
        int cantidad = scanner.nextInt();

        // Contar mayores de edad
        int mayoresDeEdad = contarMayoresDeEdad(cantidad);

        // Mostrar el resultado
        System.out.println("El número de mayores de edad es: " + mayoresDeEdad);
    }

    // Método para contar cuántos son mayores de edad
    public static int contarMayoresDeEdad(int cantidad) {
        Scanner scanner = new Scanner(System.in);
        int mayores = 0;
        int anioActual = java.time.Year.now().getValue(); // Obtener el año actual

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el año de nacimiento de la persona " + i + ": ");
            int anioNacimiento = scanner.nextInt();
            if (anioActual - anioNacimiento >= 18) {
                mayores++;
            }
        }
        return mayores;
    }
}