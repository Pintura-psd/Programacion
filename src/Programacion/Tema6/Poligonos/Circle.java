package Programacion.Tema6.Poligonos;

public class Circle extends Figura2D{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return (3.1416 * (this.radius * this.radius));
    }

    @Override
    public double perimetro() {
        return (2 * 3.1416 * this.radius);
    }
}
