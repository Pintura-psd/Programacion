package Programacion.Tema3.Parte3;

import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int[] Array1 = new int[6];
        for (int i=0;  i <= 5; i++) {
            Array1[i] = i + 1;
        }

        int[] Array2 = new int[6];
        for (int i=0; i<=5; i++){
            Array2[i] = i +1;
        }


        String menu = " ";

        System.out.println("a: Imprimir Array por pantalla.");
        System.out.println("b: El número máximo del Array.");
        System.out.println("c: El número mínimo del Array");
        System.out.println("d: La media de todo el Array");
        System.out.println("f: Una función que diga si un elemento existe o no un elemento.");
        System.out.println("g: Una función que haga la suma de dos vectores.");
        System.out.println("h: Una función que haga la resta de dos vectores. ");
        System.out.println("i: Multiplicar dos arrays.");
        System.out.println("j: Invertir una array.");
        System.out.println("k: Indicar si una array es capicúa.");

        menu = input.nextLine();

        switch (menu){
            case "a":
                /*Imprimir por pantalla el array*/
                MyArray.printArray(Array1);
                break;

            case "b":
                /*El máximo de la array.*/
                System.out.println("El número máximo del array es: "+ MyArray.maximunArray(Array1));
                break;

            case "c":
                /*El mínimo del array*/
                System.out.println("El número mínimo del array es: "+ MyArray.minimunArray(Array1));
                break;

            case "d":
                /*Media de la array*/
                System.out.println("La media de la array es: "+ MyArray.averegeArray(Array1));
                break;

            case "f":
                /*Si existe el factor en la array*/
                boolean noExist = false;
                int element = 0;

                System.out.println("Introduce tú valor");
                element = input.nextInt();
                noExist = MyArray.existingFactor(Array1, element);

                if (noExist == true){
                    System.out.println("El valor NO existe en este array.");
                }
                else {
                    System.out.println("El valor SÍ existe en este array.");
                }

                /*Aquí funciona porque es una sucesión, pero si el array estuviera rellenada
                * con números arbitriarios del usuario. ¿Que puedo hacer?*/

            case "g":
                /*Suma de dos vecores*/
                System.out.println("La suma es "+ Arrays.toString(sumaVector(Array1,Array2)));
                break;

            case "h":
                /*Resta de dos vectores*/
                System.out.println("La resta es "+ Arrays.toString(restaVector(Array1,Array2)));
                break;

            case "i":
                /*multiplicar 2 arrays*/
                System.out.println("La multiplicación es "+ Arrays.toString(multVector(Array1,Array2)));
              break;

            case "j":
                /*Invertir una array*/
                System.out.println("Array original: ");
                printArray(Array1);
                System.out.println(" ");
                System.out.println("Array invertida: ");
                reverseArray(Array1);
                break;
            case "k":
                /*Indica si la array es capicua*/

                System.out.println("Introduce el tamaño de la array");
                int size;
                size = input.nextInt();
                int[] array = new int [size];
                System.out.println("Introduce los elementos en tú array.");
                for (int i = 0; i <size; i++){
                    System.out.println("Elemento "+ (i + 1)+ ": " );
                    array[i] = input.nextInt();
                }

                System.out.println("El array introducido es: ");
                printArray(array);

                if (isCapicua(array)){
                    System.out.println("Si que es capicúa.");
                }
                else  {
                    System.out.println("No es capicúa.");
                }

                break;
        }

        input.close();
    }

    /*Procedimiento imprimir Array*/
    public static void printArray  (int[] Array1) {
        System.out.println(Arrays.toString(Array1));
    }

    /*Procedimiento monstrar el numero máximo del array*/
    public static int maximunArray (int[] Array1) {
        int maximun = Array1 [0];
        for (int i = 0; i < 6; i++){
            if (Array1[i] > maximun){
                maximun = Array1[i];
            }
        }
        return maximun;
    }

    /*Procedimiento monstrar el numero mínimo del array*/
    public static int minimunArray (int[] Array1) {
        int minimun = Array1 [0];
        for (int i = 0; i < 6; i++){
            if (Array1[i] < minimun){
                minimun = Array1[i];
            }
        }
        return minimun;
    }

    /* Procedimiento para que devuelva la media del Array */
    public static int averegeArray (int[] Array1) {
        int sum = 0;
        int average = 0;

        for (int i = 0; i < Array1.length; i++){
            sum = sum + Array1[i];
        }
        average = sum / Array1.length;
        return average;
    }

    /*Procedimiento para ver si existe un elemento en nuestra array*/

    public static boolean existingFactor (int[] Array1, int element){
        boolean noExist = false;

        for (int i = 0; i < Array1.length; i++){
            if (element > Array1.length || element < 1){
                noExist = true;

            }
            else {noExist = false;}
        }

        return noExist;
    }

    /*Sumar dos vectores*/
    public static int[] sumaVector (int [] array1, int [] array2){
        if(array1.length != array2.length) {
            System.out.println("ERROR: Las arrays tienen que ser de la misma logitud.");
        }
        int sum [] = new int[array1.length];

        for (int i = 0; i < array1.length; i++ ){
            sum[i] = array1[i] + array2[i];
        }
        return sum;
    }

    /*Restar dos vectores*/
    public static int[] restaVector (int [] array1, int [] array2){
        if(array1.length != array2.length) {
            System.out.println("ERROR: Las arrays tienen que ser de la misma logitud.");
        }
        int rest [] = new int[array1.length];

        for (int i = 0; i < array1.length; i++ ){
            rest [i] = array1[i] - array2[i];
        }
        return rest;
    }

    /*Multiplicar dos vectores*/
    public static int[] multVector (int [] array1, int [] array2){
        if(array1.length != array2.length){
            System.out.println("ERROR: Las arrays son de distinta longitud.");
        }
        int mult [] = new int[array1.length];

        for (int i = 0; i < array1.length; i++){
            mult [i] = array1[i] * array2[i];
        }

        return mult;
    }

    /*Invertir una array*/
    public static long[] reverseArray (int [] Array1){

        for (int i = 0; i < Array1.length/2; i++) {
            int temp = Array1[i]; /*Aquí guardamos temporalmente los valores*/
            Array1[i] = Array1[Array1.length - 1 - i]; /*Esto es el intercambio de posición.*/
            Array1[Array1.length - 1 - i] = temp; /*Aquí guardamos los valores que teíamos en la posición original*/
        }
        System.out.println(Arrays.toString(Array1));
        return null;
    }

    /*Indicar si una array es capicua*/
    public static boolean isCapicua(int[]array){
        int left = 0; /*Índice del incio del array*/
        int right = array.length -1; /*Índice el final de array*/

        while (left < right){
            if (array[left] != array[right]){
                return false;
            }
            left++;
            right--;
            //Comprueban los valores hacia el centro;
        }
        return true; /*Solo si conciden*/
    }

}
