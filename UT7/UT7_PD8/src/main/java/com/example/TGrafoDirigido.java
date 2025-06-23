package com.example;

import java.util.*;


public class TGrafoDirigido {
    public Map<String, TVertice> vertices;
    public List<TArista> arcos;

    public TGrafoDirigido() {
        this.vertices = new HashMap<>();
        this.arcos = new ArrayList<>();
    }
    
    public void addVertice(String id) {
        vertices.put(id, new TVertice(id));
    }

    public void addArista(String source, String destination) {
        TVertice v1 = vertices.get(source);
        TVertice v2 = vertices.get(destination);
        TArista arista = new TArista(v1, v2);
        v1.addArista(arista);
        arcos.add(arista);
    }

    private int time = 0;
    private List<TArista> arcosArbol = new ArrayList<>();
    private List<TArista> arcosRetroceso = new ArrayList<>();
    private List<TArista> arcosAvance = new ArrayList<>();
    private List<TArista> arcosCruzados = new ArrayList<>();

    public void DFS() {
        for (TVertice u : vertices.values()) {
            if (u.discoverTime == 0) {
                DFSVisit(u);
            }
        }
    }

    private void DFSVisit(TVertice u) {
        time++;
        u.discoverTime = time;
        for (TArista arista : u.adjList) {
            TVertice v = arista.destination;
            if (v.discoverTime == 0) {
                arcosArbol.add(arista);
                v.parent = u;
                DFSVisit(v);
            } else if (v.finishTime == 0) {
                arcosRetroceso.add(arista);
            } else if (u.discoverTime < v.discoverTime) {
                arcosAvance.add(arista);
            } else {
                arcosCruzados.add(arista);
            }
        }
        time++;
        u.finishTime = time;
    }

    public void clasificarArcos() {
        DFS();
        System.out.println("Arcos de Árbol: " + arcosArbol);
        System.out.println("Arcos de Retroceso: " + arcosRetroceso);
        System.out.println("Arcos de Avance: " + arcosAvance);
        System.out.println("Arcos Cruzados: " + arcosCruzados);
    }
}
