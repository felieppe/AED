package com.example;

import java.util.*;

public class TVertice {
    public String id;
    public int discoverTime;
    public int finishTime;
    public TVertice parent;
    public List<TArista> adjList;

    public TVertice(String id) {
        this.id = id;
        this.adjList = new ArrayList<>();
    }

    public void addArista(TArista arista) {
        adjList.add(arista);
    }
}


