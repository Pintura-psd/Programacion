package Programacion.Tema6.Vehiculos;

public class motorbike extends Vehicle {

    private int cubicCentimetres;
    private Boolean mandatoryCarnet = true;

    public motorbike(int wheelsCuantity, int weight, int personelCapacity, String model) {
        super(wheelsCuantity, weight, personelCapacity, model);
        if (cubicCentimetres < 125){
            mandatoryCarnet = false;
        }
    }

    public int getCubicCentimetres() {
        return cubicCentimetres;
    }

    public void setCubicCentimetres(int cubicCentimetres) {
        this.cubicCentimetres = cubicCentimetres;
    }

    public Boolean getMandatoryCarnet() {
        return mandatoryCarnet;
    }

    public void setMandatoryCarnet(Boolean mandatoryCarnet) {
        this.mandatoryCarnet = mandatoryCarnet;
        if (cubicCentimetres < 125){
            this.mandatoryCarnet = false;
        }
    }
}
