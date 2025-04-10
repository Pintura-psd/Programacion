package Programacion.Tema6.Bibilioteca;

public class DVD extends Ficha{
    private String director;
    private int realeaseYear;
    private String gender;

    public DVD(int num, String title, String director, String gender) {
        super(num, title);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRealeaseYear() {
        return realeaseYear;
    }

    public void setRealeaseYear(int realeaseYear) {
        this.realeaseYear = realeaseYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return String.format("Número: "+ getNum() +" Título: "+ getTitle() +" Director: "+ this.director +" Año de publicación: " + this.realeaseYear + " género: " + this.gender);
    }
}
