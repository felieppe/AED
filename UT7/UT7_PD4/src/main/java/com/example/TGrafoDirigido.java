package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TGrafoDirigido {
    private Map<Comparable, TVertice> vertices;

    public TGrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    public void agregarVertice(TVertice vertice) {
        vertices.put(vertice.getEtiqueta(), vertice);
    }

    public TVertice buscarVertice(Comparable etiqueta) {
        return vertices.get(etiqueta);
    }

    public void agregarArista(Comparable origen, Comparable destino, double costo) {
        TVertice vOrigen = buscarVertice(origen);
        TVertice vDestino = buscarVertice(destino);
        if (vOrigen != null && vDestino != null) {
            vOrigen.agregarAdyacencia(new TAdyacencia(vDestino, costo));
        }
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null) {
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    public void cargarAeropuertos(String archivoAeropuertos) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoAeropuertos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                agregarVertice(new TVertice(linea.trim()));
            }
        }
    }

    public void cargarConexiones(String archivoConexiones) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoConexiones))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                if (partes.length == 3) {
                    String origen = partes[0].trim();
                    String destino = partes[1].trim();
                    double costo = Double.parseDouble(partes[2].trim());
                    agregarArista(origen, destino, costo);
                }
            }
        }
    }
}
