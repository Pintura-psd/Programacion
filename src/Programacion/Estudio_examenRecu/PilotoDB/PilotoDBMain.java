package Programacion.Estudio_examenRecu.PilotoDB;

import java.util.ArrayList;
import java.util.Scanner;

public class PilotoDBMain {
    public static void main(String[] args) {
        String[] credenciales = OperacionesPiloto.cargarCredenciales();
        int slectMenu = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Piloto> listapilotos = new ArrayList<>();

        while (slectMenu == 0){
            OperacionesPiloto.menu();
            slectMenu = input.nextInt();

            switch (slectMenu){
                case 1:
                    OperacionesPiloto.createPilot(listapilotos,input);
                    slectMenu = 0;
                    break;
                case 2:
                    break;
            }
        }
    }
}
