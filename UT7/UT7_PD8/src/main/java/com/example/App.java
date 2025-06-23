package com.example;

public class App 
{
    public static void main(String[] args) {
        TGrafoDirigido grafo = new TGrafoDirigido();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");

        grafo.addArista("A", "B");
        grafo.addArista("B", "C");
        grafo.addArista("C", "D");
        grafo.addArista("D", "B");
        grafo.addArista("A", "D");

        grafo.clasificarArcos();
    }
}

/*
Analisis del tiempo de ejecucion del Algoritmo:
El tiempo de ejecucion del algoritmo es de o(n), donde n es el numero de vertices del grafo. Este es o(n),
debido a que siempre nos quedamos con el peor de los casos, donde va recorriendo todos los vertices del grafo 
y los va visitando. Por lo que el tiempo de ejecucion depende de la cantidad de vertices que tenga el grafo.
*/