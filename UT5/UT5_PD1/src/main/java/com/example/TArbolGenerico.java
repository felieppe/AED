
package com.example;
public class TArbolGenerico {
    private TNodoArbolGenerico raiz;

    public TArbolGenerico() {
        this.raiz = null;
    }

    // Método para insertar un nodo en el árbol.
    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (etiquetaPadre.isEmpty()) {
            if (raiz == null) {
                raiz = new TNodoArbolGenerico(unaEtiqueta);
                return true;
            } else {
                return false;
            }
        } else {
            if (raiz != null) {
                TNodoArbolGenerico padre = raiz.buscar(etiquetaPadre);
                if (padre != null) {
                    TNodoArbolGenerico nuevoNodo = new TNodoArbolGenerico(unaEtiqueta);
                    padre.insertarHijo(nuevoNodo);
                    return true;
                }
            }
        }
        return false;
    }

    // Método para buscar un nodo en el árbol.
    public TNodoArbolGenerico buscar(String etiqueta) {
        if (raiz != null) {
            return raiz.buscar(etiqueta);
        }
        return null;
    }

    // Método para imprimir el árbol en forma indentada.
    public void listarIndentado() {
        listarIndentado(raiz, "");
    }

    private void listarIndentado(TNodoArbolGenerico nodo, String indent) {
        if (nodo != null) {
            System.out.println(indent + nodo.getEtiqueta());
            TNodoArbolGenerico hijo = nodo.getPrimerHijo();
            while (hijo != null) {
                listarIndentado(hijo, indent + "    ");
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public void imprimir(TNodoArbolGenerico node, int indent) {
        if (node != null) {
            for (int i = 0; i < indent; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getNombre());
            TNodoArbolGenerico hijo = node.getHijoIzquierdo();
            while (hijo != null) {
                imprimir(hijo, indent + 2);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }
}
