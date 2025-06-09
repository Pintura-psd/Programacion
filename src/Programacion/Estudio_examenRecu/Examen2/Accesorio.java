package Programacion.Estudio_examenRecu.Examen2;

public class Accesorio {

    private String nombre;
    private String material;
    private String descripcion;

    public Accesorio(String nombre, String material, String descripcion) {
        this.nombre = nombre;
        this.material = material;
        this.descripcion = descripcion;
    }

    public Accesorio() {
        this.nombre = "";
        this.material = "";
        this.descripcion = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return "Nombre: "+ this.nombre +" Material: "+ this.material + " Descripción: "+ this.descripcion;
    }
}
