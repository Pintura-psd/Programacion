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
}
