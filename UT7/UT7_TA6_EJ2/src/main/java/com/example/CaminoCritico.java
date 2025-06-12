package com.example;

import java.util.*;

public class CaminoCritico {
    private Grafo grafo;

    public CaminoCritico(Grafo grafo) {
        this.grafo = grafo;
    }

    public List<Tarea> obtenerOrdenTopologico() {
        List<Tarea> ordenTopologico = new ArrayList<>();
        Map<Tarea, Integer> gradosEntrantes = new HashMap<>();
        Queue<Tarea> cola = new LinkedList<>();

        for (Tarea tarea : grafo.getTareas()) {
            gradosEntrantes.put(tarea, tarea.getPredecesores().size());
            if (tarea.getPredecesores().isEmpty()) {
                cola.add(tarea);
            }
        }

        while (!cola.isEmpty()) {
            Tarea tarea = cola.poll();
            ordenTopologico.add(tarea);
            for (Tarea sucesor : tarea.getSucesores()) {
                int gradoEntrante = gradosEntrantes.get(sucesor) - 1;
                gradosEntrantes.put(sucesor, gradoEntrante);
                if (gradoEntrante == 0) {
                    cola.add(sucesor);
                }
            }
        }

        return ordenTopologico;
    }

    public int calcularCaminoCritico() {
        List<Tarea> ordenTopologico = obtenerOrdenTopologico();
        Map<Tarea, Integer> costoMaximo = new HashMap<>();

        for (Tarea tarea : ordenTopologico) {
            costoMaximo.put(tarea, tarea.getDuracion());
        }

        for (Tarea tarea : ordenTopologico) {
            for (Tarea sucesor : tarea.getSucesores()) {
                int costo = costoMaximo.get(tarea) + sucesor.getDuracion();
                if (costo > costoMaximo.get(sucesor)) {
                    costoMaximo.put(sucesor, costo);
                }
            }
        }

        int costoTotal = 0;
        for (int costo : costoMaximo.values()) {
            if (costo > costoTotal) {
                costoTotal = costo;
            }
        }

        return costoTotal;
    }

    public List<List<Tarea>> listarSecuencias() {
        List<Tarea> ordenTopologico = obtenerOrdenTopologico();
        List<List<Tarea>> secuencias = new ArrayList<>();
        listarSecuenciasRecursivo(ordenTopologico, new ArrayList<Tarea>(), secuencias);
        return secuencias;
    }

    private void listarSecuenciasRecursivo(List<Tarea> ordenTopologico, List<Tarea> actual, List<List<Tarea>> secuencias) {
        if (ordenTopologico.isEmpty()) {
            secuencias.add(new ArrayList<Tarea>(actual));
            return;
        }

        for (Tarea tarea : ordenTopologico) {
            List<Tarea> restantes = new ArrayList<>(ordenTopologico);
            restantes.remove(tarea);
            actual.add(tarea);
            listarSecuenciasRecursivo(restantes, actual, secuencias);
            actual.remove(actual.size() - 1);
        }
    }

    public void calcularHolguras() {
        int costoCritico = calcularCaminoCritico();
        List<List<Tarea>> secuencias = listarSecuencias();

        for (List<Tarea> secuencia : secuencias) {
            int costo = 0;
            for (Tarea tarea : secuencia) {
                costo += tarea.getDuracion();
            }
            int holgura = costoCritico - costo;
            System.out.println("Secuencia: " + secuencia + ", Costo: " + costo + ", Holgura: " + holgura);
        }
    }
}
