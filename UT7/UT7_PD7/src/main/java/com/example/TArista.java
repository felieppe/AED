package com.example;

public class TArista {
    private String origen;
    private String destino;
    
    public TArista(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public String getDestino() {
        return destino;
    }
}
