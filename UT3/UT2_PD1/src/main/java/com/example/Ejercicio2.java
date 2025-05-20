package com.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {
    
    public static void bubbleSort(int[] arreglo, Contador contador) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                contador.incrementar(); // Incrementamos el contador en cada comparación
                if (arreglo[j] < arreglo[j - 1]) {
                    // Intercambio de elementos
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j - 1];
                    arreglo[j - 1] = temp;
                }
            }
        }
    }
    
    public static int[] leerNumerosDeArchivo(String nombreArchivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nombreArchivo));
        int N = scanner.nextInt(); // Leer el primer número que indica la cantidad de elementos
        int[] numeros = new int[N];
        for (int i = 0; i < N; i++) {
            numeros[i] = scanner.nextInt(); // Leer cada número y agregarlo al arreglo
        }
        scanner.close();
        return numeros;
    }

    public static void main(String[] args) {
        try {
            int[] arreglo = leerNumerosDeArchivo("C:\\Users\\stuff\\OneDrive\\Escritorio\\Entrega UT3\\UT3_PD6\\numeros.txt");
            Contador contador = new Contador();
            bubbleSort(arreglo, contador);
            System.out.println("Largo N: " + arreglo.length);
            System.out.println("Contador de Comparaciones: " + contador.getConteo());
            System.out.println("Primera Posición: " + arreglo[0]);
            System.out.println("Última Posición: " + arreglo[arreglo.length - 1]);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }
}

class Contador {
    private int conteo = 0;
    
    public void incrementar() {
        conteo++;
    }
    
    public int getConteo() {
        return conteo;
    }
}

/*
La complejidad de tiempo del algoritmo es O(n^2), ya que el algoritmo tiene dos ciclos anidados, 
lo que indica que el tiempo de ejecución aumenta cuadráticamente con el tamaño del arreglo de entrada.
*/