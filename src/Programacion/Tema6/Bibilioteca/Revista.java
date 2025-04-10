package Programacion.Tema6.Bibilioteca;

public class Revista extends Ficha{
    private int publishNum;
    private int realeaseYear;

    public Revista(int num, String title, int publishNum, int yearReleash) {
        super(num, title);

        this.realeaseYear = yearReleash;
        this.publishNum = publishNum;
    }

    public int getPublishNum() {
        return publishNum;
    }

    public void setPublishNum(int publishNum) {
        this.publishNum = publishNum;
    }

    public int getRealeaseYear() {
        return realeaseYear;
    }

    public void setRealeaseYear(int realeaseYear) {
        this.realeaseYear = realeaseYear;
    }

    @Override
    public String toString(){
        return String.format("Número: "+ getNum() +" Título: "+ getTitle() +" numero de publicación: "+ this.publishNum +" Año de publicación: " + this.realeaseYear);
    }
}
