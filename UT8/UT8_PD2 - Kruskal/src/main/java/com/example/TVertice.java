package com.example;

import java.util.ArrayList;

public class TVertice {
    private String etiqueta;
    private ArrayList<TAdyacencia> adyacencias;
    private boolean visitado;

    public TVertice(String etiqueta) {
        this.etiqueta = etiqueta;
        this.adyacencias = new ArrayList<>();
        this.visitado = false;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public ArrayList<TAdyacencia> getAdyacencias() {
        return adyacencias;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public String toString() {
        return etiqueta;
    }

    public ArrayList<TArista> getAristas() {
        ArrayList<TArista> aristas = new ArrayList<>();
        for (TAdyacencia adyacencia : adyacencias) {
            aristas.add(new TArista(this, adyacencia.getDestino(), adyacencia.getCosto()));
        }
        return aristas;
    }

    public boolean getVisitado() {
        return this.visitado;
    }
}
