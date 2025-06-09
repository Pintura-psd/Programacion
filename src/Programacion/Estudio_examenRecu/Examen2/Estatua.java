package Programacion.Estudio_examenRecu.Examen2;

public class Estatua extends Figura{

    private String franquicia;

    public Estatua(String nombre, int anyo, boolean edicion_esp, double precio, Embalaje embalaje, String franquicia) {
        super(nombre, anyo, precio, embalaje);
        this.franquicia = franquicia;
    }

    public Estatua(String franquicia) {
        this.franquicia = franquicia;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @Override
    public String toString(){
        return  "Nombre: "+ getNombre() + " Año lanzamiento"+ getAnyo() + "Franquicia: " + this.franquicia +"Estado embalaje: "+ getEmbalaje();
    }

    @Override
    public void precioReal(){
        double precioReal;
        if (getEmbalaje().equals("PRECINTADO")){
            precioReal = getPrecio() * 2;
        }else if (getEmbalaje().equals("EMBALAJE_OG")){
            precioReal = getPrecio();
        } else {
            precioReal = getPrecio()/2;
        }
    }
}
