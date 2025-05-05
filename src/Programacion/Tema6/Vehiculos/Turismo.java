package Programacion.Tema6.Vehiculos;

public class Turismo extends Vehicle{
    private int personelCapacity;
    private Boolean profesional;

    public Turismo(int wheelsCuantity, int weight, int personelCapacity, String model, int personelCapacity1, Boolean profesional) {
        super(wheelsCuantity, weight, model);
        this.personelCapacity = personelCapacity1;
        this.profesional = profesional;
    }

}
