package Programacion.Tema6.Vehiculos;

public class Truck extends Vehicle{

    private int maximunCarryWight;
    private Boolean dangerousCarry;

    public Truck(int wheelsCuantity, int weight, int personelCapacity, String model) {
        super(wheelsCuantity, weight, personelCapacity, model);
    }

    public int getMaximunCarryWight() {
        return maximunCarryWight;
    }

    public void setMaximunCarryWight(int maximunCarryWight) {
        this.maximunCarryWight = maximunCarryWight;
    }

    public Boolean getDangerousCarry() {
        return dangerousCarry;
    }

    public void setDangerousCarry(Boolean dangerousCarry) {
        this.dangerousCarry = dangerousCarry;
    }
}
