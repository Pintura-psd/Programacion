package Tema5;
/* 2. Haz una aplicación que permitirá gestionar los usuarios de un gimnasio.
Necesitarás una clase Usuario con los datos del usuario (nombre y edad). La
información de los usuarios se almacenará en un Mapa donde la clave será el
DNI y el valor un objeto de la clase Usuario. La aplicación debe permitir dar de
alta usuarios, dar de baja usuarios, mostrar los datos de un usuario y
modificar usuarios. Debe mostrar mensajes de error si no existe un usuario o
hay cualquier otro problema. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gym {
    private static Scanner input = new Scanner(System.in);
    private static List<Abonado> abonados= new ArrayList<>();

    public static void main(String[] args) {
        int menu = 0;

        System.out.println("¿Qué quiere hacer?");
        System.out.println(" ");
        System.out.println("Para dar de alta a un abonado introuzca 1");
        System.out.println("Si quiere darle de baja introduzca 2");
        System.out.println("Si quiere ver la lista de abonados 3");
        System.out.println("Si quiere salir 4");

        menu = input.nextInt();
        input.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Si quieres parar de abonar escribe fin en vez del nombre.");
                    abonar();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("La lista de abonados es: ");
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
            }

        input.close();
    }

    public static void abonar(){
        Scanner input = new Scanner(System.in);
        String nombre = "";
        String dni = "";
        int edad = 0;

        while (!nombre.equals("fin")) {
            System.out.println("Dar de alta: ");
            System.out.println("");
            System.out.println("Introduce los datos del abonado.");
            System.out.println("");

            System.out.println("Nombre:");
            nombre = input.nextLine().toLowerCase();


          if(!nombre.equals("fin")) {
              System.out.println("DNI");
              dni = input.nextLine();


              System.out.println("edad");
              edad = input.nextInt();

              Abonado abonado = new Abonado(dni, nombre, edad);

              abonados.add(abonado);
              System.out.println("Se ha dado de alta a: ");
              System.out.println(abonado);
              input.nextLine();
          }
          else {
              System.out.println("Los abonados son: "+ abonados);
              System.out.println("Saliendo");
          }
        }
    }

}
