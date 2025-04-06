package Programacion.Tema6.Vehiculos;

public class Vehicle {

    private String model;
    private int wheelsCuantity;
    private int weight;



    public Vehicle(int wheelsCuantity, int weight, int personelCapacity, String model) {
        this.wheelsCuantity = wheelsCuantity;
        this.weight = weight;
        this.model = model;
    }

    public int getWheelsCuantity() {
        return wheelsCuantity;
    }

    public void setWheelsCuantity(int wheelsCuantity) {
        this.wheelsCuantity = wheelsCuantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}