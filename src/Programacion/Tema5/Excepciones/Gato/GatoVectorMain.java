package Programacion.Tema5.Excepciones.Gato;

import java.util.*;

public class GatoVectorMain {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            ArrayList<Gato> vectorGatos = new ArrayList<>();

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
            System.out.println("");
            System.out.println("Lista de gatos");
            System.out.println("");
            while (vectorGatos.size() < 4){
                try {
                    System.out.println("Introduce el nombre que quieres darle al gato: ");
                    name = input.nextLine();
                    System.out.println("Introduce la edad que tiene el gatete: ");
                    age = input.nextInt();

                    Gato temporalyCat = new Gato (age, name);
                    vectorGatos.add(temporalyCat);
                    name = "";
                    age = 0;
                    input.nextLine();
                }
                //sin invierto el orden de los catch no sé porque no me compila
                catch (InputMismatchException e){
                    System.out.println("No el valor correcto, porfavor introduce numeros enteros.");
                    input.nextLine(); //limpio buffer
                }
                catch (Exception e){
                    System.out.println("Valores incorrectos en la lista. "+ e.getMessage());
                    //Con el e.getMessage llamamos al mensage de dónde se produce el error si hemos estructurado bien
                    //nuestro objeto.
                }
            }

            System.out.println("Gatos listados");
           //Preguntar los for each
            /*  for (Gato cat : vectorGatos) {
                System.out.println(vectorGatos);
            } */
            System.out.println(vectorGatos);

        }
}
