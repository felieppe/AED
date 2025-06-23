package com.example;

import java.util.LinkedList;
import java.util.List;

public class TVertice {
    private Comparable etiqueta;
    private List<TAdyacencia> adyacentes;
    private boolean visitado;

    public TVertice(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.adyacentes = new LinkedList<>();
        this.visitado = false;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public List<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        this.adyacentes.add(adyacencia);
    }

    public void todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarUltimaAdyacencia();
                }
            }
        }
        this.setVisitado(false);
    }
}
