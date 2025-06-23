package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

    public ArrayList<TArista> kruskal() {
        ArrayList<TArista> arbolMinimo = new ArrayList<>();
        Collections.sort(aristas);

        HashMap<String, Set<String>> conjuntos = new HashMap<>();
        for (String etiqueta : vertices.keySet()) {
            Set<String> conjunto = new HashSet<>();
            conjunto.add(etiqueta);
            conjuntos.put(etiqueta, conjunto);
        }

        for (TArista arista : aristas) {
            TVertice origen = arista.getOrigen();
            TVertice destino = arista.getDestino();

            Set<String> conjuntoOrigen = conjuntos.get(origen.getEtiqueta());
            Set<String> conjuntoDestino = conjuntos.get(destino.getEtiqueta());

            if (conjuntoOrigen != conjuntoDestino) {
                arbolMinimo.add(arista);

                conjuntoOrigen.addAll(conjuntoDestino);
                for (String vertice : conjuntoDestino) {
                    conjuntos.put(vertice, conjuntoOrigen);
                }
            }
        }

        return arbolMinimo;
    }
    public void resetearVerticesVisitados() {
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }
}
