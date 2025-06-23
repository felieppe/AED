package com.example;

public class TAdyacencia {
    private TVertice destino;
    private double costo;

    public TAdyacencia(TVertice destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public TVertice getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }
}
