package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TGrafoNoDirigido {
    protected HashMap<String, TVertice> vertices;
    protected ArrayList<TArista> aristas;

    public TGrafoNoDirigido(ArrayList<TVertice> vertices, ArrayList<TArista> aristas) {
        this.vertices = new HashMap<>();
        this.aristas = aristas;

        for (TVertice vertice : vertices) {
            this.vertices.put(vertice.getEtiqueta(), vertice);
        }

        for (TArista arista : aristas) {
            this.insertarAdyacencia(arista);
        }
    }

    public boolean insertarAdyacencia(TArista arista) {
        TVertice origen = vertices.get(arista.getOrigen().getEtiqueta());
        TVertice destino = vertices.get(arista.getDestino().getEtiqueta());

        if (origen != null && destino != null) {
            origen.getAdyacencias().add(new TAdyacencia(destino, arista.getCosto()));
            destino.getAdyacencias().add(new TAdyacencia(origen, arista.getCosto()));
            return true;
        }
        return false;
    }

    public void mostrarMatrizAdyacencias() {
        int size = vertices.size();
        double[][] matriz = new double[size][size];
        int i = 0;
        HashMap<String, Integer> indices = new HashMap<>();

        for (String vertice : vertices.keySet()) {
            indices.put(vertice, i++);
        }

        for (TVertice vertice : vertices.values()) {
            int row = indices.get(vertice.getEtiqueta());
            for (TAdyacencia adyacencia : vertice.getAdyacencias()) {
                int col = indices.get(adyacencia.getDestino().getEtiqueta());
                matriz[row][col] = adyacencia.getCosto();
            }
        }

        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void buscarProfundidad(TVertice vertice) {
        if (!vertice.isVisitado()) {
            vertice.setVisitado(true);
            System.out.println(vertice.getEtiqueta());
            for (TAdyacencia adyacencia : vertice.getAdyacencias()) {
                buscarProfundidad(adyacencia.getDestino());
            }
        }
    }

    public ArrayList<ArrayList<TVertice>> buscarCaminos(TVertice origen, TVertice destino) {
        ArrayList<ArrayList<TVertice>> caminos = new ArrayList<>();
        ArrayList<TVertice> caminoActual = new ArrayList<>();
        caminoActual.add(origen);
        buscarCaminosRecursivo(origen, destino, caminos, caminoActual);
        return caminos;
    }

    private void buscarCaminosRecursivo(TVertice actual, TVertice destino, ArrayList<ArrayList<TVertice>> caminos, ArrayList<TVertice> caminoActual) {
        if (actual.equals(destino)) {
            caminos.add(new ArrayList<>(caminoActual));
            return;
        }

        for (TAdyacencia adyacencia : actual.getAdyacencias()) {
            TVertice siguiente = adyacencia.getDestino();
            if (!caminoActual.contains(siguiente)) {
                caminoActual.add(siguiente);
                buscarCaminosRecursivo(siguiente, destino, caminos, caminoActual);
                caminoActual.remove(caminoActual.size() - 1);
            }
        }
    }

    public ArrayList<TArista> prim() {
        ArrayList<TArista> arbolMinimo = new ArrayList<>();
        Set<TVertice> visitados = new HashSet<>();
        ArrayList<TArista> aristasDisponibles = new ArrayList<>();

        TVertice inicio = vertices.values().iterator().next();
        visitados.add(inicio);
        aristasDisponibles.addAll(inicio.getAristas());

        while (!aristasDisponibles.isEmpty()) {
            TArista aristaMenorCosto = null;
            for (TArista arista : aristasDisponibles) {
                if (aristaMenorCosto == null || arista.getCosto() < aristaMenorCosto.getCosto()) {
                    aristaMenorCosto = arista;
                }
            }
            aristasDisponibles.remove(aristaMenorCosto);

            TVertice verticeDestino = aristaMenorCosto.getDestino();
            if (!visitados.contains(verticeDestino)) {
                arbolMinimo.add(aristaMenorCosto);
                visitados.add(verticeDestino);
                aristasDisponibles.addAll(verticeDestino.getAristas());
            }
        }

        return arbolMinimo;
    }

    public void bea(TVertice vertice) {
        LinkedList<TVertice> cola = new LinkedList<>();
        HashSet<TVertice> visitados = new HashSet<>();
        HashMap<TVertice, TVertice> parent = new HashMap<>();
        vertice.setVisitado(true);
        visitados.add(vertice);
        cola.add(vertice);
        while (!cola.isEmpty()) {
            TVertice actual = cola.removeFirst();
            System.out.println(actual.getEtiqueta());
            for (TAdyacencia adyacente : actual.getAdyacencias()) {
                TVertice verticeAdyacente = adyacente.getDestino();
                if (!visitados.contains(verticeAdyacente)) {
                    verticeAdyacente.setVisitado(true);
                    visitados.add(verticeAdyacente);
                    cola.add(verticeAdyacente);
                    parent.put(verticeAdyacente, actual);
                    System.out.println(actual.getEtiqueta() + " -> " + verticeAdyacente.getEtiqueta()); // arco de arbol
                } else if (!actual.equals(parent.get(verticeAdyacente))) {
                    System.out.println(actual.getEtiqueta() + " -- " + verticeAdyacente.getEtiqueta()); // arco de retroceso
                }
            }
        }
    }

    public void resetearVerticesVisitados() {
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }
}
