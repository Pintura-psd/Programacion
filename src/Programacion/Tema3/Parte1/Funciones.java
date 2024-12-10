package Programacion.Tema3.Parte1;


import java.util.Scanner;

public class Funciones {

    //Positivo o negativo
    public static int numberSing(int numFun){
        if (numFun>0){
            return 1;
        }
        else if (numFun<0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    //Mayoría de edad.
    public static boolean isAdult(int ageFun){

        if (ageFun>18){
            return true;
        }
        else {
            return false;
        }
    }

    //Radio válido.
    public static boolean validRadius(double radiusFun ){
        if (radiusFun>0){
            System.out.println("El radio es válido.");
            return true;
        }
        else {
            System.out.println("El radio no es válido.");
            return false;
        }
    }

    //Calcular el perímetro de la circuferencia.
    public static  double calculateCirclePerimeter(double radiusFun){
        double perimetre=0;
        perimetre= 2*3.14159* radiusFun;
        return perimetre;
    }

    //Calcular el área de la circunferencia.
    public static double calculateCircleArea(double radiusFun){
        double area=0;
        area = 3.14159*(radiusFun*radiusFun);
        return area;
    }

    //Enseñar menú.
    public static void showMenu(){
        System.out.println("Si quieres pasar a de Euros a Dólares escribe Dólares.");
        System.out.println("Si quieres pasar a Dólares a Euros escribe Euros.");
    }

    //Euros a dólares.
    public static double euro2dollar (double eurosFun){
        eurosFun = eurosFun * 0.95;
        return eurosFun;
    }

    //Dólares a euros.
    public static double dollar2euro (double dollarsfun){
        dollarsfun = dollarsfun * 1.06;
        return dollarsfun;
    }

    //Tabla de multiplicar
    public static void multiplyTable (int numFun){
        for (int i= 1; i<=10; i++ ) {
            System.out.println(numFun+" * "+ i+" = "+ (i*numFun));
        }
    }

    //Funcion de números primos
    public static boolean primeNumber (int numFun){
        /*No sé hasta qué punto es beuno tener varios returns en una función.
        * Preguntar como resolver usando un solo return.*/
        if (numFun<=1){
            return false;
        }
        for (int i= 2; i < numFun; i++ ){
            if (numFun % i==0){
                return false;
            }
        }
        return true;
    }

//Si la fecha es correcta.
    public static void correctDate(int month, int day, int year) {
        Scanner input = new Scanner(System.in);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day <= 31 && day > 0) {

                    System.out.println("Es " + day + " mes " + month + " año " + year);
                } else {
                    System.out.println("No es un día válido");
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if (day <= 30 && day > 0) {

                    System.out.println("Es " + day + " mes " + month + " año " + year);
                } else {
                    System.out.println("No es un día válido");
                }
                break;
            case 2:
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    if (day <= 29 && day > 0) {

                        System.out.println("Es " + day + " mes " + month + " año " + year);
                    } else {
                        System.out.println("No es un día válido");
                    }
                } else if (day < 28 && day > 0) {

                    System.out.println("Es " + day + " mes " + month + " año " + year);
                } else {
                    System.out.println("No es un día válido");
                }
                break;

            default:
                System.out.println("No es una fecha válida.");
        }
        input.close();
    }

// Para hacer una pirámide.
    public static void chactPiramid (int hightFun, char symbolFun){

        for (int i = 1; i <= hightFun; i++){

            characterXtimes(' ',hightFun*2-i-1);
            characterXtimes(symbolFun, i*2-1);
            characterXtimes(' ', hightFun*2-i-1);
            System.out.println();
        }
    }

//Imprimir un carácter X veces
    public static void characterXtimes (char characterFun, int timesFun ){
        for (int i = 0; i < timesFun; i++){
            System.out.print(characterFun);
        }
    }


}

