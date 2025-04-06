package Programacion.Tema6.Poligonos;

public class Rectangle extends Figura2D{
    private double side1;
    private double side2;

    public Rectangle(double side1) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public double area() {

        return this.side1 * this.side2;
    }

    @Override
    public double perimetro() {
        return (this.side1 * 2) + (this.side2 * 2) ;
    }
}
