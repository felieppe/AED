package com.example;
import java.util.Random;

public class TablaHash {
    private static final int TAMANIO = 1000; // Tamaño de la tabla hash
    private static final int NUM_PRUEBAS = 10000; // Número de pruebas para cada factor de carga

    private static class Nodo {
        int clave;
        Nodo siguiente;

        Nodo(int clave) {
            this.clave = clave;
            this.siguiente = null;
        }
    }

    private Nodo[] tabla;
    private int numElementos;

    public TablaHash() {
        tabla = new Nodo[TAMANIO];
        numElementos = 0;
    }

    public int hash(int clave) {
        return Math.abs(clave) % TAMANIO; 
    }

    public int insertar(int clave) {
        int index = hash(clave);
        Nodo nuevo = new Nodo(clave);
        int comparaciones = 1; // Contamos la comparación inicial

        if (tabla[index] == null) {
            tabla[index] = nuevo;
        } else {
            Nodo actual = tabla[index];
            while (actual.siguiente != null) {
                comparaciones++;
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }

        numElementos++;
        return comparaciones;
    }

    public int buscar(int clave) {
        int index = hash(clave);
        Nodo actual = tabla[index];
        int comparaciones = 0;

        while (actual != null) {
            comparaciones++;
            if (actual.clave == clave) {
                return comparaciones; 
            }
            actual = actual.siguiente;
        }

        return comparaciones; 
    }

    public void limpiarTabla() {
        tabla = new Nodo[TAMANIO];
        numElementos = 0;
    }

    public static void main(String[] args) {
        TablaHash tablaHash = new TablaHash();
        Random random = new Random();

        double[] factoresCarga = {0.70, 0.75, 0.80, 0.85, 0.90, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99};
        int[] claves = new int[NUM_PRUEBAS];

        for (int i = 0; i < NUM_PRUEBAS; i++) {
            claves[i] = random.nextInt();
        }

        System.out.println("Factor de carga\tProm. Comp. Inserción\tProm. Comp. Búsqueda Exitosa\tProm. Comp. Búsqueda Sin Éxito");
        for (double factorCarga : factoresCarga) {
            tablaHash.limpiarTabla();
            int totalComparacionesInsercion = 0;
            int totalComparacionesBusquedaExitosa = 0;
            int totalComparacionesBusquedaSinExito = 0;

            int numInserciones = (int) (factorCarga * TAMANIO);
            for (int i = 0; i < numInserciones; i++) {
                totalComparacionesInsercion += tablaHash.insertar(claves[i]);
            }

            for (int i = 0; i < numInserciones; i++) {
                totalComparacionesBusquedaExitosa += tablaHash.buscar(claves[i]);
            }

            for (int i = numInserciones; i < NUM_PRUEBAS; i++) {
                totalComparacionesBusquedaSinExito += tablaHash.buscar(claves[i]);
            }

            double promedioInsercion = (double) totalComparacionesInsercion / numInserciones;
            double promedioBusquedaExitosa = (double) totalComparacionesBusquedaExitosa / numInserciones;
            double promedioBusquedaSinExito = (double) totalComparacionesBusquedaSinExito / (NUM_PRUEBAS - numInserciones);

            System.out.println(String.format("%.2f\t\t%.2f\t\t\t%.2f\t\t\t\t%.2f", factorCarga * 100, promedioInsercion, promedioBusquedaExitosa, promedioBusquedaSinExito));
        }
    }
}
