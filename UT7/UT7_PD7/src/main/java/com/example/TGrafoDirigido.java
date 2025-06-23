package com.example;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;

public class TGrafoDirigido {
    private Map<String, LinkedList<String>> grafo = new HashMap<>();
    private Map<String, Integer> gradosEntrada = new HashMap<>();

    public void agregarTarea(TTarea tarea) {
        grafo.putIfAbsent(tarea.getCodigo(), new LinkedList<String>());
        gradosEntrada.putIfAbsent(tarea.getCodigo(), 0);  // Inicializa grado de entrada
    }

    public void agregarDependencia(TArista arista) {
        if (grafo.containsKey(arista.getOrigen()) && grafo.containsKey(arista.getDestino())) {
            grafo.get(arista.getOrigen()).add(arista.getDestino());
            gradosEntrada.put(arista.getDestino(), gradosEntrada.getOrDefault(arista.getDestino(), 0) + 1);
        } else {
            System.err.println("Tarea no encontrada para la arista: " + arista.getOrigen() + " -> " + arista.getDestino());
        }
    }

    public LinkedList<String> ordenParcial() {
        LinkedList<String> resultado = new LinkedList<>();
        Deque<String> ceroGrado = new ArrayDeque<>();

        for (Map.Entry<String, Integer> entry : gradosEntrada.entrySet()) {
            if (entry.getValue() == 0) {
                ceroGrado.add(entry.getKey());
            }
        }

        while (!ceroGrado.isEmpty()) {
            String tarea = ceroGrado.poll();
            resultado.add(tarea);
            for (String adyacente : grafo.get(tarea)) {
                int gradoActual = gradosEntrada.get(adyacente) - 1;
                gradosEntrada.put(adyacente, gradoActual);
                if (gradoActual == 0) {
                    ceroGrado.add(adyacente);
                }
            }
        }

        if (resultado.size() != grafo.size()) {
            System.err.println("El grafo tiene ciclos o no se pudieron ordenar todas las tareas.");
        }
        return resultado;
    }

    public void listarTareas(LinkedList<String> orden) {
        for (String tarea : orden) {
            System.out.println(tarea);
        }
    }
}
