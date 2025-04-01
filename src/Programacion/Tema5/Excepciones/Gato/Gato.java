package Programacion.Tema5.Excepciones.Gato;

public class Gato {
    private int age;
    private String name;

    public Gato(int age, String name) throws Exception {
      setAge(age);
      setName(name);
    }

    public Gato(){
        this.age = 0;
        this.name = "Bob";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
     if (age < 0) {
         throw new Exception("La edad no puede ser negativa, se establecerá 0.");
     }
      this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() <= 2) {
            throw new Exception("No se admiten nombres menores de 3 letras. Su nombre será Bob");
        }
        this.name = name;
        }

    @Override
    public String toString(){
        return "Nombre: "+ this.name +" edad: "+ this.age ;
    }
}