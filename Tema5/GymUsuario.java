package Programacion.Tema5;

public class GymUsuario {
    private  String name;
    private  int age;

    public GymUsuario(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Nombre: "+ name +"  Edad: "+ age;
    }
}
