package com.example;

import java.util.ArrayList;

public class TGrafoDirigido extends TGrafoNoDirigido {

    public TGrafoDirigido(ArrayList<TVertice> vertices, ArrayList<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public boolean insertarAdyacencia(TArista arista) {
        if (super.insertarAdyacencia(arista)) {
            return super.insertarAdyacencia(new TArista(arista.getDestino(), arista.getOrigen(), arista.getCosto()));
        }
        return false;
    }
}
