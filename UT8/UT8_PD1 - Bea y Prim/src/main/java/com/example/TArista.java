package com.example;

public class TArista {
    private TVertice origen;
    private TVertice destino;
    private double costo;

    public TArista(TVertice origen, TVertice destino, double costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public TVertice getOrigen() {
        return origen;
    }

    public TVertice getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return origen + " - " + destino + " : " + costo;
    }
}