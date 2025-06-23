package com.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        TVertice a = new TVertice("a");
        TVertice b = new TVertice("b");
        TVertice c = new TVertice("c");
        TVertice d = new TVertice("d");
        TVertice e = new TVertice("e");
        TVertice f = new TVertice("f");
        TVertice g = new TVertice("g");

        e.getAdyacencias().add(new TAdyacencia(a, 1));
        e.getAdyacencias().add(new TAdyacencia(b, 1));
        e.getAdyacencias().add(new TAdyacencia(c, 1));
        c.getAdyacencias().add(new TAdyacencia(f, 1));
        c.getAdyacencias().add(new TAdyacencia(g, 1));
        a.getAdyacencias().add(new TAdyacencia(b, 1));
        b.getAdyacencias().add(new TAdyacencia(d, 1));

        ArrayList<TVertice> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);

        ArrayList<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista(e, a, 1));
        aristas.add(new TArista(e, b, 1));
        aristas.add(new TArista(e, c, 1));
        aristas.add(new TArista(c, f, 1));
        aristas.add(new TArista(c, g, 1));
        aristas.add(new TArista(a, b, 1));
        aristas.add(new TArista(b, d, 1));

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        System.out.println("Matriz de Adyacencias:");
        grafo.mostrarMatrizAdyacencias();

        System.out.println("\nBúsqueda en Profundidad:");
        grafo.buscarProfundidad(a);

        System.out.println("\nAlgoritmo de Prim:");
        ArrayList<TArista> arbolMinimo = grafo.prim();
        for (TArista arista : arbolMinimo) {
            System.out.println(arista);
        }

        grafo.resetearVerticesVisitados();
        System.out.println("\nBúsqueda en Amplitud (BEA):");
        grafo.bea(e);
    }
}