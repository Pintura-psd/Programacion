package Programacion.Tema5.Banco;


import java.util.*;

public class BankQueue {

    static Queue <BankUser> cola;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<BankUser> bankQueue = new LinkedList<>();
        int menu = 0;


        while (menu != 4){
            System.out.println("Opciones: ");
            System.out.println("1: Añadair usuario a la cola.");
            System.out.println("2: Quitar usuario de la cola.");
            System.out.println("3: Eliminar usuario atendido");
            System.out.println("4: Cerrar");

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    queueAdd(bankQueue, input);
                    break;
                case 2:
                    System.out.println("Eliminar usuario de la lista.");
                    queueRemoveAnyWhere(bankQueue,input);
                    break;
                case 3:
                    System.out.println("Eliminar usuario antendido.");
                    queueRemoveFirst(bankQueue,input);
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;

            }
        }
    }

    public static void queueAdd (List<BankUser> cola, Scanner input){
        String dni ;
        String nombre;
        int edad;
        input.nextLine();

        System.out.println("Añadir usuario: ");
        System.out.println("DNI: ");
        dni = input.nextLine();
        System.out.println("Nombre: ");
        nombre = input.nextLine();
        System.out.println("Edad: ");
        edad = input.nextInt();

        cola.add(new BankUser(nombre,edad,dni));
        System.out.println("Usuario añadido.");
    }

    public static void queueRemoveFirst(List<BankUser> cola, Scanner input){
        input.nextLine();
        //Preguntar a ana el porqué de Poll();
        if (cola.isEmpty()){
            System.out.println("No hay usuarios en cola.");
        }
        else {
            BankUser usuario = cola.remove(0);
            System.out.println("El usuario:" + usuario + "ha sido atendido." );
        }
    }

    public static void queueRemoveAnyWhere(List<BankUser> cola, Scanner input){
        input.nextLine();

        //Preguntar cómo funciona bien un iterador.
        if (cola.isEmpty()){
            System.out.println("No hay usuarios en cola.");
        }
        else {
            Iterator<BankUser> itUsers = cola.iterator();

            System.out.println("Ingresa tú DNI.");
            String dni = input.nextLine();

            while (itUsers.hasNext()){
                BankUser userTem = itUsers.next();
                if (userTem.getDni().equals(dni)){
                    itUsers.remove();
                }
            }
            System.out.println("Usuario borrado");
            System.out.println(" ");
            System.out.println("Lista actualizada: ");
            System.out.println(cola);
        }
    }
}
