package com.example;
import java.util.*;

public class Grafo {
    private Map<String, Tarea> tareas;

    public Grafo() {
        this.tareas = new HashMap<>();
    }

    public void agregarTarea(String id, int duracion) {
        if (!tareas.containsKey(id)) {
            Tarea tarea = new Tarea(id, duracion);
            tareas.put(id, tarea);
        }
    }

    public Tarea getTarea(String id) {
        return tareas.get(id);
    }

    public void agregarDependencia(String idPredecesora, String idSucesora) {
        Tarea predecesora = tareas.get(idPredecesora);
        Tarea sucesora = tareas.get(idSucesora);
        if (predecesora != null && sucesora != null) {
            predecesora.agregarSucesor(sucesora);
            sucesora.agregarPredecesor(predecesora);
        }
    }

    public Collection<Tarea> getTareas() {
        return tareas.values();
    }
}
