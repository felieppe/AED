
package com.example;

public class ArbolBinario 
{
    NodoArbol raiz;
    public ArbolBinario(){
        raiz = null;
    }
    // Metodo para insertar un nodo en el Arbol
    public void agregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d, nom);
        if(raiz == null){
            raiz = nuevo;
        }else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while(true){
                padre = auxiliar;
                if(d < auxiliar.dato){
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }else {
                    auxiliar = auxiliar.hijoDerecho;
                    if(auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    public void imprimirArbol() {
        imprimirEnOrden(raiz);
    }

    // Método auxiliar para imprimir el árbol en orden
    private void imprimirEnOrden(NodoArbol nodo) {
        if (nodo != null) {
            imprimirEnOrden(nodo.hijoIzquierdo); // Visita el hijo izquierdo
            System.out.println("Dato: " + nodo.dato + " , Nombre: " + getNodeName(nodo)); // Imprime el dato del nodo
            imprimirEnOrden(nodo.hijoDerecho); // Visita el hijo derecho
        }
    }
    
    // Método para obtener el nombre del nodo
    private String getNodeName(NodoArbol nodo) {
        // Replace 'nom' with the actual field or property that represents the name of the node
        return nodo.nombre;
    }
    public void preorden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.println(nodo.nombre);
            preorden(nodo.hijoIzquierdo);
            preorden(nodo.hijoDerecho);
        }
    }
    
    public void postorden(NodoArbol nodo) {
        if (nodo != null) {
            postorden(nodo.hijoIzquierdo);
            postorden(nodo.hijoDerecho);
            System.out.println(nodo.nombre);
        }
    }
    
    public void inorden(NodoArbol nodo) {
            if (nodo != null) {
                inorden(nodo.hijoIzquierdo);
                System.out.println(nodo.nombre);
                inorden(nodo.hijoDerecho);
            }
        } // Add this closing curly brace
        String getRaiz (NodoArbol nodo) {
            if(nodo == null) {
                return raiz.nombre;
            }else {
                return null;
            }
        }
}
