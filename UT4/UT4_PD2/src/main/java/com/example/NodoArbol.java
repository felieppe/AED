package com.example;

public class NodoArbol {
    int dato;  // tipo entero
    String nombre; // tipo String
    NodoArbol hijoIzquierdo, hijoDerecho;  // 2 punteros a los hijos
    public NodoArbol(int d, String nom){
        this.dato = d;
        this.nombre = nom;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
    public String toString(){
        return nombre + " su dato es: " + dato;
    }
    public int getDato() {
        return dato;
    }
    public String getNombre() {
        return nombre;
    }
}
