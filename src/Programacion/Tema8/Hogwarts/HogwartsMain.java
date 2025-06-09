package Programacion.Tema8.Hogwarts;

import java.util.Scanner;

public class HogwartsMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] credenciales = Operaciones.cargarCredenciales();

        //Fantasma prueba
         Operaciones.fantasma(credenciales);
        //Ejercicio1
         Operaciones.ejercicio1(credenciales);
        //Ejercicio2
         Operaciones.ejercicio2(credenciales);
        //Ejercicio3
         Operaciones.ejercicio3(credenciales);
        //Ejercicio4
         Operaciones.insertarTabla(input);
        //Ejercicio5
         Operaciones.modificarAsignatura(input);
        //Ejercicio6
         Operaciones.eliminarAsignatura(input);









    }
}
