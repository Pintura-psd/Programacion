package Programacion.Tema6.Poligonos;

public class Triangle extends Figura2D {
    private double base;
    private double height;
    private double side1;
    private double side2;

    public Triangle(double base, double height, double side1, double side2) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }


    @Override
    public double area() {
        return (base * height) / 2;
    }

    @Override
    public double perimetro() {
        double hipotenuse;
        hipotenuse = Math.sqrt((this.side1 * this.side1) * (this.side2 * this.side2));
        return this.side1 + this.side2 + hipotenuse;
    }
}
