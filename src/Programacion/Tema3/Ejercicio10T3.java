package Programacion.Tema3;
/*10)Escribe un programa que muestre un menú con 9 opciones (si tus
ejercicios son modulares no debería costarte demasiado):
a) Muestra el signo de un número introducido por el usuario.
b) Indica si el usuario es mayor de edad o no.
c) Calcula el área y perímetro de un círculo.
d) Conversor de euros a dólares y de dólares a euros.
e) Mostrar tabla de multiplicar de un número.
f) Mostrar tablas de multiplicar del 1 al 10.
g) Comprobador de números primos.
h) Comprobador de fechas.
i) Dibujar triángulos.*/

import java.util.Scanner;

public class Ejercicio10T3 {
    public static void main (String [] args){

  String menu = " ";
  Scanner input = new Scanner(System.in);
        int num1;
        int result = 0;
        int age = 0;
        boolean mas18;
        double radius=0;
        double area;
        double perimetre;
        boolean validRadius;;
        String converter = " ";
        double euros=0;
        double dollars=0;
        double dollarsConversion=0;
        double eurosConversion=0;
        int num=0;
        int numPrime=1;
        boolean prime;
        int month;
        int day;
        int year;
        char symbol;
        int hightLines;


        System.out.println("Introduce una letra para seleccionar el ejercicio.");
        System.out.println(" ");
        menu = input.next();

//Preguntar cómo hace para que el switch acepte cualquier tipo de caso de letra.
        switch (menu){
            case "a":
                System.out.println("Muestra el signo de un número introducido por el usuario.");

                System.out.println("Te diré con un 1 si un número es postivo -1 si es negativo y 0 si es neutro.");
                System.out.println("Introduce un número: ");
                num1 = input.nextInt();


                Funciones.numberSing(num1);

                if (result == 1) {
                    System.out.println("El número es positivo.");
                }
                else if (result == -1) {
                    System.out.println("El número es negativo.");
                }
                else {
                    System.out.println("El número es 0.");
                }

            case "b":
                System.out.println("Indica si el usuario es mayor de edad o no.");

                System.out.println("Introduce la edad para saber si es mayor de edad o no.");
                System.out.println(" ");

                age = input.nextInt();

                mas18 = Funciones.isAdult(age);

                if (mas18 == true){
                    System.out.println("Es mayor de edad.");
                }
                else {
                    System.out.println( "No es mayor de edad.");
                }
            case "c":
                System.out.println("Calcula el área y perímetro de un círculo.");

                System.out.println("Introduce el valor del radio.");
                radius = input.nextInt();

                validRadius = Funciones.validRadius(radius);
                if (validRadius == true){
                    perimetre = Funciones.calculateCirclePerimeter(radius);
                    System.out.println("Tú perímetro es: "+ perimetre);

                    area = Funciones.calculateCircleArea(radius);
                    System.out.println("Tú área es: "+ area);
                }
            case "d":
                System.out.println("Conversor de euros a dólares y de dólares a euros.");

                Funciones.showMenu();

                converter = input.next();

                switch (converter){
                    case "Dólares":
                        System.out.println("Introduce la cantidad de Dólares que quieres pasar a Euros.");
                        dollars = input.nextDouble();
                        dollarsConversion = Funciones.dollar2euro(dollars);
                        System.out.println("Tienes "+ dollarsConversion +" €");
                        break;
                    case "Euros":
                        System.out.println("Introduce la cantidad de Euros que quieres pasar a Dólares");
                        euros = input.nextDouble();
                        eurosConversion = Funciones.euro2dollar(euros);
                        System.out.println("Tienes "+ eurosConversion +" $");
                        break;
                }
            case "f":
                System.out.println("Mostrar tablas de multiplicar del 1 al 10.");

                System.out.println("Introduce un múmero del 1 al 10 y te muestro su tabla de multiplicar.");
                num= input.nextInt();

                System.out.println("Esta es tu tabla de multiplicar.");
                System.out.println(" ");

                Funciones.multiplyTable(num);
            case "g":
                System.out.println("Comprobador de números primos.");

                System.out.println("Introduce un numero positivo y te diré si es primo o no.");

                while (numPrime>0) {
                    num = input.nextInt();
                    prime = Funciones.primeNumber(num);

                    if (prime == true) {
                        System.out.println("Es un número primo.");
                    } else {
                        System.out.println("No es un número primo.");
                    }
                }

                System.out.println("Hasta la siguiente sesión.");

            case "h":
                System.out.println("Comprobador de fechas.");

                System.out.println("Introduce el mes con números.");
                month = input.nextInt();
                System.out.println("Introduce el día en números");
                day = input.nextInt();
                System.out.println("Introduce el año en números");
                year = input.nextInt();

                Funciones.correctDate(month, day, year);

            case "i":
                System.out.println("Dibujar triángulos");

                System.out.println("Vamos a construir un triángulo.");
                System.out.println(" ");
                System.out.println("Introduce el carácter con el con el cual contruiremos el triángulo: ");
                symbol = input.next().charAt(0);

                System.out.println("Ahora dime cuantas líneas quieres que formen el triángulo.");
                hightLines = input.nextInt();

                Funciones.chactPiramid(hightLines, symbol);
        }
        }
    }
