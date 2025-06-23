package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Grafo {
    private final Map<String, HashMap<String, Integer>> adjList = new HashMap<>();

    public void addVertice(String vertice) {
        adjList.putIfAbsent(vertice, new HashMap<String, Integer>());
    }

    public void addArista(String origen, String destino, int costo) {
        adjList.get(origen).put(destino, costo);
    }

    public void mostrarMatrizConexiones() {
        for (String origen : adjList.keySet()) {
            System.out.print(origen + ": ");
            for (String destino : adjList.get(origen).keySet()) {
                System.out.print(destino + "(" + adjList.get(origen).get(destino) + ") ");
            }
            System.out.println();
        }
    }

    public void calcularCostosMinimos() {
        for (String k : adjList.keySet()) {
            for (String i : adjList.keySet()) {
                for (String j : adjList.keySet()) {
                    if (adjList.get(i).containsKey(k) && adjList.get(k).containsKey(j)) {
                        int newCost = adjList.get(i).get(k) + adjList.get(k).get(j);
                        adjList.get(i).put(j, Math.min(adjList.get(i).getOrDefault(j, Integer.MAX_VALUE), newCost));
                    }
                }
            }
        }
    }

    public int obtenerCosto(String origen, String destino) {
        return adjList.getOrDefault(origen, new HashMap<String, Integer>()).getOrDefault(destino, -1);
    }

    public void readAeropuertos(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                addVertice(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void readConexiones(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addArista(parts[0].trim(), parts[1].trim(), Integer.parseInt(parts[2].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Metodo de busqueda en profundidad
    public void bps(String inicio) {
        Set<String> visitados = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(inicio);
        
        while (!stack.isEmpty()) {
            String vertice = stack.pop();
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);
                System.out.print(vertice + " ");
                for (String vecino : adjList.getOrDefault(vertice, new HashMap<String, Integer>()).keySet())  {
                    if (!visitados.contains(vecino)) {
                        stack.push(vecino);
                    }
                }
            }
        }
    }

    public List<List<String>> obtenerTodosLosCaminos(String origen, String destino) {
        List<List<String>> caminos = new ArrayList<>();
        List<String> caminoActual = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        obtenerCaminosDFS(origen, destino, visitados, caminoActual, caminos);
        return caminos;
    }

    private void obtenerCaminosDFS(String actual, String destino, Set<String> visitados, List<String> caminoActual, List<List<String>> caminos) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            caminos.add(new ArrayList<>(caminoActual));
        } else {
            for (String vecino : adjList.getOrDefault(actual, new HashMap<String, Integer>()).keySet()) {
                if (!visitados.contains(vecino)) {
                    obtenerCaminosDFS(vecino, destino, visitados, caminoActual, caminos);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
        visitados.remove(actual);
    }

    // Metodo de busqueda en amplitud
    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            String vertice = cola.poll();
            System.out.print(vertice + " ");
            for (String vecino : adjList.getOrDefault(vertice, new HashMap<String, Integer>()).keySet()) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }
}
