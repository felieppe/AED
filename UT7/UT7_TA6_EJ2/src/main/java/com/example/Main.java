package com.example;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarTarea("A", 3);
        grafo.agregarTarea("B", 2);
        grafo.agregarTarea("C", 1);
        grafo.agregarTarea("D", 5);
        grafo.agregarTarea("E", 4);

        grafo.agregarDependencia("A", "B");
        grafo.agregarDependencia("A", "C");
        grafo.agregarDependencia("B", "D");
        grafo.agregarDependencia("C", "D");
        grafo.agregarDependencia("D", "E");

        CaminoCritico caminoCritico = new CaminoCritico(grafo);
        int costoCritico = caminoCritico.calcularCaminoCritico();
        System.out.println("Costo total del camino crítico: " + costoCritico);

        caminoCritico.calcularHolguras();
    }
}
