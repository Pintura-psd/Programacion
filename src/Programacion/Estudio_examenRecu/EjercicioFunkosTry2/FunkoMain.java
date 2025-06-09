package Programacion.Estudio_examenRecu.EjercicioFunkosTry2;

import java.util.ArrayList;
import java.util.Scanner;
//Ejercicio completado sin Serializar en 1:23 minutos
//Ejercicio con serializacion en 1:57. Cuidado con escribir los Path mal o hacer el OutpurStream de manera desordenada.
//Probar a hacer los modelos por Enum

public class FunkoMain {
    public static void main(String[] args) {
        int selectMenu = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Funko> listaFunkos = FunkosFunciones.leerCSV();

        while (selectMenu == 0){
            FunkosFunciones.menu();
            System.out.println("Introduce la opción que deseas: ");
            try {
                selectMenu = input.nextInt();
            }catch (Exception e){
                System.out.println("Introduce el dato correctamente. "+ e.getMessage());
            }

            switch (selectMenu){
                case 1:
                    System.out.println("Añadir Funko");
                    FunkosFunciones.addFunko(listaFunkos,input);
                    selectMenu=0;
                    break;
                case 2:
                    System.out.println("Eliminar Funko");
                    FunkosFunciones.eliminarFunko(listaFunkos,input);
                    selectMenu=0;
                    break;
                case 3:
                    System.out.println("Motrando funkos... ");
                    FunkosFunciones.mostrarFunkos(listaFunkos);
                    selectMenu=0;
                    break;
                case 4:
                    System.out.println("El funko más caro: ");
                    FunkosFunciones.masCaro(listaFunkos);
                    selectMenu=0;
                    break;
                case 5:
                    System.out.println("Precio medio de los Funkos: ");
                    FunkosFunciones.averageFunkos(listaFunkos);
                    selectMenu=0;
                    break;
                case 6:
                    System.out.println("Agrupar por modelo: ");
                    FunkosFunciones.mostrarPorModelo(listaFunkos,input);
                    selectMenu=0;
                    break;
                case 7:
                    System.out.println("Funkos del año 2023");
                    FunkosFunciones.mostrar2023(listaFunkos);
                    selectMenu = 0;
                   break;
                case 8:
                    FunkosFunciones.serializacion(listaFunkos);
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }
}
