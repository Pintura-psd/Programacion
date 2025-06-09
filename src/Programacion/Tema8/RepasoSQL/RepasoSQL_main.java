package Programacion.Tema8.RepasoSQL;

import Programacion.Estudio_examenRecu.HowartsRepasodb.HogwartsRecu1_operaciones;

public class RepasoSQL_main {
    public static void main(String[] args) {
        String[] credenciales=  RepasoSQL_Operaciones.cargarCredenciales();

       /* //Nombres y apellidos
        System.out.println("Nombres y apellidos de los profesores: ");
        RepasoSQL_Operaciones.nombresyapellidosProfesores(credenciales);*/

       /* //Nacidos después de 1980
        System.out.println("Nacidos depués de 1980: ");
        RepasoSQL_Operaciones.nacidosDespues1980(credenciales);*/

        //Ordenar con ORDER BY
       //System.out.println("Ordenar Ascendente: ");
      //RepasoSQL_Operaciones.nombresyapellidosAscend(credenciales);

        //Distinguir por año
        System.out.println("Distinguir por año: ");
        RepasoSQL_Operaciones.DistinguirPorAnyo1982(credenciales);

        //Nombres que empiecen por la letra A
        System.out.println("Nombres que empiecen por la letra A: ");
        RepasoSQL_Operaciones.startsF(credenciales);

        //Mostrar alumnos que tengan mascota
        System.out.println("Alumnos que tienen máscota: ");
        RepasoSQL_Operaciones.alumnosQueTienenMascota(credenciales);
    }
}
