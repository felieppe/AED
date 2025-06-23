package com.example;

import java.util.*;

public class GrafoDirigido {
    private Map<Integer, List<Integer>> adyacencias;
    
    public GrafoDirigido() {
        adyacencias = new HashMap<>();
    }
    
    public void agregarArista(int origen, int destino) {
        adyacencias.putIfAbsent(origen, new ArrayList<Integer>());
        adyacencias.get(origen).add(destino);
    }
    
    public List<Integer> ordenacionTopologica() {
        Set<Integer> visitados = new HashSet<>();
        List<Integer> ordenacion = new ArrayList<>();
    
        for (int v : adyacencias.keySet()) {
            if (!visitados.contains(v)) {
                DFS(v, visitados, ordenacion);
            }
        }
    
        Collections.reverse(ordenacion);
        return ordenacion; 
    }
    
    private void DFS(int v, Set<Integer> visitados, List<Integer> ordenacion) {
        visitados.add(v);
    
        for (int w : adyacencias.getOrDefault(v, new ArrayList<Integer>())) {
            if (!visitados.contains(w)) {
                DFS(w, visitados, ordenacion);
            }
        }
        ordenacion.add(v);
    }
    
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();
        grafo.agregarArista(5, 2);
        grafo.agregarArista(5, 0);
        grafo.agregarArista(4, 0);
        grafo.agregarArista(4, 1);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 1);
    
        List<Integer> ordenacion = grafo.ordenacionTopologica();
        System.out.println("Ordenación Topológica: " + ordenacion);
    }
}

/*
Obtener Todas las Ordenaciones Topológicas
- Utilizar una cola de prioridad para almacenar los vértices con grado de entrada cero.
- Remover un vértice de la cola, añadirlo a la ordenación y disminuir el grado de entrada de sus vecinos.
- Si los vecinos tienen grado de entrada cero, añadirlos a la cola.
- Repetir el proceso recursivamente para explorar todas las posibles ordenaciones.
*/