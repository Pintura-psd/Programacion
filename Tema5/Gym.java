package Programacion.Tema5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gym {
    public static void main(String[] args) {
        int menu = 0;
        Scanner input = new Scanner(System.in);
        Map<String, GymUsuario > gymAbonados = new HashMap<>();
        String dni;


        while (menu != 6) {
            System.out.println("¿Qué quieres hacer?");
            System.out.println(" ");
            System.out.println("Para dar de alta a un abonado introuzca 1");
            System.out.println("Si quiere darle de baja introduzca 2");
            System.out.println("Si quiere ver la lista de abonados 3");
            System.out.println("Para modificar un usuario escriba 4");
            System.out.println("Motrar un usuario en especifico escriba 5");
            System.out.println("Si quiere salir 6");

            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Abonar: ");
                    abonar(input, gymAbonados);
                    break;
                case 2:
                    System.out.println("Dar de baja");
                    borrarUsuario(input, gymAbonados);
                    break;
                case 3:
                    System.out.println("La lista de abonados es: ");
                    mostrarMap(gymAbonados);
                    break;
                case 4:
                    System.out.println("Modificar usuario: ");
                    actualizarUsuario(input, gymAbonados);
                    break;
                case 5:
                    System.out.println("Mostrar usuario específico: ");
                    mostrarUsuario(input, gymAbonados);
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
            }
        }
    }

    private static void abonar (Scanner input, Map<String, GymUsuario> gymAbonados) {
        System.out.println("Introduce el DNI: ");
        String dni = input.nextLine();

        if (gymAbonados.containsKey(dni)){
            System.out.println("El usuario ya está abonado.");
        }
        else {
            gymAbonados.put(dni, guardarGymUsuario(input));
            System.out.println("Usuario dado de alta.");
        }

    }
    private static void actualizarUsuario(Scanner input, Map<String, GymUsuario> gymAbonados) {
        System.out.println("DNI: ");
        String dni = input.nextLine();
        if (gymAbonados.containsKey(dni)) {
            System.out.println("Usuario actualizado");
        }
        else {
            System.out.println("El usuario no forma parte de la base de datos.");
        }
    }

    public static void mostrarUsuario(Scanner input, Map<String, GymUsuario> gymUsuarios) {
        System.out.println("DNI: ");
        String dni = input.nextLine();

        if (gymUsuarios.containsKey(dni)) {
            System.out.println(gymUsuarios.get(dni));
        }
        else {
            System.out.println("El usuario no existe.");
        }
    }

    private static void borrarUsuario(Scanner input, Map<String, GymUsuario> gymUsuarios) {
        System.out.println("DNI: ");
        String dni = input.nextLine();

        if (gymUsuarios.containsKey(gymUsuarios.get(dni))) {
            gymUsuarios.remove(dni);
            System.out.println("Se ha eliminado el usuario.");
        }
        else {
            System.out.println("El usuario no existe.");
        }
    }

    private static GymUsuario guardarGymUsuario(Scanner input){
        System.out.println("Nombre: ");
        String name = input.nextLine();
        System.out.println("Edad: ");
        int age = input.nextInt();
        input.nextLine();
        return new GymUsuario(name, age);
    }

    private static void mostrarMap (Map<String, GymUsuario> gymUsuarios) {
        if (gymUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        }
        else {
        //No me queda laro este for each lo que hace
            for (Map.Entry<String, GymUsuario> entry : gymUsuarios.entrySet()) {
                System.out.println("DNI: " + entry.getKey() + ", " + entry.getValue());
            }
        }
    }
}
