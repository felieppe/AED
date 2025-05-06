package com.example;

public class Arbol {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar("B");
        arbol.insertar("A");
        arbol.insertar("C");
        arbol.recorrer();
        System.out.println(arbol.buscar("A"));  // Debería imprimir "true"
        System.out.println(arbol.buscar("D"));  // Debería imprimir "false"
    }

    public static class Nodo {
        String valor;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(String val) {
            this.valor = val;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public static class ArbolBinario {
        Nodo raiz;

        ArbolBinario() {
            this.raiz = null;
        }

        // Método para insertar un nodo
        public void insertar(String val) {
            this.raiz = this.insertarNodo(this.raiz, val);
        }

        private Nodo insertarNodo(Nodo nodo, String val) {
            if (nodo == null) {
                return new Nodo(val);
            }

            if (val.compareTo(nodo.valor) < 0) {
                nodo.izquierdo = this.insertarNodo(nodo.izquierdo, val);
            } else if (val.compareTo(nodo.valor) > 0) {
                nodo.derecho = this.insertarNodo(nodo.derecho, val);
            }

            return nodo;
        }

        // Método para buscar un valor
        public boolean buscar(String val) {
            return this.buscarNodo(this.raiz, val);
        }

        private boolean buscarNodo(Nodo nodo, String val) {
            if (nodo == null) {
                return false;
            }

            if (val.compareTo(nodo.valor) == 0) {
                return true;
            }

            return val.compareTo(nodo.valor) < 0 ? this.buscarNodo(nodo.izquierdo, val) : this.buscarNodo(nodo.derecho, val);
        }

        // Método para recorrer el árbol en orden (izquierdo, raíz, derecho)
        public void recorrer() {
            this.recorrerNodo(this.raiz);
        }

        private void recorrerNodo(Nodo nodo) {
            if (nodo != null) {
                this.recorrerNodo(nodo.izquierdo);
                System.out.println(nodo.valor);
                this.recorrerNodo(nodo.derecho);
            }
        }
    }
}