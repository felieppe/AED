package com.example;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private Tarea tarea;
    private List<Vertice> adyacencias;

    public Vertice(Tarea tarea) {
        this.tarea = tarea;
        this.adyacencias = new ArrayList<>();
    }

    public Tarea getTarea() {
        return tarea;
    }

    public List<Vertice> getAdyacencias() {
        return adyacencias;
    }

    public void addAdyacencia(Vertice vertice) {
        adyacencias.add(vertice);
    }
}
