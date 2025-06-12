
package com.example;

import java.util.List;

public class VueleSeguro {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.readAeropuertos("ut7_pd3\\src\\main\\java\\com\\example\\aeropuertos.txt");

        grafo.readConexiones("ut7_pd3\\src\\main\\java\\com\\example\\conexiones.txt");

        System.out.println("Matriz de conexiones:");
        grafo.mostrarMatrizConexiones();

        System.out.println("\nCalculando costos mínimos...");
        grafo.calcularCostosMinimos();

        System.out.println("\nCosto mínimo de Montevideo a Rio de Janeiro: " + grafo.obtenerCosto("Montevideo", "Rio de Janeiro"));
        System.out.println("Costo mínimo de Montevideo a Curitiba: " + grafo.obtenerCosto("Montevideo", "Curitiba"));

        System.out.println("\nBúsqueda en profundidad desde Montevideo:");
        grafo.bps("Montevideo");

        System.out.println("\nBúsqueda en amplitud desde Montevideo:");
        grafo.bfs("Montevideo");


        System.out.println("\n\nTodos los caminos desde Montevideo a Rio de Janeiro:");
        List<List<String>> caminos = grafo.obtenerTodosLosCaminos("Montevideo", "Rio de Janeiro");
        for (List<String> camino : caminos) {
            System.out.println(camino);
        }
    }
}
