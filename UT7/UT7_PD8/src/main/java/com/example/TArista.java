package com.example;

public class TArista {
    public TVertice source;
    public TVertice destination;

    public TArista(TVertice source, TVertice destination) {
        this.source = source;
        this.destination = destination;
    }

    public String toString() {
        return source.id + " -> " + destination.id;
    }
}

