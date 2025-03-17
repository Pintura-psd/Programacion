package Programacion.Tema3.Parte2;

/*10.Crea un programa principal llamado Ejercicio10 donde utilices todas las
funciones creadas anteriormente dentro de MyMath. */

import java.util.Scanner;

public class Ejercicoi10T3P2 {
    public static void main (String [] args){

        Scanner input = new Scanner (System.in);
        // a variables
        int menuA = 0;
        double squareSide = 0;
        double baseRectangle = 0;
        double hightRectangle = 0;
        double radius = 0;
        // b variables
        int numPrime;
        // c variables
        int numLength;
        // d variables
        int numOdd;
        // f variables
        int numFac;
        // g variables
        int numFacRecu;
        // h variables
        int a = 0, b = 0, c = 0;
        // i variables
        int numPlus;

        String menu = " ";

        System.out.println("Introduce el ejericio que quieres hacer. ");
        System.out.println(" ");
        System.out.println("a. Calcular áreas y perimetros");
        System.out.println("b. Si es primo o no es primo ");
        System.out.println("c. Cuantas posiciones pares tiene un número");
        System.out.println("d. Cuantas posiciones impares tiene un número");
        System.out.println("f. El factorial de un número");
        System.out.println("g. El factorial de un número utiliando recursividad");
        System.out.println("h. Cuantas soluciones tiene una ecuación");
        System.out.println("i. Sumar los dígitos de un número entero");

        menu = input.nextLine();

        switch (menu){
            case "a":

                System.out.println("Introduce que quieres hacer.");
                System.out.println(" ");
                System.out.println("1. Perímetro de un cuadrado");
                System.out.println("2. Área del cuadrado");
                System.out.println("3. Perímetro de rectángulo");
                System.out.println("4. Área del rectángulo");
                System.out.println("5. Perímetro del círculo");
                System.out.println("6. Área del círculo");
                menuA = input.nextInt();

                switch (menuA) {
                    case 1:
                        //perimetro del cuadrado.
                        System.out.println("Introduce tú lado");
                        squareSide = input.nextDouble();

                        System.out.println("Tú perímetro es: "+ MyMath.squarePerimetre(squareSide));
                        break;

                    case 2:
                        //Área del cuadrado
                        System.out.println("Introduce tú lado");
                        squareSide = input.nextDouble();

                        System.out.println("Tú área es: "+ MyMath.squareArea(squareSide));
                        break;

                    case 3:
                        //Perimeetro de un rectángulo.
                        System.out.println("Introduce tú base.");
                        baseRectangle = input.nextDouble();

                        System.out.println("Introduce tú altura ");
                        hightRectangle = input.nextDouble();

                        System.out.println("Tú perímetro es: "+ MyMath.rectaglePerimetre(baseRectangle, hightRectangle));
                        break;

                    case 4:
                        //Área del rectángulo
                        System.out.println("Introduce tú base.");
                        baseRectangle = input.nextDouble();

                        System.out.println("Introduce tú altura ");
                        hightRectangle = input.nextDouble();

                        System.out.println("Tú área es: "+ MyMath.areaRectangle(baseRectangle, hightRectangle));
                        break;

                    case 5:
                        //Perímetro círculo
                        System.out.println("Introduce tú radio.");
                        radius = input.nextDouble();

                        System.out.println("Tú perímetro es: "+ MyMath.circlePerimetre(radius));
                        break;

                    case 6:
                        //Área del círculo.
                        System.out.println("Introduce tú radio.");
                        radius = input.nextDouble();

                        System.out.println("Tú área es: "+ MyMath.circleArea(radius));
                        break;
                }
                break;

            case "b":

                System.out.println("Introduce un numero y te diré si es primo.");
                System.out.println("Recuenda que un número primo ha de ser entreo y positivo.");
                numPrime = input.nextInt();

                if (numPrime>0){
                    if (MyMath.primeNumber(numPrime))
                        System.out.println(numPrime +" Es un número primo");
                    else if (MyMath.primeNumber(numPrime)==false) {
                        System.out.println(numPrime +" No es un número primo");
                    }
                }
                else {
                    System.out.println("No es un número valido");
                }
                break;

            case "c":
                System.out.println("Introduce el número del que quieras saber la longitud.");
                numLength = input.nextInt();

                System.out.println(numLength+ " Tienen: "+ MyMath.lengthNum(numLength) + " dígitos.");

                break;

            case "d":
                System.out.println("Introduce el número del cual quieras cuantos dígitos nuemros impares tiene.");
                numOdd=input.nextInt();

                System.out.println(numOdd +" Tiene "+ MyMath.oddPosition(numOdd)+ " en posición inpar.");
                break;

            case "f":
                System.out.println("Introduce el número del cual quieras saner su factorial.");
                numFac = input.nextInt();

                System.out.println("El factorias es "+ MyMath.factorial(numFac));

            case "g":
                System.out.println("Introduce un número del cual quieras saber su factorial");
                numFacRecu = input.nextInt();

                System.out.println("El factorial de "+ numFacRecu + " es "+ MyMath.recursiveFactorial(numFacRecu));
                break;

            case "h":


                System.out.println("Introduce los valores de los coeficientes de tu ecuación de segundo grado.");
                System.out.println("Introduce el valor de a");
                a = input.nextInt();
                System.out.println("Introduce el valor de b");
                b = input.nextInt();
                System.out.println("Introduce el valor de c");
                c = input.nextInt();

                System.out.println("Tú encuación tiene "+ MyMath.discriminant(a,b,c) +" soluciones posibles.");
                break;

            case "i":
                System.out.println("Introduce un número para sumar sus dígitos.");
                numPlus = input.nextInt();

                System.out.println("La suma de sus dígitos es "+ MyMath.DigitPlus(numPlus));
                break;
            }
        }
    }

