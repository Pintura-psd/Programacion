package Programacion.Tema6.Ataques.AtaqueBase;

public interface IAtaque {
    /*Cuando indetificamos los elementos con el tipo de dato, hay que devolver los metodos con el
     * dato respectivo*/

    void lanzar();
    int coste();
    int daño();
}
