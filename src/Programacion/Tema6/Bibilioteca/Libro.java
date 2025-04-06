package Programacion.Tema6.Bibilioteca;

public class Libro extends Ficha{
    private String author;
    private int realeaseYear;
    private String publisher;

    public Libro(int num, String title, int realeaseYear, String publisher, String author) {
        super(num, title);
        this.author = author;
        this.realeaseYear = realeaseYear;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRealeaseYear() {
        return realeaseYear;
    }

    public void setRealeaseYear(int realeaseYear) {
        this.realeaseYear = realeaseYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString(){
        return String.format("Número: "+ getNum() +" Título: "+ getTitle() +" Autor: "+ this.author +" Año de publicación: " + this.realeaseYear +" Editorial: "+ this.publisher);
    }
}
