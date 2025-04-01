package Programacion.Tema5.Excepciones.Gato;

import java.util.Objects;
import java.util.Scanner;

public class GatoMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age = 0;
        String name = "";

        try{
            Gato cat1 = new Gato(0,"Bob");
            Gato cat2 = new Gato(0,"Fer");

            try {
                //Gatos mal generados, nombre.
                Gato cat3 = new Gato(2,"Bo");
            }
            catch (Exception e){
                System.out.println("Exception: "+ e.getMessage());
            }
            try {
                //Gatos mal gnerados, edad.
                Gato cat4 = new Gato(-2,"Luis");
            }
            catch (Exception e){
                System.out.println("Excepción: "+ e.getMessage());
            }
        }
        catch (Exception e){
            System.out.println("Técnicamente no debería salir esto, el gato esta bien constrído" + e.getMessage());
        }
    }
}
