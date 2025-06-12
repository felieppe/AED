package com.example;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    private String id;
    private int duracion;
    private List<Tarea> predecesores;
    private List<Tarea> sucesores;

    public Tarea(String id, int duracion) {
        this.id = id;
        this.duracion = duracion;
        this.predecesores = new ArrayList<>();
        this.sucesores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public List<Tarea> getPredecesores() {
        return predecesores;
    }

    public List<Tarea> getSucesores() {
        return sucesores;
    }

    public void agregarPredecesor(Tarea tarea) {
        this.predecesores.add(tarea);
    }

    public void agregarSucesor(Tarea tarea) {
        this.sucesores.add(tarea);
    }

    public String toString() {
        return id;
    }
}
