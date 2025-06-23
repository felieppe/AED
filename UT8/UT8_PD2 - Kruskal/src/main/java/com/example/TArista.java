package com.example;

public class TArista implements Comparable<TArista> {
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
    public int compareTo(TArista otraArista) {
        return Double.compare(this.costo, otraArista.getCosto());
    }

    public String toString() {
        return String.format("%s -> %s: %.2f", origen.getEtiqueta(), destino.getEtiqueta(), costo);
    }
}