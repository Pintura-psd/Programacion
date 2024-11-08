package Programacion.Tema2;

import java.util.Scanner;

public class Tema2ejercicio23 {
public static void main (String []arg){
    /*23. Lee por teclado varios números enteros positivos hasta recibir un
número negativo. El programa mostrará la media de los números (sin
tener en cuenta el negativo).*/

    int num;
    int suma=0;
    int aux;
    int count;
    int media;
    Scanner input= new Scanner(System.in);
    aux=0;
    count=0;

    System.out.println("Introduce números enteros. Cuando introduzcas el negativo te daré la media de los positivos");
    num=input.nextInt();

    while (num>=0 ){
        suma= suma +num;
        //aux=num;
        System.out.println("Introduce un otro número positivo o uno negativo para acabar de contar ");
        num=input.nextInt();
        count++;
    }
    if (num<0){

        media= suma/count;
        System.out.println(" Tú media es "+ media );

    }
    input.close();
    }
}
