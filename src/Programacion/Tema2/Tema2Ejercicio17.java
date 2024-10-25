package Programacion.Tema2;

import java.util.Scanner;

public class Tema2Ejercicio17 {
    public static void main (String [] arg){
        /* Realiza un programa que si lee por consola 0, muestra la superficie y el
perímetro de un cuadrado; si lee 1, muestra la superficie y el perímetro
de un rectángulo; y si lee 2, muestra la superficie de un triángulo. Todos
los valores se leen por consola. Si no es una opción válida se indica por consola que ha habido un error
Intenta no usar break*/

    double square;
    double psquare;
    double rectangle;
    double prectangle;
    double triangle;
    double ptriangle;
    double side1;
    double side2;
    double base;
    double hight;
    int aux;
    Scanner input=new Scanner(System.in);

    System.out.println("Escribe 0 si quieres el área y el perímetro de una cuadrado, 1 si del rectángulo o 2 si es del triángulo.");
    aux=input.nextInt();

    while ((aux !=0 && aux!=1 && aux!=2)){
        System.out.println("Estos valores están mal. Introduce vaolres del 0 al 2");
        aux=input.nextInt();
    }

    if (aux==0) {
        System.out.println("Introduce tu lado");
        base=input.nextDouble();
        square=base*base;
        psquare=base*4;
        System.out.println("Tú área es "+ square +" y tú perímetro"+ psquare);
    } else if (aux==1) {
        System.out.println("Introduce tu base y tú altura");
        base=input.nextDouble();
        hight=input.nextDouble();
        rectangle=base*hight;
        prectangle=(base*2)+(hight*2);
        System.out.println("Tú area es "+ rectangle +" y tú perímetro es "+ prectangle);
    } else if (aux==2) {
        /*Esto se podría plantear con pitágoras para que con solo un lado podamos saber el prímetro
         pero ahora mismo no me da tiempo a resolverlo*/
        System.out.println("Introduce tu base y tú altura");
        base=input.nextDouble();
        hight=input.nextDouble();
        System.out.println("Necesito saber las dimensiones de los otros dos lados.");
        side1=input.nextDouble();
        side2=input.nextDouble();
        triangle=(base*hight)/2;
        ptriangle=base+side1+side2;
        System.out.println("Tú área es "+ triangle +" y tu perímetro "+ ptriangle);
    } else {
        System.out.println("Esto no es una de las tres figuras platónicas que te he pedido.");
    }

input.close();
    }
}
