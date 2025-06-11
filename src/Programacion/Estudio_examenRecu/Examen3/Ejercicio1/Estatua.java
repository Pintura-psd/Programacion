package Programacion.Estudio_examenRecu.Examen3.Ejercicio1;

public class Estatua extends Figura{
    private String Faquicia;

    public Estatua(String nombre, int year, double precio, Embalaje estado, String faquicia) {
        super(nombre, year, precio, estado);
        Faquicia = faquicia;
    }

    public Estatua(String faquicia) {
        Faquicia = faquicia;
    }

    public Estatua() {
        Faquicia = "";
    }

    public String getFaquicia() {
        return Faquicia;
    }

    public void setFaquicia(String faquicia) {
        Faquicia = faquicia;
    }

    @Override
    public String toString(){
        return "Nombre: "+ getNombre() +" Año lanzamiento"+ getYear() + " Franquicia: "+ this.Faquicia + " Precio base: "+ getPrecio() + " Estado caja: " + getEstado();
    }

    @Override
    public void precioReal(){
        double precioReal = 0.0;
        if (getEstado().equals("PRECINTADO")){
            precioReal = getPrecio() * 2;
        } else if (getEstado().equals("PACK_OG")) {
            precioReal = getPrecio();
        } else {
            precioReal = getPrecio()/2;
        }
    }
}
