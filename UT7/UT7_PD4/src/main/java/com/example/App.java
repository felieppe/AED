package com.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        TGrafoDirigido grafo = new TGrafoDirigido();
        try {
            grafo.cargarAeropuertos("src/main/java/com/example/aeropuertos.txt");
            grafo.cargarConexiones("src/main/java/com/example/conexiones.txt");

            System.out.println("Aeropuertos y conexiones cargados.");

            TCaminos caminos = grafo.todosLosCaminos("Montevideo", "San_Pablo");

            if (caminos != null && !caminos.getCaminos().isEmpty()) {
                for (TCamino camino : caminos.getCaminos()) {
                    System.out.println("Camino con costo total: " + camino.getCostoTotal());
                    for (TAdyacencia adyacencia : camino.getAdyacencias()) {
                        System.out.print(adyacencia.getDestino().getEtiqueta() + " -> ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No se encontraron caminos.");
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
