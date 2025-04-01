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
            System.out.println(cat1);
            System.out.println(cat2);

            try {
                //Gatos mal generados, nombre.
                Gato cat3 = new Gato(2,"Bo");
                System.out.println(cat3);

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

            //Pruegas de setters.
            try {
                Gato cat5 = new Gato(6,"Michu");
                cat5.setName("Mi");
            }
            catch (Exception e){
                System.out.println("Excepcion de setter: "+ e.getMessage());
            }
            try {
                Gato cat6 = new Gato(2,"Piponazo");
                cat6.setAge(-1);
            }
            catch (Exception e){
                System.out.println("Exception de setter: " + e.getMessage());
            }
        }
        catch (Exception e){
            System.out.println("Técnicamente no debería salir esto, si el gato esta bien construído" + e.getMessage());
        }
    }
}
