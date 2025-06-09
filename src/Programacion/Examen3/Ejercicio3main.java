package Programacion.Examen3;

import Programacion.Examen3.Ejercicio2.Ejercicio2Funciones;

import java.util.Scanner;

public class Ejercicio3main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] credenciales = Operaciones.cargarCredenciales();

        System.out.println("Estudiantes que empiezan por A");
        Operaciones.startsA(credenciales);

        // System.out.println("Mascotas de alumnos");
        // Operaciones.alumnosQueTienenMascota(credenciales);

    }
}
