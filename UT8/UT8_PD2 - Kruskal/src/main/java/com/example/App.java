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

        a.getAdyacencias().add(new TAdyacencia(b, 1));
        a.getAdyacencias().add(new TAdyacencia(c, 3));
        b.getAdyacencias().add(new TAdyacencia(a, 1));
        b.getAdyacencias().add(new TAdyacencia(d, 2));
        c.getAdyacencias().add(new TAdyacencia(a, 3));
        c.getAdyacencias().add(new TAdyacencia(e, 4));
        c.getAdyacencias().add(new TAdyacencia(f, 1));
        c.getAdyacencias().add(new TAdyacencia(g, 1));
        d.getAdyacencias().add(new TAdyacencia(b, 2));
        d.getAdyacencias().add(new TAdyacencia(e, 1));
        e.getAdyacencias().add(new TAdyacencia(c, 4));
        e.getAdyacencias().add(new TAdyacencia(d, 1));
        e.getAdyacencias().add(new TAdyacencia(f, 2));
        f.getAdyacencias().add(new TAdyacencia(e, 2));

        ArrayList<TVertice> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);

        ArrayList<TArista> aristas = new ArrayList<>();
        aristas.add(new TArista(a, b, 1));
        aristas.add(new TArista(a, c, 3));
        aristas.add(new TArista(b, d, 2));
        aristas.add(new TArista(c, e, 4));
        aristas.add(new TArista(c, f, 1));
        aristas.add(new TArista(c, g, 1));
        aristas.add(new TArista(d, e, 1));
        aristas.add(new TArista(e, f, 2));

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        System.out.println("Matriz de Adyacencias:");
        grafo.mostrarMatrizAdyacencias();

        System.out.println("\nÁrbol de expansión mínima (Kruskal):");
        ArrayList<TArista> arbolMinimo = grafo.kruskal();
        for (TArista arista : arbolMinimo) {
            System.out.println(arista);
        }

        System.out.println("\nÁrbol de expansión mínima (Prim):");
        ArrayList<TArista> arbolMinimoPrim = grafo.prim(); 
        for (TArista arista : arbolMinimoPrim) {
            System.out.println(arista);
        }
    }
}