package Programacion.Tema2;

public class Tema2Ejercicio21 {
    /*21. Escribe un programa que calcula la suma de todos los números pares
entre 1 y 1000 y la muestra por consola.*/
    public static void main(String[]arg){

        int suma=0;

      for (int i=2; i <=1000; i+=2 ) {
          suma += i;
      }

        System.out.println("La suma de todos los números pares es de:"+ suma);
    }
}
