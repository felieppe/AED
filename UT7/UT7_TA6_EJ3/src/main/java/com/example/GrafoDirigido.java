package com.example;

import java.util.*;

public class GrafoDirigido {
    private Map<Integer, Vertice> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    public void agregarTarea(Tarea tarea) {
        vertices.put(tarea.getId(), new Vertice(tarea));
    }

    public void agregarPrecedencia(int idTarea1, int idTarea2) {
        Vertice origen = vertices.get(idTarea1);
        Vertice destino = vertices.get(idTarea2);
        if (origen != null && destino != null) {
            origen.addAdyacencia(destino);
        }
    }

    public List<Tarea> ordenParcial() {
        List<Tarea> orden = new ArrayList<>();
        Map<Vertice, Integer> gradosEntrada = new HashMap<>();
        
        for (Vertice v : vertices.values()) {
            gradosEntrada.put(v, 0);
        }
        
        for (Vertice v : vertices.values()) {
            for (Vertice adyacente : v.getAdyacencias()) {
                gradosEntrada.put(adyacente, gradosEntrada.get(adyacente) + 1);
            }
        }

        Queue<Vertice> cola = new LinkedList<>();
        for (Map.Entry<Vertice, Integer> entry : gradosEntrada.entrySet()) {
            if (entry.getValue() == 0) {
                cola.offer(entry.getKey());
            }
        }

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            orden.add(actual.getTarea());
            
            for (Vertice adyacente : actual.getAdyacencias()) {
                gradosEntrada.put(adyacente, gradosEntrada.get(adyacente) - 1);
                if (gradosEntrada.get(adyacente) == 0) {
                    cola.offer(adyacente);
                }
            }
        }

        if (orden.size() != vertices.size()) {
            throw new IllegalStateException("El grafo contiene un ciclo");
        }

        return orden;
    }

    public Collection<Vertice> getVertices() {
        return vertices.values();
    }

    public List<Tarea> getTareas() {
        List<Tarea> tareas = new ArrayList<>();
        for (Vertice v : vertices.values()) {
            tareas.add(v.getTarea());
        }
        return tareas;
    }
}
