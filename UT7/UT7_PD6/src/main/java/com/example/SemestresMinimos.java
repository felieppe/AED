package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SemestresMinimos {

    public static int encontrarSemestresMinimos(int numCursos, int[][] prerrequisitos) {
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < numCursos; i++) {
            grafo.add(new ArrayList<Integer>());
        }
        
        int[] gradosEntrada = new int[numCursos];
        
        for (int[] pre : prerrequisitos) {
            grafo.get(pre[0]).add(pre[1]);
            gradosEntrada[pre[1]]++;
        }
        
        Queue<Integer> cola = new LinkedList<>();
        
        for (int i = 0; i < numCursos; i++) {
            if (gradosEntrada[i] == 0) {
                cola.offer(i);
            }
        }
        
        int semestres = 0;
        int cursosCompletados = 0;
        
        while (!cola.isEmpty()) {
            int tamaño = cola.size();
            semestres++;
            
            for (int i = 0; i < tamaño; i++) {
                int curso = cola.poll();
                cursosCompletados++;
                
                for (int vecino : grafo.get(curso)) {
                    gradosEntrada[vecino]--;
                    if (gradosEntrada[vecino] == 0) {
                        cola.offer(vecino);
                    }
                }
            }
        }
        
        if (cursosCompletados == numCursos) {
            return semestres;
        } else {
            return -1;  
        }
    }

    static class Arista {
        int destino;
        double probabilidad;
        
        Arista(int destino, double probabilidad) {
            this.destino = destino;
            this.probabilidad = probabilidad;
        }
    }
    
    public static double[] encontrarCaminosMasFiables(int numComputadoras, int[][] conexiones, double[] probabilidades, int inicio) {
        List<List<Arista>> grafo = new ArrayList<>();
        for (int i = 0; i < numComputadoras; i++) {
            grafo.add(new ArrayList<Arista>());
        }
        
        for (int i = 0; i < conexiones.length; i++) {
            int u = conexiones[i][0];
            int v = conexiones[i][1];
            double prob = probabilidades[i];
            grafo.get(u).add(new Arista(v, prob));
            grafo.get(v).add(new Arista(u, prob)); 
        }
        
        double[] maxProbabilidad = new double[numComputadoras];
        Arrays.fill(maxProbabilidad, 0);
        maxProbabilidad[inicio] = 1;
        
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(inicio);
        
        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            
            for (Arista vecino : grafo.get(nodo)) {
                int vecinoNodo = vecino.destino;
                double nuevaProb = maxProbabilidad[nodo] * vecino.probabilidad;
                
                if (nuevaProb > maxProbabilidad[vecinoNodo]) {
                    maxProbabilidad[vecinoNodo] = nuevaProb;
                    cola.offer(vecinoNodo);
                }
            }
        }
        
        return maxProbabilidad;
    }
}