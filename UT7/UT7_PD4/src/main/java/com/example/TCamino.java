package com.example;

import java.util.LinkedList;
import java.util.List;

public class TCamino {
    private List<TAdyacencia> adyacencias;
    private double costoTotal;

    public TCamino(TVertice origen) {
        this.adyacencias = new LinkedList<>();
        this.costoTotal = 0;
        this.adyacencias.add(new TAdyacencia(origen, 0));
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        this.adyacencias.add(adyacencia);
        this.costoTotal += adyacencia.getCosto();
    }

    public void eliminarUltimaAdyacencia() {
        if (!adyacencias.isEmpty()) {
            TAdyacencia ultima = adyacencias.remove(adyacencias.size() - 1);
            this.costoTotal -= ultima.getCosto();
        }
    }

    public TCamino copiar() {
        TCamino copia = new TCamino(adyacencias.get(0).getDestino());
        for (int i = 1; i < adyacencias.size(); i++) {
            copia.agregarAdyacencia(adyacencias.get(i));
        }
        return copia;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public List<TAdyacencia> getAdyacencias() {
        return adyacencias;
    }
}

