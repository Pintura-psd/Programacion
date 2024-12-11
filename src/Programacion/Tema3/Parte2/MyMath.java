package Programacion.Tema3.Parte2;

public class MyMath {

    //Perímetro del cuadrado.
    public static double squarePerimetre (double side){
        double squarePerimetre = side * 4;
        return squarePerimetre;
    }

    //Área del cuadrado.
    public static double squareArea (double side) {
        double squareArea = side * side;
        return squareArea;
    }

    //Perimetro del rectágulo.
    public static double rectaglePerimetre (double base, double hight) {
        double rectanglePerimetre = base * 2 + hight * 2;
        return rectanglePerimetre;
    }

    //Área del rectángulo.
    public static double areaRectangle (double base, double hight) {
        double areaRectangle = base * hight;
        return areaRectangle;
    }

    //Perímetro del crículo.
    public static double circlePerimetre (double radius){
        double circlePerimetre = (radius * 2) * 3.14159 ;
        return circlePerimetre;
    }

    //Área del círculo.
    public static double circleArea (double radius){
        double circleArea = 3.14159 * radius * radius;
        return circleArea;
    }

    //Funcion de números primos
    public static boolean primeNumber (int numFun){
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

    //Saber cuantos dígitos tiene un número entero.
    public static int lengthNum (int num) {
        return Integer.toString(num).length();
    }

    //Para saber las posiciones impares de un número
    public static int pairPosition (int num){

        int cuantity = MyMath.lengthNum(num);

        return cuantity/2;
    }

    //Saber cuentos dígitos en posición inpar tiene un número entero.
    public static int oddPosition (int num) {
        int cuantity = MyMath.lengthNum(num);

        if (cuantity % 2 == 0) {
            cuantity = (cuantity / 2);

        } else if (cuantity % 2 != 0) {

           cuantity = ((cuantity / 2) + 1);
        }

        return cuantity;
    }

    //El factorial de un número
    public static int factorial (int num){
        int factorial = 1;

        //inicio en 1 porque los factoriales de 0 y 1 son ellos mismos.

        for (int i = 2; i <= num; ++i){
            factorial = factorial * i;
        }
        return factorial;

    }

    //Factorial con recursividad.
    public static int recursiveFactorial (int num){

        //Esto es la base, de nuevo está parte evitar el problema de 0 o 1.
        if (num == 0 || num == 1) {
            return 1;
        }

        //Esto es la recursividad
        return  num * recursiveFactorial(num - 1); /*El -1 evita la recursión infinita parece, es cómo cuando
        pongo ;i <=  num; en el modelo anterior, es lo que me establece la salida del bucle.*/

        /*¿Haciendo el factorial a "mano" cómo en el caso anterior habría también recursividad?
        No me queda claro*/
    }

    //Sacar el discriminante de una ecuación.

    public static int discriminant (int a, int b, int c){

        int discriminant = b * b - 4 * a * c; /* Parece que esto es una fórmula que calcula algo
        de matemáticas que desconozco.*/

        if (discriminant>0){
            return 2;
        }
        else if (discriminant == 0) {
            return 1;
        }
        else {return 0;}

        /*Vale aquí la idea es que el enunciado me da 3 posbilidades y parece que las
        * ecuaciones tienen su propia fórmula para saber el número de opciones. Al saber esto
        * podemos darle a la máquina las el resultado de esta fórmula con un if a 3 retuns de la función*/

    }

    //Tomar los dígitos de un número y sumarlos.

    public static int DigitPlus (int num){
        num = Math.abs(num); /*Esta vaina me ayuda a pasar tomar los números absolutos.
        Es decir, sin preocuparme de si son negativos o no.*/

        int sum = 0;
        int remainder = 0;
        while (num>0){

            remainder = num % 10;
            sum = sum + remainder;
            num = num/10;
            remainder = 0;
        }
        return sum;

        //Esto me está funcionando porque uso enteros, me preguntan con dobles y creo que no se por dónde emepzar.
    }
}
