package Programacion.Tema6.Vehiculos;

public class Truck extends Vehicle{

    private int maximunCarryWight;
    private Boolean dangerousCarry;

    public Truck(int wheelsCuantity, int weight, String model, int maximunCarryWight, boolean dangerousCarry1) {
        super(wheelsCuantity, weight, model);
        this.maximunCarryWight= maximunCarryWight;
        this.dangerousCarry= dangerousCarry1;
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
