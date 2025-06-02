package Programacion.Estudio_examenRecu.Ejercicio1;

public class Estatua extends Figura{

    private String franquicia;

    public Estatua(String nombre, int releaseYear, double precioBase, boolean precintada, boolean embalajeOG, String franquicia) {
        super(nombre, releaseYear, precioBase, precintada, embalajeOG);
        this.franquicia = franquicia;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public String toString() {
        return "Nombre: "+ this.getNombre() + " Franquicia: "+ this.franquicia +" Año de lanzamiento: "+ getReleaseYear() +" Precintada: "+ isPrecintada() +" Embalaje original: "+ isEmbalajeOG() +" Precio Base: "+ getPrecioBase()+ " Precio Final: "+ calcularPrecio();
    }

    @Override
    public double calcularPrecio() {
        double precioReal = 0.0;

        if (isPrecintada()){
            precioReal = getPrecioBase() * 2;

        } else if (!isPrecintada()){
            if (isEmbalajeOG()){
                precioReal = getPrecioBase();
            }
            else {
                precioReal = getPrecioBase() / 2;
            }
        }
        return precioReal;
    }
}
