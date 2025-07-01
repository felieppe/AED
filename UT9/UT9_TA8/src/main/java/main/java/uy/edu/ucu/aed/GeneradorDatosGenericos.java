package main.java.uy.edu.ucu.aed;

import java.util.Random;

public class GeneradorDatosGenericos {
    
    public int[] generarDatosAscendentes(int tamanio) {
        int[] datos = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            datos[i] = i;
        }
        return datos;
    }

    public int[] generarDatosDescendentes(int tamanio) {
        int[] datos = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            datos[i] = tamanio - i;
        }
        return datos;
    }

    public int[] generarDatosAleatorios(int tamanio) {
        int[] datos = new int[tamanio];
        Random rand = new Random();
        for (int i = 0; i < tamanio; i++) {
            datos[i] = rand.nextInt(tamanio);
        }
        return datos;
    }
}
