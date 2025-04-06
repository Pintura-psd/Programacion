package Programacion.Tema6.Bibilioteca;

public class Revista extends Libro{
    private int publishNum;

    //Preguntar si puedo eliminar atributos del padre y como funciona exactamente el consturctor.
    public Revista(int num, String title, int realeaseYear, String publisher, String author) {
        super(num, title, realeaseYear, publisher, author);
    }
}
