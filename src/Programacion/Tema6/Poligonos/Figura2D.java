package Programacion.Tema6.Poligonos;

public abstract class Figura2D {
    public abstract double area ();
    public abstract double perimetro();

    @Override
    public String toString () {
        return "Area: "+ area() +", Perímetros: "+ perimetro();
    }
}
