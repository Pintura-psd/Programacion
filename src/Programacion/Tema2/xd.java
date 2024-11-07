package Programacion.Tema2;

public class xd {
    public static void main(String[] args) {
    int suma = 0;

    // Bucle para recorrer los números entre 1 y 1000
    for (int i = 2; i <= 1000; i += 2) {  // Incremento de 2 para ir solo a números pares
        suma += i;
    }

    // Mostrar el resultado de la suma
    System.out.println("La suma de todos los números pares entre 1 y 1000 es: " + suma);
}
}
